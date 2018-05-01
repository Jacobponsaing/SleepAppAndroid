package com.example.jacob.sleepapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Consent extends AppCompatActivity {

    private MainActivity mainActivity;

    public void SetMain (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consent);
    }
}
