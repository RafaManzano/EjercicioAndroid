package iesnervion.rmanzano.coincatch.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int botonPulsado;
    private String nickname;
    private MutableLiveData<Integer> saberBotonPulsado;

    public MainViewModel() {
        this.nickname = "";
        this.botonPulsado = 0;
        saberBotonPulsado = new MutableLiveData<>();
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
