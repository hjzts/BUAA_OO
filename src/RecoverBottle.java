/**
 * 继承于Bottle的百分比回复药水
 * 2023/10/24 11:13
 *
 * @author hugo
 */
public class RecoverBottle extends CritEquipment.Bottle {
    private double ratio;

    public RecoverBottle(int id, String name, int capacity, long price, double ratio) {
        super(id, name, capacity, price);
        this.ratio = ratio;
    }

    public String getType() {
        return "RecoverBottle";
    }

    public double getRatio() {
        return ratio;
    }
}
