package proyect;

import java.io.PrintStream;

public abstract class Publicacion implements Printable {

    private String titulo;

    private float precio;

    private int numPag;

    public Publicacion() {
    }

    public Publicacion(String titulo, float precio, int numPag) {
        this.titulo = titulo;
        this.precio = precio;
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public void printMetadata(PrintStream out) {
        out.println("Título: " + titulo);
        out.println("Precio: " + String.format("%.2f", precio));
        out.println("Cantidad de páginas: " + numPag);
    }
}
