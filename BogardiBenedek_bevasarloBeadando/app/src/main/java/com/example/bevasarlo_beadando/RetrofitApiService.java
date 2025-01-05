package com.example.bevasarlo_beadando;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public class RetrofitApiService {

    @GET("termekek")
    Call<List<Termekek>> getAllTermekek();

    @GET("termekek/{id}")
    Call<Termekek> getTermekekById(@Path("id") int id);

    @PUT("termekek/{id}")
    Call<Termekek> updateTermekek(@Path("id") int id, @Body Termekek termekek);

    @POST("termekek")
    Call<Termekek> createTermekek(@Body Termekek termekek);

    @DELETE("termekek/{id}")
    Call<Void> deleteTermekek(@Path("id") int id);
    
}
