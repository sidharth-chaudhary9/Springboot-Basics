package org.example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartService {
    @GET("carts/{id}")
    Call<Carts> getCartById(@Path("id") String user);

    @POST("carts")
    Call<Carts> postInCart(@Body Carts carts);
}
