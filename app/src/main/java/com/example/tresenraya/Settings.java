package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Settings extends Activity {
    ImageView back;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.settings_layout);

        back = (ImageView) findViewById(R.id.backButton);
        back.setOnClickListener(view -> {
            startActivity(new Intent(Settings.this, MainPage.class));
        });
    }
}

