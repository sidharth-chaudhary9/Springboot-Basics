package org.example;


import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CartService s1= retrofit.create(CartService.class);
        Carts c2=new Carts();
        c2.setId(10);
        c2.setDate("2020-03-01T00:00:00.000Z");
        c2.setV(0);
        c2.setUserId(20);
        List<ProductsItem> productlist=new ArrayList<>();
        productlist.add(new ProductsItem(18,21));
        productlist.add(new ProductsItem(17,22));
        c2.setProducts(productlist);
        Carts c1=s1.postInCart(c2).execute().body();
        System.out.println(c1.toString());
        Response<Carts> response = s1.postInCart(c2).execute();
        System.out.println("Status code: " + response.code());
        System.out.println(productlist.get(1).getProductId());

    }
}