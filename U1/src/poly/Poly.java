package poly;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class Poly {

    private ArrayList<Mono> monos;
    private String string;

    public Poly() {
        monos = new ArrayList<Mono>();
    }

    public Poly clone() {
        Poly poly = new Poly();
        for (Mono mono : monos) {
            poly.addMono(mono.clone());
        }
        return poly;
    }

    public boolean equals(Poly newPoly) {
        if (this.monos.size() != newPoly.getSize()) {
            return false;
        } else if (this.monos.isEmpty() && newPoly.isEmpty()) {
            return true;
        } else {
            for (Mono mono1 : monos) {
                HashSet<Mono> containSet = new HashSet<Mono>();
                boolean contain = false;
                for (Mono mono2 : newPoly.getMonoList()) {
                    if (containSet.contains(mono2)) {
                        continue;
                    } else if (mono1.equals(mono2)) {
                        containSet.add(mono2);
                        contain = true;
                    }
                }
                if (!contain) {
                    return false;
                }
            }
            return true;
        }
    }

    public ArrayList<Mono> getMonoList() {
        return monos;
    }

    public Boolean isEmpty() {
        if (monos.isEmpty()) {
            return true;
        }
        if (monos.size() == 1) {
            if (monos.get(0).getCoe().equals(BigInteger.ZERO)) {
                return true;
            }
        }
        return false;
    }

    public void addPoly(Poly newPoly) {
        for (Mono mono : newPoly.getMonoList()) {
            this.addMono(mono);
        }
    }

    public Poly addPoly(Poly poly1, Poly poly2) {
        Poly result = new Poly();
        if (!poly1.isEmpty()) {
            for (Mono mono1 : poly1.monos) {
                result = result.addMono(result, mono1);
            }
        }
        if (!poly2.isEmpty()) {
            for (Mono mono2 : poly2.monos) {
                result = result.addMono(result, mono2);
            }
        }
        return result;
    }

    public void addMono(Mono mono) {
        for (Mono newMono : monos) {
            if (newMono.isSameKind(newMono, mono)) {
                if (newMono.getCoe().add(mono.getCoe()).equals(BigInteger.ZERO)) {
                    monos.remove(newMono);
                    return;
                }
                newMono.addSameKind(mono);
                return;
            }
        }
        this.monos.add(mono);
    }

    public Poly addMono(Poly poly, Mono mono) {
        // important to merge
        Poly result = poly.clone();
        if (poly.isEmpty()) {
            result.addMono(mono);
            return result;
        }
        int flag = 0;
        for (Mono mono1 : result.monos) {
            if (mono1.isSameKind(mono1, mono)) {
                mono1.setCoe(mono1.getCoe().add(mono.getCoe()));
                if (mono1.getCoe().compareTo(BigInteger.ZERO) == 0) {
                    result.monos.remove(mono1);
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            result.addMono(mono);
        }
        return result;
    }

    public void multiplyPoly(Poly newPoly) {
        Poly result = new Poly();
        for (Mono mono1 : monos) {
            for (Mono mono2 : newPoly.getMonoList()) {
                Mono newMono = mono1.multiplyMono(mono1, mono2);
                result.addMono(newMono);
            }
        }
        monos.clear();
        monos = result.getMonoList();
    }

    public Poly multiplyPoly(Poly poly1, Poly poly2) {
        Poly result = new Poly();
        for (Mono mono1 : poly1.monos) {
            for (Mono mono2 : poly2.monos) {
                result = result.addMono(result, mono1.multiplyMono(mono1, mono2));
            }
        }
        return result;
    }

    public void multiplyMono(Mono mono) {
        for (Mono mono1 : monos) {
            mono1.multiplyMono(mono);
        }
    }

    public Poly multiplyMono(Poly poly, Mono mono) {
        Poly result = new Poly();
        for (Mono mono1 : poly.monos) {
            Mono newMono = mono1.multiplyMono(mono1, mono);
            result = result.addMono(result, newMono);
        }
        return result;
    }

    public Poly toNegate(Poly poly) {
        Poly result = new Poly();
        for (Mono mono : poly.monos) {
            result = result.addMono(result, mono.multiplyNum(mono, BigInteger.ONE.negate()));
        }
        return result;
    }

    public void powPoly(BigInteger preExp) {
        BigInteger exp = preExp;
        if (exp.equals(BigInteger.ZERO)) {
            Mono mono = new Mono(BigInteger.ONE, BigInteger.ZERO);
            monos.clear();
            monos.add(mono);
            return;
        }
        Poly result = new Poly();
        result.addMono(new Mono(BigInteger.ONE, BigInteger.ZERO));
        Poly newPoly = this.clone();
        while (exp.compareTo(BigInteger.ZERO) > 0) {
            result.multiplyPoly(newPoly);
            exp = exp.subtract(BigInteger.ONE);
        }
        monos.clear();
        monos = result.getMonoList();
    }

    public Poly powPoly(Poly poly, BigInteger preExp) {
        BigInteger exp = preExp;
        Poly result = new Poly();
        if (exp.equals(BigInteger.ZERO)) {
            Mono mono = new Mono(BigInteger.ONE, BigInteger.ZERO);
            result = result.addMono(result, mono);
            return result;
        }
        Poly newPoly = poly.clone();
        result = result.addMono(result, new Mono(BigInteger.ONE, BigInteger.ZERO));
        while (exp.compareTo(BigInteger.ZERO) > 0) {
            if (exp.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = result.multiplyPoly(result, newPoly);
            }
            newPoly = newPoly.multiplyPoly(newPoly, poly);
            exp = exp.divide(BigInteger.valueOf(2));
        }
        return result;
    }

    public Poly derive() {
        Poly poly = new Poly();
        for (Mono mono : monos) {
            poly.addPoly(mono.derive());
        }
        return poly;
    }

    @Override
    public String toString() {
        if (string != null) {
            //return string;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> monoList = new ArrayList<>();
        int position = -1;
        for (Mono mono : monos) {
            monoList.add(mono.toString());
            if (position == -1 && mono.getCoe().signum() == 1) {
                position = monoList.size() - 1;
            }
        }
        if (position == -1) {
            for (int i = 0; i < monoList.size(); i++) {
                sb.append(monoList.get(i));
            }
        } else {
            sb.append(monoList.get(position));
            for (int i = 0; i < monoList.size(); i++) {
                if (i == position) {
                    continue;
                }
                if (monoList.get(i).isEmpty()) {
                    continue;
                }
                if (monoList.get(i).charAt(0) == '-') {
                    sb.append(monoList.get(i));
                } else {
                    sb.append("+");
                    sb.append(monoList.get(i));
                }
            }
        }

        string = sb.toString();
        return string;
    }

    public Integer getSize() {
        return monos.size();
    }

    public String sortString() {
        ArrayList<String> list = new ArrayList<>();
        for (Mono mono : monos) {
            list.add(mono.toString());
        }
        list.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
