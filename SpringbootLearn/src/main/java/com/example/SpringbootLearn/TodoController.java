package com.example.SpringbootLearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<TodoList> lists;
    public TodoController(){
        lists=new ArrayList<>();
        lists.add(new TodoList(5,"Yo Yo Yo","148323269",9));
        lists.add(new TodoList(8,"Whatsup","represting the abq",10));
    }
    @GetMapping("/todolist")
    public List<TodoList> getTheList(){
        return lists;
    }
    @PostMapping("/todolist")
    public TodoList setLists(@RequestBody TodoList newlist){
        lists.add(newlist);
        return newlist;
    }
}
