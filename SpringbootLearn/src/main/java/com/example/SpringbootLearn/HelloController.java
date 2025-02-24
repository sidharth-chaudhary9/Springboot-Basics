package com.example.SpringbootLearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/Hello")
    public String getHello(){
        return "<h1><b>Hello World</b></h1>";
    }

}
