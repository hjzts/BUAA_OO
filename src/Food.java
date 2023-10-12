/**
 * 食物类
 * 2023/9/24 12:31
 *
 * @author hugo
 */
public class Food {
    private int id;
    private String name;
    private int energy;

    public Food(int id, String name, int energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
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

}
