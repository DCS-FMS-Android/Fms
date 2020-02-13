package com.example.fms.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;



    public static Retrofit getClient(String url){

        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


//            Type collectionType = new TypeToken<List<ResObj>>(){}.getType();
//            List<ResObj> lcs = (List<ResObj>) new Gson()
//                    .fromJson( jstring , collectionType);
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }



}
