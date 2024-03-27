
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public class Partida implements Serializable {

    public Partida(){
        Map<String,Jugador> m = new HashMap<>();
        this.setMapJugadores(m);
        Queue<Combate> queue = new LinkedList<>();
        this.setCombateQueue(queue);
        this.setUsuarioActivo(null);
        List<Personaje> lista = new ArrayList<>();
        this.setListaPersonajes(lista);
    }
    private transient Usuario UsuarioActivo;
    private Map<String,Jugador> MapJugadores;
    private Queue<Combate> combateQueue;
    private List<Personaje> ListaPersonajes;

    public Usuario getUsuarioActivo() {
        return UsuarioActivo;
    }

    public Map<String,Jugador> getMapJugadores() {
        return MapJugadores;
    }

    public void setMapJugadores(Map<String,Jugador> MapUsuarios) {
        this.MapJugadores = MapUsuarios;
    }

    public Queue<Combate> getCombateQueue() {
        return combateQueue;
    }

    public void setCombateQueue(Queue<Combate> combateQueue) {
        this.combateQueue = combateQueue;
    }

    public List<Personaje> getListaPersonajes() {
        return ListaPersonajes;
    }

    public void setListaPersonajes(List<Personaje> listaPersonajes) {
        ListaPersonajes = listaPersonajes;
    }

    public boolean noExiste(String s){
        Map<String,Jugador> mapa = this.getMapJugadores();
        boolean ok = true;
        for (Map.Entry<String, Jugador> entry : mapa.entrySet()) {
            String clave = entry.getKey();
            Jugador u = entry.getValue();
            if (u.getNRegistro().equals(s)) {
                ok = false;
            }
        }
        return ok;
    }

    public Usuario coincidePass(String nick, String pass){
        Map<String,Jugador> mapa = this.getMapJugadores();
        for (Map.Entry<String, Jugador> entry : mapa.entrySet()) {
            Jugador u = entry.getValue();
            if (u.getNick().equals(nick) && u.getPass().equals(pass)){
                return u;
            }
        }
        return null;
    }

    public boolean nickUnico(String s) {
        Map<String, Jugador> mapa = this.getMapJugadores();
        if (mapa == null) {
            return true;
        } else {
            for (Map.Entry<String, Jugador> entry : mapa.entrySet()) {
                Jugador u = entry.getValue();
                if (u.getNick().equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void serializar() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Trabajo-MP/datos/partida/partida");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            // Escribe la instancia actual de la clase Game en el archivo
            objectOutputStream.writeObject(this);

            System.out.println("Partida guardada correctamente");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al intentar serializar la partida");
        }
    }

    /**
     * 
     */
    public Partida deserializar() {
        try (FileInputStream fileInputStream = new FileInputStream("Trabajo-MP/datos/partida/partida");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Leer la instancia de la clase Game desde el archivo
            Partida loadedGame = (Partida) objectInputStream.readObject();

            System.out.println("Partida cargada correctamente");
            return loadedGame;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se an encontrado este fichero ERROR");
            System.exit(0);
        }
        return  null;
    }

    public void Play() {
        this.getUsuarioActivo().Menu(this);
        this.serializar();
    }

    public void setUsuarioActivo(Usuario u) {
        this.UsuarioActivo = u;
    }
    public void addChallenge(Combate c) {
        this.combateQueue.add(c);
    }

    public void darDeBajaUsuario(Usuario user) {
        Map<String,Jugador> mapa = this.getMapJugadores();
        for (Map.Entry<String, Jugador> entry : mapa.entrySet()) {
            Jugador u = entry.getValue();
            if (u == user) {
                this.getMapJugadores().remove(entry.getKey());
                break;
            }
        }

    }

    public void getPersonaje() {
        // TODO implement here
    }

    public Personaje seleccionPersonaje() {
        // TODO implement here
        return null;
    }

    public Boolean checkVersion(Personaje p) {
        // TODO implement here
        return null;
    }

    public Personaje solveVersion(Personaje personaje) {
        // TODO implement here
        return null;
    }

    private int leerInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String leerString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
