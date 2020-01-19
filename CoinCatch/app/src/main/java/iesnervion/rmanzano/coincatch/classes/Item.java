package iesnervion.rmanzano.coincatch.classes;

public class Item {
    private int imagen;
    private String nombre;

    public Item() {
        this.imagen = 0;
        this.nombre = "Vacio";
    }

    public Item(int imagen, String nombre) {
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
