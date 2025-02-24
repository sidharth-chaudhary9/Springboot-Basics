package com.example.SpringbootRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {
    @GET("/todos/{id}")
    Call<TodoList> getTodoById(@Path("id") int id);
}
