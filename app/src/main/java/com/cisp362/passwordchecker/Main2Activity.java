package com.cisp362.passwordchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {

    private TextView msgWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layouts TextView and set the string as Text
        msgWelcome = findViewById(R.id.msgWelcome);
        message = " Welcome to Mobile Developers Page, " + message;
        msgWelcome.setText(message);
    }
}
