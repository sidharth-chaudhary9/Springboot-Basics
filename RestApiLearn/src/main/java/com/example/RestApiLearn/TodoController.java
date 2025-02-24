package com.example.RestApiLearn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private final static List<TodoList> todos=new ArrayList<>();
    public TodoController(){
        todos.add(new TodoList(5,10,"Hello",true));
        todos.add(new TodoList(19,21,"Yo Yo",false));
    }
    @GetMapping("/todos")
    public List<TodoList> getTodos(){
        return todos;
    }
    @PostMapping("/todos")
    public void postTodos(@RequestBody TodoList newTodo){
        todos.add(newTodo);
    }
    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoList> getTodoById(@PathVariable int todoId){
        for(int i=0;i<todos.size();i++){
            if(todos.get(i).getId()==todoId){
                return ResponseEntity.ok(todos.get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoList> changeTodo(@RequestBody TodoList changedTodo,@PathVariable int todoId){
        for(int i=0;i<todos.size();i++){
            if(todos.get(i).getId()==todoId){
                todos.get(i).setId(changedTodo.getId()).setUserId(changedTodo.getUserId()).setCompleted(changedTodo.isCompleted()).setTitle(changedTodo.getTitle());
                return ResponseEntity.ok(changedTodo);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/todos/{todoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void smallChanges(@RequestBody TodoList changesTodo,@PathVariable int id){

    }
}
