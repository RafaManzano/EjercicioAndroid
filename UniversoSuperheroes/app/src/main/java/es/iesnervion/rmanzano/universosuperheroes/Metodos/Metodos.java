package es.iesnervion.rmanzano.universosuperheroes.Metodos;

import java.util.ArrayList;

import es.iesnervion.rmanzano.universosuperheroes.Clases.Companhia;
import es.iesnervion.rmanzano.universosuperheroes.Clases.Personaje;
import es.iesnervion.rmanzano.universosuperheroes.R;

public class Metodos {
    public static ArrayList<Companhia> obtenerCompanhias() {
        ArrayList<Companhia> companhias = new ArrayList<>();
        companhias.add(new Companhia(R.drawable.dcfeo, "DC"));
        companhias.add(new Companhia(R.drawable.marvelfeo, "Marvel"));
        return companhias;
    }

    public static ArrayList<Personaje> obtenerTodosPersonajes(){
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje(R.drawable.aquaman, "Aquaman", "DC"));
        personajes.add(new Personaje(R.drawable.batman, "Batman", "DC"));
        personajes.add(new Personaje(R.drawable.capitanamerica, "Capitan America", "Marvel"));
        personajes.add(new Personaje(R.drawable.deadpool, "Deadpool", "Marvel"));
        personajes.add(new Personaje(R.drawable.flash, "Flash", "DC"));
        personajes.add(new Personaje(R.drawable.ironman, "Ironman", "Marvel"));
        personajes.add(new Personaje(R.drawable.spiderman, "Spiderman", "Marvel"));
        personajes.add(new Personaje(R.drawable.superman, "Superman", "DC"));
        personajes.add(new Personaje(R.drawable.thor, "Thor", "Marvel-+++"));

        return personajes;
    }

    public static ArrayList<Personaje> obtenerPersonajePorCompanhia(int id) {
        ArrayList<Personaje> personajes = obtenerTodosPersonajes();
        ArrayList<Personaje> p = new ArrayList<>();
        if(id == 0) {
            for(Personaje item : personajes) {
                if(item.getCompanhia().equals("DC")) {
                    p.add(item);
                }
            }
        }
        else {
            for(Personaje item : personajes) {
                if(item.getCompanhia().equals("Marvel")) {
                    p.add(item);
                }
            }
        }

        return p;
    }
}
