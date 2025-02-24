package com.example.DependencyInjection;

import org.springframework.stereotype.Service;

@Service("fake")
public class FakeTodoService implements TodoService{
    @TimeMonitor
    public String doSomething(){
        for(Long i=0L;i<=100000L;i++);
        return "fakeTodo something";
    }
}
