package es.iesnervion.rmanzano.nbateams.Clases;

public class Equipo {
    private Integer imagen;
    private String nombre;
    private String conferencia;

    public Equipo(Integer imagen, String nombre, String conferencia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.conferencia = conferencia;
    }

    public Integer getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConferencia() {
        return conferencia;
    }
}
