package es.iesnervion.rmanzano.piedrapapeltijeracompader;

public class Estadistica {
    private String jugador;
    private String maquina;
    private String ganador;

    public Estadistica(String jugador, String maquina, String ganador) {
        this.jugador = jugador;
        this.maquina = maquina;
        this.ganador = ganador;
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
