package es.iesnervion.rmanzano.objetostft.clases;

public class ObjetoFinal {
    private String primerObjeto;
    private String segundoObjeto;
    private int imagen;
    private String objetoFinal;
    private String descripcion;

    public ObjetoFinal(String primerObjeto, String segundoObjeto, int imagen, String objetoFinal, String descripcion) {
        this.primerObjeto = primerObjeto;
        this.segundoObjeto = segundoObjeto;
        this.imagen = imagen;
        this.objetoFinal = objetoFinal;
        this.descripcion = descripcion;
    }

    public String getPrimerObjeto() {
        return primerObjeto;
    }

    public String getSegundoObjeto() {
        return segundoObjeto;
    }

    public int getImagen() {
        return imagen;
    }

    public String getObjetoFinal() {
        return objetoFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
