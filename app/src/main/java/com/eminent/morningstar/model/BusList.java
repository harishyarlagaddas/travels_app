package com.eminent.morningstar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BusList {
    @SerializedName("From")
    String mFrom;

    @SerializedName("To")
    String mTo;

    @SerializedName("BusInfo")
    ArrayList<BusInfo> mBusInfoList;

    public ArrayList<BusInfo> getBusList(){
        return mBusInfoList;
    }
}

