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
    private statcic long foodSellNum;

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

    public static Bottle bottleSell(ArrayList<String> strings, int money) {
        long price = bottlePriceSum / bottleSellNum;
        return null;
        long capacity = bottleCapacitySum / bottleSellNum;
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        if (strings.get(4).equals("RegularBottle")) {

        }
        else if ()
    }
}
