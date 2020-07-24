package com.example.registartionformusingdataparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {
    TextView tv;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        tv=findViewById(R.id.detail);
        str = getIntent().getStringExtra("message_key");

        tv.setText(str);

    }
}