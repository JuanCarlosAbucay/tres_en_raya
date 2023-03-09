package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.example.tresenraya.adaptador.AdaptadorRanking;
import com.example.tresenraya.roomdatabse.Dao;
import com.example.tresenraya.roomdatabse.Database;
import com.example.tresenraya.roomdatabse.Jugador;

import java.util.List;

public class Ranking extends Activity {
    ImageView back;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.ranking_layout);

        Database db = Database.getDatabase(this.getApplicationContext());
        Dao dao = db.getDao();

        back = (ImageView) findViewById(R.id.backButton);

        RecyclerView recyclerView = findViewById(R.id.recycleRanking);
        List<Jugador> jugadorList = dao.listaPuntuacion();
        System.out.println(jugadorList);
        AdaptadorRanking adaptadorRanking = new AdaptadorRanking(jugadorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorRanking);

        back.setOnClickListener(view -> {
            startActivity(new Intent(Ranking.this, Profile.class));
        });
    }
}
