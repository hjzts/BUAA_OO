/**
 * 继承于bottle的常规药水瓶
 * 2023/10/24 11:07
 *
 * @author hugo
 */
public class RegularBottle extends Bottle {
    public RegularBottle(int id, String name, int capacity, int price) {
        super(id, name, capacity, price);
    }

    public String getType() {
        return "RegularBottle";
    }
}
