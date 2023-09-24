/**
 * 实现了Equipment类中的equipment的基本属性以及加入了EquipmentHashMap这一类
 * 2022/9/16 22:37
 * @author 86152
 */
public class Equipment {
    private int id;
    private String name;
    private int star;

    public Equipment(int id, String name, int star) {
        this.id = id;
        this.name = name;
        this.star = star;
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
}
