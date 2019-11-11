package es.iesnervion.rmanzano.mesafutsalcompadre.ViewModel;

import android.os.SystemClock;

import androidx.lifecycle.ViewModel;

public class PartidoViewModel extends ViewModel {
    private Integer golLocal;
    private Integer golVisitante;
    private Integer faltaLocal;
    private Integer faltaVisitante;
    //private Long chrono;

    public PartidoViewModel() {
        golLocal = 0;
        golVisitante = 0;
        faltaLocal = 0;
        faltaVisitante = 0;
        //chrono = 1200000L;
    }

    public Integer getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    public Integer getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }

    public Integer getFaltaLocal() {
        return faltaLocal;
    }

    public void setFaltaLocal(Integer faltaLocal) {
        this.faltaLocal = faltaLocal;
    }

    public Integer getFaltaVisitante() {
        return faltaVisitante;
    }

    public void setFaltaVisitante(Integer faltaVisitante) {
        this.faltaVisitante = faltaVisitante;
    }

    /*
    public Long getChrono() {
        return chrono;
    }

    public void setChrono(Long chrono) {
        this.chrono = chrono;
    }
    */

}
