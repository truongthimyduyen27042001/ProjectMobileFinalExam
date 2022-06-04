package com.midterm.reviewfilmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity {

    FilmsModel filmsModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final Object object = getIntent().getSerializableExtra("video");
        if( object instanceof FilmsModel){
            filmsModel = (FilmsModel) object;
        }

        VideoView videoView =(VideoView)findViewById(R.id.videoView1);
        videoView.setVideoURI(Uri.parse(filmsModel.getVideo_url()));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}