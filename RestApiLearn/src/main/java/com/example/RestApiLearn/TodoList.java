package com.example.RestApiLearn;

public class TodoList {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    TodoList(int userId,int id,String title,boolean completed){
        this.userId=userId;
        this.id=id;
        this.title=title;
        this.completed=completed;
    }
    TodoList(){}

    public int getUserId() {
        return userId;
    }

    public TodoList setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getId() {
        return id;
    }

    public TodoList setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TodoList setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoList setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
