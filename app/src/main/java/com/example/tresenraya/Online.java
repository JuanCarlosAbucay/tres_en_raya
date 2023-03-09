package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;


public class Online extends Activity {
    ImageView back, online, local;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.online_layout);

        back = (ImageView) findViewById(R.id.backButton);
        online = (ImageView) findViewById(R.id.online);
        local = (ImageView) findViewById(R.id.local);
        back.setOnClickListener(view -> {
            startActivity(new Intent(Online.this, Select.class));
        });
        local.setOnClickListener(view -> {
            startActivity(new Intent(Online.this, GameLocal.class));

        });
        online.setOnClickListener(view -> {
            startActivity(new Intent(Online.this, Login.class));
        });
    }
}
