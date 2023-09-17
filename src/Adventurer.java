/**
 * 冒险者类
 *
 * @author 86152
 */
import java.util.HashMap;

public class Adventurer {
    private int id;
    private String name;
    private HashMap<Integer,Bottle> bottlesMap = new HashMap<>();
    private HashMap<Integer,Equipment> equipmentsMap = new HashMap<>();

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addBottle(Bottle bottle) {
        bottlesMap.put(bottle.getId(),bottle);
    }

    public void deleteBottle(int bottleId) {
        bottlesMap.remove(bottleId);
    }

    public int getBottleCount() {
        return bottlesMap.size();
    }

    public String getBottleName(int bottleId) {
        return bottlesMap.get(bottleId).getName();
    }

    public void addEquipment(Equipment equipment) {
        equipmentsMap.put(equipment.getId(),equipment);
    }

    public void deleteEquipment(int equipmentId) {
        equipmentsMap.remove(equipmentId);
    }

    public void upgradeEquipment(int equipmentId) {

        equipmentsMap.get(equipmentId).upgrade();
    }

    public int getEquipmentCount() {
        return equipmentsMap.size();
    }

    public String getEquipmentName(int equipmentId) {
        return equipmentsMap.get(equipmentId).getName();
    }

    public int getEquipmentStar(int equipmentId) {
        return equipmentsMap.get(equipmentId).getStar();
    }
}
