package com.eminent.morningstar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BusInfo{
    private static final int BUS_SEATS_COUNT = 36;

    @SerializedName("BusStyle")
    private String mBusStyle;

    @SerializedName("Cost")
    private double mCost;

    @SerializedName("startTime")
    private double mStartTime;

    @SerializedName("endTime")
    private double mEndTime;

    @SerializedName("Seats")
    private SeatInfo mSeatInfo;

    @SerializedName("BoardingPoints")
    ArrayList<String> mBoardingPoints;

    public String getBusStyle(){
        return mBusStyle;
    }

    public double getPrice(){
        return mCost;
    }

    public double getStartTime(){
        return mStartTime;
    }

    public double getEndTime(){
        return mEndTime;
    }

    public SeatInfo getSeatInfo(){
        return mSeatInfo;
    }

    public ArrayList<String> getBoardingPoints(){
        return mBoardingPoints;
    }

    public int getAvailableSeats(){
        return BUS_SEATS_COUNT - mSeatInfo.getmBookedSeats().size();
    }
}
