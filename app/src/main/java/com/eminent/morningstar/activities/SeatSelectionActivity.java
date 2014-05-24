package com.eminent.morningstar.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.eminent.morningstar.R;
import com.eminent.morningstar.model.BusInfo;
import com.eminent.morningstar.utils.LocalPreferences;

import java.util.ArrayList;

public class SeatSelectionActivity extends Activity{
    private static final String LOG_TAG = SeatSelectionActivity.class.getSimpleName();

    private Spinner mBoardingPointsSpinner = null;
    private ArrayList<ImageView> mSeatImages;

    private BusInfo mBusInfo = null;
    private Button mContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");
        setContentView(R.layout.seat_selection);

        mBusInfo = LocalPreferences.getCurrentBusInfo();
        if(null == mBusInfo){
            Toast.makeText(this,R.string.toast_msg_no_bus_info,Toast.LENGTH_SHORT).show();
            finish();
        }

        mBoardingPointsSpinner = (Spinner)findViewById(R.id.id_boarding_point_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mBusInfo.getBoardingPoints());
        mBoardingPointsSpinner.setAdapter(adapter);

        mSeatImages = new ArrayList<ImageView>();
        populateSeatImages();
        updateSeatStatus();

        for(ImageView imageView: mSeatImages){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tagVal = (String)v.getTag();
                    if(null != tagVal && tagVal.equals(SeatSelectionActivity.this.getString(R.string.tag_available))){
                        ((ImageView)v).setImageResource(R.drawable.seat_selected);
                        v.setTag(SeatSelectionActivity.this.getString(R.string.tag_selected));
                    }else if(null != tagVal && tagVal.equals(SeatSelectionActivity.this.getString(R.string.tag_ladies))){
                        ((ImageView)v).setImageResource(R.drawable.seat_selected);
                        v.setTag(SeatSelectionActivity.this.getString(R.string.tag_ladies_selected));
                    }else if(null != tagVal && tagVal.equals(SeatSelectionActivity.this.getString(R.string.tag_selected))){
                        ((ImageView)v).setImageResource(R.drawable.seat_empty);
                        v.setTag(SeatSelectionActivity.this.getString(R.string.tag_available));
                    }else if(null != tagVal && tagVal.equals(SeatSelectionActivity.this.getString(R.string.tag_ladies_selected))){
                        ((ImageView)v).setImageResource(R.drawable.seat_ladies);
                        v.setTag(SeatSelectionActivity.this.getString(R.string.tag_ladies));
                    }
                }
            });
        }

        mContinueButton = (Button)findViewById(R.id.id_continue_button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"Continue Button onClick");
                Intent intent = new Intent(SeatSelectionActivity.this,ContactDetailsActivity.class);
                SeatSelectionActivity.this.startActivity(intent);
            }
        });
    }

    private void populateSeatImages(){
        ImageView iv = (ImageView)findViewById(R.id.id_seat1);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat2);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat3);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat4);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat5);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat6);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat7);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat8);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat9);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat10);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat11);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat12);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat13);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat14);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat15);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat16);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat17);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat18);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat19);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat20);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat21);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat22);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat23);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat24);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat25);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat26);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat27);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat28);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat29);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat30);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat31);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat32);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat33);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat34);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat35);
        mSeatImages.add(iv);

        iv = (ImageView)findViewById(R.id.id_seat36);
        mSeatImages.add(iv);
    }

    private void updateSeatStatus(){
        ArrayList<Integer> bookedSeats = mBusInfo.getSeatInfo().getmBookedSeats();
        for(Integer i: bookedSeats){
            mSeatImages.get(i-1).setImageResource(R.drawable.seat_booked);
            mSeatImages.get(i-1).setTag(SeatSelectionActivity.this.getString(R.string.tag_booked));
        }
        ArrayList<Integer> ladiesSeats = mBusInfo.getSeatInfo().getmLadiesSeats();
        for(Integer i: ladiesSeats){
            mSeatImages.get(i-1).setImageResource(R.drawable.seat_ladies);
            mSeatImages.get(i-1).setTag(SeatSelectionActivity.this.getString(R.string.tag_ladies));
        }
    }
}
