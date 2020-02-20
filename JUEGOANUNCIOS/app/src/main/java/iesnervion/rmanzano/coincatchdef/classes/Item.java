package iesnervion.rmanzano.coincatchdef.classes;

public class Item {
    private int id;
    private int imagen;
    private String nombre;

    public Item() {
        this.id = 0;
        this.imagen = 0;
        this.nombre = "Vacio";
    }

    public Item(int id, int imagen, String nombre) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
