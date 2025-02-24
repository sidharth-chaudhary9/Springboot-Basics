import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<TodoList> todos;
        todos = new ArrayList<>();
//        todos.add(new TodoList(5,10,"hello",true));
        todos.add(new TodoList().setId(5).setUserId(5));
        System.out.println(todos);
    }
}
