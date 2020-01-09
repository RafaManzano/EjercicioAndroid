package es.iesnervion.rmanzano.piedrapapeltijeracompader;

public class ViewModel {
    private Integer victorias;
    private Integer derrotas;
    private Integer empates;

    public ViewModel() {
        victorias = 0;
        derrotas = 0;
        empates = 0;
    }

    public Integer getVictorias() {
        return victorias;
    }

    public void setVictorias(Integer victorias) {
        this.victorias = victorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }
}
