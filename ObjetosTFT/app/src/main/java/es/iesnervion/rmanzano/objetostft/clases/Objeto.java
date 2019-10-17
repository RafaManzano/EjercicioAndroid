package es.iesnervion.rmanzano.objetostft.clases;

public class Objeto {
    private int imagen;
    private String nombre;

    public Objeto(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }
}
