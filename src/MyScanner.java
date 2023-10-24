import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 用于解析输入输出
 * 2023/10/23 21:10
 *
 * @author hugo
 */
public class MyScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static int getOperationLine() {
        return Integer.parseInt(scanner.nextLine().trim()); // 读取行数
    }

    private static int n = getOperationLine();

    public static ArrayList<ArrayList<String>> getInputInfo() {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            ArrayList<String> operation = new ArrayList(Arrays.asList(strings));
            if (operation.get(0).equals("14")) {
                int k = Integer.parseInt(operation.get(2));
                for (int j = 0; j < k; j++) {
                    String nextLine1 = scanner.nextLine();
                    operation.add(nextLine1.trim());
                }
            }
            // System.out.println(operation);
            inputInfo.add(operation); // 将指令分割后的各个部分存进容器中
        }
        // System.out.println(inputInfo);
        return inputInfo;
    }

    public static int getN() {
        return n;
    }
}
