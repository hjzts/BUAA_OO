package expr;

import poly.Mono;
import poly.Poly;

import java.math.BigInteger;

public class Expon implements Factor {
    private Factor factor;

    public Expon(Factor factor) {
        this.factor = factor;
    }

    @Override
    public Poly toPoly() {
        return null;
    }

    @Override
    public Mono toMono() {
        return new Mono(factor.toPoly());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("exp(");
        if (factor instanceof Expr) {
            sb.append("(");
            if (((Expr) factor).getCoe().compareTo(BigInteger.ONE) != 0) {
                sb.append(((Expr) factor).getCoe());
                sb.append("*");
            }
            sb.append(factor.toString());
            sb.append(")");
            if (((Expr) factor).getExp().compareTo(BigInteger.ONE) != 0) {
                sb.append(")^");
                sb.append(((Expr) factor).getExp());
            }
        } else {
            sb.append(factor.toString());
        }
        sb.append(")");
        return sb.toString();
    }

}
