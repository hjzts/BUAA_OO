/**
 * 继承于Equipment的常规装备
 * 2023/10/24 11:16
 *
 * @author hugo
 */
public class RegularEquipment extends Equipment {

    public RegularEquipment(int id, String name, int star, int price) {
        super(id, name, star, price);
    }

    public String getType() {
        return "RegularEquipment";
    }
}
