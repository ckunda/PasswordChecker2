package com.cisp362.passwordchecker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity
implements OnEditorActionListener, OnClickListener {

    private EditText txtUserID, txtPassword;
    private TextView msgSuccess, txtAttempts;
    private Button btnSubmit;
    private int tries;
    private static final String TAG = "PasswordChecker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        txtUserID = findViewById(R.id.txtUserID);
        txtUserID.setText("");
        txtPassword = findViewById(R.id.txtPassword);
        msgSuccess = findViewById(R.id.msgSuccess);
        msgSuccess.setText("");
        txtAttempts = findViewById(R.id.txtAttempts);
        txtAttempts.setText("");
        btnSubmit = findViewById(R.id.btnSubmit);

        txtPassword.setOnEditorActionListener(this);
        btnSubmit.setOnClickListener(this);

        tries = 0;

    }

    public boolean checkPassword() {

        boolean status = false;

        tries++;
        txtAttempts.setText(getText(R.string.strAttempts) + " " + tries);

        if (txtUserID.getText().toString().toUpperCase().equals("NBKAECY"))
            if (txtPassword.getText().toString().equals("tramp")) {
                msgSuccess.setText(R.string.strSuccess);
                msgSuccess.setTextColor(Color.MAGENTA);
                status = true;
                tries = 0;
            }
        else {
                msgSuccess.setText(R.string.strFailure);
                msgSuccess.setTextColor(Color.RED);
                status = false;
            }
        return status;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        checkPassword();
        return false;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnSubmit) {
            checkPassword();
        }
    }
}
