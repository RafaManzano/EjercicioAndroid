package es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewModelPokemon extends ViewModel {
    private int punto;
    private int pokemon;
    MutableLiveData<ArrayList<Integer>> datosAcambiar;
    String puntuacion;
    String descubierto;

    public ViewModelPokemon() {
        punto = 0;
        pokemon = 7;
        datosAcambiar = new MutableLiveData<>();
        descubierto = "POKEMON ENCONTRADOS: 7";
        puntuacion = "PUNTUACION: 0" ;
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
    }

    public int getPokemon() {
        return pokemon;
    }

    public void setPokemon(int pokemon) {
        this.pokemon = pokemon;
    }

    public MutableLiveData<ArrayList<Integer>> getDatosAcambiar() {
        return datosAcambiar;
    }

    public void modificarNumeros() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(getPokemon());
        numeros.add(getPunto());
        datosAcambiar.setValue(numeros);
        descubierto = ("POKEMON ENCONTRADOS: " + numeros.get(0));
        puntuacion = ("PUNTUACION: " + numeros.get(1));
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(String descubierto) {
        this.descubierto = descubierto;
    }
}
