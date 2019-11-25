package es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel;

public class ViewModel {
    private int punto;

    public ViewModel() {
        punto = 0;
    }

    public ViewModel(int punto) {
        this.punto = punto;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }
}
