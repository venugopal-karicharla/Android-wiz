package com.example.venu.purchaseplanner;

import java.util.Date;

/**
 * Created by sujatha on 1/20/2016.
 */
public class DataClass {
    int mslNo;
    String mdate;
    String mlistName;
    String mitemName;
    String mqty;
    String munits;
    String mremarks;

    public int getMslNo() {
        return mslNo;
    }

    public void setMslNo(int mslNo) {
        this.mslNo = mslNo;
    }

    public String getMdate() { return mdate; }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getMlistName() {
        return mlistName;
    }

    public void setMlistName(String mlistName) {
       //System.out.println("<<<<<<<<<<<<<<<<"+mlistName+">>>>>>>>>>>>>>>>>>>>>>");
        this.mlistName = mlistName;
    }

    public String getMitemName() {
        return mitemName;
    }

    public void setMitemName(String mitemName) {
        this.mitemName = mitemName;
    }

    public String getMqty() {
        return mqty;
    }

    public void setMqty(String mqty) {
        this.mqty = mqty;
    }

    public String getMunits() {
        return munits;
    }

    public void setMunits(String munits) {
        this.munits = munits;
    }

    public String getMremarks() {
        return mremarks;
    }

    public void setMremarks(String mremarks) {
        this.mremarks = mremarks;
    }
}
