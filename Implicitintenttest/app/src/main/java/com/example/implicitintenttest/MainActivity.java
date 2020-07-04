package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openURL(View view) {
        Uri u = Uri.parse("http://ww.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void call(View view) {
        Uri uri= Uri.parse("tel:1234567890");
        Intent i =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void myLocation(View view) {
        Uri map= Uri.parse("geo:16.463054,80.506849?z=21");
        Intent i = new Intent(Intent.ACTION_VIEW,map);
        startActivity(i);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}