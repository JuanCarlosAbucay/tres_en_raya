package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tresenraya.roomdatabse.Dao;
import com.example.tresenraya.roomdatabse.Database;
import com.example.tresenraya.roomdatabse.Jugador;

public class Register extends Activity {
    ImageView back, register;
    EditText nickname, password, repeat;
    Database db;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.register_layout);

        db = Database.getDatabase(this.getApplicationContext());
        Dao dao = db.getDao();
        Jugador jugador = new Jugador();

        back = (ImageView) findViewById(R.id.backButton);
        register = (ImageView) findViewById(R.id.registerRegister);
        nickname = (EditText) findViewById(R.id.registerNickname);
        password = (EditText) findViewById(R.id.registerPassword);
        repeat = (EditText) findViewById(R.id.registerRepeat);
        back.setOnClickListener(view -> {
            startActivity(new Intent(Register.this, Login.class));
        });

        register.setOnClickListener(view -> {
            jugador.nombre = nickname.getText().toString();
            if (nickname.getText().toString().equals("") && password.getText().toString().equals("") && repeat.getText().toString().equals("")){
                Toast.makeText(this, "Rellena los datos", Toast.LENGTH_SHORT).show();
            }
            else if (password.getText().toString().equals(repeat.getText().toString())){
                jugador.contraseña = password.getText().toString();
                dao.instertar(jugador);
                Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
                db = Database.getDatabase(getApplicationContext());
            }
            else Toast.makeText(this, "Repita la contraseña", Toast.LENGTH_SHORT).show();
        });
    }
}
