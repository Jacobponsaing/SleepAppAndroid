package com.example.jacob.sleepapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class SleepActivity extends AppCompatActivity {

    private MainActivity mainActivity;

    private Button mStartButton;
    private Button mPauseButton;
    private Button mResetButton;
    private Button mVagenButton;
    private Chronometer mChronometer;

    private long lastPasue;

    public void SetMain (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        mStartButton = (Button) findViewById(R.id.start_button);
        mPauseButton = (Button) findViewById(R.id.pause_button);
        mResetButton = (Button) findViewById(R.id.reset_button);
        mVagenButton = (Button) findViewById(R.id.vagen_button);
        mChronometer = (Chronometer) findViewById(R.id.chronometer);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPasue != 0){
                    mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPasue);
                }
                else {
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }
                mChronometer.start();
                mStartButton.setEnabled(false);
                mPauseButton.setEnabled(true);
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastPasue = SystemClock.elapsedRealtime();
                mChronometer.stop();
                mPauseButton.setEnabled(false);
                mStartButton.setEnabled(true);
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();
                mChronometer.setBase(SystemClock.elapsedRealtime());
                lastPasue = 0;
                mPauseButton.setEnabled(false);
                mStartButton.setEnabled(true);
            }
        });

        mVagenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();
                mPauseButton.setEnabled(false);

            }
        });
    }
}
