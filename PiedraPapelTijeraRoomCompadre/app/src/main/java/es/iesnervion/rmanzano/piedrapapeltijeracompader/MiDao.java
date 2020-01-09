package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MiDao {
    @Insert
    public Void insertarEstadistica(Estadistica e);

    @Query("SELECT * FROM Estadistica")
    public List<Estadistica> recogerEstadisticas();
}
