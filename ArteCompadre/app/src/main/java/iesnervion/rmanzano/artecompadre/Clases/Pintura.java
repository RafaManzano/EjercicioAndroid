package iesnervion.rmanzano.artecompadre.Clases;

public class Pintura {
    private int foto;
    private String estilo;

    public Pintura() {
        this.foto = 0;
        this.estilo = "Vacio";
    }

    public Pintura(int foto, String estilo) {
        this.foto = foto;
        this.estilo = estilo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
