package org.example;

public class TodoList {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public boolean getStatus(){
        return completed;
    }
    public void setStatus(boolean completed){
        this.completed=completed;
    }

    @Override
    public String toString() {
        return "{\n" +
                "userId : " + userId +"\n"+
                "id : " + id +"\n"+
                "title : " + title +"\n"+
                "completed : " + completed +"\n }";
    }
}
