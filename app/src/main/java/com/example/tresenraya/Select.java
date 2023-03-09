package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Select extends Activity {
    ImageView back;
    ImageView bot;
    ImageView multi;
    @Override
    protected void onCreate(Bundle onSavedInstance){
         super.onCreate(onSavedInstance);
         setContentView(R.layout.select_layout);
         back = (ImageView) findViewById(R.id.backButton);
         bot = (ImageView) findViewById(R.id.bot);
         multi = (ImageView) findViewById(R.id.multi);

         back.setOnClickListener(view -> {
             startActivity(new Intent(Select.this, MainPage.class));
         });

         multi.setOnClickListener(view -> {
             startActivity(new Intent(Select.this, Online.class));
         });

         bot.setOnClickListener(view -> {
             startActivity(new Intent(Select.this, GameBot.class));
         });
    }
}
