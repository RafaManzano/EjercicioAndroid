package iesnervion.rmanzano.masterdetails.clases;

public class Contacto {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int imagen;
    private String nombre;

    public Contacto() {
        this.imagen = 0;
        this.nombre = "";
    }

    public Contacto(int imagen, String nombre) {
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
