package es.iesnervion.rmanzano.examenatletas.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import es.iesnervion.rmanzano.examenatletas.clases.Atleta;

@Dao
public interface MiDao {
    @Insert
    public Void insertarAtleta(Atleta a);

    @Query("SELECT * FROM Atleta")
    public List<Atleta> listarAtleta();

    @Query("SELECT * FROM Atleta WHERE id = :id")
    public Atleta atletaPorID(int id);
}
