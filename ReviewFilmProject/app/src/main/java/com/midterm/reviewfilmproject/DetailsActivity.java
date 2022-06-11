package com.midterm.reviewfilmproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailsImg;
    TextView name,type,desc,year;
    Button play;
    ImageButton addToFavorite;
    Toolbar toolbar;
    FilmsModel filmsModel = null;

    FirebaseFirestore firestore;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

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
        addToFavorite = findViewById(R.id.favorite);
        addToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFav();
                addToFavorite.setBackgroundResource(R.drawable.ic_baseline_red_favorite_24);
            }
        });
    }

    private void addToFav() {
        final HashMap<String,Object> fvr = new HashMap<>();

        fvr.put("name",filmsModel.getName());
        fvr.put("year",filmsModel.getYear());
        fvr.put("desc",filmsModel.getDesc());
        fvr.put("img_url",filmsModel.getImg_url());
        fvr.put("video",filmsModel.getVideo());
        fvr.put("isTrending",filmsModel.getIstrending());
        
        firestore.collection("AddToFavorite").document(auth.getCurrentUser().getUid())
                .collection("CurrentUser").add(fvr).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(DetailsActivity.this, "Add to Favorite", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}