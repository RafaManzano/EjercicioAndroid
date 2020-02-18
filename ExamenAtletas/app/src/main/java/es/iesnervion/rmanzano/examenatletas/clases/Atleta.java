package es.iesnervion.rmanzano.examenatletas.clases;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Atleta {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombre;
    private String apellidos;
    private String observaciones;

    public Atleta() {
        this.nombre = "";
        this.apellidos = "";
        this.observaciones= "";
    }

    @Ignore
    public Atleta(String nombre, String apellidos, String observaciones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
