/**
 * 这里专门用于处理战斗模式，对于每次进入战斗模式的adv，进行完操作后将对应的容器清空
 * 同时保留每个冒险者攻击和被攻击的记录，以及对应时间的战斗情况。
 * 2023/10/12 2:00
 *
 * @author hugo
 */

import java.util.HashMap;
import java.util.ArrayList;

public class FightMode {
    private ArrayList<Adventurer> adventurerInFightModeList = new ArrayList<>();
    private HashMap<String, ArrayList<String>> fightLogTimeMap = new HashMap<>();
    private HashMap<Integer, ArrayList<String>> attackLogMap = new HashMap<>();
    private HashMap<Integer, ArrayList<String>> beAttackedLogMap = new HashMap<>();

    public void enterFightMode(Adventurer adventurer) {
        adventurerInFightModeList.add(adventurer);
    }

    public void timeLogTreeInsert(String outputLog) {
        String[] strings = outputLog.trim().split(" ");
        String time = strings[0];
        if (fightLogTimeMap.containsKey(time)) {
            ArrayList<String> temp = fightLogTimeMap.get(time);
            temp.add(outputLog);
            fightLogTimeMap.replace(time, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(outputLog);
            fightLogTimeMap.put(time, temp);
        }
    }

    public void attackLogMapInsert(String outputLog) {
        String[] strings = outputLog.trim().split(" ");
        String attackName = strings[1];
        int attackId = Manager.getAdventurer(attackName).getId();
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
        String[] strings = outputLog.trim().split(" ");
        String beAttackedName = strings[3];
        if (Manager.getAdventurer(beAttackedName) == null) {
            return;
        } else {
            int beAttackedId = Manager.getAdventurer(beAttackedName).getId();
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
    }

    public void beAttackedLogMapAoeInsert(String outputLog, int adventurerId) {
        if (beAttackedLogMap.containsKey(adventurerId)) {
            ArrayList<String> temp = beAttackedLogMap.get(adventurerId);
            temp.add(outputLog);
            beAttackedLogMap.replace(adventurerId, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(outputLog);
            beAttackedLogMap.put(adventurerId, temp);
        }
    }

    public void useBottle(ArrayList<String> input, int adventurerId) {
        if (!adventurerInFightModeList.contains(Manager.getAdventurer(adventurerId))) {
            System.out.println("Fight log error");
            return;
        }
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add(Integer.toString(adventurerId));
        strings.add(input.get(2));
        boolean useSuccess = Manager.bottleUse(strings, 1);
        if (useSuccess) {
            String timeLog = input.get(0) + " " + input.get(1) + " " + "used" + " " + input.get(2);
            timeLogTreeInsert(timeLog);
        } else {
            return;
        }
    }

    public void attackOne(ArrayList<String> input) {
        Adventurer adventurerAttack = Manager.getAdventurer(input.get(1));
        Adventurer adventurerBeAttacked = Manager.getAdventurer(input.get(2));
        int attackId = adventurerAttack.getId();
        int beAttackedId = adventurerBeAttacked.getId();
        if (!adventurerInFightModeList.contains(Manager.getAdventurer(attackId)) ||
                !adventurerInFightModeList.contains(Manager.getAdventurer(beAttackedId))) {
            System.out.println("Fight log error");
            return;
        } else {
            boolean attackSuccess = adventurerAttack.hasEquipmentInBackpack(input.get(3));
            if (attackSuccess) {
                int attackerLevel = adventurerAttack.getLevel();
                int equipmentStar = adventurerAttack.getEquipmentCarriedStar(input.get(3));
                adventurerBeAttacked.decreaseHitPoint(attackerLevel * equipmentStar);
                int hitPoint = adventurerBeAttacked.getHitPoint();
                System.out.println(beAttackedId + " " + hitPoint);

                String outputLog = input.get(0) + " " + input.get(1) + " " + "attacked"
                        + " " + input.get(2) + " " + "with" + " " + input.get(3);
                timeLogTreeInsert(outputLog);
                attackLogMapInsert(outputLog);
                beAttackedLogMapInsert(outputLog);
            } else {
                System.out.println("Fight log error");
                return;
            }
        }

    }

    public void attackAoe(ArrayList<String> input) {
        Adventurer adventurerAttack = Manager.getAdventurer(input.get(1));
        int attackId = adventurerAttack.getId();
        if (!adventurerInFightModeList.contains(Manager.getAdventurer(attackId))) {
            System.out.println("Fight log error");
            return;
        } else {
            boolean attackSuccess = adventurerAttack.hasEquipmentInBackpack(input.get(2));
            int attackerLevel;
            int equipmentStar;
            if (attackSuccess) {
                attackerLevel = adventurerAttack.getLevel();
                equipmentStar = adventurerAttack.getEquipmentCarriedStar(input.get(2));

                String outputLog = "";
                for (int i = 0; i < adventurerInFightModeList.size(); i++) {
                    if (adventurerInFightModeList.get(i).getId() == attackId) {
                        continue;
                    } else {
                        Adventurer adventurerBeAttacked = adventurerInFightModeList.get(i);
                        if (adventurerBeAttacked == null) {
                            continue;
                        }
                        adventurerBeAttacked.decreaseHitPoint(attackerLevel * equipmentStar);
                        int hitPoint = adventurerBeAttacked.getHitPoint();
                        System.out.print(hitPoint + " ");
                        outputLog = input.get(0) + " " + input.get(1) + " " + "AOE-attacked"
                                + " " + "with" + " " + input.get(2);
                        beAttackedLogMapAoeInsert(outputLog, adventurerBeAttacked.getId());
                    }
                }
                attackLogMapInsert(outputLog);
                timeLogTreeInsert(outputLog);
                System.out.println();
            }
            else {
                System.out.println("Fight log error");
                return;
            }
        }
    }

    public void queryTimeLog(String time) {
        if (fightLogTimeMap.containsKey(time)) {
            ArrayList<String> temp = fightLogTimeMap.get(time);
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
        adventurerInFightModeList.clear();
    }
}
