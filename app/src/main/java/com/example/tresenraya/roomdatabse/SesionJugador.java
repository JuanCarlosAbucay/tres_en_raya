package com.example.tresenraya.roomdatabse;

public class SesionJugador {
    private static SesionJugador instancia;
    private Jugador jugador;

    public static synchronized SesionJugador getInstancia() {
        if (instancia == null) {
            instancia = new SesionJugador();
        }
        return instancia;
    }

    public void iniciarSesion(Jugador jugador) {
        this.jugador = jugador;
    }

    public void cerrarSesion() {
        this.jugador = null;
    }

    public boolean estaConectado() {
        return this.jugador != null;
    }

    public Jugador getUsuario() {
        return jugador;
    }

}
