package com.example.springboot.RiskMap;

import java.util.*;
import java.util.stream.Collectors;

public class RiskMap {

    private HashMap<String, Territory> territories;//territory name + territory
    private Map<String, List<String>> playerTerritoryMap;//player name + one's territory

    public HashMap<String, Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(HashMap<String, Territory> territories){
        this.territories = territories;
    }

    public Map<String, List<String>> getPlayerTerritoryMap() {
        return playerTerritoryMap;
    }

    public void setPlayerTerritoryMap(Map<String, List<String>> playerTerritoryMap) {
        this.playerTerritoryMap = playerTerritoryMap;
    }



    public RiskMap() {
        // TODO: Abstracted to reading from file;
        // fixed available territory, their neighbors, and groups
        String[] territoryNames = {"Narnia", "Elastris", "Midkemia", "Scadrial", "Oz", "Roshar", "Gondor", "Mordor", "Hogwarts"};
        List<String> territoryNameList = Arrays.asList(territoryNames);
        HashMap<String, HashSet<String>> territoryNeighbors = new HashMap<>();
        territoryNeighbors.put("Narnia", new HashSet<>(Arrays.asList("Elastris", "Midkemia")));
        territoryNeighbors.put("Elastris", new HashSet<>(Arrays.asList("Narnia", "Scadrial", "Midkemia", "Roshar")));
        territoryNeighbors.put("Midkemia", new HashSet<>(Arrays.asList("Narnia", "Elastris", "Scadrial", "Oz")));
        territoryNeighbors.put("Scadrial", new HashSet<>(Arrays.asList("Elastris", "Midkemia", "Oz", "Mordor", "Hogwarts", "Roshar")));
        territoryNeighbors.put("Oz", new HashSet<>(Arrays.asList("Midkemia", "Scadrial", "Gondor", "Mordor")));
        territoryNeighbors.put("Roshar", new HashSet<>(Arrays.asList("Elastris", "Scadrial", "Hogwarts")));
        territoryNeighbors.put("Gondor", new HashSet<>(Arrays.asList("Oz", "Mordor")));
        territoryNeighbors.put("Mordor", new HashSet<>(Arrays.asList("Gondor", "Oz", "Scadrial", "Hogwarts")));
        territoryNeighbors.put("Hogwarts", new HashSet<>(Arrays.asList("Mordor", "Scadrial", "Roshar")));
        // group the territories by color
        HashMap<String, String> territoryGroups = new HashMap<>();
        territoryGroups.put("Narnia", "Green");
        territoryGroups.put("Midkemia", "Green");
        territoryGroups.put("Oz", "Green");
        territoryGroups.put("Scadrial", "Green");
        territoryGroups.put("Roshar", "Red"); // originally, blue
        territoryGroups.put("Elastris", "Red"); // originally, blue
        territoryGroups.put("Gondor", "Red");
        territoryGroups.put("Mordor", "Red");
        territoryGroups.put("Hogwarts", "Red");

        HashMap<String, Integer> territorySoldierNums = new HashMap<>();
        territorySoldierNums.put("Narnia", 10);
        territorySoldierNums.put("Midkemia", 12);
        territorySoldierNums.put("Oz", 8);
        territorySoldierNums.put("Scadrial", 5);
        territorySoldierNums.put("Roshar", 3); // originally, blue
        territorySoldierNums.put("Elastris", 6); // originally, blue
        territorySoldierNums.put("Gondor", 13);
        territorySoldierNums.put("Mordor", 14);
        territorySoldierNums.put("Hogwarts", 3);
        this.territories = createTerritories(territoryNameList, territoryNeighbors, territoryGroups, territorySoldierNums);
        // TODO: check whether the cast is safe or not
        this.playerTerritoryMap = territoryGroups.keySet().stream().collect(Collectors.groupingBy(territoryGroups::get));
    }

    private HashMap<String, Territory> createTerritories(List<String> territoryNames, HashMap<String, HashSet<String>> territoryNeighbors, HashMap<String, String> territoryGroups, Map<String, Integer> territorySoldierNums) {
        this.territories = new HashMap<>();
        for (String territoryName: territoryNames) {
            String territoryGroup = territoryGroups.get(territoryName);
            territories.put(territoryName, new Territory(territorySoldierNums.get(territoryName), territoryGroup, territoryName));
        }
        for (HashMap.Entry<String, HashSet<String>> entry : territoryNeighbors.entrySet()) {
            Territory territory = territories.get(entry.getKey());
            for (String territoryName : entry.getValue()) {
                Territory neighbor = territories.get(territoryName);
                territory.addNeighbor(neighbor);
            }
        }
        return territories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Risk Map: \n");
        for (Territory territory : territories.values()) {
            sb.append(territory.toString());
        }
        return sb.toString();
    }




}
