package iesnervion.rmanzano.artecompadre.Clases;

public class FraseCelebre {
    private String escritor;
    private String frase;

    public FraseCelebre() {
        this.escritor = "Vacio";
        this.frase = "Vacio";
    }

    public FraseCelebre(String escritor, String frase) {
        this.escritor = escritor;
        this.frase = frase;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
