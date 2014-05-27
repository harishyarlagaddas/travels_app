package com.eminent.morningstar.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eminent.morningstar.R;

public class AlertDialogBuilder extends AlertDialog.Builder {
    private static final String LOG_TAG = AlertDialogBuilder.class.getSimpleName();

    private TextView mTitleView;
    private TextView mMessageView;
    private Button mOkButton;

    public AlertDialogBuilder(Context context) {
        super(context);
    }

    public void setView(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sigle_button_alert_dialog, null);
        mTitleView = (TextView)view.findViewById(R.id.id_title);
        mMessageView = (TextView)view.findViewById(R.id.id_msg);
        mOkButton = (Button)view.findViewById(R.id.id_ok_option_button);
        setView(view);
    }

    @Override
    public AlertDialog.Builder setTitle(CharSequence title) {
        mTitleView.setText(title);
        return this;
    }

    @Override
    public AlertDialog.Builder setMessage(CharSequence message) {
        mMessageView.setText(message);
        return this;
    }

    public void setOkButtonClickListener(View.OnClickListener listener)
    {
        mOkButton.setOnClickListener(listener);
    }

}
