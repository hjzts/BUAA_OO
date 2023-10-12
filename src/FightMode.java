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
    private HashMap<Integer, Adventurer> adventurerInFightModeMap = new HashMap<>();
    private TreeMap<String, ArrayList<String>> fightLogTimeTree = new TreeMap<>();
    private HashMap<Integer, ArrayList<String>> attackLogMap = new HashMap<>();
    private HashMap<Integer, ArrayList<String>> beAttackedLogMap = new HashMap<>();

    public void enterFightMode(Adventurer adventurer) {
        adventurerInFightModeMap.put(adventurer.getId(), adventurer);
    }

    public void timeLogTreeInsert(String outputLog) {
        String[] strings = outputLog.split(" ");
        String time = strings[0];
        if (fightLogTimeTree.containsKey(time)) {
            ArrayList<String> temp = fightLogTimeTree.get(time);
            temp.add(outputLog);
            fightLogTimeTree.replace(time, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(outputLog);
            fightLogTimeTree.put(time, temp);
        }
    }

    public void attackLogMapInsert(String outputLog) {
        String[] strings = outputLog.split(" ");
        String attackName = strings[1];
        int attackId = Main.getAdventurer(attackName).getId();
        if (attackLogMap.containsKey(attackId)) {
            ArrayList<String> temp = attackLogMap.get(attackId);
            temp.add(outputLog);
            attackLogMap.replace(attackId, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(outputLog);
            attackLogMap.put(attackId, temp);
        }
    }

    public void beAttackedLogMapInsert(String outputLog) {
        String[] strings = outputLog.split(" ");
        String beAttackedName = strings[3];
        if (Main.getAdventurer(beAttackedName) == null) {
            return;
        }
        int beAttackedId = Main.getAdventurer(beAttackedName).getId();
        if (beAttackedLogMap.containsKey(beAttackedId)) {
            ArrayList<String> temp = beAttackedLogMap.get(beAttackedId);
            temp.add(outputLog);
            beAttackedLogMap.replace(beAttackedId, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(outputLog);
            beAttackedLogMap.put(beAttackedId, temp);
        }
    }

    public void useBottle(ArrayList<String> input, int adventurerId) {
        if (!adventurerInFightModeMap.containsKey(adventurerId)) {
            System.out.println("Fight log error");
            return;
        }
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add(Integer.toString(adventurerId));
        strings.add(input.get(2));
        boolean useSuccess = Main.bottleUse(strings, 1);
        if (useSuccess) {
            String timeLog = input.get(0) + " " + input.get(1) + " " + "used" + " " + input.get(2);
            timeLogTreeInsert(timeLog);
        } else {
            return;
        }
    }

    public void attackOne(ArrayList<String> input) {
        Adventurer adventurerAttack = Main.getAdventurer(input.get(1));
        Adventurer adventurerBeAttacked = Main.getAdventurer(input.get(2));
        int attackId = adventurerAttack.getId();
        int beAttackedId = adventurerBeAttacked.getId();
        if (!adventurerInFightModeMap.containsKey(attackId) ||
                !adventurerInFightModeMap.containsKey(beAttackedId)) {
            System.out.println("Fight log error");
            return;
        }
        boolean attackSuccess = adventurerAttack.hasEquipmentInBackpack(input.get(3));
        if (attackSuccess) {
            int attackerLevel = adventurerAttack.getLevel();
            int equipmentStar = adventurerAttack.getEquipmentCarriedStar(input.get(3));
            adventurerBeAttacked.decreaseHitPoint(attackerLevel * equipmentStar);
            int hitPoint = adventurerBeAttacked.getHitPoint();
            System.out.println(beAttackedId + " " + hitPoint);
        } else {
            System.out.println("Fight log error");
            return;
        }
        String outputLog = input.get(0) + " " + input.get(1) + " " + "attacked"
                + " " + input.get(2) + " " + "with" + " " + input.get(3);
        timeLogTreeInsert(outputLog);
        attackLogMapInsert(outputLog);
        beAttackedLogMapInsert(outputLog);
    }

    public void attackAoe(ArrayList<String> input) {
        Adventurer adventurerAttack = Main.getAdventurer(input.get(1));
        int attackId = adventurerAttack.getId();
        if (!adventurerInFightModeMap.containsKey(attackId)) {
            System.out.println("Fight log error");
            return;
        }
        boolean attackSuccess = adventurerAttack.hasEquipmentInBackpack(input.get(2));
        int attackerLevel;
        int equipmentStar;
        if (attackSuccess) {
            attackerLevel = adventurerAttack.getLevel();
            equipmentStar = adventurerAttack.getEquipmentCarriedStar(input.get(2));
        }
        else {
            System.out.println("Fight log error");
            return;
        }
        for (Integer key : adventurerInFightModeMap.keySet()) {
            if (key != attackId) {
                Adventurer adventurerBeAttacked = Main.getAdventurer(key);
                if (adventurerBeAttacked == null) {
                    continue;
                }
                adventurerBeAttacked.decreaseHitPoint(attackerLevel * equipmentStar);
                int hitPoint = adventurerBeAttacked.getHitPoint();
                System.out.print(hitPoint + " ");
                String outputLog = input.get(0) + " " + input.get(1) + " " + "AOE-attacked"
                        + " " + "with" + " " + input.get(2);
                timeLogTreeInsert(outputLog);
                attackLogMapInsert(outputLog);
                beAttackedLogMapInsert(outputLog);
            }
        }
        System.out.println();
    }

    public void queryTimeLog(String time) {
        if (fightLogTimeTree.containsKey(time)) {
            ArrayList<String> temp = fightLogTimeTree.get(time);
            for (String s : temp) {
                System.out.println(s);
            }
        } else {
            System.out.println("No Matched Log");
        }
    }

    public void queryAttackLog(int attackId) {
        if (attackLogMap.containsKey(attackId)) {
            ArrayList<String> temp = attackLogMap.get(attackId);
            for (String s : temp) {
                System.out.println(s);
            }
        } else {
            System.out.println("No Matched Log");
        }
    }

    public void queryBeAttackedLog(int beAttackedId) {
        if (beAttackedLogMap.containsKey(beAttackedId)) {
            ArrayList<String> temp = beAttackedLogMap.get(beAttackedId);
            for (String s : temp) {
                System.out.println(s);
            }
        } else {
            System.out.println("No Matched Log");
        }
    }

    public void exitFightMode() {
        adventurerInFightModeMap.clear();
    }
}
