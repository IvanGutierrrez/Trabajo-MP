
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Vampiro extends Personaje implements Serializable, Cloneable {

    public Vampiro() {
    }

    private int Edad;

    private double Sangre;

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public double calcularPotencialAtaque() {
        // TODO implement here
        return 0.0d;
    }

    @Override
    public double calcularPotencialDefensa() {
        // TODO implement here
        return 0.0d;
    }

    @Override
    public void gestionEquipamiento() {
        // TODO implement here
    }

    @Override
    public void gestionarApuesta(int oro) {
        // TODO implement here
    }

    @Override
    public void editarAtributos() {
        // TODO implement here
    }


    @Override
    public Vampiro clone() {
        return (Vampiro) super.clone();
    }
}