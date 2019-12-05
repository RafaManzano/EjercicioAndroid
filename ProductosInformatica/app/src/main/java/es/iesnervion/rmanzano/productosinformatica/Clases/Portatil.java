package es.iesnervion.rmanzano.productosinformatica.Clases;

public class Portatil {
    private int disponibilidad;
    private int imagen;
    private String modelo;
    private int imagenCpu;

    public Portatil() {
        this.disponibilidad = 0;
        this.imagen = 0;
        this.modelo = "Vacio";
        this.imagenCpu = 0;
    }

    public Portatil(int disponibilidad, int imagen, String modelo, int imagenCpu) {
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
        this.modelo = modelo;
        this.imagenCpu = imagenCpu;
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

    public int getImagenCpu() {
        return imagenCpu;
    }

    public void setImagenCpu(int imagenCpu) {
        this.imagenCpu = imagenCpu;
    }
}
