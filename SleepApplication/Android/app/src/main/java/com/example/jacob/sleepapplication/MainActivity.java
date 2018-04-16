package com.example.jacob.sleepapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //set Event
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i<mainGrid.getChildCount();i++){
            //You can see, all child item is CardView, so we just cast object to CardView
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI == 0){// opens activity one
                        Intent intent = new Intent(MainActivity.this,SleepActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1){//opens activity two
                        Intent intent = new Intent(MainActivity.this,ActivityTwo.class);
                        startActivity(intent);

                    }
                    else if(finalI == 2){//opens activity two
                        Intent intent = new Intent(MainActivity.this,ActivityThree.class);
                        startActivity(intent);

                    }
                    else if(finalI == 3){//opens activity two
                        Intent intent = new Intent(MainActivity.this,ActivityFour.class);
                        startActivity(intent);

                    }

                    else if(finalI == 5) {//opens activity two
                        Intent intent = new Intent(MainActivity.this, DataActivity.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(MainActivity.this,"Please set activity for this card item",Toast.LENGTH_SHORT).show();
                    }
                }
            })  ;
        }
    }
}
