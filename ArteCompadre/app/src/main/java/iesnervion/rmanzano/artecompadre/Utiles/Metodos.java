package iesnervion.rmanzano.artecompadre.Utiles;

import java.util.ArrayList;
import java.util.Random;

import iesnervion.rmanzano.artecompadre.Clases.Danza;
import iesnervion.rmanzano.artecompadre.Clases.Escultura;
import iesnervion.rmanzano.artecompadre.Clases.FraseCelebre;
import iesnervion.rmanzano.artecompadre.Clases.Pintura;
import iesnervion.rmanzano.artecompadre.R;

public class Metodos {
    public static ArrayList<Object> rellenarListado() {
        ArrayList<Object> filas = new ArrayList<>();
        ArrayList<String> obras = new ArrayList<String>();
        obras.add("Primera Obra");
        obras.add("Segunda Obra");
        obras.add("Tercera Obra");
        Danza d = new Danza(R.drawable.d,"Genero", "Mejor Cancion", R.drawable.c);
        Escultura e = new Escultura(R.drawable.e, "1900/1950", new ArrayList<String>(obras));
        Pintura p = new Pintura(R.drawable.p, "Algun Estilo");
        FraseCelebre f = new FraseCelebre("Persona", "Una persona de buen corazon");

        for(int i = 0; i < 1000; i++) {
            Random r = new Random();
            switch (r.nextInt(4)) {
                case 0:
                    filas.add(d);
                    break;

                case 1:
                    filas.add(e);
                    break;

                case 2:
                    filas.add(p);
                    break;

                case 3:
                    filas.add(f);
                    break;
            }
        }
        return filas;
    }
}
