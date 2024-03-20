import expr.Derive;
import expr.Expr;
import expr.Expon;
import expr.Term;
import expr.Pow;
import expr.Func;
import expr.Factor;

import token.Token;
import token.TokenType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class Parser {
    private Lexer lexer;
    private Token token;
    private Definer definer;

    public Parser(Lexer lexer, Definer definer) {
        this.lexer = lexer;
        this.definer = definer;
    }

    public Expr parseExpr(int signal) {
        Expr expr = new Expr();
        if (!lexer.hasNext()) {
            return expr;
        }
        token = lexer.curToken();
        if (token.getType() == TokenType.SUB) {
            lexer.next();
            expr.addTerm(parseTerm(-signal));
        } else if (token.getType() == TokenType.ADD) {
            lexer.next();
            expr.addTerm(parseTerm(signal));
        } else {
            expr.addTerm(parseTerm(signal));
        }
        while (lexer.hasNext()) {
            token = lexer.curToken();
            if (token.getType() == TokenType.ADD) {
                lexer.next();
                expr.addTerm(parseTerm(signal));
            } else if (token.getType() == TokenType.SUB) {
                lexer.next();
                expr.addTerm(parseTerm(-signal));
            } else {
                break;
            }
        }
        return expr;
    }

    public Term parseTerm(int signal) {
        Term term = new Term();
        token = lexer.curToken();
        if (token != null && token.getType() == TokenType.SUB) {
            lexer.next();
            term.addFactor(parseFactor(-signal, term));
        } else if (token != null && token.getType() == TokenType.ADD) {
            lexer.next();
            term.addFactor(parseFactor(signal, term));
        } else {
            term.addFactor(parseFactor(signal, term));
        }

        while (lexer.hasNext()) {
            token = lexer.curToken();
            if (token.getType() == TokenType.MUL) {
                lexer.next();
                term.addFactor(parseFactor(1, term));
            } else {
                break;
            }
        }
        return term;
    }

    public Factor parseFactor(int preSignal, Term term) {
        int signal = preSignal;
        token = lexer.curToken();
        if (token != null && token.getType() == TokenType.SUB) {
            lexer.next();
            signal = -signal;
        } else if (lexer.hasNext() && lexer.nextToken().getType() == TokenType.ADD) {
            lexer.next();
        }

        token = lexer.curToken();
        if (token.getType() == TokenType.NUM) {
            lexer.next();
            return parseNum(signal);

        } else if (token.getType() == TokenType.X) {
            lexer.next();
            return parseX(signal);

        } else if (token.getType() == TokenType.LEFT_PAREN) {
            lexer.next();
            return parseLP(signal, term);

        } else if (token.getType() == TokenType.EXP) {
            lexer.next();
            return parseExp(signal, term);

        } else if (token.getType() == TokenType.FUN) {
            return parseFun(signal, term);
        } else if (token.getType() == TokenType.DERIVE) {
            return parseDerive(signal, term);
        }
        return null;
    }

    public Factor parseNum(int signal) {
        return new Pow((new BigInteger(token.getValue())).
                multiply(BigInteger.valueOf((long) signal)), BigInteger.ZERO);
    }

    public Factor parseX(int signal) {
        if (lexer.hasNext() && lexer.nextToken().getType() == TokenType.POW) {
            lexer.next();
            token = lexer.curToken();
            lexer.next();
            return new Pow(BigInteger.valueOf((long) signal), new BigInteger(token.getValue()));
        } else {
            return new Pow(BigInteger.valueOf((long) signal), BigInteger.ONE);
        }
    }

    public Factor parseLP(int signal, Term term) {
        int theSignal = signal;
        Expr expr = parseExpr(1);
        lexer.next();
        if (lexer.hasNext() && lexer.nextToken().getType() == TokenType.POW) {
            lexer.next();       // '^'

            token = lexer.curToken();
            lexer.next();
            // expr = expr.powExpr(new BigInteger(token.getValue()));
            expr.setExp(new BigInteger(token.getValue()));
        }
        if (theSignal == -1) {
            term.addFactor(new Pow(BigInteger.ONE.negate(), BigInteger.ZERO));
        }
        return expr;
    }

    public Factor parseExp(int signal, Term term) {
        lexer.next();           // '('
        int theSignal = signal;
        Expr expr = parseExpr(1);
        lexer.next();
        if (lexer.hasNext() && (lexer.nextToken().getType() == TokenType.POW)) {
            lexer.next();
            token = lexer.curToken();
            lexer.next();
            expr.setCoe(new BigInteger(token.getValue()));
        }
        if (theSignal == -1) {
            term.addFactor(new Pow(BigInteger.ONE.negate(), BigInteger.ZERO));
        }
        return new Expon(expr);
    }

    public Factor parseFun(int signal, Term term) {
        String funcName;
        funcName = token.getValue();
        lexer.next();
        lexer.next();
        ArrayList<Factor> factorList = new ArrayList<>();
        factorList.add(parseFactor(1, term));
        while (lexer.curToken().getType() == TokenType.COMMA) {
            lexer.next();
            factorList.add(parseFactor(1, term));
        }
        lexer.next();

        ArrayList<String> actualParaList = new ArrayList<>();
        for (Factor factor : factorList) {
            if (Objects.equals(factor.toString(), "")) {
                actualParaList.add("(0)");
            } else {
                actualParaList.add("(" + factor + ")");
            }
        }
        Func func = definer.getFunc(funcName);
        String funcString = func.func2String(actualParaList);
        Lexer lexer1 = new Lexer(funcString);
        Parser parser1 = new Parser(lexer1, definer);

        Expr funExpr = parser1.parseExpr(1);
        if (signal == -1) {
            term.addFactor(new Pow(BigInteger.ONE.negate(), BigInteger.ZERO));
        }
        return funExpr;
    }

    public Factor parseDerive(int signal, Term term) {
        lexer.next();
        lexer.next();//(
        if (signal == -1) {
            term.addFactor(new Pow(BigInteger.ONE.negate(), BigInteger.ZERO));
        }
        Expr expr = parseExpr(1);
        lexer.next();
        return new Derive(expr);
    }

    public Expr string2Expr(String input) {
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer, definer);
        Expr expr = parser.parseExpr(1);
        return expr;
    }
}
