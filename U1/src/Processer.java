import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Processer {
    private String exprString;
    private Integer funcNum;
    private ArrayList<String> funcList = new ArrayList<>();

    public Processer() {
        Scanner scanner = new Scanner(System.in);
        this.funcNum = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < funcNum; i++) {
            funcList.add(scanner.nextLine());
        }
        this.exprString = scanner.nextLine();
    }

    public String process(String preInput) {
        String input = preInput;
        input = input.replaceAll("\\s", "");
        input = input.replaceAll("--", "+");
        input = input.replaceAll("\\+\\+", "+");
        input = input.replaceAll("-\\+", "-");
        input = input.replaceAll("\\+-", "-");
        input = input.replaceAll("--", "+");
        input = input.replaceAll("\\^\\+", "^");
        return input;
    }

    public String processExpr() {
        return process(exprString);
    }

    public HashMap<String, String> funcMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < funcNum; i++) {
            String string = process(funcList.get(i));
            String[] strings = string.split("=");
            map.put(strings[0], strings[1]);
        }
        return map;
    }
}
