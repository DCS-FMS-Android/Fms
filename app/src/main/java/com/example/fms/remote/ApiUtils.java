package com.example.fms.remote;

public class ApiUtils {

    public static final String BASE_URL = "http://blackhatcynic.com/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}