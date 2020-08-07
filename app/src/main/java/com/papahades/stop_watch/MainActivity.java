package com.papahades.stop_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button mStart ;
Button mStop;
Button mReset;
TextView mtextview;
int sec=0 ;                                            // to keep seconds value

boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mStart=findViewById(R.id.button);
        mStop=findViewById(R.id.button2);
        mReset=findViewById(R.id.button3);
        mtextview=findViewById(R.id.textView);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=true;

                final Handler handler = new Handler();                                       // code we want to run
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int hour=sec/3600;                                                 // calculating the hours
                        int min =(sec%3600)/60;
                        int second = sec%60;
                        String time =String.format("%d:%02d:%02d",hour,min,second);        //setting the format for the string to be dispalyed in the text view
                        mtextview.setText(time);
                        if(running){
                            sec++;
                        }
                        handler.postDelayed(this,1000);                            // crating delay after running code in handler for one time
                    }
                });

            }
        });



        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;

            }
        });



       mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
                sec=0;
            }
        });
    }
//    public void timer(){
//        final Handler handler = new Handler();                                  // code we want to run
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                int hour=sec/3600;                                              // calculating the hours
//                int min =(sec%3600)/60;
//                int second = sec%60;
//                String time =String.format("%d:%02d:%02d",hour,min,second);        //setting the format for the string to be dispalyed in the text view
//                mtextview.setText(time);
//                if(running==true){
//                    sec++;
//                }
//                handler.postDelayed(this,1000);    // crating delay after running code in handler for one time
//            }
//        });
//
//    }



}