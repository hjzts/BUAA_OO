import org.junit.Test;
import org.junit.Before;


import java.util.ArrayList;
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
    public void operation() {
        ArrayList<String> strings = new ArrayList<>();

        // advId = 1; bottleId = 11; equipmentId = 111; foodId = 1111;
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
        inputInfo.add(strings);
        strings.clear();


        strings.add("7");
        strings.add("1");
        strings.add("1111");
        strings.add("foodName");
        strings.add("1");
        inputInfo.add(strings);
        strings.clear();

        strings.add("8");
        strings.add("1");
        strings.add("1111");
        inputInfo.add(strings);
        strings.clear();

        strings.add("7");
        strings.add("1");
        strings.add("1111");
        strings.add("foodName");
        strings.add("1");
        inputInfo.add(strings);
        strings.clear();

        strings.add("9");
        strings.add("1");
        strings.add("111");
        inputInfo.add(strings);
        strings.clear();

        strings.add("10");
        strings.add("1");
        strings.add("11");
        inputInfo.add(strings);
        strings.clear();

        strings.add("11");
        strings.add("1");
        strings.add("1111");
        inputInfo.add(strings);
        strings.clear();

        strings.add("12");
        strings.add("1");
        strings.add("bottleName");
        inputInfo.add(strings);
        strings.clear();

        strings.add("13");
        strings.add("1");
        strings.add("foodName");
        inputInfo.add(strings);
        strings.clear();

        Main.operation(15, inputInfo);
        assertEquals(1, adventurersMap.size());
    }

    @Test
    public void adventurerAdd() {
    }

    @Test
    public void bottleAdd() {
    }

    @Test
    public void bottleDelete() {
    }

    @Test
    public void equipmentAdd() {
    }

    @Test
    public void equipmentDelete() {
    }

    @Test
    public void equipmentUpgrade() {
    }

    @Test
    public void foodAdd() {
    }

    @Test
    public void foodDelete() {
    }

    @Test
    public void equipmentCarry() {
    }

    @Test
    public void bottleCarry() {
    }

    @Test
    public void foodCarry() {
    }

    @Test
    public void bottleUse() {
    }

    @Test
    public void foodUse() {
    }
}