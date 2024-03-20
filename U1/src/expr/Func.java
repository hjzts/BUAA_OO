package expr;

import poly.Mono;
import poly.Poly;

import java.util.ArrayList;
import java.util.HashMap;

public class Func implements Factor {
    private Integer paraNum;
    private String funcName;
    private ArrayList<String> formalParaList;
    private String funcExpr;
    private HashMap<String, String> formal2paraMap;

    public Func(String funcName, ArrayList<String> formalParaList, String funcExpr) {
        this.funcName = funcName;
        this.formalParaList = formalParaList;
        this.paraNum = formalParaList.size();
        this.funcExpr = funcExpr;
        this.formal2paraMap = new HashMap<>();
    }

    public String func2String(ArrayList<String> preActualParaList) {
        String result = new String(funcExpr);
        result = result.replaceAll("exp", "e");
        ArrayList<String> actualParaList = new ArrayList<>();
        for (int i = 0; i < paraNum; i++) {
            actualParaList.add(preActualParaList.get(i).replaceAll("exp", "e"));
        }
        for (int i = 0; i < paraNum; i++) {
            result = result.replaceAll(formalParaList.get(i), actualParaList.get(i));
        }
        result = result.replaceAll("e", "exp");
        return result;
    }

    @Override
    public Poly toPoly() {
        return null;
    }

    @Override
    public Mono toMono() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}
