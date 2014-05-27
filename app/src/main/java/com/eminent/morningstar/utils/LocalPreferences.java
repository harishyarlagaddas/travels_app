package com.eminent.morningstar.utils;

import com.eminent.morningstar.model.BusInfo;

public class LocalPreferences {
    private static final String LOG_TAG = LocalPreferences.class.getSimpleName();

    private static BusInfo mCurrentBusInfo;
    private static String mName;
    private static String mAge;
    private static String mSeats;
    private static String mEmail;
    private static String mMobile;
    private static String mIDProof;

    public static void storeCurrentBusInfo(BusInfo info){
        mCurrentBusInfo = info;
    }

    public static BusInfo getCurrentBusInfo(){
        return mCurrentBusInfo;
    }

    public static void storeName(String name){
        mName = name;
    }

    public static String getStoredName(){
        return mName;
    }

    public static void storeAge(String age){
        mAge = age;
    }

    public static String getStoredAge(){
        return mAge;
    }

    public static void storeSelectedSeats(String seats){
        mSeats = seats;
    }

    public static String getStoredSeats(){
        return mSeats;
    }

    public static void storeEmail(String email){
        mEmail = email;
    }

    public static String getStoredEmail(){
        return mEmail;
    }

    public static void storeMobile(String mobile){
        mMobile = mobile;
    }

    public static String getStoredMobile(){
        return mMobile;
    }

    public static void storeIDProof(String idProof){
        mIDProof = idProof;
    }

    public static String getStoredIDProof(){
        return mIDProof;
    }
}
