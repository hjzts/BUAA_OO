import java.util.ArrayList;

/**
 * 继承于Equipment的暴击装备
 * 2023/10/24 11:17
 *
 * @author hugo
 */
public class CritEquipment extends Equipment {
    private int critical;

    public CritEquipment(int id, String name, int star, long price, int critical) {
        super(id, name, star, price);
        this.critical = critical;
    }

    public String getType() {
        return "CritEquipment";
    }

    public int getCritical() {
        return this.critical;
    }

}
