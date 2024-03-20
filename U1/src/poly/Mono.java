package poly;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.ArrayList;

public class Mono {
    private BigInteger coe;
    private BigInteger exp;

    private Poly expPoly;

    public Mono(BigInteger coe, BigInteger exp) {
        this.coe = coe;
        this.exp = exp;
        this.expPoly = new Poly();
    }

    public Mono(Poly expPoly) {
        this.coe = BigInteger.ONE;
        this.exp = BigInteger.ZERO;
        this.expPoly = expPoly;
    }

    public Mono(BigInteger coe, BigInteger exp, Poly expPoly) {
        this.coe = coe;
        this.exp = exp;
        this.expPoly = expPoly;
    }

    public boolean expIsExpr() {
        if (expPoly.toString().contains("*")) {
            return true;
        }
        return false;
    }

    public void setCoe(BigInteger coe) {
        this.coe = coe;
    }

    public void setExp(BigInteger exp) {
        this.exp = exp;
    }

    public BigInteger getCoe() {
        return coe;
    }

    public BigInteger getExp() {
        return exp;
    }

    public Poly getExpPoly() {
        return expPoly;
    }

    public void multiplyMono(Mono newMono) {
        this.coe = this.coe.multiply(newMono.getCoe());
        this.exp = this.exp.add(newMono.getExp());
        this.expPoly.addPoly(newMono.getExpPoly());
    }

    public Mono multiplyMono(Mono mono1, Mono mono2) {
        BigInteger newCoe = mono1.coe.multiply(mono2.coe);
        BigInteger newExp = mono1.exp.add(mono2.exp);

        Poly newExpPoly = new Poly();
        newExpPoly = newExpPoly.addPoly(mono1.getExpPoly(), mono2.getExpPoly());
        return new Mono(newCoe, newExp, newExpPoly);
    }

    public void multiplyNum(BigInteger num) {
        this.coe = this.coe.multiply(num);
    }

    public Mono multiplyNum(Mono mono, BigInteger num) {
        BigInteger newCoe = mono.coe.multiply(num);
        BigInteger newExp = mono.exp;
        Poly newPoly = mono.expPoly;
        return new Mono(newCoe, newExp, newPoly);
    }

    public void addMono(Mono newMono) {
        this.coe = this.coe.add(newMono.getCoe());
    }

    public Mono addMono(Mono mono1, Mono mono2) {
        Mono mono = new Mono(mono1.getCoe().add(mono2.getExp()),
                mono1.getExp(), mono1.getExpPoly().clone());
        return mono;
    }

    public boolean isSameKind(Mono mono1, Mono mono2) {
        if (mono1.getExp().compareTo(mono2.getExp()) != 0) {
            return false;
        }
        Poly expPoly1 = mono1.getExpPoly();
        Poly expPoly2 = mono2.getExpPoly();
        Poly result = new Poly();
        result = expPoly2.toNegate(expPoly2);
        result = result.addPoly(result, expPoly1);
        if (result.isEmpty()) {
            return true;
        }
        return false;

    }

    public void addSameKind(Mono mono) {
        this.coe = this.coe.add(mono.getCoe());
    }

    public Mono addSameKind(Mono mono1, Mono mono2) {
        BigInteger newCoe = mono1.getCoe().add(mono2.getCoe());
        BigInteger newExp = mono1.getExp();
        Poly newExpPoly = mono1.getExpPoly();
        Mono result = new Mono(newCoe, newExp, newExpPoly);
        return result;
    }

    public void subSameKind(Mono mono) {
        this.coe = this.coe.subtract(mono.getCoe());
    }

