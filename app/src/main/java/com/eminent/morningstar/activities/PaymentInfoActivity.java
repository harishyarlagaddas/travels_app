package com.eminent.morningstar.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.eminent.morningstar.R;
import com.eminent.morningstar.utils.Utils;

public class PaymentInfoActivity extends Activity {
    private static final String LOG_TAG = PaymentInfoActivity.class.getSimpleName();

    private Spinner mPaymentTypeSpinner;
    private EditText mNameView;
    private EditText mCardNumberView;
    private Spinner mExpDateSpinner;
    private EditText mExpiryYearView;
    private EditText mCVVView;

    private Button mContinueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");

        setContentView(R.layout.payment_info);

        mNameView = (EditText)findViewById(R.id.id_name);
        mCardNumberView = (EditText)findViewById(R.id.id_card_number);
        mExpiryYearView = (EditText)findViewById(R.id.id_expiry_year);
        mCVVView = (EditText)findViewById(R.id.id_cvv);

        ArrayAdapter<CharSequence> paymentAdapter = ArrayAdapter.createFromResource(this,
                R.array.payment_type_array, android.R.layout.simple_spinner_item);
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPaymentTypeSpinner = (Spinner)findViewById(R.id.id_payment_type_spinner);
        mPaymentTypeSpinner.setAdapter(paymentAdapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exp_date_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mExpDateSpinner = (Spinner)findViewById(R.id.id_expiry_month);
        mExpDateSpinner.setAdapter(adapter);

        mContinueButton = (Button)findViewById(R.id.id_continue_button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"Continue Button onClick");
                String errorStr = checkForErrors();
                if(null == errorStr){
                    Intent intent = new Intent(PaymentInfoActivity.this,ConfirmationActivity.class);
                    PaymentInfoActivity.this.startActivity(intent);
                }else{
                    String title = PaymentInfoActivity.this.getString(R.string.alert_payment_info_title);
                    Utils.showInformationalAlertDialog(PaymentInfoActivity.this,title,errorStr);
                }
            }
        });
    }

    private String checkForErrors(){
        Context ctx = PaymentInfoActivity.this;
        if(!isNameValid()){
            return ctx.getString(R.string.alert_payment_info_name);
        }else if(!isCardNumberValid()){
            return ctx.getString(R.string.alert_payment_info_card_number);
        }else if(!isYearVald()){
            return ctx.getString(R.string.alert_payment_info_year);
        }else if(!isCVVValid()){
            return ctx.getString(R.string.alert_payment_info_cvv);
        }

        return null;
    }

    private boolean isNameValid(){
        String name = mNameView.getText().toString();
        if(null == name || name.length() <= 0){
            return false;
        }
        return true;
    }

    private boolean isCardNumberValid(){
        String card = mCardNumberView.getText().toString();
        if(null == card || card.length() <= 0){
            return false;
        }
        return true;
    }

    private boolean isYearVald(){
        String year = mExpiryYearView.getText().toString();
        if(null == year || year.length() <= 0){
            return false;
        }
        return true;
    }

    private boolean isCVVValid(){
        String cvv = mCVVView.getText().toString();
        if(null == cvv || cvv.length() <= 0){
            return false;
        }
        return true;
    }
}
