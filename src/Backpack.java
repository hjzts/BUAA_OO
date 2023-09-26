/**
 * 背包类，背包中为所携带的bottles，equipments，food
 * 2023/9/24 12:30
 *
 * @author hugo
 */

import java.util.TreeMap;

public class Backpack {
    private TreeMap<Integer, Bottle> bottleTreeMap = new TreeMap<>();
    private TreeMap<Integer, Equipment> equipmentTreeMap = new TreeMap<>();
    private TreeMap<Integer, Food> foodTreeMap = new TreeMap<>();

    public void carryEquipment(Equipment equipment) {
        // 遍历，如果有同名的先把那个删除
        if (equipmentTreeMap.isEmpty()) {
            equipmentTreeMap.put(equipment.getId(), equipment);
        }
        else {
            for (Integer key : equipmentTreeMap.keySet()) {
                if (equipmentTreeMap.get(key) == null) {
                    break;
                }
                if (equipmentTreeMap.get(key).getName().equals(equipment.getName())) {
                    equipmentTreeMap.remove(key);
                    break;
                }
            }
            equipmentTreeMap.put(equipment.getId(), equipment);
        }
    }

    public void carryBottle(Bottle bottle) {
        if (bottle == null) {
            return;
        }
        bottleTreeMap.put(bottle.getId(), bottle);
    }

    public void carryFood(Food food) {
        if (! foodTreeMap.containsValue(food)) {
            if (food == null) {
                return;
            }
            foodTreeMap.put(food.getId(), food);
        }
    }

    public int getBottleNum() {
        return bottleTreeMap.size();
    }

    public boolean hasBottle(String bottleName) {
        if (bottleTreeMap.isEmpty()) {
            return false;
        }
        for (Integer key: bottleTreeMap.keySet()) {
            if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                return true;
            }
        }
        return false;
    }

    public int getBottleId(String bottleName) {
        if (bottleTreeMap.isEmpty()) {
            return 0;
        }
        else {
            for (Integer key : bottleTreeMap.keySet()) {
                if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                    return bottleTreeMap.get(key).getId();
                }
            }
            return 0;
        }

    }

    public int useBottle(String bottleName) {
        for (Integer key: bottleTreeMap.keySet()) {
            if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                int capacity = bottleTreeMap.get(key).getCapacity();
                if (capacity == 0) {
                    bottleTreeMap.remove(key);
                }
                else {
                    bottleTreeMap.get(key).resetCapacity();
                }
                return capacity;
            }
        }
        return 0;
    }

    public boolean hasFood(String foodName) {
        if (foodTreeMap.isEmpty()) {
            return false;
        }
        for (Integer key : foodTreeMap.keySet()) {
            if (foodTreeMap.get(key).getName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFood(int foodId) {
        return foodTreeMap.containsKey(foodId);
    }

    public int getFoodId(String foodName) {
        for (Integer key : foodTreeMap.keySet()) {
            if (foodTreeMap.get(key).getName().equals(foodName)) {
                return foodTreeMap.get(key).getId();
            }
        }
        return 0;
    }

    public int useFood(String foodName) {
        for (Integer key: foodTreeMap.keySet()) {
            if (foodTreeMap.get(key).getName().equals(foodName)) {
                int energy = foodTreeMap.get(key).getEnergy();
                foodTreeMap.remove(key);
                return energy;
            }
        }
        return 0;
    }
}
