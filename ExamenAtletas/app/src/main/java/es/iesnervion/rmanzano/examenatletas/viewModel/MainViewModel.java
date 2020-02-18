package es.iesnervion.rmanzano.examenatletas.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.rmanzano.examenatletas.clases.Atleta;

public class MainViewModel extends ViewModel {
    private int botonPulsado;
    private MutableLiveData<Integer> saberBotonPulsado;
    private Atleta atletaSeleccionado;
    private MutableLiveData<Atleta> mutableAtleta;
    private ArrayList<Atleta> atletas;
    private MutableLiveData<ArrayList<Atleta>> mutableAtletas;
    private boolean tablet;

    public MainViewModel() {
        this.botonPulsado = 0;
        this.saberBotonPulsado = new MutableLiveData<>();
        this.atletaSeleccionado = new Atleta();
        this.mutableAtleta = new MutableLiveData<>();
        this.atletas = new ArrayList<>();
        this.mutableAtletas = new MutableLiveData<>();
        this.tablet = false;
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

    public Atleta getAtletaSeleccionado() {
        return atletaSeleccionado;
    }

    public void setAtletaSeleccionado(Atleta atletaSeleccionado) {
        this.atletaSeleccionado = atletaSeleccionado;
    }

    public MutableLiveData<Atleta> getMutableAtleta() {
        return mutableAtleta;
    }

    public ArrayList<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(ArrayList<Atleta> atletas) {
        this.atletas = atletas;
        mutableAtletas.setValue(atletas);
    }

    public MutableLiveData<ArrayList<Atleta>> getMutableAtletas() {
        return mutableAtletas;
    }

    public void anhadirNuevoAtleta(Atleta atleta) {
        atletas.add(atleta);
        mutableAtletas.setValue(atletas);
    }

    public boolean isTablet() {
        return tablet;
    }

    public void setTablet(boolean tablet) {
        this.tablet = tablet;
    }

    public void cambiarAtleta(Atleta atleta) {
        mutableAtleta.setValue(atleta);
    }
}
