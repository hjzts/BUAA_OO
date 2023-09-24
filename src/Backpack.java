/**
 * 背包类，背包中为所携带的bottles，equipments，food
 * 2023/9/24 12:30
 *
 * @author hugo
 */
import java.util.TreeMap;
import java.util.Iterator;
public class Backpack {
    private TreeMap<Integer,Bottle> bottleTreeMap = new TreeMap<>();
    private TreeMap<Integer,Equipment> equipmentTreeMap = new TreeMap<>();
    private TreeMap<Integer,Food> foodTreeMap = new TreeMap<>();


    public void carryEquipment(Equipment equipment) {
        for(Iterator<Integer> it = equipmentTreeMap.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if(equipmentTreeMap.get(key).getName().equals(equipment.getName())) {
                equipmentTreeMap.remove(key);
            }
        }
        equipmentTreeMap.put(equipment.getId(),equipment);
    }

    public void carryBottle(Bottle bottle) {
        bottleTreeMap.put(bottle.getId(),bottle);
    }

    public void carryFood(Food food) {
        if(foodTreeMap.containsValue(food)) {
            int id = food.getId();
            foodTreeMap.replace(id,food);
        }
        else {
            foodTreeMap.put(food.getId(),food);
        }
    }

    public int getBottleNum() {
        return bottleTreeMap.size();
    }


    public boolean hasBottle(String bottleName) {
        if(bottleTreeMap.size() == 0) {
            return false;
        }
        for(Iterator<Integer> it = bottleTreeMap.keySet().iterator(); it.hasNext();){
            int key = it.next();
            if(bottleTreeMap.get(key).getName().equals(bottleName)) {
                return true;
            }
        }
        return false;
    }

    public int getBottleId(String bottleName) {
        for(Iterator<Integer> it = bottleTreeMap.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if(foodTreeMap.get(key).getName().equals(bottleName)){
                return foodTreeMap.get(key).getId();
            }
        }
        return 0;
    }

    public int useBottle(String bottleName) {
        for(Iterator<Integer> it = bottleTreeMap.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if(bottleTreeMap.get(key).getName().equals(bottleName)){
                int capacity =  bottleTreeMap.get(key).getCapacity();
                bottleTreeMap.remove(key);
                return capacity;
            }
        }
        return 0;
    }

    public boolean hasFood(String foodName) {
        if(foodTreeMap.size() == 0) {
            return false;
        }
        for(Iterator<Integer>it = foodTreeMap.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if(foodTreeMap.get(key).getName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }
    public int getFoodId(String foodName) {
        for(Iterator<Integer> it = foodTreeMap.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if(foodTreeMap.get(key).getName().equals(foodName)) {
                return foodTreeMap.get(key).getId();
            }
        }
        return 0;
    }

    public int useFood(String foodName) {
        for(Iterator<Integer> it = foodTreeMap.keySet().iterator(); it.hasNext(); ) {
            int key = it.next();
            if(foodTreeMap.get(key).getName().equals(foodName)) {
                int energy = foodTreeMap.get(key).getEnergy();
                foodTreeMap.remove(key);
                return energy;
            }
        }
        return 0;
    }



}
