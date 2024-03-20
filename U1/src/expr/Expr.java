package expr;

import poly.Mono;
import poly.Poly;

import java.math.BigInteger;
import java.util.ArrayList;

public class Expr implements Factor {
    private final ArrayList<Term> termSet;

    private BigInteger exp;
    private BigInteger coe;

    public Expr() {
        termSet = new ArrayList<>();
        this.exp = BigInteger.ONE;
        this.coe = BigInteger.ONE;
    }

    public Expr(BigInteger exp) {
        termSet = new ArrayList<>();
        this.exp = exp;
        this.coe = BigInteger.ONE;
    }

    public Expr(BigInteger exp, BigInteger coe) {
        termSet = new ArrayList<>();
        this.exp = exp;
        this.coe = coe;
    }

    public void setExp(BigInteger exp) {
        this.exp = exp;
    }

    public void setCoe(BigInteger coe) {
        this.coe = coe;
    }

    public void mulExp(BigInteger newExp) {
        this.exp = this.exp.multiply(newExp);
    }

    public BigInteger getExp() {
        return this.exp;
    }

    public BigInteger getCoe() {
        return this.coe;
    }

    public void addTerm(Term term) {
        termSet.add(term);
    }

    public Factor getExprFactor() {
        for (Term term : termSet) {
            for (Factor factor : term.getFactors()) {
                return factor;
            }
        }
        return null;
    }

    public Integer getSize() {
        return termSet.size();
    }

    public Integer getFactorSize() {
        int i = 0;
        for (Term term : termSet) {
            i += term.getSize();
        }
        return i;
    }

    @Override
    public Poly toPoly() {
        Poly poly = new Poly();
        for (Term term : termSet) {
            Poly newPoly = term.toPoly();
            if (!coe.equals(BigInteger.ONE)) {
                newPoly.multiplyMono(new Mono(coe, BigInteger.ZERO));
            }
            poly.addPoly(newPoly);
        }
        return poly;
    }

    @Override
    public Mono toMono() {
        return null;
    }

    @Override
    public String toString() {
        if (termSet.isEmpty()) {
            return "0";
        } else if (termSet.size() == 1) {
            for (Term term : termSet) {
                if (exp.compareTo(BigInteger.ONE) == 0) {
                    return term.toString();
                } else {
                    return "(" + term + ")^" + exp;
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (Term term : termSet) {
                String termString = term.toString();
                if (termString.isEmpty()) {
                    continue;
                } else {
                    if (sb.length() > 0) {
                        sb.append("+");
                    }
                    sb.append(termString);
                }
            }
            if (sb.toString().contains("+")) {
                if (exp.compareTo(BigInteger.ONE) == 0) {
                    return "(" + sb + ")";
                } else {
                    return "(" + sb + ")^" + exp;
                }
            } else {
                if (exp.compareTo(BigInteger.ONE) == 0) {
                    return sb.toString();
                } else {
                    return "(" + sb + ")^" + exp;
                }
            }
        }
        return null;
    }
}
