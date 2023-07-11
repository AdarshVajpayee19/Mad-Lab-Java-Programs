package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button start,stop, reset;
    TextView text;
    Handler customHandler=new Handler();
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.button);
        stop=(Button)findViewById(R.id.button2);
        reset=(Button)findViewById(R.id.button3);
        text=(TextView) findViewById(R.id.textView);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimerThread,0);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
                i=0;
                text.setText("");
            }
        });
    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            text.setText(""+i);
            customHandler.postDelayed(this,1000);
            i++;
        }
    };
}
