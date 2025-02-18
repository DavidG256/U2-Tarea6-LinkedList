import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album1 = new Album("Album1", "Artista1");
        album1.addSong("Cancion1", 1.2);
        album1.addSong("Cancion2", 2.0);
        albums.add(album1);

        Album album2 = new Album("Album2", "Artista2");
        album2.addSong("Cancion3", 3.5);
        album2.addSong("Cancion4", 7.8);
        albums.add(album2);

        LinkedList<Cancion> playlist = new LinkedList<>();
        album1.addToPlayList("Cancion1", playlist);
        album1.addToPlayList("Cancion2", playlist);
        album2.addToPlayList("Cancion3", playlist);
        album2.addToPlayList("Cancion4", playlist);


        play(playlist);
    }

    public static void play(LinkedList<Cancion> Canciones) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        ListIterator<Cancion> it = Canciones.listIterator();

        if (Canciones.isEmpty()) {
            System.out.println("No hay canciones");
            return;
        } else {
            System.out.println("Reproduciendo " + it.next());
            mostrarMenu();
        }

        boolean haciaAdelante = true;
        while (continuar) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Se acabaron las canciones");
                    continuar = false;
                    break;

                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext())
                            it.next();
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Reproduciendo " + it.next());
                    } else {
                        System.out.println("Fin Lista Reproduccion");
                        haciaAdelante = false;
                    }
                    break;

                case 2:
                    if (haciaAdelante) {
                        if (it.hasPrevious())
                            it.previous();
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Reproduciendo " + it.previous());
                    } else {
                        System.out.println("Primera cancion");
                        haciaAdelante = true;
                    }
                    break;

                case 3:
                    if (haciaAdelante) {
                        if (it.hasPrevious()) {
                            System.out.println("estas escuchando " + it.previous());
                            it.next();

                        } else {
                            System.out.println("estas escuchando" + it.next());
                        }
                    } else {
                        if (it.hasNext()) {
                            System.out.println("estas escuchando" + it.next());
                            it.previous();


                        } else {
                            System.out.println("estas escuchando" + it.previous());
                            it.next();
                        }

                    }
                    break;

                case 4:
                    if (Canciones.isEmpty()) {
                        System.out.println("La playlist está vacía");
                    } else {
                        System.out.println("Lista de canciones en la playlist:");
                        int index = 1;
                        for (Cancion cancion : Canciones) {
                            System.out.println(index + ". " + cancion.getTitulo() + "");
                            index++;
                        }
                        System.out.println();
                    }

                    break;

                case 5:
                    mostrarMenu();
                    break;

                case 6:
                    it.remove();
                    System.out.println("La cancion actual ha sido eliminada");
                    break;

                case 7:
                    imprimirAlbum();
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("0. Salir de la lista de reproducción");
        System.out.println("1. Reproducir siguiente canción en la lista");
        System.out.println("2. Reproducir la canción previa de la lista");
        System.out.println("3. Repetir la canción actual");
        System.out.println("4. Imprimir la lista de canciones en la playlist");
        System.out.println("5. Volver a imprimir el menú.");
        System.out.println("6. Eliminar la cancion actual de la playlist");
        System.out.println("7. Imprimir canciones por Album");

    }

    private static void imprimirLista(LinkedList<Cancion> playlist) {
        Iterator<Cancion> iter = playlist.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void imprimirAlbum() {
        Scanner scanner = new Scanner(System.in);
        for (Album album : albums) {
            System.out.println(albums);

        }
        System.out.println();
        System.out.println("¿Que album quieres imprimir?");
        String nombre = scanner.next();
        for (Album albumes : albums) {
            if (nombre.equalsIgnoreCase(albumes.nombre)) {
                System.out.println(albumes);
                for (Cancion cancion : albumes.canciones) {
                    System.out.println();

                }

            }
        }
    }


}