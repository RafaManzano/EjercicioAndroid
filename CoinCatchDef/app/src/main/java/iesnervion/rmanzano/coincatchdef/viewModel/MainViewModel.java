package iesnervion.rmanzano.coincatchdef.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int monedas;
    private int botonPulsado;
    private boolean pulsadoJugar;
    private String nickname;
    private boolean musica;
    private boolean sonido;
    private MutableLiveData<Integer> saberBotonPulsado;
    private MutableLiveData<Boolean> isMusica;
    private MutableLiveData<Boolean> isSonido;

    public MainViewModel() {
        this.monedas = 0;
        this.nickname = "";
        this.botonPulsado = 0;
        this.musica = true;
        this.sonido = true;
        this.saberBotonPulsado = new MutableLiveData<>();
        this.isMusica = new MutableLiveData<>();
        this.isSonido = new MutableLiveData<>();
        this.pulsadoJugar = false;
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

    public boolean isMusica() {
        return musica;
    }

    public void setMusica(boolean musica) {
        this.musica = musica;
        cambioMusica(musica);
    }

    public boolean isSonido() {
        return sonido;
    }

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
        cambioSonido(sonido);
    }

    public MutableLiveData<Boolean> getIsMusica() {
        return isMusica;
    }

    public MutableLiveData<Boolean> getIsSonido() {
        return isSonido;
    }

    public void cambioMusica(Boolean decision) {
        isMusica.setValue(decision);
    }

    public void cambioSonido(Boolean decision) {
        isSonido.setValue(decision);
    }
}
