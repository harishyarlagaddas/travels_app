package com.eminent.morningstar.utils;

import android.content.Context;
import android.util.Log;

import com.eminent.morningstar.R;
import com.eminent.morningstar.adapter.BusListAdapter;
import com.eminent.morningstar.model.BusInfo;
import com.eminent.morningstar.model.BusList;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DummyBusData {
    private static final String LOG_TAG = DummyBusData.class.getSimpleName();

    public static void addDummyBusData(Context c, BusListAdapter adapter) {
        Log.d(LOG_TAG, "addDummyBusData IN");
        BusList busList = new Gson().fromJson(loadJSONFromAsset(c), BusList.class);

        ArrayList<BusInfo> busInfoList = busList.getBusList();
        for (BusInfo info : busInfoList) {
            adapter.addItem(info);
        }
    }

    private static String loadJSONFromAsset(Context c) {
        String json = null;
        try {

            InputStream is = c.getResources().openRawResource(R.raw.dummy_bus_data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
