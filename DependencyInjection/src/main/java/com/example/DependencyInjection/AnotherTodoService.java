package com.example.DependencyInjection;

import org.springframework.stereotype.Service;

@Service("another")
public class AnotherTodoService implements TodoService{
    public String doSomething(){
        return "Another something";
    }
}
