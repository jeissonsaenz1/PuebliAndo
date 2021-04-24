package com.example.puebliando;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        intro=MediaPlayer.create(this,R.raw.intval);
        intro.start();

        TimerTask inicio= new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash.this,Home.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo=new Timer();
        tiempo.schedule(inicio,9000);




    }
}
