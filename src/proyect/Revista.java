package proyect;

import java.io.PrintStream;

public class Revista extends Publicacion implements Periodicidad {

    private String ISSN;

    private int numero;

    private int anio;

    private String periodicidad;

    public Revista() {
        super();
    }

    public Revista(String titulo, float precio, int numPag, String ISSN, int numero, int anio, String periodicidad) {
        super(titulo, precio, numPag);
        this.ISSN = ISSN;
        this.numero = numero;
        this.anio = anio;
        this.periodicidad = periodicidad;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public void setPeriodicidad(String value) {
        periodicidad = value;
    }

    @Override
    public String getPeriodicidad() {
        return periodicidad;
    }

    @Override
    public void printMetadata(PrintStream out) {
        out.println("Revista");
        out.println("-------");
        super.printMetadata(out);
        out.println("ISSN: " + ISSN);
        out.println("Número: " + numero);
        out.println("Año: " + anio);
        out.println("Periodicidad: " + periodicidad);
    }

}
