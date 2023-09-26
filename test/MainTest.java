import org.junit.Test;
import org.junit.Before;


import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private HashMap<Integer, Adventurer> adventurersMap;
//    private ArrayList<ArrayList <String>> inputInfo;
    @Before
    public void setUp() {
        adventurersMap = new HashMap<>();
//        inputInfo = new ArrayList<>();
    }

    @Test
    public void main() {

    }

    @Test
    public void operation() {
        ArrayList<ArrayList <String>> inputInfo;
        inputInfo = new ArrayList<>();

        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        ArrayList<String> strings3 = new ArrayList<>();
        ArrayList<String> strings4 = new ArrayList<>();
        ArrayList<String> strings5 = new ArrayList<>();
        ArrayList<String> strings6 = new ArrayList<>();
        ArrayList<String> strings7 = new ArrayList<>();
        ArrayList<String> strings8 = new ArrayList<>();
        ArrayList<String> strings9 = new ArrayList<>();
        ArrayList<String> strings10 = new ArrayList<>();
        ArrayList<String> strings11 = new ArrayList<>();
        ArrayList<String> strings12 = new ArrayList<>();
        ArrayList<String> strings13 = new ArrayList<>();
        ArrayList<String> strings14 = new ArrayList<>();
        ArrayList<String> strings15 = new ArrayList<>();

        // advId = 1; bottleId = 11; equipmentId = 111; foodId = 1111;
        strings1.add("1");
        strings1.add("1");
        strings1.add("advName");
        inputInfo.add(strings1);

        strings2.add("2");
        strings2.add("1");
        strings2.add("11");
        strings2.add("bottleName");
        strings2.add("1");
        inputInfo.add(strings2);


        strings3.add("3");
        strings3.add("1");
        strings3.add("11");
        inputInfo.add(strings3);

        inputInfo.add(strings2);

        strings4.add("4");
        strings4.add("1");
        strings4.add("111");
        strings4.add("equipmentName");
        strings4.add("2");
        inputInfo.add(strings4);


        strings5.add("5");
        strings5.add("1");
        strings5.add("111");
        inputInfo.add(strings5);

        strings6.add("4");
        strings6.add("1");
        strings6.add("111");
        strings6.add("equipmentName");
        strings6.add("2");
        inputInfo.add(strings6);

        strings7.add("6");
        strings7.add("1");
        strings7.add("111");
        inputInfo.add(strings7);


        strings8.add("7");
        strings8.add("1");
        strings8.add("1111");
        strings8.add("foodName");
        strings8.add("1");
        inputInfo.add(strings8);

        strings9.add("8");
        strings9.add("1");
        strings9.add("1111");
        inputInfo.add(strings9);

        strings10.add("7");
        strings10.add("1");
        strings10.add("1111");
        strings10.add("foodName");
        strings10.add("1");
        inputInfo.add(strings10);

        strings11.add("9");
        strings11.add("1");
        strings11.add("111");
        inputInfo.add(strings11);

        strings12.add("10");
        strings12.add("1");
        strings12.add("11");
        inputInfo.add(strings12);

        strings13.add("11");
        strings13.add("1");
        strings13.add("1111");
        inputInfo.add(strings13);

        strings14.add("12");
        strings14.add("1");
        strings14.add("bottleName");
        inputInfo.add(strings14);

        strings15.add("13");
        strings15.add("1");
        strings15.add("foodName");
        inputInfo.add(strings15);

        Main.operation(16, inputInfo);
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