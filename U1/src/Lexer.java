import token.TokenType;
import token.Token;

import java.util.ArrayList;

public class Lexer {
    private String input;
    private int position = 0;
    private final ArrayList<Token> tokens = new ArrayList<>();

    public Lexer(String input) {
        this.input = input;
        tokenize();
    }

    public void tokenize() {
        while (input.length() > 0) {
            char c = input.charAt(0);
            if (Character.isDigit(c)) {
                String number = "";
                while (Character.isDigit(c)) {
                    number += c;
                    input = input.substring(1);
                    if (input.length() == 0) {
                        break;
                    }
                    c = input.charAt(0);
                }
                tokens.add(new Token(TokenType.NUM, number));
            } else if (c == '+') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.ADD, "+"));
            } else if (c == '-') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.SUB, "-"));
            } else if (c == '*') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.MUL, "*"));
            } else if (c == '^') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.POW, "^"));
            } else if (c == 'x') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.X, "x"));
            } else if (c == '(') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.LEFT_PAREN, "("));
            } else if (c == ')') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
            } else if (c == ',') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.COMMA, ","));
            } else if (c == 'e') {
                input = input.substring(3);
                tokens.add(new Token(TokenType.EXP, "exp"));
            } else if (c == 'f' || c == 'g' || c == 'h') {
                input = input.substring(1);
                tokens.add(new Token(TokenType.FUN, String.valueOf(c)));
            } else if (c == 'd') {
                input = input.substring(2);
                tokens.add(new Token(TokenType.DERIVE, String.valueOf("dx")));
            }
        }
    }

    public Token curToken() {
        if (position == tokens.size()) {
            return null;
        }
        return tokens.get(position);
    }

    public void next() {
        position++;
    }

    public Token nextToken() {
        if (position >= tokens.size()) {
            return null;
        }
        return tokens.get(position);
    }

    public boolean hasNext() {
        return position < tokens.size();
    }

}
