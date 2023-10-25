/**
 * 冒险者类
 *
 * @author 86152
 */

import java.util.HashMap;

public class Adventurer implements Commodity {
    private int id;
    private String name;
    private int hitPoint;
    private int level;
    // private HashMap<Integer, Commodity> commodityMap = new HashMap<>();
    private HashMap<Integer, Bottle> bottlesMap = new HashMap<>();
    private HashMap<Integer, Equipment> equipmentsMap = new HashMap<>();
    private HashMap<Integer, Food> foodMap = new HashMap<>();
    private HashMap<Integer, Adventurer> hireAdventurerMap = new HashMap<>();
    private Backpack backpack = new Backpack();

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 500;
        this.level = 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void decreaseHitPoint(int decreaseHitPoint) {
        this.hitPoint -= decreaseHitPoint;
    }

    public void increaseLevel(int foodEnergy) {
        this.level += foodEnergy;
    }

    public int getMaxBottles() {
        return (level / 5) + 1;
    }

    //bottle
    public void addBottle(Bottle bottle) {
        bottlesMap.put(bottle.getId(), bottle);
        // commodityMap.put(bottle.getId(),bottle);
    }

    public void deleteBottle(int bottleId) {
        bottlesMap.remove(bottleId);
        // commodityMap.remove(bottleId);
        backpack.deleteBottle(bottleId);
    }

    public int getBottleCount() {
        return bottlesMap.size();
    }

    public String getBottleName(int bottleId) {
        if (bottlesMap.containsKey(bottleId)) {
            return bottlesMap.get(bottleId).getName();
        }
        return null;
    }

    // equipment
    public void addEquipment(Equipment equipment) {
        equipmentsMap.put(equipment.getId(), equipment);
        // commodityMap.put(equipment.getId(), equipment);
    }

    public void deleteEquipment(int equipmentId) {
        equipmentsMap.remove(equipmentId);
        // commodityMap.remove(equipmentId);
        backpack.deleteEquipment(equipmentId);
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

    public int getEquipmentCarriedStar(String equipmentName) {
        return backpack.getEquipmentStar(equipmentName);
    }

    public Equipment getEquipmentCarried(String equipmentName) {
        return backpack.getEquipment(equipmentName);
    }

    public boolean hasEquipmentInBackpack(String equipmentName) {
        return backpack.hasEquipment(equipmentName);
    }

    //food
    public void addFood(Food food) {
        foodMap.put(food.getId(), food);
    }

    public String getFoodName(int foodId) {
        return foodMap.get(foodId).getName();
    }

    public int getFoodCount() {
        return foodMap.size();
    }

    public void deleteFood(int foodId) {
        foodMap.remove(foodId);
        backpack.deleteFood(foodId);
    }

    public boolean hasFoodInBackpack(int foodId) {
        return backpack.hasFoodById(foodId);
    }

    public boolean hasFoodInBackpack(String foodName) {
        return backpack.hasFoodByName(foodName);
    }

    public void carryBottle(int bottleId) {
        if (!bottlesMap.containsKey(bottleId)) {
            return;
        }
        String bottleName = bottlesMap.get(bottleId).getName();
        if (backpack.getSameNameBottleNum(bottleName) >= getMaxBottles()) {
            return;
        }
        backpack.carryBottle(bottlesMap.get(bottleId));
    }

    public void carryEquipment(int equipmentId) {
        if (equipmentsMap.containsKey(equipmentId)) {
            backpack.carryEquipment(equipmentsMap.get(equipmentId));
        }
    }

    public void carryFood(int foodId) {
        if (!hasFoodInBackpack(foodId)) {
            backpack.carryFood(foodMap.get(foodId));
        }
    }

    public boolean hasBottleInBackpack(String bottleName) {
        return backpack.hasBottle(bottleName);
    }

    public boolean hasBottle(String bottleName) {
        return bottlesMap.containsValue(bottleName);
    }

    public int getBottleId(String bottleName) {
        return backpack.getBottleId(bottleName);
    }

    public int useBottle(String bottleName) {
        int bottleId = getBottleId(bottleName);
        int capacity = backpack.useBottle(bottleName,hitPoint);
        if (capacity == 0) {
            bottlesMap.remove(bottleId);
        }
        return capacity;
    }

    public boolean hasFood(String foodName) {
        return foodMap.containsValue(foodName);
    }

    public int getFoodId(String foodName) {
        return backpack.getFoodId(foodName);
    }

    public int useFood(String foodName) {
        foodMap.remove(getFoodId(foodName));
        int energy = backpack.useFood(foodName);
        return energy;
    }

    public void hireAdventurer(int adventurerHiredId) {
        if (!hireAdventurerMap.containsKey(adventurerHiredId)) {
            Adventurer adventurerHired = Manager.getAdventurer(adventurerHiredId);
            hireAdventurerMap.put(adventurerHiredId, adventurerHired);
        }
    }

    public int getCommodityNum() {
        return bottlesMap.size() + equipmentsMap.size() + foodMap.size() + hireAdventurerMap.size();
    }

    public long getCommodityValue() {
        long value = 0;
        for (Bottle bottle : bottlesMap.values()) {
            value += bottle.getCommodityValue();
        }
        for (Equipment equipment : equipmentsMap.values()) {
            value += equipment.getCommodityValue();
        }
        for (Food food : foodMap.values()) {
            value += food.getCommodityValue();
        }
        for (Adventurer adventurer : hireAdventurerMap.values()) {
            value += adventurer.getCommodityValue();
        }
        return value;
    }

    public long getMaxCommodityValue() {
        long value = 0;
        for (Bottle bottle : bottlesMap.values()) {
            if (value < bottle.getCommodityValue()) {
                value = bottle.getCommodityValue();
            }
        }
        for (Equipment equipment : equipmentsMap.values()) {
            if (value < equipment.getCommodityValue()) {
                value = equipment.getCommodityValue();
            }
        }
        for (Food food : foodMap.values()) {
            if (value < food.getCommodityValue()) {
                value = food.getCommodityValue();
            }
        }
        for (Adventurer adventurer : hireAdventurerMap.values()) {
            if (value < adventurer.getCommodityValue()) {
                value = adventurer.getCommodityValue();
            }
        }
        return value;
    }

    public void getCommodityClass(int commodityId) {
        for (Integer key : bottlesMap.keySet()) {
            if (key == commodityId) {
                System.out.println("Commodity whose id is "
                        + commodityId + " belongs to " + bottlesMap.get(key).getType());
                return;
            }
        }
        for (Integer key : equipmentsMap.keySet()) {
            if (key == commodityId) {
                System.out.println("Commodity whose id is "
                        + commodityId + " belongs to " + equipmentsMap.get(key).getType());
                return;
            }
        }
        for (Integer key : foodMap.keySet()) {
            if (key == commodityId) {
                System.out.println("Commodity whose id is "
                        + commodityId + " belongs to " + foodMap.get(key).getType());
                return;
            }
        }
        for (Integer key : hireAdventurerMap.keySet()) {
            if (key == commodityId) {
                System.out.println("Commodity whose id is "
                        + commodityId + " belongs to " + "Adventurer");
                return;
            }
        }
    }
}
