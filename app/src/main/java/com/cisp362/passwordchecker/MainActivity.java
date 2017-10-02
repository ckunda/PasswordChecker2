package com.cisp362.passwordchecker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Button;
import android.view.View.OnClickListener;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity
implements OnEditorActionListener, OnClickListener {

    public static final String EXTRA_MESSAGE = "com.cisp362.passwordchecker;";
    private EditText txtUserID, txtPassword;
    private TextView msgSuccess, txtAttempts;
    private Button btnSubmit;
    private int tries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // Increment number if attempts counter and display it
        tries++;
        txtAttempts.setText(getText(R.string.strAttempts) + " " + tries);

        // Validate if the user id and password are correct
        if (txtUserID.getText().toString().toUpperCase().equals("NBKAECY"))
            if (txtPassword.getText().toString().equals("tramp")) {
                msgSuccess.setText(R.string.strSuccess);
                msgSuccess.setTextColor(Color.MAGENTA);
                status = true;
                tries = 0;
            }
            // Invalid credentials, display error
        else {
                msgSuccess.setText(R.string.strFailure);
                msgSuccess.setTextColor(Color.RED);
                status = false;
            }
        return status;
    }

    // Validate credentials and go to next screen if correct
    public void validate() {

        // Go to next screen if valid user id and password
        if (checkPassword()) {

            String message = txtUserID.getText().toString();

            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    // User pressed an action key on the password field, validate credentials
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        validate();
        return false;
    }

    // User clicked on the Login button, validate credentials
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnSubmit) {
            validate();
        }
    }
}
