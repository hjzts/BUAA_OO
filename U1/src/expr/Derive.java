package expr;

import poly.Mono;
import poly.Poly;

public class Derive implements Factor {
    private Expr expr;

    public Derive(Expr expr) {
        this.expr = expr;
    }

    @Override
    public Poly toPoly() {
        Poly poly = expr.toPoly();
        return poly.derive();
    }

    @Override
    public Mono toMono() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("dx(").append(expr.toString()).append(")");
        return sb.toString();
    }
}