    public Mono subSameKind(Mono mono1, Mono mono2) {
        BigInteger newCoe = mono1.getCoe().subtract(mono2.getCoe());
        BigInteger newExp = mono2.getExp();
        Poly newExpPoly = mono1.getExpPoly();
        Mono result = new Mono(newCoe, newExp, newExpPoly);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String expPolyString = expPoly.toString();

        if (coe.equals(BigInteger.ZERO)) {
            return "";
        } else if (coe.equals(BigInteger.ONE)) {
            if (exp.equals(BigInteger.ZERO)) {
                if (expPolyString.isEmpty() || expPolyString.equals("0")) {
                    return "1";
                }
            } else if (exp.equals(BigInteger.ONE)) {
                sb.append("x");
            } else {
                sb.append("x^").append(exp);
            }

        } else if (coe.equals(BigInteger.ONE.negate())) {
            if (exp.equals(BigInteger.ZERO)) {
                if (expPolyString.isEmpty() || expPolyString.equals("0")) {
                    return "-1";
                } else {
                    sb.append("-");
                }
            } else if (exp.equals(BigInteger.ONE)) {
                sb.append("-x");
            } else {
                sb.append("-x^").append(exp);
            }

        } else {
            if (exp.equals(BigInteger.ZERO)) {
                sb.append(coe);
            } else if (exp.equals(BigInteger.ONE)) {
                sb.append(coe).append("*x");
            } else {
                sb.append(coe).append("*x^").append(exp);
            }

        }

        if (!(expPolyString.isEmpty() || "0".equals(expPolyString))) {
            if (sb.length() > 0 && (!"-".contentEquals(sb))) {
                sb.append("*");
            }
            sb.append(processExpPoly(expPoly, expPolyString));
        }


        return sb.toString();

    }

    public String processExpPoly(Poly expPoly, String expPolyString) {
        StringBuilder sb = new StringBuilder();

        Integer preLen = expPolyString.length();


        String numRegex = "[-]?\\d+$";
        String powRegex = "x(\\^\\d+)?$";
        String expRegex = "^exp\\(.*\\)$";

        if (expPolyString.matches(numRegex)
                || expPolyString.matches(powRegex)
                || (expPolyString.matches(expRegex) && expPoly.getSize() == 1)) {
            sb.append("exp(").append(expPolyString).append(")");
            preLen += 5;
        } else {
            // get gcd
            preLen += 7;
            if (expPolyString.matches("x.+") || expPolyString.matches("(.*[+-]x.*)")) {
                // 含有系数为1的项
                sb.append("exp((").append(expPolyString).append("))");
            } else {
                Pair<BigInteger, String> pair = extractGcd(expPolyString);
                BigInteger gcd = pair.getKey();
                if (gcd.equals(BigInteger.ONE)) {
                    sb.append("exp((").append(expPolyString).append("))");
                } else {
                    String extractExpPoly = pair.getValue();
                    if (extractExpPoly.matches(numRegex) || extractExpPoly.matches(powRegex)
                            || extractExpPoly.matches(expRegex)) {
                        sb.append("exp(").append(extractExpPoly).append(")^").append(gcd);
                    } else {
                        sb.append("exp((").append(extractExpPoly).append("))^").append(gcd);
                    }
                }
            }
        }
        if (sb.toString().length() > preLen) {
            if (expPolyString.matches(numRegex)
                    || expPolyString.matches(powRegex)
                    || (expPolyString.matches(expRegex) && expPoly.getSize() == 1)) {
                return "exp(" + expPolyString + ")";
            } else {
                return "exp((" + expPolyString + "))";
            }
        } else {
            return sb.toString();
        }
    }

    public static BigInteger getGcd(String polyString,
                                    ArrayList<Pair<BigInteger, String>> monoStringList) {

        int n = polyString.length();
        int index = 0;
        while (index < n) {
            Pair pair = getBigInteger(polyString, index);
            BigInteger coe = (BigInteger) pair.getValue();
            index = (int) pair.getKey();
            StringBuilder sb = new StringBuilder();
            int parenCnt = 0;
            while (index < n) {
                char c = polyString.charAt(index);
                if (c == '(') {
                    parenCnt++;
                } else if (c == ')') {
                    parenCnt--;
                }
                if (parenCnt == 0 && (c == '+' || c == '-')) {
                    break;
                }
                sb.append(c);
                index++;
            }
            monoStringList.add(new Pair<>(coe, sb.toString()));
        }

        BigInteger gcd = new BigInteger(monoStringList.get(0).getKey().toString());
        if (gcd.compareTo(BigInteger.ZERO) < 0) {
            gcd = gcd.negate();
        }
        for (Pair<BigInteger, String> pair : monoStringList) {
            BigInteger coe = pair.getKey();
            BigInteger tmpCoe = new BigInteger(coe.toString());
            if (tmpCoe.compareTo(BigInteger.ZERO) < 0) {
                tmpCoe = tmpCoe.negate();
            }
            gcd = gcd.gcd(tmpCoe);
        }
        return gcd;
    }

