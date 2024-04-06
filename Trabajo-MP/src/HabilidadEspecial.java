
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class HabilidadEspecial implements Serializable, Cloneable{

    private String Nombre;

    private double ValorATC;

    private double ValorDFS;

    private double Coste;

    public HabilidadEspecial(){
        buildHabilidadEspecialFromInput();
    }

    @Override
    public HabilidadEspecial clone() {
        try {
            return (HabilidadEspecial) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public double DarAtq( double Valor) {
        if(Valor>=this.Coste){
            return this.ValorATC;
        }
        return 0;
    }

    public double getCoste() { return this.Coste;}

    public double DarDef(double Valor) {
        if(Valor>=this.Coste){
            return this.ValorDFS;
        }
        return 0;
    }

    public void buildHabilidadEspecialFromInput() {
        this.Nombre = inputNombre();
        this.ValorATC = inputValorATC();
        this.ValorDFS = inputValorDFS();
        this.Coste = inputCoste();
    }

    protected void EditarHabilidadEspecial(){
        int ans;
        do {
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar valor ataque");
            System.out.println("3. Modificar valor defensa");
            System.out.println("4. Modificar coste");
            System.out.println("5. Salir");
            ans = leerInt();
            if(ans == 1){
                System.out.println("Nombre actual: " + this.Nombre);
                this.Nombre = inputNombre();
            } else if (ans == 2) {
                System.out.println("Ataque actual: " + this.ValorATC);
                this.ValorATC=inputValorATC();
            } else if (ans == 3) {
                System.out.println("Defensa actual: " + this.ValorDFS);
                this.ValorDFS=inputValorDFS();
            } else if (ans == 4) {
                System.out.println("Coste actual: " + this.Coste);
                this.Coste = inputCoste();
            }

        } while (ans!=5);

    }

    private int leerInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getNombre() {
        return Nombre;
    }

    private String inputNombre() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        do {
            System.out.println("Ingrese nombre de la habilidad especial:");
            nombre = scanner.nextLine().trim();
        } while (nombre.isEmpty());
        return nombre;
    }

    private double inputValorATC() {
        Scanner scanner = new Scanner(System.in);
        double valorATC;
        do {
            System.out.println("Ingrese el valor de la habilidad especial para el ataque (entre 1 y 3):");
            valorATC = scanner.nextDouble();
            if (valorATC < 1 || valorATC > 3) {
                System.out.println("El valor debe estar entre 1 y 3, inclusive.");
            }
        } while (valorATC < 1 || valorATC > 3);
        return valorATC;
    }

    private double inputValorDFS() {
        Scanner scanner = new Scanner(System.in);
        double valorDFS;
        do {
            System.out.println("Ingrese el valor de la habilidad especial para la defensa (entre 1 y 3):");
            valorDFS = scanner.nextDouble();
            if (valorDFS < 1 || valorDFS > 3) {
                System.out.println("El valor debe estar entre 1 y 3, inclusive.");
            }
        } while (valorDFS < 1 || valorDFS > 3);
        return valorDFS;
    }

    private double inputCoste() {
        Scanner scanner = new Scanner(System.in);
        double coste;
        do {
            System.out.println("Ingrese el costo de la habilidad especial:");
            coste = scanner.nextDouble();
        } while (coste < 0);
        return coste;
    }

}
