/**
 * 这里专门用于处理战斗模式，对于每次进入战斗模式的adv，进行完操作后将对应的容器清空
 * 同时保留每个冒险者攻击和被攻击的记录，以及对应时间的战斗情况。
 * 2023/10/12 2:00
 *
 * @author hugo
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;

public class FightMode {
    private HashMap<Integer,Adventurer> adventurerMap = new HashMap<>();
    private TreeMap<String, ArrayList<String>> fightLogTimeTree = new TreeMap<>();
    private HashMap<Integer,ArrayList<String>> attackLogMap = new HashMap<>();
    private HashMap<Integer,ArrayList<String>> beAttackedLogMap = new HashMap<>();

    public void enterFightMode(Adventurer adventurer) {
        adventurerMap.put(adventurer.getId(),adventurer);
    }

    public ArrayList<String> useBottle(ArrayList<String> input,int adventurerId) {
        fightLogTimeTree.put(input.get(0),input);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(Integer.toString(adventurerId));
        strings.add(input.get(2));
        Main.bottleUse(strings);
        return strings;
    }

    public void attackOne(ArrayList<String> input) {

    }
    public void exitFightMode() {
        adventurerMap.clear();
    }
}
