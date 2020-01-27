package iesnervion.rmanzano.coincatchdef.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatchdef.classes.Stats;

public class StatsViewModel extends ViewModel {
    private ArrayList<Stats> stats = new ArrayList<>();
    private MutableLiveData<ArrayList<Stats>> mutableStats;

    public StatsViewModel() {
        stats = new ArrayList<>();
        mutableStats = new MutableLiveData<>();
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Stats> stats) {
        this.stats = stats;
    }

    public MutableLiveData<ArrayList<Stats>> getMutableStats() {
        return mutableStats;
    }

    public void setMutableStats(MutableLiveData<ArrayList<Stats>> mutableStats) {
        this.mutableStats = mutableStats;
    }

    public void cargarListaEstadistica(ArrayList<Stats> stats) {
        mutableStats.setValue(stats);
    }
}
