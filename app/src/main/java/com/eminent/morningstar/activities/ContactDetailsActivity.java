package com.eminent.morningstar.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.eminent.morningstar.R;
import com.eminent.morningstar.utils.LocalPreferences;
import com.eminent.morningstar.utils.Utils;

import java.util.regex.Pattern;

public class ContactDetailsActivity extends Activity {
    private static final String LOG_TAG = ContactDetailsActivity.class.getSimpleName();

    private EditText mName;
    private EditText mAge;
    private EditText mEmail;
    private EditText mMobile;
    private EditText mIDProof;
    private RadioButton mMale;
    private RadioButton mFemale;
    private Button mContinueButton;
    private Spinner mIdPrrofSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate IN");
        setContentView(R.layout.contact_details);

        mName = (EditText)findViewById(R.id.id_name);
        mAge = (EditText)findViewById(R.id.id_age);
        mEmail = (EditText)findViewById(R.id.id_email);
        mMobile = (EditText)findViewById(R.id.id_mobile);
        mIDProof = (EditText)findViewById(R.id.id_proof_number);
        mMale = (RadioButton)findViewById(R.id.id_male);
        mFemale = (RadioButton)findViewById(R.id.id_female);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.id_proofs_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mIdPrrofSpinner = (Spinner)findViewById(R.id.id_proof_spinner);
        mIdPrrofSpinner.setAdapter(adapter);

        mContinueButton = (Button)findViewById(R.id.id_continue_button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"Continue Button on click");
                String errorStr = checkForErrors();
                if(null == errorStr){
                    Intent intent = new Intent(ContactDetailsActivity.this,PaymentInfoActivity.class);
                    ContactDetailsActivity.this.startActivity(intent);
                }else{
                    String title = ContactDetailsActivity.this.getString(R.string.alert_contact_details_title);
                    Utils.showInformationalAlertDialog(ContactDetailsActivity.this,title,errorStr);
                }
            }
        });
    }

    private String checkForErrors(){
        Context ctx = ContactDetailsActivity.this;
        if(!isNameValid()){
            return ctx.getString(R.string.alert_contact_details_name_invalid);
        }else if(!isAgeValid()){
            return ctx.getString(R.string.alert_contact_details_age_invalid);
        }else if(!isGenderValid()){
            return ctx.getString(R.string.alert_contact_details_gender_invalid);
        }else if(!isEmailValid()){
            return ctx.getString(R.string.alert_contact_details_email_invalid);
        }else if(!isMobileValid()){
            return ctx.getString(R.string.alert_contact_details_mobile_invalid);
        }else if(!isIDProofValid()){
            return ctx.getString(R.string.alert_contact_details_id_proof_number_invald);
        }

        return null;
    }

    private boolean isNameValid(){
        String name = mName.getText().toString();
        if(null == name || name.length() <= 0){
            return false;
        }
        LocalPreferences.storeName(name);
        return true;
    }

    private boolean isAgeValid(){
        String age = mAge.getText().toString();
        if(null == age || age.length() <= 0){
            return false;
        }
        LocalPreferences.storeAge(age+" Years");
        return true;
    }

    private boolean isEmailValid(){
        String email = mEmail.getText().toString();
        if(null == email || email.length() <= 0){
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return false;
        }
        LocalPreferences.storeEmail(email);
        return true;
    }

    private boolean isMobileValid(){
        String mobile = mMobile.getText().toString();
        if(null == mobile || mobile.length() <= 0){
            return false;
        }
        LocalPreferences.storeMobile(mobile);
        return true;
    }

    private boolean isGenderValid(){
        boolean maleSelected = mMale.isChecked();
        boolean femaleSelected = mFemale.isChecked();
        if(!maleSelected && !femaleSelected){
            return false;
        }
        return true;
    }

    private boolean isIDProofValid(){
        String idProof = mIDProof.getText().toString();
        if(null == idProof || idProof.length() <= 0){
            return false;
        }
        LocalPreferences.storeIDProof(idProof);
        return true;
    }
}
