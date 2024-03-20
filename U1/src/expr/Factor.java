package expr;

import poly.Mono;
import poly.Poly;

public interface Factor {
    public Poly toPoly();

    public Mono toMono();

    public String toString();
}
