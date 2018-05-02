package com.example.jacob.sleepapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Consent extends AppCompatActivity {

    private MainActivity mainActivity;
    private String consent;
    public void SetMain(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consent);
        final Button btnAccept = (Button) findViewById(R.id.btnaccept);
        final Button btnReject = (Button) findViewById(R.id.btnreject);

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consent = "0";
                String type = "consent";
                DatabaseController dbController = new DatabaseController(Consent.this);
                dbController.execute(type, consent);
                Intent intent = new Intent(Consent.this, MainActivity.class);
                Consent.this.startActivity(intent);
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consent = "1";
                String type = "consent";
                DatabaseController dbController = new DatabaseController(Consent.this);
                dbController.execute(type, consent);
                Intent intent = new Intent(Consent.this, MainActivity.class);
                Consent.this.startActivity(intent);
            }
        });

    }
}