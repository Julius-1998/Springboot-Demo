package com.example.springboot.RiskMap;

import org.springframework.context.annotation.Bean;

public class LittleMap {
    String name;
    public LittleMap(){
        this.name ="abc";
    }
    @Override
    public String toString(){
        return "LittleMap{"+
                "name='"+ name+'\''+"}";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
