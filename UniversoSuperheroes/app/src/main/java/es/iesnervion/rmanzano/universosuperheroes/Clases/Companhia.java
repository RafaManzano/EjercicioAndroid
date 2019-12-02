package es.iesnervion.rmanzano.universosuperheroes.Clases;

public class Companhia {
    private int imagen;
    private String nombre;

    public Companhia() {
        imagen = 0;
        nombre = "noDefinido";
    }

    public Companhia(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
