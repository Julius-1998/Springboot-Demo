package com.example.springboot.RiskMap;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Territory {

    private int soldierNum;
    private String ownerName;
    private List<Territory> neighbors;
    private String territoryName;

    public int getSoldierNum() {
        return soldierNum;
    }

    public void setSoldierNum(int soldierNum) {
        this.soldierNum = soldierNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @JsonBackReference
    public List<Territory> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Territory> neighbors) {
        this.neighbors = neighbors;
    }

    public String getTerritoryName() {
        return territoryName;
    }

    public void setTerritoryName(String territoryName) {
        this.territoryName = territoryName;
    }

    public Territory(int soldiers, String ownerName, String territoryName) {
        this.soldierNum = soldiers;
        this.ownerName = ownerName;
        this.territoryName = territoryName;
        this.neighbors = new ArrayList<Territory>();
    }

    public void addNeighbor(Territory neighbor) {
        neighbors.add(neighbor);
    }

    public String getDisplayInfo() {
        StringBuilder sb = new StringBuilder();
        for (Territory t : neighbors) {
            sb.append(t.territoryName).append(" ");
        }
        String neighborString = sb.toString();
        String displayInfo =
                soldierNum + " units in " +
                        territoryName +
                        " owned by " + ownerName +
                        "(next to: " + neighborString+ ")\n";
        return displayInfo;
    }

    @Override
    public String toString(){
        return this.getDisplayInfo();
    }


}
