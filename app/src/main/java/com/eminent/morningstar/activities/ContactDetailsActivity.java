package com.eminent.morningstar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.eminent.morningstar.R;

public class ContactDetailsActivity extends Activity {
    private static final String LOG_TAG = ContactDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");
        setContentView(R.layout.contact_details);
    }
}
