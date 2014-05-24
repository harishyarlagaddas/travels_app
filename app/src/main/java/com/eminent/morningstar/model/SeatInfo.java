package com.eminent.morningstar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SeatInfo{
    @SerializedName("Booked")
    private ArrayList<Integer> mBookedSeats;

    @SerializedName("Ladies")
    private ArrayList<Integer> mLadiesSeats;

    public ArrayList<Integer> getmBookedSeats(){
        return mBookedSeats;
    }

    public ArrayList<Integer> getmLadiesSeats(){
        return mLadiesSeats;
    }
}
