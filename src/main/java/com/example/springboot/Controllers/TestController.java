package com.example.springboot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import com.example.springboot.RiskMap.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ResponseBody
@Controller
@RequestMapping("/testAPI")
public class TestController {

    @PostMapping("")
    public String testAPI(@RequestBody Map<String,String> params)
    {
        RiskMap riskmap = new RiskMap();
        LittleMap littlemap = new LittleMap();
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "name");
//        map.put("test", 123);
//        map.put("array", new String[]{"a", "b", "c"});
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
