package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tresenraya.roomdatabse.Dao;
import com.example.tresenraya.roomdatabse.Database;
import com.example.tresenraya.roomdatabse.Jugador;
import com.example.tresenraya.roomdatabse.SesionJugador;

import org.w3c.dom.Text;

public class Stats extends Activity {
    ImageView back;
    TextView wins, loss, points;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.stats_layout);

        back = (ImageView) findViewById(R.id.backButton);
        wins = (TextView) findViewById(R.id.statsWin);
        loss = (TextView) findViewById(R.id.statsLoss);
        points = (TextView) findViewById(R.id.statsPoints);

        Database db = Database.getDatabase(this.getApplicationContext());
        Dao dao = db.getDao();

        back.setOnClickListener(view -> {
            startActivity(new Intent(Stats.this, Profile.class));
        });

        int winsText = dao.getWins(SesionJugador.getInstancia().getUsuario().getNombre());
        int lossText = dao.getLoss(SesionJugador.getInstancia().getUsuario().getNombre());
        int pointsText = dao.getPoints(SesionJugador.getInstancia().getUsuario().getNombre());
        wins.setText(String.valueOf(winsText));
        loss.setText(String.valueOf(lossText));
        points.setText(String.valueOf(pointsText));
    }
}
