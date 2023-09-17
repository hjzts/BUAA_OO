// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private int adventuerId;
    private String adventuerName;
    private int bottleCount;
    private int equipmentCount;

    private int bottleId;
    private String bottleName;
    private int bottleCapacity;

    private int equipmentId;
    private String equipmentName;
    private int equipmentStar;

    public void main(String[] args) {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        }
        HashMap<Integer, Adventuer> adventuersMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            ArrayList<String> strings = inputInfo.get(i); // 获取第i行指令
            switch (strings.get(0)) { // 获取第i行指令的第一个部分
                case "1":
                    // Adventuer.add();
                    adventuerAdd(adventuersMap, strings);
                    break;
                case "2":
                    // Bottle.add();
                    bottleAdd(adventuersMap, strings);
                    break;
                case "3":
                    // Bottle.delete();
                    bottleDelete(adventuersMap, strings);
                    break;
                case "4":
                    //Equipment.add();
                    equipmentAdd(adventuersMap, strings);
                    break;
                case "5":
                    //Equipment.delete();
                    equipmentDel(adventuersMap, strings);
                    break;
                case "6":
                    //Equipment.upgrade();
                    equipmentUp(adventuersMap, strings);
                    break;
                default:
                    break;
            }
        }
    }

    public void adventuerAdd(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        adventuerName = strings.get(2);
        Adventuer adventuer1 = new Adventuer(adventuerId, adventuerName);
        adventuersMap.put(adventuerId, adventuer1);
    }

    public void bottleAdd(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        bottleId = Integer.parseInt(strings.get(2));
        bottleName = strings.get(3);
        bottleCapacity = Integer.parseInt(strings.get(4));

        Bottle bottle = new Bottle(bottleId, bottleName, bottleCapacity);
        adventuersMap.get(adventuerId).addBottle(bottle);
    }

    public void bottleDelete(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        bottleId = Integer.parseInt(strings.get(2));

        bottleName = adventuersMap.get(adventuerId).getBottleName(bottleId);
        adventuersMap.get(adventuerId).deleteBottle(bottleId);
        bottleCount = adventuersMap.get(adventuerId).getBottleCount();

        System.out.println(bottleCount + " " + bottleName);
    }

    public void equipmentAdd(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        equipmentId = Integer.parseInt(strings.get(2));
        equipmentName = strings.get(3);
        equipmentStar = Integer.parseInt(strings.get(4));

        Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentStar);
        adventuersMap.get(adventuerId).addEquipment(equipment);
    }

    public void equipmentDel(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        equipmentId = Integer.parseInt(strings.get(2));
        equipmentName = adventuersMap.get(adventuerId).getEquipmentName(equipmentId);
        adventuersMap.get(adventuerId).deleteEquipment(equipmentId);
        equipmentCount = adventuersMap.get(adventuerId).getEquipmentCount();
        System.out.println(equipmentCount + " " + equipmentName);
    }

    public void equipmentUp(HashMap<Integer, Adventuer> adventuersMap, ArrayList<String> strings) {
        adventuerId = Integer.parseInt(strings.get(1));
        equipmentId = Integer.parseInt(strings.get(2));

        equipmentName = adventuersMap.get(adventuerId).getEquipmentName(equipmentId);
        adventuersMap.get(adventuerId).upgradeEquipment(equipmentId);
        equipmentStar = adventuersMap.get(adventuerId).getEquipmentStar(equipmentId);
        System.out.println(equipmentName + " " + equipmentStar);
    }
}