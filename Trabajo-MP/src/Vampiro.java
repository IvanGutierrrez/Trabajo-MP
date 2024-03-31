
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Vampiro extends Personaje implements Serializable, Cloneable {

    public Vampiro() {
        buildPersonajeFromInput();
    }

    private int Edad;

    private double Sangre;

    private void buildPersonajeFromInput() {
        this.Armas = new ArrayList<>();
        this.ArmasActivas = new ArrayList<>();
        this.Armaduras = new ArrayList<>();
        this.Esbirros = new ArrayList<>();
        this.Debilidades = new ArrayList<>();
        this.Fortalezas = new ArrayList<>();
        this.Version = 1;
        this.Nombre = inputNombre();
        this.Edad = inputEdad();
        this.Sangre = inputSangre();
        this.Oro = inputOro();
        this.Salud = inputSalud();
        this.Poder = inputPoder();
    }

    public void SubirSangre(){
        this.Sangre=this.Sangre+4;
        if(this.Sangre>10){
            this.Sangre=10;
        }
    }

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public double calcularPotencialAtaque() {
        double suma=0;
        suma=suma+super.Poder;
        suma=suma+super.DarValorAtqEquipo();
        if(this.Sangre>=5){
            suma=suma+2;
        }
        suma=suma+super.HabilidadEspecial.DarAtq(this.Sangre);

        return suma;
    }

    @Override
    public double calcularPotencialDefensa() {
        double suma=0;
        suma=suma+super.Poder;
        suma=suma+super.DarValorDefEquipo();
        if(this.Sangre>=5){
            suma=suma+2;
        }
        double aux=super.HabilidadEspecial.DarDef(this.Sangre);
        if(aux!=0){
            this.Sangre=this.Sangre-super.HabilidadEspecial.getCoste();
            suma=suma+aux;
        }
        return suma;
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

    protected int inputEdad() {
        int edad;
        do {
            System.out.println("Ingrese la edad:");
            edad = leerInt();
            if (edad < 0) {
                System.out.println("La edad debe ser un número positivo.");
            }
        } while (edad < 0);
        return edad;
    }

    protected double inputSangre() {
        double sangre;
        do {
            System.out.println("Ingrese la cantidad de sangre:");
            sangre = leerDouble();
            if (sangre < 0) {
                System.out.println("La cantidad de sangre debe ser mayor o igual a 0.");
            }
        } while (sangre < 0);
        return sangre;
    }

    private double leerDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private int leerInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}