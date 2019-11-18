package es.iesnervion.rmanzano.mesafutsalcompadre.ViewModel;

import android.os.SystemClock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.rmanzano.mesafutsalcompadre.Fila;

public class PartidoViewModel extends ViewModel {
    private Integer golLocal;
    private Integer golVisitante;
    private Integer faltaLocal;
    private Integer faltaVisitante;
    ArrayList<Fila> filas = new ArrayList<>();
    private MutableLiveData<ArrayList<Fila>> tarjetasAmarillas;
    //private Long chrono;

    public PartidoViewModel() {
        golLocal = 0;
        golVisitante = 0;
        faltaLocal = 0;
        faltaVisitante = 0;
        tarjetasAmarillas = new MutableLiveData<>();
        //filas = new ArrayList<Fila>();
        //f0.ilas.add(new Fila())
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

    public MutableLiveData<ArrayList<Fila>> getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void anhadirTarjetaAmarilla(Fila fila) {
        filas.add(fila);
        tarjetasAmarillas.setValue(filas);
    }


}