    public static Pair<Integer, BigInteger> getBigInteger(String polyString, int oleIndex) {
        int index = oleIndex;
        int sign = 1;
        if (polyString.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (polyString.charAt(index) == '+') {
            index++;
        }
        int n = polyString.length();
        StringBuilder sb = new StringBuilder();
        while (index < n && Character.isDigit(polyString.charAt(index))) {
            sb.append(polyString.charAt(index));
            index++;
        }
        if (sb.length() == 0) {
            if (sign == -1) {
                return new Pair(index, BigInteger.ONE.negate());
            } else {
                return new Pair(index, BigInteger.ONE);
            }
        }
        if (sign == -1) {
            sb.insert(0, '-');
        }
        return new Pair(index, new BigInteger(sb.toString()));
    }

    public static Pair<BigInteger, String> extractGcd(String expPolyString) {
        ArrayList<Pair<BigInteger, String>> monoStringList = new ArrayList<>();
        BigInteger gcd = getGcd(expPolyString, monoStringList);
        if (gcd.equals(BigInteger.ONE)) {
            return new Pair<>(gcd, expPolyString);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Pair<BigInteger, String> pair : monoStringList) {
                BigInteger coe = pair.getKey().divide(gcd);
                String monoString = pair.getValue();
                if (sb.length() > 0) {
                    if (coe.compareTo(BigInteger.ZERO) > 0) {
                        sb.append("+");
                    }
                }
                if (coe.equals(BigInteger.ONE)) {
                    if (monoString.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append(monoString.substring(1));
                    }
                } else if (coe.equals(BigInteger.ONE.negate())) {
                    if (monoString.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append("-").append(monoString.substring(1));
                    }
                } else {
                    sb.append(coe).append(monoString);
                }
            }
            return new Pair<>(gcd, sb.toString());
        }
    }

    public boolean equals(Mono newMono) {
        if (exp.compareTo(newMono.getExp()) != 0) {
            return false;
        } else if (this.coe != newMono.getCoe()) {
            return false;
        } else if (this.exp != newMono.getExp()) {
            return false;
        } else if (expPoly.equals(newMono.getExpPoly())) {
            return true;
        }
        return false;
    }

    public Mono clone() {
        Mono mono = new Mono(this.coe, this.exp, this.expPoly);
        return mono;
    }

    public Poly derive() {
        Poly poly = new Poly();
        if (exp.equals(BigInteger.ZERO)) {
            BigInteger newCoe = new BigInteger(String.valueOf(coe.toString()));
            BigInteger newExp = new BigInteger("0");
            Mono newMono = new Mono(newCoe, newExp, this.expPoly.clone());
            Poly newPoly = this.expPoly.clone().derive();
            poly = poly.multiplyMono(newPoly, newMono);
            return poly;
        } else {
            BigInteger newCoe = new BigInteger(String.valueOf(coe.toString()));
            BigInteger newExp = new BigInteger(String.valueOf(exp.toString()));
            Mono newMono = new Mono(newCoe, newExp, this.expPoly.clone());
            Poly newPoly = this.expPoly.clone().derive();
            poly = poly.multiplyMono(newPoly, newMono);

            BigInteger newCoePre = coe.multiply(exp);
            BigInteger newExpPre = exp.subtract(BigInteger.ONE);
            Mono newMonoPre = new Mono(newCoePre, newExpPre, this.expPoly.clone());
            poly.addMono(newMonoPre);

            return poly;
        }
    }
}
