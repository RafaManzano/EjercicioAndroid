package es.iesnervion.rmanzano.universosuperheroes.Clases;

public class Personaje {
    private int imagen;
    private String apodo;
    private String companhia;

    public Personaje() {
        imagen = 0;
        apodo = "noDefinido";
        companhia = "noDefinido";
    }

    public Personaje(int imagen, String apodo, String companhia) {
        this.imagen = imagen;
        this.apodo = apodo;
        this.companhia = companhia;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }
}
