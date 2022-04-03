package com.example.springboot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/testAPI")
public class TestController {

    @PostMapping("")
    public Map testAPI(@RequestBody Map<String,String> params)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "name");
        map.put("test", 123);
        map.put("array", new String[]{"a", "b", "c"});
        return map;
    }
}
