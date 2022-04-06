package com.example.springboot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.springboot.RiskMap.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.springboot.Orders.*;

import javax.servlet.http.HttpServletRequest;

@ResponseBody
@Controller
@RequestMapping("/testAPI")
public class TestController {

    private String getUpdateTerritoryFromClient(@RequestBody Map<String, List<Map<String, String>>> actions){
        if(actions.containsKey("updateTerritory")){
            List<Map<String, String>> updateTerritory = actions.get("updateTerritory");
            for (Map<String, String> updateterritory: updateTerritory){
                String operatorName = updateterritory.get("operatorName").toString();
                String territoryName = updateterritory.get("territoryName").toString();
                Integer originalLevel = Integer.parseInt(updateterritory.get("originalLevel").toString());
                Integer aimLevel = Integer.parseInt(updateterritory.get("aimLevel").toString());

                System.out.println(operatorName+" "+territoryName+ " "+originalLevel+" "+ aimLevel);
            }
        }
        return null;
    }

    private String getUpdateUnitFromClient(@RequestBody Map<String, List<Map<String, String>>> actions){
        if(actions.containsKey("updateUnit")){
            List<Map<String, String>> updateUnit = actions.get("updateUnit");
            for (Map<String, String> updateunit: updateUnit){
                String operatorName = updateunit.get("operatorName").toString();
                String territoryName = updateunit.get("territoryName").toString();
                Integer originalLevel = Integer.parseInt(updateunit.get("originalLevel").toString());
                Integer aimLevel = Integer.parseInt(updateunit.get("aimLevel").toString());
                Integer num = Integer.parseInt(updateunit.get("num").toString());

                System.out.println(operatorName+" "+territoryName+ " "+originalLevel+" "+ aimLevel+ " "+ num);
            }
        }
        return null;
    }

    private String getOrderFromClient(@RequestBody Map<String, List<Map<String, String>>> actions){
        if (actions.containsKey("order")){
            List<Map<String, String>> myOrders = actions.get("order");
            for (Map<String, String> order:myOrders){
                String actionCategory = order.get("actionCategory").toString();
                String operatorName = order.get("operatorName").toString();
                String from = order.get("from").toString();
                String to = order.get("to").toString();
                Integer id = Integer.parseInt(order.get("num").toString());

                System.out.println(actionCategory+" "+operatorName+" "+from+" "+to + " "+ id);
            }

        }
        return null;
    }

    @PostMapping("")
    public String testAPI(@RequestBody Map<String, List<Map<String, String>>> params, HttpServletRequest request)
    {

        getOrderFromClient(params);
        getUpdateTerritoryFromClient(params);
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);
        RiskMap riskmap = new RiskMap();
        LittleMap littlemap = new LittleMap();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(riskmap);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
