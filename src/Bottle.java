/**
 * 实现了Bottle类中bottle的基本属性以及加入了BottleHashMap这一类
 * 2022/9/16 22:37
 * @author 86152
 */
public class Bottle {
    private int id;
    private String name;
    private int capacity;

    public Bottle(int id,String name,int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
