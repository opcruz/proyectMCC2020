package proyect;

import java.io.PrintStream;

public class Periodico extends Publicacion implements Periodicidad {

    private String secciones;

    private String editor;

    private String periodicidad;

    public Periodico() {
        super();
    }

    public Periodico(String titulo, float precio, int numPag, String secciones, String editor, String periodicidad) {
        super(titulo, precio, numPag);
        this.secciones = secciones;
        this.editor = editor;
        this.periodicidad = periodicidad;
    }

    public String getSecciones() {
        return secciones;
    }

    public void setSecciones(String secciones) {
        this.secciones = secciones;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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
        out.println("Periódico");
        out.println("-------");
        super.printMetadata(out);
        out.println("Secciones: " + secciones);
        out.println("Editor: " + editor);
        out.println("Periodicidad: " + periodicidad);
    }

}
