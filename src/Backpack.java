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

    public void deleteEquipment(int equipmentId) {
        if (equipmentTreeMap.containsKey(equipmentId)) {
            equipmentTreeMap.remove(equipmentId);
        }
    }

    public void carryBottle(Bottle bottle) {
        bottleTreeMap.put(bottle.getId(), bottle);
    }

    public void carryFood(Food food) {
        if (foodTreeMap.containsValue(food)) {
            int id = food.getId();
            foodTreeMap.replace(id, food);
        } else {
            foodTreeMap.put(food.getId(), food);
        }
    }

    public int getSameNameBottleNum(String bottleName) {
        int num = 0;
        for (Integer key: bottleTreeMap.keySet()) {
            if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                num++;
            }
        }
        return num;
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
            boolean flag = false;
            int bottleId = 0;
            for (Integer key : bottleTreeMap.keySet()) {
                if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                    if (!flag) {
                        bottleId = key;
                        flag = true;
                    }
                    else if (bottleId > key) {
                        bottleId = key;
                    }
                    else {
                        continue;
                    }
                }
            }
            return bottleId;
        }
    }

    public int useBottle(String bottleName) {
        int capacity = 0;
        int bottleId = 0;
        boolean flag = false;
        for (Integer key: bottleTreeMap.keySet()) {
            if (bottleTreeMap.get(key).getName().equals(bottleName)) {
                if (!flag) {
                    capacity = bottleTreeMap.get(key).getCapacity();
                    bottleId = key;
                    flag = true;
                }
                else if (bottleId > key) {
                    capacity = bottleTreeMap.get(key).getCapacity();
                    bottleId = key;
                }
                else {
                    continue;
                }
            }
        }
        if (capacity == 0) {
            bottleTreeMap.remove(bottleId);
        }
        else {
            bottleTreeMap.get(bottleId).resetCapacity();
        }
        return capacity;
    }

    public void deleteBottle(int bottleId) {
        if (bottleTreeMap.containsKey(bottleId)) {
            bottleTreeMap.remove(bottleId);
        }
    }

    public boolean hasFoodById(int foodId) {
        return foodTreeMap.containsKey(foodId);
    }

    public boolean hasFoodByName(String foodName) {
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

    public void deleteFood(int foodId) {
        if (foodTreeMap.containsKey(foodId)) {
            foodTreeMap.remove(foodId);
        }
    }
}
