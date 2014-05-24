package com.eminent.morningstar.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import com.eminent.morningstar.listeners.DatePickerListener;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private static final String LOG_TAG = DatePickerFragment.class.getSimpleName();
    private DatePickerListener mListener;

    public DatePickerFragment(DatePickerListener listener){
        mListener = listener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateDialog IN");
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.d(LOG_TAG,"onDateSet Year: "+year+" Month: "+month+" Day: "+day);
        if(null != mListener) {
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Log.d(LOG_TAG,"Calling DatePickerListener onDateChanged");
            mListener.onDateChanged(calendar);
        }
    }
}
