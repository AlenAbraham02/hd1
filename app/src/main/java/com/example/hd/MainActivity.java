package com.example.hd;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button start,resume;
int a;
MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.pause);
        resume=findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
                mediaPlayer.start();
                start.setText("pause");
                if(start.getText().toString().equals("pause"))
                {
                    mediaPlayer.pause();
                    a=mediaPlayer.getCurrentPosition();
                }


            }
        });
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(a);
                mediaPlayer.start();
                resume.setText("stop");
                if(resume.getText().toString().equals("stop"))
                {
                    mediaPlayer.stop();
                }

            }
        });
    }
}
