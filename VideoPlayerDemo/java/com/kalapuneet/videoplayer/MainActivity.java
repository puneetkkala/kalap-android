package com.kalapuneet.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView kalapVv = (VideoView) findViewById(R.id.kalapVv);
        kalapVv.setVideoPath("http://www.quirksmode.org/html5/videos/big_buck_bunny.mp4");

        kalapVv.start();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(kalapVv);
        kalapVv.setMediaController(mediaController);
        //http://www.quirksmode.org/html5/videos/big_buck_bunny.mp4
    }
}
