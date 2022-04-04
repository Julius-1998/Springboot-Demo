package com.example.springboot.Orders;

import java.io.Serializable;

public abstract class Order implements Serializable {
    protected int unitNum;
    protected String origin;
    protected String target;

    public int getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(int unitNum) {
        this.unitNum = unitNum;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Order(int unitNum, String origin, String target) {
        this.unitNum = unitNum;
        this.origin = origin;
        this.target = target;
    }
}
