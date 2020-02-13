package com.example.fms.remote;

import com.example.fms.model.Bank_acc;
import com.example.fms.model.Login_data;
import com.example.fms.model.bussiness_data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {


    @FormUrlEncoded
    @POST("fms/android/login_json.php")
    Call<Login_data> login(@Field("username") String username,
                           @Field("password") String password);
    @FormUrlEncoded
    @POST("fms/android/bank_acounts.php")
    Call<ArrayList<Bank_acc>>  bank_accounts(@Field("buss_id") String buss_id);

    @GET("fms/android/buss.php")
    Call<ArrayList<bussiness_data>> bussniss_names();

}