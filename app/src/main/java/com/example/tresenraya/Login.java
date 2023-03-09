package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tresenraya.roomdatabse.Dao;
import com.example.tresenraya.roomdatabse.Database;
import com.example.tresenraya.roomdatabse.Jugador;
import com.example.tresenraya.roomdatabse.SesionJugador;

public class Login extends Activity {
    ImageView back, register, login;
    EditText nick, password;
    Jugador jugador = new Jugador();

    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.login_layout);

        back = (ImageView) findViewById(R.id.backButton);
        register = (ImageView) findViewById(R.id.register);
        login = (ImageView) findViewById(R.id.login);
        nick = (EditText) findViewById(R.id.loginNickname);
        password = (EditText) findViewById(R.id.loginPassword);

        Database db = Database.getDatabase(this.getApplicationContext());
        Dao dao = db.getDao();

        back.setOnClickListener(view -> {
            startActivity(new Intent(Login.this, Online.class));
        });

        register.setOnClickListener(view -> {
            startActivity(new Intent(Login.this, Register.class));
        });

        login.setOnClickListener(view -> {
            String nickname = nick.getText().toString();
            String contraseña = password.getText().toString();

            jugador = dao.buscarJugador(nickname, contraseña);

            if (jugador == null){
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
            }
            else {
                SesionJugador.getInstancia().iniciarSesion(jugador);
                Toast.makeText(this, "Iniciado con éxito", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, Profile.class));
            }
        });
    }
}
