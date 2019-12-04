package iesnervion.rmanzano.artecompadre.Clases;

import java.util.ArrayList;

public class Escultura {
    private int foto;
    private String fecha;
    private ArrayList<String> obras;

    public Escultura() {
        this.foto = 0;
        this.fecha = "Vacio";
        this.obras = new ArrayList<>();
    }

    public Escultura(int foto, String fecha, ArrayList<String> obras) {
        this.foto = foto;
        this.fecha = fecha;
        this.obras = obras;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<String> getObras() {
        return obras;
    }

    public void setObras(ArrayList<String> obras) {
        this.obras = obras;
    }
}
