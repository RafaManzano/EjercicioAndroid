package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Estadistica {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String jugador;
    private String maquina;
    private String ganador;

    public Estadistica() {
        this.jugador = "";
        this.maquina = "";
        this.ganador = "";
    }

    @Ignore
    public Estadistica(String jugador, String maquina, String ganador) {
        this.jugador = jugador;
        this.maquina = maquina;
        this.ganador = ganador;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
}
