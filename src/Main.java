/**
 * Main方法，冒险者系列第一版
 * @author 86152
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        }
        HashMap<Integer, Adventurer> adventuersMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            ArrayList<String> strings = inputInfo.get(i); // 获取第i行指令
            switch (strings.get(0)) { // 获取第i行指令的第一个部分
                case "1":
                    // Adventurer.add();
                    advAd(adventuersMap, strings);
                    break;
                case "2":
                    // Bottle.add();
                    botAd(adventuersMap, strings);
                    break;
                case "3":
                    // Bottle.delete();
                    botDe(adventuersMap, strings);
                    break;
                case "4":
                    //Equipment.add();
                    equAd(adventuersMap, strings);
                    break;
                case "5":
                    //Equipment.delete();
                    equDe(adventuersMap, strings);
                    break;
                case "6":
                    //Equipment.upgrade();
                    equUp(adventuersMap, strings);
                    break;
                default:
                    break;
            }
        }
    }

    public static void advAd(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String adventurerName = strings.get(2);
        Adventurer adventurer1 = new Adventurer(adventurerId, adventurerName);
        adventuersMap.put(adventurerId, adventurer1);
    }

    public static void botAd(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        int bottleCapacity = Integer.parseInt(strings.get(4));

        Bottle bottle = new Bottle(bottleId, bottleName, bottleCapacity);
        adventuersMap.get(adventurerId).addBottle(bottle);
    }

    public static void botDe(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));

        String bottleName = adventuersMap.get(adventurerId).getBottleName(bottleId);
        adventuersMap.get(adventurerId).deleteBottle(bottleId);
        int bottleCount = adventuersMap.get(adventurerId).getBottleCount();

        System.out.println(bottleCount + " " + bottleName);
    }

    public static void equAd(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = strings.get(3);
        int equipmentStar = Integer.parseInt(strings.get(4));

        Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentStar);
        adventuersMap.get(adventurerId).addEquipment(equipment);
    }

    public static void equDe(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = adventuersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventuersMap.get(adventurerId).deleteEquipment(equipmentId);
        int equipmentCount = adventuersMap.get(adventurerId).getEquipmentCount();
        System.out.println(equipmentCount + " " + equipmentName);
    }

    public static void equUp(HashMap<Integer, Adventurer> adventuersMap,ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));

        String equipmentName = adventuersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventuersMap.get(adventurerId).upgradeEquipment(equipmentId);
        int equipmentStar = adventuersMap.get(adventurerId).getEquipmentStar(equipmentId);
        System.out.println(equipmentName + " " + equipmentStar);
    }
}