import poly.Mono;
import poly.Poly;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Optimizer {
    private Poly poly;

    public Optimizer(Poly poly) {
        this.poly = poly;
    }

    public Poly optimize() {
        HashMap<BigInteger, ArrayList<Mono>> monoMap = new HashMap<>();
        for (Mono mono : poly.getMonoList()) {
            BigInteger exp = mono.getExp();
            if (monoMap.containsKey(exp)) {
                ArrayList<Mono> preMonoList = monoMap.get(exp);
                boolean flag = false;
                for (Mono preMono : preMonoList) {
                    if (mono.isSameKind(mono, preMono)) {
                        preMono.setCoe(preMono.getCoe().add(mono.getCoe()));
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    preMonoList.add(mono);
                }
            } else {
                ArrayList<Mono> monoList = new ArrayList<>();
                monoList.add(mono);
                monoMap.put(exp, monoList);
            }
        }

        Poly result = new Poly();
        for (ArrayList<Mono> monoList : monoMap.values()) {
            for (Mono mono : monoList) {
                if (mono.getCoe().compareTo(BigInteger.ZERO) == 0) {
                    continue;
                } else {
                    result = result.addMono(result, mono);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        Poly result = optimize();
        if (result.isEmpty()) {
            return "0";
        }
        ArrayList<String> monoList = new ArrayList<>();
        int position = -1;
        for (Mono mono : result.getMonoList()) {
            monoList.add(mono.toString());
            if (position == -1 && mono.getCoe().signum() == 1) {
                position = monoList.size() - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
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
                if (monoList.get(i).charAt(0) == '-') {
                    sb.append(monoList.get(i));
                } else {
                    sb.append("+");
                    sb.append(monoList.get(i));
                }
            }
        }
        return sb.toString();
    }
}
