package es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel;

import androidx.lifecycle.LiveData;

public class ViewModel {
    private int punto;
    private int pokemon;
    private LiveData<String> botonPulsado;

    public ViewModel() {
        punto = 0;
        pokemon = 7;
    }

    public ViewModel(int punto, int pokemon) {
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

    public LiveData<String> getBotonPulsado() {
        return botonPulsado;
    }

    public void setBotonPulsado(LiveData<String> botonPulsado) {
        this.botonPulsado = botonPulsado;
    }
}
