/**
 * 继承于Bottle的百分比强化药水
 * 2023/10/24 11:07
 *
 * @author hugo
 */
public class ReinforcedBottle extends Bottle {
    private double ratio;

    public ReinforcedBottle(int id, String name, int capacity, long price, double ratio) {
        super(id, name, capacity, price);
        this.ratio = ratio;
    }

    public String getType() {
        return "ReinforcedBottle";
    }

    public double getRatio() {
        return ratio;
    }
}
