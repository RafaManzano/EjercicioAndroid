package iesnervion.rmanzano.coincatchdef.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int monedas;
    private int botonPulsado;
    private boolean pulsadoJugar;
    private String nickname;
    private MutableLiveData<Integer> saberBotonPulsado;
    private MutableLiveData<Boolean> musica;
    private boolean sonido;
    private String level;

    public MainViewModel() {
        this.monedas = 0;
        this.nickname = "";
        this.botonPulsado = 0;
        this.saberBotonPulsado = new MutableLiveData<>();
        this.musica = new MutableLiveData<>();
        this.sonido = true;
        this.pulsadoJugar = false;
        this.level = "";
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

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public boolean isPulsadoJugar() {
        return pulsadoJugar;
    }

    public void setPulsadoJugar(boolean pulsadoJugar) {
        this.pulsadoJugar = pulsadoJugar;
    }

    public MutableLiveData<Boolean> getMusica() {
        return musica;
    }

    public void cambiarMusica(boolean musica) {
        this.musica.setValue(musica);
    }

    public boolean isSonido() {
        return sonido;
    }

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}


