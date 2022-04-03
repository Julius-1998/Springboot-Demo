package com.example.springboot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/testAPI")
public class TestController {

    @PostMapping("")
    public String testAPI(@RequestBody Map<String,String> map)
    {
        System.out.print(map);
        return "";
    }
}
