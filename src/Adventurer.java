/**
 * 冒险者类
 *
 * @author 86152
 */
import java.util.HashMap;

public class Adventurer {
    private int id;
    private String name;
    private int hitPoint;
    private int level;
    private HashMap<Integer,Bottle> bottlesMap = new HashMap<>();
    private HashMap<Integer,Equipment> equipmentsMap = new HashMap<>();
    private HashMap<Integer,Food> foodMap = new HashMap<>();

    private Backpack backpack = new Backpack();
    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 0;
        this.level = 0;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getLevel() {
        return level;
    }

    public void increaseHitPoint(int bottleCapacity) {
        this.hitPoint += bottleCapacity;
    }

    public void increaseLevel(int foodEnergy) {
        this.level += foodEnergy;
    }

    public int getMaxBottles() {
        return (int)(level / 5) + 1;
    }

    //bottle
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

    // equipment
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

    //food
    public void addFood(Food food) {
        foodMap.put(food.getId(),food);
    }
    public String getFoodName(int foodId) {
        return foodMap.get(foodId).getName();
    }

    public int getFoodCount() {
        return foodMap.size();
    }

    public void deleteFood(int foodId) {
        foodMap.remove(foodId);
    }
    public void carryBottle(int bottleId) {
        if(backpack.getBottleNum() >= getMaxBottles()) {
            return;
        }
        backpack.carryBottle(bottlesMap.get(bottleId));
    }

    public void carryEquipment(int equipmentId) {
        backpack.carryEquipment(equipmentsMap.get(equipmentId));
    }

    public void carryFood(int foodId) {
        backpack.carryFood(foodMap.get(foodId));
    }



    public boolean hasBottle(String bottleName) {
        return backpack.hasBottle(bottleName);
    }

    public int getBottleId(String bottleName) {
        return backpack.getBottleId(bottleName);
    }

    public int useBottle(String bottleName) {
        return backpack.useBottle(bottleName);
    }

    public boolean hasFood(String foodName) {
        return backpack.hasFood(foodName);
    }
    public int getFoodId(String foodName) {
        return backpack.getFoodId(foodName);
    }
    public int useFood(String foodName) {
        return backpack.useFood(foodName);
    }



}
