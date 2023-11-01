/**
 * 进行指令的处理分类
 * 2023/10/23 21:19
 *
 * @author hugo
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    private static HashMap<Integer, Adventurer> adventurersMap = new HashMap<>();

    private static FightMode fightMode = new FightMode();
    private static boolean printTestFlag = false;

    private static ArrayList<String> strings;

    public static void operation(int n, ArrayList<ArrayList<String>> inputInfo) {
        for (int i = 0; i < n; ++i) {
            strings = inputInfo.get(i); // 获取第i行指令
            switch (strings.get(0)) { // 获取第i行指令的第一个部分
                case "1":
                    // Adventurer.add();
                    adventurerAdd(strings);
                    break;
                case "2":
                    // CritEquipment.Bottle.add();
                    bottleAdd(strings);
                    break;
                case "3":
                    // CritEquipment.Bottle.delete();
                    //if(printTestFlag)  System.out.print("3 :");
                    //bottleDelete(strings);
                    bottleSell(strings);
                    break;
                case "4":
                    //Equipment.add();
                    equipmentAdd(strings);
                    break;
                case "5":
                    //Equipment.delete();
                    //if(printTestFlag)  System.out.print("5 :");
                    //equipmentDelete(strings);
                    equipmentSell(strings);
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
                    //foodDelete(strings);
                    foodSell(strings);
                    break;
                default:
                    operation2(strings);
                    break;
            }
        }
    }

    public static void operation2(ArrayList<String> strings) {
        switch (strings.get(0)) {
            case "9":
                // Equipment.carry();
                equipmentCarry(strings);
                break;
            case "10":
                // CritEquipment.Bottle.carry();
                bottleCarry(strings);
                break;
            case "11":
                // Food.carry();
                foodCarry(strings);
                break;
            case "12":
                // CritEquipment.Bottle.use();
                //if(printTestFlag)  System.out.print("12 :");
                bottleUse(strings, 0);
                break;
            case "13":
                // Food.use();
                //if(printTestFlag)  System.out.print("13 :");
                foodUse(strings);
                break;
            default:
                operation3(strings);
                break;
        }
    }

    public static void operation3(ArrayList<String> strings) {
        switch (strings.get(0)) {
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
            case "17":
                // query adventurer be attacked log
                queryBeAttackedLog(strings);
                break;
            default:
                operation4(strings);
                break;
        }
    }

    public static void operation4(ArrayList<String> strings) {
        switch (strings.get(0)) {
            case "18":
                adventurerHire(strings);
                break;
            case "19":
                adventurerCommodityGet(strings);
                break;
            case "20":
                adventurerMaxCommodityQuery(strings);
                break;
            case "21":
                adventurerCommodityClassGet(strings);
                break;
            case "22":
                adventurerSellAllCarried(strings);
                break;
            case "23":
                adventurerShopping(strings);
                break;
            default:
                break;
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
        CritEquipment.Bottle bottle = CritEquipment.Bottle.newBottle(strings);
        adventurersMap.get(adventurerId).addBottle(bottle);
    }

    public static void bottleSell(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int bottleId = Integer.parseInt(strings.get(2));
        Bottle bottle = adventurersMap.get(adventurerId).getBottle(bottleId);
        long price = bottle.getCommodityValue();
        adventurersMap.get(adventurerId).addMoney(price);
        Shop.bottleAdventurerSell(bottle);
        bottleDelete(strings);
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
        Equipment equipment = Equipment.newEquipment(strings);
        adventurersMap.get(adventurerId).addEquipment(equipment);
    }

    public static void equipmentSell(ArrayList<String> stirngs) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int equipmentId = Integer.parseInt(strings.get(2));
        Equipment equipment = adventurersMap.get(adventurerId).getEquipment(equipmentId);
        long price = equipment.getCommodityValue();
        adventurersMap.get(adventurerId).addMoney(price);
        Shop.equipmentAdventurerSell(equipment);
        equipmentDelete(strings);
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
        if (strings.size() <= 5) {
            long price = 0;
            Food food = new Food(foodId, foodName, foodEnergy, price);
            adventurersMap.get(adventurerId).addFood(food);
            return;
        }
        long price = Long.parseLong(strings.get(5));
        Food food = new Food(foodId, foodName, foodEnergy, price);
        adventurersMap.get(adventurerId).addFood(food);
    }

    public static void foodSell(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int foodId = Integer.parseInt(strings.get(2));
        Food food = adventurersMap.get(adventurerId).getFood(foodId);
        long price = food.getCommodityValue();
        adventurersMap.get(adventurerId).addMoney(price);
        Shop.foodAdventurerSell(food);
        foodDelete(strings);
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
            int bottleHitPoint = adventurersMap.get(adventurerId).useBottle(bottleName);
            adventurersMap.get(adventurerId).increaseHitPoint(bottleHitPoint);
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
        fightMode.adventurerHiringHelp();
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

    public static void adventurerHire(ArrayList<String> strings) {
        int adventurerHiringId = Integer.parseInt(strings.get(1));
        int adventurerHiredId = Integer.parseInt(strings.get(2));
        adventurersMap.get(adventurerHiringId).hireAdventurer(adventurerHiredId);
    }

    public static void adventurerCommodityGet(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int commodityNum = adventurersMap.get(adventurerId).getCommodityNum();
        long commodityValue = adventurersMap.get(adventurerId).getCommodityValue()
                - adventurersMap.get(adventurerId).getMoney();
        System.out.println(commodityNum + " " + commodityValue);
    }

    public static void adventurerMaxCommodityQuery(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        if (adventurersMap.get(adventurerId).getCommodityNum() == 0) {
            System.out.println(0);
            return;
        }
        long maxCommodityValue = adventurersMap.get(adventurerId).getMaxCommodityValue();
        System.out.println(maxCommodityValue);
    }

    public static void adventurerCommodityClassGet(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        int commodityId = Integer.parseInt(strings.get(2));
        adventurersMap.get(adventurerId).getCommodityClass(commodityId);
    }

    public static void adventurerSellAllCarried(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        String adventurerName = adventurersMap.get(adventurerId).getName();
        long money = adventurersMap.get(adventurerId).sellAllCarried();
        System.out.println(adventurerName + " emptied the backpack " + money);
    }

    public static void adventurerShopping(ArrayList<String> strings) {
        int adventurerId = Integer.parseInt(strings.get(1));
        long money = adventurersMap.get(adventurerId).getMoney();
        int commodityId = Integer.parseInt(strings.get(2));
        String commodityName = strings.get(3);
        String commodityType = strings.get(4);
        if (commodityType.equals("RegularBottle") || commodityType.equals("RecoverBottle")
                || commodityType.equals("ReinforcedBottle")) {
            long price = Shop.getBottlePrice();
            Bottle bottle = Shop.bottleAdventurerPurchase(strings, money);
            if (bottle == null) {
                System.out.println("failed to buy " + commodityName + " for " + price);
                return;
            }
            adventurersMap.get(adventurerId).addBottle(bottle);
            adventurersMap.get(adventurerId).removeMoney(price);
            System.out.println("successfully buy " + commodityName + " for " + price);
        } else if (commodityType.equals("RegularEquipment") || commodityType.equals("CritEquipment")
                || commodityType.equals("EpicEquipment")) {
            long price = Shop.getEquipmentPrice();
            Equipment equipment = Shop.equipmentAdventurerPurchase(strings, money);
            if (equipment == null) {
                System.out.println("failed to buy " + commodityName + " for " + price);
                return;
            }
            adventurersMap.get(adventurerId).addEquipment(equipment);
            adventurersMap.get(adventurerId).removeMoney(price);
            System.out.println("successfully buy " + commodityName + " for " + price);
        } else if (commodityType.equals("Food")) {
            long price = Shop.getFoodPrice();
            Food food = Shop.foodAdventurerPurchase(strings, money);
            if (food == null) {
                System.out.println("failed to buy " + commodityName + " for " + price);
                return;
            }
            adventurersMap.get(adventurerId).addFood(food);
            adventurersMap.get(adventurerId).removeMoney(price);
            System.out.println("successfully buy " + commodityName + " for " + price);
        }
    }

    public static Adventurer getAdventurer(String name) {
        for (Object key : adventurersMap.keySet()) {
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