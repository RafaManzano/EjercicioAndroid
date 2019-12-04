package iesnervion.rmanzano.sumatoriocompadre.Clases;

public class Suma {
    private Integer contador;
    private Integer suma;

    public Suma() {
        contador = 0;
        suma = 0;
    }

    public Suma(Integer contador, Integer suma) {
        this.contador = contador;
        this.suma = suma;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer getSuma() {
        return suma;
    }

    public void setSuma(Integer suma) {
        this.suma = suma;
    }
}
