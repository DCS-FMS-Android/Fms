package com.example.fms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bussiness_data {
    @SerializedName("buss_id")
    @Expose
    private String id;
    @SerializedName("buss_nam")
    @Expose
    private String buss_name;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     */
    public bussiness_data() {
    }

    /**
     * @param id
     */
    public bussiness_data(String id, String buss_name, String status) {
        super();
        this.id = id;
        this.buss_name = buss_name;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuss_name() {
        return buss_name;
    }

    public void setBuss_name(String buss_name) {
        this.buss_name = buss_name;
    }

}