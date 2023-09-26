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
    private HashMap<Integer, Bottle> bottlesMap = new HashMap<>();
    private HashMap<Integer, Equipment> equipmentsMap = new HashMap<>();
    private HashMap<Integer, Food> foodMap = new HashMap<>();

    private Backpack backpack = new Backpack();

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.hitPoint = 500;
        this.level = 1;
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
        return (int) (level / 5) + 1;
    }

    //bottle
    public void addBottle(Bottle bottle) {
        bottlesMap.put(bottle.getId(), bottle);
    }

    public void deleteBottle(int bottleId) {
        bottlesMap.remove(bottleId);
    }

    public void deleteBottleByName(String bottleName) {
        int bottleId = 0;
        boolean flag = false;
        for (Integer key : bottlesMap.keySet()) {
            if (bottlesMap.get(key).getName().equals(bottleName)) {
                bottleId = key;
                if (!flag) {
                    bottleId = bottlesMap.get(key).getId();
                }
                else if (bottleId > bottlesMap.get(key).getId()) {
                    bottleId = bottlesMap.get(key).getId();
                }
                else {
                    continue;
                }
            }
        }
        bottlesMap.remove(bottleId);
    }

    public int getBottleCount() {
        return bottlesMap.size();
    }

    public String getBottleName(int bottleId) {
        if(bottlesMap.containsKey(bottleId)) {
            return bottlesMap.get(bottleId).getName();
        }
        return null;
    }

    // equipment
    public void addEquipment(Equipment equipment) {
        equipmentsMap.put(equipment.getId(), equipment);
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
    }

    public void deleleFoodByName(String foodName) {
        int foodId = 0;
        boolean flag = false;
        for (Integer key : foodMap.keySet()) {
            if (foodMap.get(key).getName().equals(foodName)) {
                foodId = key;
                if ( ! flag) {
                    flag = true;
                    foodId = foodMap.get(key).getId();
                }
                else if (foodId > foodMap.get(key).getId()) {
                    foodId = foodMap.get(key).getId();
                }
                else {
                    continue;
                }
            }
        }
        foodMap.remove(foodId);
    }


    public boolean hasFoodInBackpack(int foodId) {
        return backpack.hasFood(foodId);
    }

    public void carryBottle(int bottleId) {
        if (backpack.getBottleNum() >= getMaxBottles()) {
            return;
        }
        backpack.carryBottle(bottlesMap.get(bottleId));
    }

    public void carryEquipment(int equipmentId) {
        if(equipmentsMap.containsKey(equipmentId)) {
            backpack.carryEquipment(equipmentsMap.get(equipmentId));
        }
    }

    public void carryFood(int foodId) {
        if ( ! hasFoodInBackpack(foodId)) {
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
        int bottleId = 0;
        boolean flag = false;
        for(Integer key : bottlesMap.keySet()) {
            if (bottlesMap.get(key).getName().equals(bottleName)) {
                bottleId = key;
                if (! flag) {
                    flag = true;
                    bottleId = bottlesMap.get(key).getId();
                }
                else if (bottleId > bottlesMap.get(key).getId()) {
                    bottleId = bottlesMap.get(key).getId();
                }
                else {
                    continue;
                }
            }
        }
        if(flag) {
            return bottleId;
        }
        return 0;
    }

    public int useBottle(String bottleName) {
        int bottleId = getBottleId(bottleName);
        int capacity = backpack.useBottle(bottleName);
        if (capacity == 0) {
            bottlesMap.remove(bottleId);
        }
        return capacity;
    }

    public boolean hasFoodInBackpack(String foodName) {
        return backpack.hasFood(foodName);
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


}
