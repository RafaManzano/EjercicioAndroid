package es.iesnervion.rmanzano.productosinformatica.Clases;

public class Impresora {
    private int disponibilidad;
    private int imagen;
    private String modelo;
    private String tipo;

    public Impresora() {
        this.disponibilidad = 0;
        this.imagen = 0;
        this.modelo = "Vacio";
        this.tipo = "Vacio";
    }

    public Impresora(int disponibilidad, int imagen, String modelo, String tipo) {
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
