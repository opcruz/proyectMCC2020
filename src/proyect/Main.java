package proyect;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Publicacion> list = new LinkedList<>();

    public static void main(String[] args) {
        boolean running = true;
        do {
            switch (menu()) {
                case 1:
                    addPublicacion();
                    break;
                case 2:
                    findPublicacion();
                    break;

                case 3:
                    deletePublicacion();
                    break;

                case 4:
                    show();
                    break;

                case 5:
                    running = false;
                    break;
            }
        } while (running);
    }

    public static int menu() {
        int option;
        System.out.println("¿Qué desea hacer? [" + list.size() + " publicaciones]");
        System.out.println("1.Dar de alta");
        System.out.println("2.Buscar");
        System.out.println("3.Eliminar");
        System.out.println("4.Mostrar");
        System.out.println("5.Salir");

        do {
            System.out.print("Opción: ");
            option = nextInt();
        } while (option < 1 || option > 5);
        return option;
    }

    public static void addPublicacion() {
        int option;
        boolean repeat;
        do {
            System.out.println();
            System.out.println("Añadir nueva publicación");
            System.out.println("1.Libro");
            System.out.println("2.Revista");
            System.out.println("3.Periódico");
            System.out.println("4.Terminar");

            do {
                repeat = false;
                System.out.print("Opción: ");
                option = nextInt();
                System.out.println();
                switch (option) {
                    case 1:
                        addLibroFromStdIn();
                        System.out.println("Libro añadido satisfactoriamente");
                        break;

                    case 2:
                        addRevistaFromStdIn();
                        System.out.println("Revista añadida satisfactoriamente");
                        break;

                    case 3:
                        addPeriodicoFromStdIn();
                        System.out.println("Periódico añadido satisfactoriamente");
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Opción inválida");
                        repeat = true;
                }
            } while (repeat);
        } while (true);
    }

    private static void addLibroFromStdIn() {
        System.out.println("Nuevo Libro");
        System.out.println("Ingrese el título:");
        String titulo = nextLine();
        System.out.println("Ingrese el precio:");
        float precio = nextFloat();
        System.out.println("Ingrese la cantidad de páginas:");
        int numPag = nextInt();
        System.out.println("Ingrese el ISBN:");
        String ISBN = nextLine();
        System.out.println("Ingrese la edición:");
        String edicion = nextLine();
        System.out.println("Ingrese el autor:");
        String autor = nextLine();

        Libro libro = new Libro(titulo, precio, numPag, ISBN, edicion, autor);
        list.add(libro);
    }

    private static void addRevistaFromStdIn() {
        System.out.println("Nueva Revista");
        System.out.println("Ingrese el título:");
        String titulo = nextLine();
        System.out.println("Ingrese el precio:");
        float precio = nextFloat();
        System.out.println("Ingrese la cantidad de páginas:");
        int numPag = nextInt();
        System.out.println("Ingrese el ISSN:");
        String ISSN = nextLine();
        System.out.println("Ingrese el número:");
        int numero = nextInt();
        System.out.println("Ingrese el año:");
        int anio = nextInt();
        System.out.println("Ingrese la periodicidad:");
        String periodicidad = nextLine();

        Revista revista = new Revista(titulo, precio, numPag, ISSN, numero, anio, periodicidad);
        list.add(revista);
    }

    private static void addPeriodicoFromStdIn() {
        System.out.println("Nuevo Periódico");
        System.out.println("Ingrese el título:");
        String titulo = nextLine();
        System.out.println("Ingrese el precio:");
        float precio = nextFloat();
        System.out.println("Ingrese la cantidad de páginas:");
        int numPag = nextInt();
        System.out.println("Ingrese las secciones:");
        String secciones = nextLine();
        System.out.println("Ingrese el editor:");
        String editor = nextLine();
        System.out.println("Ingrese la periodicidad:");
        String periodicidad = nextLine();

        Periodico periodico = new Periodico(titulo, precio, numPag, secciones, editor, periodicidad);
        list.add(periodico);
    }

    public static void deletePublicacion() {
        String title;
        int acc = 0;
        System.out.println();
        System.out.println("Ingrese el título de la  publicación a eliminar:");
        title = nextLine();
        Iterator<Publicacion> iterator = list.iterator();
        Publicacion current;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (current.getTitulo().equalsIgnoreCase(title)) {
                iterator.remove();
                acc++;
            }
        }
        System.out.println("Se eliminaron " + acc + " publicacion(es)");
        System.out.println();
    }

    public static void findPublicacion() {
        String title;
        System.out.println();
        System.out.println("Ingrese el título de la  publicación a buscar:");
        title = nextLine();
        List<Publicacion> list1 = findByTitle(title);
        show(list1);
    }

    public static void show() {
        show(list);
    }

    public static void show(List<Publicacion> l) {
        System.out.println("----------------------");
        for (Publicacion pub : l) {
            pub.printMetadata(System.out);
            System.out.println("----------------------");
        }
        System.out.println();
    }

    public static List<Publicacion> findByTitle(String title) {
        LinkedList<Publicacion> outList = new LinkedList<>();
        for (Publicacion current : list) {
            if (current.getTitulo().equalsIgnoreCase(title)) {
                outList.add(current);
            }
        }
        return outList;
    }

    public static int nextInt() {
        String line;
        while (true) {
            try {
                line = nextLine();
                return Integer.parseInt(line);
            } catch (Exception ex) {
                System.out.println("Valor inválido");
            }
        }
    }

    public static float nextFloat() {
        String line;
        while (true) {
            try {
                line = nextLine();
                return Float.parseFloat(line);
            } catch (Exception ex) {
                System.out.println("Valor inválido");
            }
        }
    }

    public static String nextLine() {
        return scanner.nextLine().trim();
    }

}
