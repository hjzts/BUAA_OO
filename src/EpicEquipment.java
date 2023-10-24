/**
 * 继承于Equipment的史诗装备
 * 2023/10/24 11:18
 *
 * @author hugo
 */
public class EpicEquipment extends Equipment {
    private double ratio;

    public EpicEquipment(int id, String name, int star, int price, double ratio) {
        super(id, name, star, price);
        this.ratio = ratio;
    }

    public String getType() {
        return "EpicEquipment";
    }

    public double getRatio() {
        return this.ratio;
    }
}
