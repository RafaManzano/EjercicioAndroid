package iesnervion.rmanzano.coincatch.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CoinViewModel extends ViewModel {
    private int monedas;
    private int botonPulsado;
    private MutableLiveData<Integer> saberBotonPulsado;

    public CoinViewModel() {
        this.monedas = 0;
        this.botonPulsado = 0;
        saberBotonPulsado = new MutableLiveData<>();
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public int getBotonPulsado() {
        return botonPulsado;
    }

    public void setBotonPulsado(int botonPulsado) {
        this.botonPulsado = botonPulsado;
        botonElegido(botonPulsado);
    }

    public MutableLiveData<Integer> getSaberBotonPulsado() {
        return saberBotonPulsado;
    }

    public void botonElegido(int pulsacion) {
        saberBotonPulsado.setValue(pulsacion);
    }

}
