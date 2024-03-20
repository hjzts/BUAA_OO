import expr.Func;

import java.util.ArrayList;
import java.util.HashMap;

public class Definer {

    private HashMap<String, String> func2ExprMap;
    private HashMap<String, Func> funcMap;
    private final ArrayList<String> newParaList = new ArrayList<>();

    public Definer(HashMap<String, String> func2ExprMap) {
        this.func2ExprMap = func2ExprMap;
        newParaList.add("u");
        newParaList.add("v");
        newParaList.add("w");
        define();
    }

    public void define() {
        funcMap = new HashMap<>();
        String func;
        String funcName;
        for (HashMap.Entry<String, String> entry : func2ExprMap.entrySet()) {
            func = entry.getKey();
            funcName = String.valueOf(func.charAt(0));
            func = func.substring(2);

            String[] para = func.split("[,)]");
            ArrayList<String> paraList = new ArrayList<>();
            for (int j = 0; j < para.length; j++) {
                paraList.add(para[j]);
            }
            String expr = entry.getValue();
            ArrayList<String> formalParaList = new ArrayList<>();
            expr = expr.replaceAll("exp", "e");
            for (int j = 0; j < para.length; j++) {
                expr = expr.replaceAll(paraList.get(j), newParaList.get(j));
                formalParaList.add(newParaList.get(j));
            }
            expr = expr.replaceAll("e", "exp");
            Func f = new Func(funcName, formalParaList, expr);
            funcMap.put(funcName, f);
        }
    }

    public Func getFunc(String funcName) {
        return funcMap.get(funcName);
    }

}
