package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Empresa extends Activity {
    @Override
    protected void onCreate(Bundle onCreateInstance){
        super.onCreate(onCreateInstance);
        setContentView(R.layout.empresa_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Empresa.this, MainPage.class));
            }
        }, 3500);
    }
}
