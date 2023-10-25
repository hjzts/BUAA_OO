import java.util.ArrayList;

/**
 * 实现了Bottle类中bottle的基本属性以及加入了BottleHashMap这一类
 * 2022/9/16 22:37
 *
 * @author 86152
 */
public class Bottle implements Commodity {
    private int id;
    private String name;
    private int capacity;

    private long price;

    public Bottle(int id, String name, int capacity, long price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resetCapacity() {
        this.capacity = 0;
    }

    public static Bottle newBottle(ArrayList<String> strings) {
        int bottleId = Integer.parseInt(strings.get(2));
        String bottleName = strings.get(3);
        int bottleCapacity = Integer.parseInt(strings.get(4));
        if (strings.size() <= 5) {
            long price = 0;
            Bottle regularBottle = new RegularBottle(bottleId, bottleName, bottleCapacity, price);
            return regularBottle;
        }
        long price = Long.parseLong(strings.get(5));
        String bottleType = strings.get(6);
        if (bottleType.equals("RegularBottle")) {
            Bottle regularBottle = new RegularBottle(bottleId, bottleName, bottleCapacity, price);
            return regularBottle;
        } else if (bottleType.equals("ReinforcedBottle")) {
            double ratio = Double.parseDouble(strings.get(7));
            Bottle reinforcedBottle =
                    new ReinforcedBottle(bottleId, bottleName, bottleCapacity, price, ratio);
            return reinforcedBottle;
        } else if (bottleType.equals("RecoverBottle")) {
            double ratio = Double.parseDouble(strings.get(7));
            Bottle recoverBottle =
                    new RecoverBottle(bottleId, bottleName, bottleCapacity, price, ratio);
            return recoverBottle;
        }
        return null;
    }

    public int getCommodityNum() {
        return 1;
    }

    public long getCommodityValue() {
        return price;
    }

    public String getType() {
        return "";
    }

    public double getRatio() {
        return 0;
    }
}
