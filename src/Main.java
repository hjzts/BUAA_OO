/**
 * Main方法，冒险者系列第一版
 * 9.24更新第二版
 *
 * @author 86152
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int n = MyScanner.getN();
        ArrayList<ArrayList<String>> inputInfo = MyScanner.getInputInfo();
        Manager.operation(n,inputInfo);
    }
}