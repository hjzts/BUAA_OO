import java.util.HashMap;

/**
 * 冒险者类
 *
 * @author 86152
 */
public class Adventuer {
    private int id;
    private String name;
//    private int bottleCount;
//    private int equipmentCount;
    HashMap<Integer,Bottle> bottlesMap = new HashMap<>();
    HashMap<Integer,Equipment> equipmentsMap = new HashMap<>();

    public Adventuer(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void addBottle(Bottle bottle){
        bottlesMap.put(bottle.getId(),bottle);
    }
    public void deleteBottle(int bottleId){
        bottlesMap.remove(bottleId);
    }
    public int getBottleCount(){
        return bottlesMap.size();
    }
    public String getBottleName(int bottleId){
        return bottlesMap.get(bottleId).getName();
    }
    public void addEquipment(Equipment equipment){
        equipmentsMap.put(equipment.getId(),equipment);
    }
    public void deleteEquipment(int equipmentId){
        equipmentsMap.remove(equipmentId);
    }
    public void upgradeEquipment(int equipmentId){

        equipmentsMap.get(equipmentId).upgrade();
    }
    public int getEquipmentCount(){
        return equipmentsMap.size();
    }
    public String getEquipmentName(int equipmentId){
        return equipmentsMap.get(equipmentId).getName();
    }
    public int getEquipmentStar(int equipmentId){
        return equipmentsMap.get(equipmentId).getStar();
    }
}
