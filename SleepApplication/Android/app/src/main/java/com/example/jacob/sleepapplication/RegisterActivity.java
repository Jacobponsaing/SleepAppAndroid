package com.example.jacob.sleepapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText editAge = (EditText) findViewById(R.id.editAge);
        final EditText editName = (EditText) findViewById(R.id.editName);
        final EditText editUsername = (EditText) findViewById(R.id.editUserName);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);
        final TextView txtHeight = (TextView) findViewById(R.id.txtHeight);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"You are now registeret",Toast.LENGTH_SHORT).show();
                String type = "register";
                DatabaseController dbController = new DatabaseController(RegisterActivity.this);
                dbController.execute(type,editPassword.getText().toString());
                //Insert successful: Student_id = '$student_id'
                SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username",editUsername.getText().toString());
                editor.putString("password",editPassword.getText().toString());
                editor.apply();
                //String username = editUsername.getText().toString();
                //String password = editPassword.getText().toString();

                //SharedPreferences.Editor editor = preferences.edit();
                //editor.putString(username,password);
                //editor.commit();

                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                String seekbarValue = String.valueOf(i);
                txtHeight.setText("Height: " + seekbarValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
