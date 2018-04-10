package com.example.jacob.sleepapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity {
    private EditText mPasswordView, mUserName;

    @Override
    public boolean deleteSharedPreferences(String name) {
        return super.deleteSharedPreferences(name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mUserName = (EditText) findViewById(R.id.txtUserName);

        mPasswordView = (EditText) findViewById(R.id.textPassword);


        Button clearData = (Button) findViewById(R.id.ClearB);
        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              deleteSharedPreferences("prefs");
                Toast.makeText(DataActivity.this,"All logins are cleared",Toast.LENGTH_LONG).show();

            }
        });
    }
}
