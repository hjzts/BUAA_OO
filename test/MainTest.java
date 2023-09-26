import org.junit.Test;
import org.junit.Before;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private HashMap<Integer, Adventurer> adventurersMap;
    private ArrayList<ArrayList <String>> inputInfo;
    @Before
    public void serUp() {
        adventurersMap = new HashMap<>();
        inputInfo = new ArrayList<>();
    }

    @Test
    public void main() {

    }

    @Test
    public void testOperation() {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("1");
        strings.add("1");
        strings.add("advName");
        inputInfo.add(strings);
        strings.clear();

        strings.add("2");
        strings.add("1");
        strings.add("11");
        strings.add("bottleName");
        strings.add("1");
        inputInfo.add(strings);
        strings.clear();

        strings.add("3");
        strings.add("11");
        inputInfo.add(strings);
        strings.clear();

        strings.add("4");
        strings.add("1");
        strings.add("111");
        strings.add("equipmentName");
        strings.add("2");
        inputInfo.add(strings);
        strings.clear();

        strings.add("5");
        strings.add("1");
        strings.add("111");
        inputInfo.add(strings);
        strings.clear();

        strings.add("4");
        strings.add("1");
        strings.add("111");
        strings.add("equipmentName");
        strings.add("2");
        inputInfo.add(strings);
        strings.clear();

        strings.add("6");
        strings.add("111");
        Main.operation(14, inputInfo);
        assertEquals(1, adventurersMap.size());
    }

    @Test
    public void testAdventurerAdd() {
    }

    @Test
    public void testBottleAdd() {
    }

    @Test
    public void testBottleDelete() {
    }

    @Test
    public void testEquipmentAdd() {
    }

    @Test
    public void testEquipmentDelete() {
    }

    @Test
    public void testEquipmentUpgrade() {
    }

    @Test
    public void testFoodAdd() {
    }

    @Test
    public void testFoodDelete() {
    }

    @Test
    public void testEquipmentCarry() {
    }

    @Test
    public void testBottleCarry() {
    }

    @Test
    public void testFoodCarry() {
    }

    @Test
    public void testBottleUse() {
    }

    @Test
    public void testFoodUse() {
    }
}