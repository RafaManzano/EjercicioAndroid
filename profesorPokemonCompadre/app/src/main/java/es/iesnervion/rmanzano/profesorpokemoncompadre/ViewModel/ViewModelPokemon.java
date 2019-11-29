package es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewModelPokemon extends ViewModel {
    private int punto;
    private int pokemon;
    private boolean botonPulsado;

    private MutableLiveData<Integer> puntuacion;
    private MutableLiveData<Integer> descubierto;
    private MutableLiveData<Boolean> cerrarFragment;

    public ViewModelPokemon() {
        punto = 0;
        pokemon = 7;
        botonPulsado = false;
        puntuacion = new MutableLiveData<>();
        descubierto = new MutableLiveData<>();
        cerrarFragment = new MutableLiveData<>();
    }

    public ViewModelPokemon(int punto, int pokemon) {
        this.punto = punto;
        this.pokemon = pokemon;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
        cambioPuntuacion(punto);

    }

    public int getPokemon() {
        return pokemon;
    }

    public void setPokemon(int pokemon) {
        this.pokemon = pokemon;
        cambioPokemonEncontrado(pokemon);
    }

    public boolean isBotonPulsado() {
        return botonPulsado;
    }

    public void setBotonPulsado(boolean botonPulsado) {
        this.botonPulsado = botonPulsado;
        cambioCerrarFragment(botonPulsado);
    }

    public MutableLiveData<Integer> getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(MutableLiveData<Integer> puntuacion) {
        this.puntuacion = puntuacion;
    }

    public MutableLiveData<Integer> getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(MutableLiveData<Integer> descubierto) {
        this.descubierto = descubierto;
    }

    public MutableLiveData<Boolean> getCerrarFragment() {
        return cerrarFragment;
    }

    public void setCerrarFragment(MutableLiveData<Boolean> cerrarFragment) {
        this.cerrarFragment = cerrarFragment;
    }

    /*
    Metodos para realizar los MutableLiveData
     */

    public void cambioPokemonEncontrado(int n) {
        descubierto.setValue(n);
    }
    public void cambioPuntuacion(int n) {
        puntuacion.setValue(n);
    }

    public void cambioCerrarFragment(boolean c) {
        cerrarFragment.setValue(c);
    }
}
