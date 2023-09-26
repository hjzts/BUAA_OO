/**
 * Main方法，冒险者系列第一版
 * 9.24更新第二版
 *
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
        //System.out.println("hello");
        operation(n, inputInfo); //进行操作
    }

    public static void operation(int n, ArrayList<ArrayList<String>> inputInfo) {
        HashMap<Integer, Adventurer> adventurersMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<String> strings = inputInfo.get(i); // 获取第i行指令
            switch (strings.get(0)) { // 获取第i行指令的第一个部分
                case "1":
                    // Adventurer.add();
                    adventurerAdd(adventurersMap, strings);
                    break;
                case "2":
                    // Bottle.add();
                    bottleAdd(adventurersMap, strings);
                    break;
                case "3":
                    // Bottle.delete();
                    bottleDelete(adventurersMap, strings);
                    break;
                case "4":
                    //Equipment.add();
                    equipmentAdd(adventurersMap, strings);
                    break;
                case "5":
                    //Equipment.delete();
                    equipmentDelete(adventurersMap, strings);
                    break;
                case "6":
                    //Equipment.upgrade();
                    equipmentUpgrade(adventurersMap, strings);
                    break;
                case "7":
                    //Food.add();
                    foodAdd(adventurersMap,strings);
                    break;
                case "8":
                    //Food.delete();
                    foodDelete(adventurersMap,strings);
                    break;
                case "9":
                    // Equipment.carry();
                    equipmentCarry(adventurersMap,strings);
                    break;
                case "10":
                    // Bottle.carry();
                    bottleCarry(adventurersMap,strings);
                    break;
                case "11":
                    // Food.carry();
                    foodCarry(adventurersMap,strings);
                    break;
                case "12":
                    // Bottle.use();
                    bottleUse(adventurersMap,strings);
                    break;
                case "13":
                    // Food.use();
                    foodUse(adventurersMap,strings);
                    break;
                default:
                    break;
            }
        }
    }

    public static void adventurerAdd(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String adventurerName = strings.get(2);
        Adventurer adventurer = new Adventurer(adventurerId, adventurerName);
        adventurersMap.put(adventurerId, adventurer);
    }

    public static void bottleAdd(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        int bottleCapacity = Integer.parseInt(strings.get(4));

        Bottle bottle = new Bottle(bottleId, bottleName, bottleCapacity);
        adventurersMap.get(adventurerId).addBottle(bottle);
    }

    public static void bottleDelete(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));

        String bottleName = adventurersMap.get(adventurerId).getBottleName(bottleId);
        adventurersMap.get(adventurerId).deleteBottle(bottleId);
        int bottleCount = adventurersMap.get(adventurerId).getBottleCount();

        System.out.println(bottleCount + " " + bottleName);
    }

    public static void equipmentAdd(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = strings.get(3);
        int equipmentStar = Integer.parseInt(strings.get(4));

        Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentStar);
        adventurersMap.get(adventurerId).addEquipment(equipment);
    }

    public static void equipmentDelete(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = adventurersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventurersMap.get(adventurerId).deleteEquipment(equipmentId);
        int equipmentCount = adventurersMap.get(adventurerId).getEquipmentCount();
        System.out.println(equipmentCount + " " + equipmentName);
    }

    public static void equipmentUpgrade(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));

        String equipmentName = adventurersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventurersMap.get(adventurerId).upgradeEquipment(equipmentId);
        int equipmentStar = adventurersMap.get(adventurerId).getEquipmentStar(equipmentId);
        System.out.println(equipmentName + " " + equipmentStar);
    }

    public static void foodAdd(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));
        String foodName = strings.get(3);
        int foodEnergy = Integer.parseInt(strings.get(4));

        Food food = new Food(foodId, foodName, foodEnergy);
        adventurersMap.get(adventurerId).addFood(food);
    }

    public static void foodDelete(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));

        String foodName = adventurersMap.get(adventurerId).getFoodName(foodId);
        adventurersMap.get(adventurerId).deleteFood(foodId);
        int foodCount = adventurersMap.get(adventurerId).getFoodCount();
        System.out.println(foodCount + " " + foodName);
    }

    public static void equipmentCarry(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryEquipment(equipmentId);
    }

    public static void bottleCarry(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryBottle(bottleId);
    }

    public static void foodCarry(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryFood(foodId);
    }

    public static void bottleUse(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String bottleName = strings.get(2);

        if (adventurersMap.get(adventurerId) != null) {
            if (adventurersMap.get(adventurerId).hasBottleInBackpack(bottleName)) {
                int bottleId = adventurersMap.get(adventurerId).getBottleId(bottleName);
                int bottleCapacity = adventurersMap.get(adventurerId).useBottle(bottleName);
                adventurersMap.get(adventurerId).increaseHitPoint(bottleCapacity);
                int hitPoint = adventurersMap.get(adventurerId).getHitPoint();
                System.out.println(bottleId + " " + hitPoint);
            }
            else {
                System.out.println("fail to use " + bottleName);
            }
        }
        else {
            System.out.println("fail to use " + bottleName);
        }
    }

    public static void foodUse(
            HashMap<Integer, Adventurer> adventurersMap, ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String foodName = strings.get(2);

        if (adventurersMap.get(adventurerId) != null) {
            if (adventurersMap.get(adventurerId).hasFoodInBackpack(foodName)) {
                int foodID      =    adventurersMap.get(adventurerId).getFoodId(foodName);
                int foodEnergy  =    adventurersMap.get(adventurerId).useFood(foodName);

                adventurersMap.get(adventurerId).increaseLevel(foodEnergy);

                int level       =    adventurersMap.get(adventurerId).getLevel();
                System.out.println(foodID + " " + level);
            }
            else {
                System.out.println("fail to eat " + foodName);
            }
        }

        else {
            System.out.println("fail to eat " + foodName);
        }
    }

}