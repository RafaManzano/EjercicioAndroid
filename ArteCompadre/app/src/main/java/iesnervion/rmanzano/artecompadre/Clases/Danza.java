package iesnervion.rmanzano.artecompadre.Clases;

public class Danza {
    private int foto;
    private String genero;
    private String cancion;
    private int continente;

    public Danza() {
        this.foto = 0;
        this.genero = "Vacio";
        this.cancion = "Vacio";
        this.continente = 0;
    }


    public Danza(int foto, String genero, String cancion, int continente) {
        this.foto = foto;
        this.genero = genero;
        this.cancion = cancion;
        this.continente = continente;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public int getContinente() {
        return continente;
    }

    public void setContinente(int continente) {
        this.continente = continente;
    }
}
