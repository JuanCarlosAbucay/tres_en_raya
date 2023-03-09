package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends Activity {
    ImageView back, stats, ranking, search;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.profile_layout);

        back = (ImageView) findViewById(R.id.backButton);
        stats = (ImageView) findViewById(R.id.stats);
        ranking = (ImageView) findViewById(R.id.ranking);
        search = (ImageView) findViewById(R.id.search); 
        back.setOnClickListener(view -> {
            startActivity(new Intent(Profile.this, Login.class));
        });
        stats.setOnClickListener(view -> {
            startActivity(new Intent(Profile.this, Stats.class));
        });
        ranking.setOnClickListener(view -> {
            startActivity(new Intent(Profile.this, Ranking.class));
        });
        search.setOnClickListener(view -> {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
        });
    }
}
