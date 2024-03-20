package expr;

import poly.Mono;
import poly.Poly;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class Term {
    private final ArrayList<Factor> factorSet;
    private Pow termPower;

    public Term() {
        factorSet = new ArrayList<>();
        termPower = new Pow(BigInteger.ONE, BigInteger.ZERO);
    }

    public Term(Pow exprPower) {
        factorSet = new ArrayList<>();
        termPower = exprPower;
        factorSet.add(termPower);
    }

    public void addFactor(Factor factor) {
        factorSet.add(factor);
    }

    public Term MultTerm(Term term) {
        BigInteger coe = termPower.getCoe().multiply(term.termPower.getCoe());
        BigInteger exp = termPower.getExp().add(term.termPower.getExp());
        Pow exprPower = new Pow(coe, exp);
        return new Term(exprPower);
    }

    public Poly toPoly() {
        Poly poly = new Poly();
        poly.addMono(new Mono(BigInteger.ONE, BigInteger.ZERO));
        for (Factor factor : factorSet) {
            if (factor instanceof Pow) {
                poly.multiplyMono(factor.toMono());
            } else if (factor instanceof Expr) {
                if (!Objects.equals(((Expr) factor).getExp(), BigInteger.ONE)) {
                    BigInteger exp = ((Expr) factor).getExp();

                    Poly factorPoly = factor.toPoly();
                    factorPoly.powPoly(exp);
                    poly.multiplyPoly(factorPoly);

                } else {
                    poly.multiplyPoly(factor.toPoly());
                }
            } else if (factor instanceof Expon) {
                poly = poly.multiplyMono(poly, factor.toMono());
            } else if (factor instanceof Derive) {
                poly.multiplyPoly(factor.toPoly());
            }
        }
        return poly;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (factorSet.isEmpty()) {
            return "";
        } else {
            for (Factor factor : factorSet) {
                if (sb.length() > 0) {
                    sb.append("*");
                }
                sb.append(factor.toString());
            }
            return sb.toString();
        }
    }

    public ArrayList<Factor> getFactors() {
        return this.factorSet;
    }

    public Integer getSize() {
        return this.factorSet.size();
    }
}
