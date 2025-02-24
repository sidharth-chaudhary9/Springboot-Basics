package com.example.SpringbootRetrofit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TodoController {

        @GetMapping("/id")
        public String thisString(TodoList list1){
            return list1.toString();
        }
}
