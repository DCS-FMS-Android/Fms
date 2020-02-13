package com.example.fms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login_data {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userid")
    @Expose
    private String userid;

    public Login_data() {
    }

    /**
     * @param message
     * @param userid
     */
    public Login_data(String message, String userid) {
        super();
        this.message = message;
        this.userid = userid;

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}