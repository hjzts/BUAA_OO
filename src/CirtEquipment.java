/**
 * 继承于Equipment的暴击装备
 * 2023/10/24 11:17
 *
 * @author hugo
 */
public class CirtEquipment extends Equipment {
    private int critical;

    public CirtEquipment(int id, String name, int star, int price, int critical) {
        super(id, name, star, price);
        this.critical = critical;
    }

    public String getType() {
        return "CirtEquipment";
    }

    public int getCritical() {
        return this.critical;
    }
}
