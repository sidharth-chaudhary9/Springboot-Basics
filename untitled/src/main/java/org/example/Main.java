package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://fakestoreapi.com/carts";
        Request request= new Request.Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                System.out.println("Something is going wrong");
            }
            String output = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(output,Object.class);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            String prettyJson = writer.writeValueAsString(json);
            System.out.println(prettyJson);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
