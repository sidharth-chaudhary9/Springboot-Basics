package com.example.SpringbootRetrofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@SpringBootApplication
public class SpringbootRetrofitApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringbootRetrofitApplication.class, args);
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		TodoService service=retrofit.create(TodoService.class);
		TodoList list1 = service.getTodoById(1).execute().body();
		System.out.println(list1.toString());
		TodoController c1=new TodoController();
		c1.thisString(list1);
	}

}
