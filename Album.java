import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    protected String nombre;
    protected String artista;
    ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.canciones = new ArrayList<>();
        this.nombre = nombre;
        this.artista = artista;
    }

    private Cancion findSong(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {
        if (findSong(titulo) == null) {
            Cancion cancion = new Cancion(titulo, duracion);
            canciones.add(cancion);
            return true;
        }else{
            return false;
        }
    }

    public boolean addToPlayList (int Numpista, LinkedList <Cancion>ListaReproduccion) {
        if (findSong(canciones.get(Numpista).getTitulo())!= null){
            ListaReproduccion.add(canciones.get(Numpista));
            return true;

        }else {
            return false;
        }

    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList) {
        if (findSong(titulo) != null) {
            playList.add(canciones.get(canciones.indexOf(findSong(titulo))));
            return  true;

        }else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                '}';
    }
}