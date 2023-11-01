import java.util.ArrayList;

/**
 * 这里是商店
 * 2023/10/31 11:23
 *
 * @author hugo
 */
public class Shop {
    private static Shop shop;
    private static long bottlePriceSum;
    private static long bottleCapacitySum;
    private static long bottleSellNum;
    private static long equipmentPriceSum;
    private static long equipmentStarSum;
    private static long equipmentSellNum;
    private static long foodPriceSum;
    private static long foodEnergySum;
    private static long foodSellNum;

    private Shop() {
        bottlePriceSum = 0;
        bottleCapacitySum = 0;
        bottleSellNum = 0;
        equipmentPriceSum = 0;
        equipmentStarSum = 0;
        equipmentSellNum = 0;
        foodPriceSum = 0;
        foodEnergySum = 0;
        foodSellNum = 0;
    }

    public static Shop getShopInstance() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }

    public static Bottle bottleAdventurerPurchase(ArrayList<String> strings, long money) {
        // adventurer purchase , the shop sell the bottle
        if (bottleSellNum == 0) {
            return null;
        }
        long price = bottlePriceSum / bottleSellNum;
        if (price > money) {
            return null;
        }
        long capacity = bottleCapacitySum / bottleSellNum;
        bottlePriceSum += price;
        bottleSellNum++;
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        if (strings.get(4).equals("RegularBottle")) {
            return new RegularBottle(bottleId, bottleName, (int) capacity, price);
        } else if (strings.get(4).equals("RecoverBottle")) {
            double ratio = Double.parseDouble(strings.get(5));
            return new RecoverBottle(bottleId, bottleName, (int) capacity, price, ratio);
        } else if (strings.get(4).equals("ReinforcedBottle")) {
            double ratio = Double.parseDouble(strings.get(5));
            return new ReinforcedBottle(bottleId, bottleName, (int) capacity, price, ratio);
        }
        return null;
    }

    public static Equipment equipmentAdventurerPurchase(ArrayList<String> strings, long money) {
        // adventurer purchase , the shop sell the equipment
        if (equipmentSellNum == 0) {
            return null;
        }
        long price = equipmentPriceSum / equipmentSellNum;
        if (price > money) {
            return null;
        }
        long star = equipmentStarSum / equipmentSellNum;
        equipmentPriceSum += price;
        equipmentSellNum++;
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = strings.get(3);
        if (strings.get(4).equals("RegularEquipment")) {
            return new RegularEquipment(equipmentId, equipmentName, (int) star, price);
        } else if (strings.get(4).equals("CritEquipment")) {
            int critical = Integer.parseInt(strings.get(5));
            return new CritEquipment(equipmentId, equipmentName, (int) star, price, critical);
        } else if (strings.get(4).equals("EpicEquipment")) {
            double ratio = Double.parseDouble(strings.get(5));
            return new EpicEquipment(equipmentId, equipmentName, (int) star, price, ratio);
        }
        return null;
    }

    public static Food foodAdventurerPurchase(ArrayList<String> strings, long money) {
        // adventurer purchase , the shop sell the food
        if (foodSellNum == 0) {
            return null;
        }
        long price = foodPriceSum / foodSellNum;
        if (price > money) {
            return null;
        }
        long energy = foodEnergySum / foodSellNum;
        foodPriceSum += price;
        foodSellNum++;
        int foodId = Integer.parseInt(strings.get(2));
        String foodName = strings.get(3);
        return new Food(foodId, foodName, (int) energy, price);
    }

    public static void bottleAdventurerSell(Bottle bottle) {
        // adventurer sell , the shop purchase the bottle
        bottlePriceSum += bottle.getCommodityValue();
        bottleCapacitySum += bottle.getCapacity();
        bottleSellNum++;
    }

    public static void equipmentAdventurerSell(Equipment equipment) {
        // adventurer sell , the shop purchase the equipment
        equipmentPriceSum += equipment.getCommodityValue();
        equipmentStarSum += equipment.getStar();
        equipmentSellNum++;
    }

    public static void foodAdventurerSell(Food food) {
        // adventurer sell , the shop purchase the food
        foodPriceSum += food.getCommodityValue();
        foodEnergySum += food.getEnergy();
        foodSellNum++;
    }

    public static long getBottlePrice() {
        if (bottleSellNum == 0) {
            return 0;
        }
        return bottlePriceSum / bottleSellNum;
    }

    public static long getEquipmentPrice() {
        if (equipmentSellNum == 0) {
            return 0;
        }
        return equipmentPriceSum / equipmentSellNum;
    }

    public static long getFoodPrice() {
        if (foodSellNum == 0) {
            return 0;
        }
        return foodPriceSum / foodSellNum;
    }
}
