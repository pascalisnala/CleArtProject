package com.example.pascalisnala.cleart.API;

import com.example.pascalisnala.cleart.models.Attraction;
import com.example.pascalisnala.cleart.models.HomeResponse;
import com.example.pascalisnala.cleart.models.defaultResponse;
import com.example.pascalisnala.cleart.models.loginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("createuser")
    Call<defaultResponse> createUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("email") String email,
            @Field("phonenum") String phonenum,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<loginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("loaddata")
    Call<HomeResponse> getAttrData();



}
