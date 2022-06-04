package com.midterm.reviewfilmproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailsImg;
    TextView name,type,desc,year;
    Button play;
    Toolbar toolbar;
    FilmsModel filmsModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Object object = getIntent().getSerializableExtra("detail");
        Log.d("OK", String.valueOf(object));
        if( object instanceof FilmsModel){
            filmsModel = (FilmsModel) object;
        }

        detailsImg = findViewById(R.id.details_img);
        name = findViewById(R.id.details_name);
        type = findViewById(R.id.details_type);
        desc = findViewById(R.id.details_desc);
        year = findViewById(R.id.details_year);

        if(filmsModel != null){
            Glide.with(getApplicationContext()).load(filmsModel.getImg_url()).into(detailsImg);
            name.setText(filmsModel.getName());
            type.setText(filmsModel.getType());
            desc.setText(filmsModel.getDesc());
            year.setText(filmsModel.getYear());
        }

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,PlayActivity.class);
                intent.putExtra("video",filmsModel);
                startActivity(intent);
            }
        });

    }
}