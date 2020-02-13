package com.example.fms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bank_acc {

    @SerializedName("bank_nam")
    @Expose
    private String bank_nam;
    @SerializedName("clear_blnce")
    @Expose
    private String clear_blnce;
    @SerializedName("pend_dep")
    @Expose
    private String pend_dep;

    public String getClear_blnce() {
        return clear_blnce;
    }

    public void setClear_blnce(String clear_blnce) {
        this.clear_blnce = clear_blnce;
    }

    public String getPend_dep() {
        return pend_dep;
    }

    public void setPend_dep(String pend_dep) {
        this.pend_dep = pend_dep;
    }

    public String getPend_with() {
        return pend_with;
    }

    public void setPend_with(String pend_with) {
        this.pend_with = pend_with;
    }

    public String getAct_blnce() {
        return act_blnce;
    }

    public void setAct_blnce(String act_blnce) {
        this.act_blnce = act_blnce;
    }

    @SerializedName("pend_with")
    @Expose
    private String pend_with;
    @SerializedName("act_blnce")
    @Expose
    private String act_blnce;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("acc_no")
    @Expose
    private String acc_no;
    @SerializedName("bank_cod")
    @Expose
    private String bank_code;

    public Bank_acc() {
    }

    /**
     * @param bank_nam
     * @param acc_no
     * @param message
     */
    public Bank_acc(String bank_nam, String acc_no, String message) {
        super();
        this.bank_nam = bank_nam;
        this.acc_no = acc_no;
        this.message = message;

    }


    public String getBank_nam() {
        return bank_nam;
    }

    public void setBank_nam(String bank_nam) {
        this.bank_nam = bank_nam;
    }
    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }
}