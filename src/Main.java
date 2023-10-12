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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static HashMap<Integer, Adventurer> adventurersMap = new HashMap<>();
    private static FightMode fightMode = new FightMode();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getOperationLine();
        ArrayList<ArrayList<String>> inputInfo = getInputInfo(n);
        operation(n, inputInfo); //进行操作
    }

    public static int getOperationLine() {
        return Integer.parseInt(scanner.nextLine().trim()); // 读取行数
    }

    public static ArrayList<ArrayList<String>> getInputInfo(int n) {
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

    public static void operation(int n, ArrayList<ArrayList<String>> inputInfo) {
        boolean printTestFlag = false;
        HashMap<Integer, Adventurer> adventurersMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<String> strings = inputInfo.get(i); // 获取第i行指令
            switch (strings.get(0)) { // 获取第i行指令的第一个部分
                case "1":
                    // Adventurer.add();
                    adventurerAdd(strings);
                    break;
                case "2":
                    // Bottle.add();
                    bottleAdd(strings);
                    break;
                case "3":
                    // Bottle.delete();
                    //if(printTestFlag)  System.out.print("3 :");
                    bottleDelete(strings);
                    break;
                case "4":
                    //Equipment.add();
                    equipmentAdd(strings);
                    break;
                case "5":
                    //Equipment.delete();
                    //if(printTestFlag)  System.out.print("5 :");
                    equipmentDelete(strings);
                    break;
                case "6":
                    //Equipment.upgrade();
                    //if(printTestFlag)  System.out.print("6 :");
                    equipmentUpgrade(strings);
                    break;
                case "7":
                    //Food.add();
                    foodAdd(strings);
                    break;
                case "8":
                    //Food.delete();
                    //if(printTestFlag)  System.out.print("8 :");
                    foodDelete(strings);
                    break;
                case "9":
                    // Equipment.carry();
                    equipmentCarry(strings);
                    break;
                case "10":
                    // Bottle.carry();
                    bottleCarry(strings);
                    break;
                case "11":
                    // Food.carry();
                    foodCarry(strings);
                    break;
                case "12":
                    // Bottle.use();
                    //if(printTestFlag)  System.out.print("12 :");
                    bottleUse(strings, 0);
                    break;
                case "13":
                    // Food.use();
                    //if(printTestFlag)  System.out.print("13 :");
                    foodUse(strings);
                    break;
                case "14":
                    // Enter Fight Mode
                    enterFightMode(strings);
                    break;
                case "15":
                    // query in YYYY/MM
                    queryTimeLog(strings);
                    break;
                case "16":
                    // query adventurer attack log
                    queryAttackLog(strings);
                    break;
                // case "17":
                //      query adventurer be attacked log
                //      queryBeAttackedLog(strings);
                //      break;
                default:
                    queryBeAttackedLog(strings);
                    break;
            }
        }
    }

    public static void adventurerAdd(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String adventurerName = strings.get(2);
        Adventurer adventurer = new Adventurer(adventurerId, adventurerName);
        adventurersMap.put(adventurerId, adventurer);
    }

    public static void bottleAdd(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        int bottleCapacity = Integer.parseInt(strings.get(4));

        Bottle bottle = new Bottle(bottleId, bottleName, bottleCapacity);
        adventurersMap.get(adventurerId).addBottle(bottle);
    }

    public static void bottleDelete(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));

        String bottleName = adventurersMap.get(adventurerId).getBottleName(bottleId);
        adventurersMap.get(adventurerId).deleteBottle(bottleId);
        int bottleCount = adventurersMap.get(adventurerId).getBottleCount();

        System.out.println(bottleCount + " " + bottleName);
    }

    public static void equipmentAdd(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = strings.get(3);
        int equipmentStar = Integer.parseInt(strings.get(4));

        Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentStar);
        adventurersMap.get(adventurerId).addEquipment(equipment);
    }

    public static void equipmentDelete(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        if (adventurersMap.get(adventurerId) == null) {
            System.out.println("有脏东西");
            return;
        }
        String equipmentName = adventurersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventurersMap.get(adventurerId).deleteEquipment(equipmentId);
        int equipmentCount = adventurersMap.get(adventurerId).getEquipmentCount();
        System.out.println(equipmentCount + " " + equipmentName);
    }

    public static void equipmentUpgrade(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));

        String equipmentName = adventurersMap.get(adventurerId).getEquipmentName(equipmentId);
        adventurersMap.get(adventurerId).upgradeEquipment(equipmentId);
        int equipmentStar = adventurersMap.get(adventurerId).getEquipmentStar(equipmentId);
        System.out.println(equipmentName + " " + equipmentStar);
    }

    public static void foodAdd(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));
        String foodName = strings.get(3);
        int foodEnergy = Integer.parseInt(strings.get(4));

        Food food = new Food(foodId, foodName, foodEnergy);
        adventurersMap.get(adventurerId).addFood(food);
    }

    public static void foodDelete(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));

        String foodName = adventurersMap.get(adventurerId).getFoodName(foodId);
        adventurersMap.get(adventurerId).deleteFood(foodId);
        int foodCount = adventurersMap.get(adventurerId).getFoodCount();
        System.out.println(foodCount + " " + foodName);
    }

    public static void equipmentCarry(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryEquipment(equipmentId);
    }

    public static void equipmentUse(int beAttackedId, int hitPointDecrease) {
        adventurersMap.get(beAttackedId).decreaseHitPoint(hitPointDecrease);
        int hitPoint = adventurersMap.get(beAttackedId).getHitPoint();
        System.out.println(beAttackedId + " " + hitPoint);
    }

    public static void bottleCarry(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryBottle(bottleId);
    }

    public static void foodCarry(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));

        adventurersMap.get(adventurerId).carryFood(foodId);
    }

    public static boolean bottleUse(ArrayList<String> strings, int flag) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String bottleName = strings.get(2);


        if (adventurersMap.get(adventurerId).hasBottleInBackpack(bottleName)) {
            int bottleId = adventurersMap.get(adventurerId).getBottleId(bottleName);
            int bottleCapacity = adventurersMap.get(adventurerId).useBottle(bottleName);
            adventurersMap.get(adventurerId).increaseHitPoint(bottleCapacity);
            int hitPoint = adventurersMap.get(adventurerId).getHitPoint();
            System.out.println(bottleId + " " + hitPoint);
            return true;
        } else if (flag == 0) {
            System.out.println("fail to use " + bottleName);
            return false;
        } else if (flag == 1) {
            System.out.println("Fight log error");
            return false;
        } else {
            System.out.println("有脏东西");
            return false;
        }
    }

    public static void foodUse(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String foodName = strings.get(2);

        if (adventurersMap.get(adventurerId).hasFoodInBackpack(foodName)) {
            int foodId = adventurersMap.get(adventurerId).getFoodId(foodName);
            int foodEnergy = adventurersMap.get(adventurerId).useFood(foodName);
            adventurersMap.get(adventurerId).increaseLevel(foodEnergy);
            int level = adventurersMap.get(adventurerId).getLevel();
            System.out.println(foodId + " " + level);
        } else {
            System.out.println("fail to eat " + foodName);
        }
    }

    public static void enterFightMode(ArrayList<String> strings) {
        System.out.println("Enter Fight Mode");
        int m = Integer.parseInt(strings.get(1));
        int k = Integer.parseInt(strings.get(2));
        // 冒险者进入战斗模式
        for (int i = 3; i < m + 3; i++) {
            int adventurerId = getAdventurer(strings.get(i)).getId();
            if (adventurerId == -1) {
                System.out.println("有脏东西");
            } else {
                fightMode.enterFightMode(adventurersMap.get(adventurerId));
            }
        }
        // 匹配战斗日志
        String regexPattern1 = "(\\d{4})/(\\d{2})-(\\S+)-(\\S+)";
        String regexPattern2 = "(\\d{4})/(\\d{2})-(\\S+)@(\\S+)-(\\S+)";
        String regexPattern3 = "(\\d{4})/(\\d{2})-(\\S+)@#-(\\S+)";
        Pattern pattern1 = Pattern.compile(regexPattern1);
        Pattern pattern2 = Pattern.compile(regexPattern2);
        Pattern pattern3 = Pattern.compile(regexPattern3);
        for (int i = m + 3; i < m + 3 + k; i++) {
            Matcher matcher1 = pattern1.matcher(strings.get(i));
            Matcher matcher2 = pattern2.matcher(strings.get(i));
            Matcher matcher3 = pattern3.matcher(strings.get(i));
            if (matcher3.find()) {
                ArrayList<String> attackAoe =
                        new ArrayList<>(Arrays.asList(matcher3.group().split("(@#)?-")));
                fightMode.attackAoe(attackAoe);
            } else if (matcher2.find()) {
                ArrayList<String> attackOne =
                        new ArrayList<>(Arrays.asList(matcher2.group().split("@|-")));
                fightMode.attackOne(attackOne);
            } else if (matcher1.find()) {
                ArrayList<String> useBottleLog =
                        new ArrayList<>(Arrays.asList(matcher1.group().split("-")));
                int adventurerId = getAdventurer(useBottleLog.get(1)).getId();
                fightMode.useBottle(useBottleLog, adventurerId);
            } else {
                System.out.println("有脏东西");
            }
        }
        fightMode.exitFightMode();
    }

    public static void queryTimeLog(ArrayList<String> strings) {
        String time = strings.get(1);
        fightMode.queryTimeLog(time);
    }

    public static void queryAttackLog(ArrayList<String> strings) {
        int attackId = Integer.parseInt(strings.get(1));
        fightMode.queryAttackLog(attackId);
    }

    public static void queryBeAttackedLog(ArrayList<String> strings) {
        int beAttackedId = Integer.parseInt(strings.get(1));
        fightMode.queryBeAttackedLog(beAttackedId);
    }

    public static Adventurer getAdventurer(String name) {
        for (Integer key : adventurersMap.keySet()) {
            if (adventurersMap.get(key).getName().equals(name)) {
                return adventurersMap.get(key);
            }
        }
        return null;
    }

    public static Adventurer getAdventurer(int id) {
        if (adventurersMap.containsKey(id)) {
            return adventurersMap.get(id);
        } else {
            return null;
        }
    }

}