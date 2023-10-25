import java.util.ArrayList;

/**
 * 实现了Equipment类中的equipment的基本属性以及加入了EquipmentHashMap这一类
 * 2022/9/16 22:37
 *
 * @author 86152
 */
public class Equipment implements Commodity {
    private int id;
    private String name;
    private int star;

    private long price;

    public Equipment(int id, String name, int star, long price) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getStar() {
        return star;
    }

    public void upgrade() {
        this.star += 1;
    }

    public static Equipment newEquipment(ArrayList<String> strings) {
        int equipmentId = Integer.parseInt(strings.get(2));
        String equipmentName = strings.get(3);
        int equipmentStar = Integer.parseInt(strings.get(4));
        if (strings.size() <= 5) {
            long price = 0;
            Equipment regularEquipment =
                    new RegularEquipment(equipmentId, equipmentName, equipmentStar, price);
            return regularEquipment;
        }
        long price = Long.parseLong(strings.get(5));
        String equipmentType = strings.get(6);
        if ("RegularEquipment".equals(equipmentType)) {
            Equipment regularEquipment =
                    new RegularEquipment(equipmentId, equipmentName, equipmentStar, price);
            return regularEquipment;
        } else if ("CritEquipment".equals(equipmentType)) {
            int critical = Integer.parseInt(strings.get(7));
            Equipment critEquipment =
                    new CritEquipment(equipmentId, equipmentName, equipmentStar, price, critical);
            return critEquipment;
        } else if ("EpicEquipment".equals(equipmentType)) {
            double ratio = Double.parseDouble(strings.get(7));
            Equipment epicEquipment =
                    new EpicEquipment(equipmentId, equipmentName, equipmentStar, price, ratio);
            return epicEquipment;
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

    public int getCritical() {
        return 0;
    }

    public double getRatio() {
        return 0;
    }
}
