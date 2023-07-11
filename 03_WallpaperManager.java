package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    boolean running;
    int[] Array= new int[]{R.drawable.wp1,R.drawable.wp2,R.drawable.wp3,R.drawable.wp4,R.drawable.wp5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(!running)
        {
            new Timer().schedule(new MyTimer(),0,300);
            running=true;
        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run()
        {
            try
            {
                WallpaperManager wallpapermanager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpapermanager.setBitmap(BitmapFactory.decodeResource(getResources(),Array[random.nextInt(5)]));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

/*
Manifest File : <uses-permission android:name="android.permission.SET_WALLPAPER" />
 */
