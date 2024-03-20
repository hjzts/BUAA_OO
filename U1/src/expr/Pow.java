package expr;

import poly.Mono;
import poly.Poly;

import java.math.BigInteger;

public class Pow implements Factor {
    private BigInteger coe;
    private BigInteger exp;

    public Pow(BigInteger coe, BigInteger exp) {
        this.coe = coe;
        this.exp = exp;
    }

    public BigInteger getCoe() {
        return this.coe;
    }

    public BigInteger getExp() {
        return this.exp;
    }

    @Override
    public Poly toPoly() {
        return null;
    }

    @Override
    public Mono toMono() {
        return new Mono(coe, exp);
    }

    public Pow pow(BigInteger preExp) {
        BigInteger newCoe = coe;
        BigInteger newExp = preExp.add(exp);
        return new Pow(newCoe, newExp);
    }

    public Pow mul(BigInteger preCoe) {
        BigInteger newCoe = coe.multiply(preCoe);
        BigInteger newExp = exp;
        return new Pow(newCoe, newExp);
    }

    @Override
    public String toString() {
        if (coe.compareTo(BigInteger.ZERO) == 0) {
            return "0";
        } else if (coe.compareTo(BigInteger.ONE) == 0) {
            if (exp.compareTo(BigInteger.ZERO) == 0) {
                return "1";
            } else if (exp.compareTo(BigInteger.ONE) == 0) {
                return "x";
            } else {
                return "x^" + exp;
            }
        } else if (coe.compareTo(BigInteger.ONE.negate()) == 0) {
            if (exp.compareTo(BigInteger.ZERO) == 0) {
                return "-1";
            } else if (exp.compareTo(BigInteger.ONE) == 0) {
                return "-x";
            } else {
                return "-x^" + exp;
            }
        } else {
            if (exp.compareTo(BigInteger.ZERO) == 0) {
                return coe.toString();
            } else if (exp.compareTo(BigInteger.ONE) == 0) {
                return coe + "x";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(coe);
                sb.append("*x^");
                sb.append(exp);
                return sb.toString();
            }
        }
    }
}
