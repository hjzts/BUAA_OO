/**
 * 食物类
 * 2023/9/24 12:31
 *
 * @author hugo
 */
public class Food implements Commodity {
    private int id;
    private String name;
    private int energy;

    private long price;

    public Food(int id, String name, int energy, long price) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }

    public long getCommodityValue() {
        return price;
    }

    public String getType() {
        return "Food";
    }
}
