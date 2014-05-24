package com.eminent.morningstar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.eminent.morningstar.R;
import com.eminent.morningstar.adapter.BusListAdapter;
import com.eminent.morningstar.utils.DummyBusData;

public class BusListActivity extends Activity{
    private static final String LOG_TAG = BusListActivity.class.getSimpleName();

    private ListView mListView = null;
    private BusListAdapter mListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");

        setContentView(R.layout.bus_list);
        mListView = (ListView)findViewById(R.id.id_buses_list);
        mListAdapter = new BusListAdapter(this);
        DummyBusData.addDummyBusData(this,mListAdapter);
        mListView.setAdapter(mListAdapter);
    }
}
