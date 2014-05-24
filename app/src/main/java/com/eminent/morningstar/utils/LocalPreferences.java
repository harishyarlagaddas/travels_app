package com.eminent.morningstar.utils;

import com.eminent.morningstar.model.BusInfo;

public class LocalPreferences {
    private static final String LOG_TAG = LocalPreferences.class.getSimpleName();

    private static BusInfo mCurrentBusInfo;

    public static void storeCurrentBusInfo(BusInfo info){
        mCurrentBusInfo = info;
    }

    public static BusInfo getCurrentBusInfo(){
        return mCurrentBusInfo;
    }
}
