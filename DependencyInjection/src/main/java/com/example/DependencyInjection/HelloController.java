package com.example.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Autowired
//    @Qualifier("another")
    private TodoService todoService;
    public HelloController(@Qualifier("fake") TodoService todoService){
        this.todoService=todoService;
    }
    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("Hello World");
        System.out.println("Inside the service" + this.todoService.doSomething());
        return "Hello World";
    }
}
