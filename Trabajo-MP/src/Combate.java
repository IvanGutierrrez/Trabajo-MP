
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Combate implements Serializable {

    private Jugador JugadorRetador;

    private Jugador JugadorRetado;

    private double OroApostado;

    private int Rondas;

    private LocalDateTime Fecha;

    private Jugador Ganador;

    private Jugador[] JugadorConEsbirrosSinDerrotar;

    private Modificador[] Modificadores;

    private boolean Valido;

    private Personaje PersonajeRetador;

    private Personaje PersonajeRetado;

    public Combate (Jugador retador, Jugador retado,int apuesta, Personaje personajeRetador, Personaje personajeRetado, LocalDateTime fecha) {
        this.JugadorRetador = retador;
        this.JugadorRetado = retado;
        this.OroApostado = apuesta;
        this.PersonajeRetador = personajeRetador;
        this.PersonajeRetado = personajeRetado;
        this.Fecha = fecha;
        this.Ganador = null;
        this.JugadorConEsbirrosSinDerrotar = null;
        this.Modificadores = null;
        this.Rondas = 0;
        this.Valido = false;
    }

    public void calcularResutado() {
        // TODO implement here
    }

    public void mostrarResultado() {
        // TODO implement here
    }

    public void cancelarCombate() {
        // TODO implement here
    }

    public void combatir() {
        // TODO implement here
    }

    public Jugador getJugadorRetador() {
        return JugadorRetador;
    }

    public void setJugadorRetador(Jugador jugadorRetador) {
        JugadorRetador = jugadorRetador;
    }

    public Jugador getJugadorRetado() {
        return JugadorRetado;
    }

    public void setJugadorRetado(Jugador jugadorRetado) {
        JugadorRetado = jugadorRetado;
    }

    public double getOroApostado() {
        return OroApostado;
    }

    public void setOroApostado(double oroApostado) {
        OroApostado = oroApostado;
    }

    public int getRondas() {
        return Rondas;
    }

    public void setRondas(int rondas) {
        Rondas = rondas;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }

    public Jugador getGanador() {
        return Ganador;
    }

    public void setGanador(Jugador ganador) {
        Ganador = ganador;
    }

    public Jugador[] getJugadorConEsbirrosSinDerrotar() {
        return JugadorConEsbirrosSinDerrotar;
    }

    public void setJugadorConEsbirrosSinDerrotar(Jugador[] jugadorConEsbirrosSinDerrotar) {
        JugadorConEsbirrosSinDerrotar = jugadorConEsbirrosSinDerrotar;
    }

    public Modificador[] getModificadores() {
        return Modificadores;
    }

    public void setModificadores(Modificador[] modificadores) {
        Modificadores = modificadores;
    }

    public boolean isValido() {
        return Valido;
    }

    public void setValido(boolean valido) {
        Valido = valido;
    }

    public Personaje getPersonajeRetador() {
        return PersonajeRetador;
    }

    public void setPersonajeRetador(Personaje personajeRetador) {
        PersonajeRetador = personajeRetador;
    }

    public Personaje getPersonajeRetado() {
        return PersonajeRetado;
    }

    public void setPersonajeRetado(Personaje personajeRetado) {
        PersonajeRetado = personajeRetado;
    }

    @Override
    public String toString() {
        return "Combate{" +
                "JugadorRetador=" + JugadorRetador +
                ", JugadorRetado=" + JugadorRetado +
                ", OroApostado=" + OroApostado +
                ", Fecha='" + Fecha + '\'' +
                '}';
    }
}