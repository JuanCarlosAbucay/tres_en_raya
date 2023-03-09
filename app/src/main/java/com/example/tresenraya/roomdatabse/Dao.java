package com.example.tresenraya.roomdatabse;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void instertar(Jugador jugador);

    @Update
    void actualizar(Jugador jugador);

    @Delete
    void eliminar(Jugador jugador);

    @Query("SELECT * FROM jugadores")
    List<Jugador> getAll();

    @Query("SELECT * FROM jugadores WHERE nombre = :nombre AND contraseña = :password")
    Jugador buscarJugador(String nombre, String password);

    @Query("SELECT wins FROM jugadores WHERE nombre = :nombre")
    int getWins(String nombre);

    @Query("SELECT loss FROM jugadores WHERE nombre = :nombre")
    int getLoss(String nombre);

    @Query("SELECT points FROM jugadores WHERE nombre = :nombre")
    int getPoints(String nombre);

    @Query("SELECT * FROM jugadores ORDER BY points desc")
    List<Jugador> listaPuntuacion();
}
