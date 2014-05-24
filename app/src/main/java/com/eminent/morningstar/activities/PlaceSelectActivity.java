package com.eminent.morningstar.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.eminent.morningstar.R;
import com.eminent.morningstar.listeners.DatePickerListener;
import com.eminent.morningstar.utils.DatePickerFragment;
import com.eminent.morningstar.utils.Utils;

import java.util.Calendar;


public class PlaceSelectActivity extends ActionBarActivity implements DatePickerListener{
    private static final String LOG_TAG = PlaceSelectActivity.class.getSimpleName();

    private Spinner mFromSpinner = null;
    private Spinner mToSpinner = null;
    private RelativeLayout mDateSectionLayout = null;
    private TextView mDateView = null;
    private TextView mMonthView = null;
    private TextView mDayView = null;
    private Button mSearchButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_select);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.places_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mFromSpinner = (Spinner)findViewById(R.id.id_from_spinner);
        mFromSpinner.setAdapter(adapter);

        mToSpinner = (Spinner)findViewById(R.id.id_to_spinner);
        mToSpinner.setAdapter(adapter);

        mDateSectionLayout = (RelativeLayout)findViewById(R.id.id_date_section);
        mDateSectionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment fragment = new DatePickerFragment(PlaceSelectActivity.this);
                fragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        mDateView = (TextView)findViewById(R.id.id_date_text);
        mMonthView = (TextView)findViewById(R.id.id_month_text);
        mDayView = (TextView)findViewById(R.id.id_day_text);
        initializeDateSection(Calendar.getInstance());

        mSearchButton = (Button)findViewById(R.id.id_search_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlaceSelectActivity.this,BusListActivity.class);
                PlaceSelectActivity.this.startActivity(i);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.place_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateChanged(Calendar calendar) {
        initializeDateSection(calendar);
    }

    private void showAlertDialog(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(PlaceSelectActivity.this);
        //LayoutInflater inflater = PlaceSelectActivity.this.getLayoutInflater();
        //View view = inflater.inflate(R.layout.sigle_button_alert_dialog,null);
        //builder.setView(view);
        builder.setTitle("Title");
        builder.setMessage("Please select the destination place..");
        builder.setNeutralButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private void initializeDateSection(Calendar calendar){
        String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String month = Utils.getMonthString(calendar.get(Calendar.MONTH))+" "+ String.valueOf(calendar.get(Calendar.YEAR));
        String day = Utils.getDayString(calendar.get(Calendar.DAY_OF_WEEK));
        Log.d(LOG_TAG, "initializeDateSection: date: " + date + " month: " + month + " day: " + day);
        if(null != mDateView){
            mDateView.setText(date);
        }
        if(null != mMonthView){
            mMonthView.setText(month);
        }
        if(null != mDayView){
            mDayView.setText(day);
        }
    }


}
