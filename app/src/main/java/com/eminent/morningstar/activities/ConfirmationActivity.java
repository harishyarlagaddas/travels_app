package com.eminent.morningstar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eminent.morningstar.R;
import com.eminent.morningstar.utils.LocalPreferences;

import org.w3c.dom.Text;

public class ConfirmationActivity extends Activity {
    private static final String LOG_TAG = ConfirmationActivity.class.getSimpleName();

    private TextView mNameView;
    private TextView mAgeView;
    private TextView mSeatView;
    private TextView mIDProofView;
    private TextView mEmailView;
    private TextView mMobileView;

    private Button mDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");

        setContentView(R.layout.confirmation);

        mNameView = (TextView)findViewById(R.id.id_name_val);
        mNameView.setText(LocalPreferences.getStoredName());

        mAgeView = (TextView)findViewById(R.id.id_age_val);
        mAgeView.setText(LocalPreferences.getStoredAge());

        mSeatView = (TextView)findViewById(R.id.id_seats_val);
        mSeatView.setText(LocalPreferences.getStoredSeats());

        mIDProofView = (TextView)findViewById(R.id.id_proof_val);
        mIDProofView.setText(LocalPreferences.getStoredIDProof());

        mEmailView = (TextView)findViewById(R.id.id_email_val);
        mEmailView.setText(LocalPreferences.getStoredEmail());

        mMobileView = (TextView)findViewById(R.id.id_mobile_val);
        mMobileView.setText(LocalPreferences.getStoredMobile());

        mDoneButton = (Button)findViewById(R.id.id_done_button);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmationActivity.this,PlaceSelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ConfirmationActivity.this.startActivity(intent);
            }
        });
    }
}
