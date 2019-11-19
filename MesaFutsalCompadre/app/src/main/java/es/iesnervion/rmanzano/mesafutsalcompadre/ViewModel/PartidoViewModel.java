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
    ArrayList<Fila> filasLocal = new ArrayList<>();
    ArrayList<Fila> filasVisitante = new ArrayList<>();
    private MutableLiveData<ArrayList<Fila>> tarjetasLocales;
    private MutableLiveData<ArrayList<Fila>> tarjetasVisitantes;
    //private Long chrono;

    public PartidoViewModel() {
        golLocal = 0;
        golVisitante = 0;
        faltaLocal = 0;
        faltaVisitante = 0;
        tarjetasLocales = new MutableLiveData<>();
        tarjetasVisitantes = new MutableLiveData<>();
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

    public MutableLiveData<ArrayList<Fila>> getTarjetasLocales() {
        return tarjetasLocales;
    }

    public MutableLiveData<ArrayList<Fila>> getTarjetasVisitantes() {
        return tarjetasVisitantes;
    }

    public void anhadirTarjetaLocal(Fila fila) {
        filasLocal.add(fila);
        tarjetasLocales.setValue(filasLocal);
    }

    public void anhadirTarjetaVisitante(Fila fila) {
        filasVisitante.add(fila);
        tarjetasVisitantes.setValue(filasVisitante);
    }

    public ArrayList<Fila> getFilasLocal() {
        return filasLocal;
    }

    public void setFilasLocal(ArrayList<Fila> filasLocal) {
        this.filasLocal = filasLocal;
        tarjetasLocales.postValue(filasLocal);
    }

    public ArrayList<Fila> getFilasVisitante() {
        return filasVisitante;
    }

    public void setFilasVisitante(ArrayList<Fila> filasVisitante) {
        this.filasVisitante = filasVisitante;
        tarjetasVisitantes.postValue(filasVisitante);
    }
}
