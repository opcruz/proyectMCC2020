package proyect;

import java.io.PrintStream;

public class Libro extends Publicacion {

    private String ISBN;

    private String edicion;

    private String autor;

    public Libro() {
        super();
    }

    public Libro(String titulo, float precio, int numPag, String ISBN, String edicion, String autor) {
        super(titulo, precio, numPag);
        this.ISBN = ISBN;
        this.edicion = edicion;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void printMetadata(PrintStream out) {
        out.println("Libro");
        out.println("-------");
        super.printMetadata(out);
        out.println("ISBN: " + ISBN);
        out.println("Edición: " + edicion);
        out.println("Autor: " + autor);
    }
}
