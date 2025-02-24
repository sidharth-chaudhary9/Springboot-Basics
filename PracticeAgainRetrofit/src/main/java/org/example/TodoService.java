package org.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface TodoService {
    @GET("todos/{id}")
    Call<TodoList> getListById(@Path("id") int id);
}
