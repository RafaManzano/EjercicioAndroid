package iesnervion.rmanzano.sumatoriocompadre.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import iesnervion.rmanzano.sumatoriocompadre.Clases.Suma;

public class SumaViewModel extends ViewModel {
    private Integer numeroIzq;
    private Integer numeroDcha;
    private ArrayList<Suma> filasSuma;
    private MutableLiveData<ArrayList<Suma>> mutableSuma;

    public SumaViewModel() {
        this.numeroIzq = 0;
        this.numeroDcha = 0;
        this.filasSuma = new ArrayList<>();
        mutableSuma = new MutableLiveData<>();
    }

    public Integer getNumeroIzq() {
        return numeroIzq;
    }

    public void setNumeroIzq(int numeroIzq) {
        this.numeroIzq = numeroIzq;
    }

    public Integer getNumeroDcha() {
        return numeroDcha;
    }

    public void setNumeroDcha(int numeroDcha) {
        this.numeroDcha = numeroDcha;
    }

    public ArrayList<Suma> getFilasSuma() {
        return filasSuma;
    }

    public void setFilasSuma(ArrayList<Suma> filasSuma) {
        this.filasSuma = filasSuma;
    }

    public MutableLiveData<ArrayList<Suma>> getMutableSuma() {
        return mutableSuma;
    }

    public void setMutableSuma(MutableLiveData<ArrayList<Suma>> mutableSuma) {
        this.mutableSuma = mutableSuma;
    }

    public void anhadirNumero(Suma suma) {
        filasSuma.add(suma);
        mutableSuma.setValue(filasSuma);
    }
}
