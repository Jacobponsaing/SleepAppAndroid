package com.example.jacob.sleepapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consent extends AppCompatActivity {

    private MainActivity mainActivity;

    public void SetMain (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consent);




        Button btnreject = (Button) findViewById(R.id.btnreject);
        btnreject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consent.this, MainActivity.class);
                Consent.this.startActivity(intent);
            }
        }) ;

    }
}
