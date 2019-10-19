package es.iesnervion.rmanzano.objetostft.clases;

import java.util.ArrayList;

import es.iesnervion.rmanzano.objetostft.R;

public class Metodos {
    public static ArrayList<String> paraAutoComplete() {
        ArrayList arr = new ArrayList<String>();
        arr.add("Espadon");
        arr.add("Arco Curvo");
        arr.add("Vara Innecesariamente Grande");
        arr.add("Lagrima de la Diosa");
        arr.add("Chaleco de cadenas");
        arr.add("Capa Negatron");
        arr.add("Cinturon de Gigante");
        arr.add("Espatula");
        return arr;
    }

    public static ArrayList<Objeto> paraSpinner() {
        ArrayList arr = new ArrayList<Objeto>();
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Espadon"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Arco Curvo"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Vara Innecesariamente Grande"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Lagrima de la Diosa"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Chaleco de cadenas"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Capa Negatron"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Cinturon de Gigante"));
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Espatula"));
        return arr;
    }

    public static ArrayList<ObjetoFinal> paraTextos() {
        ArrayList arr = new ArrayList<ObjetoFinal>();
        arr.add(new ObjetoFinal("Espadon", "Espadon", R.drawable.ic_launcher_background, "Filo Infinito", "Al participar en una eliminacion, obtienes 15 de daño adicional"));
        arr.add(new ObjetoFinal("Espadon", "Arco Curvo", R.drawable.ic_launcher_background, "Verdugo de gigantes", "Los ataques infligen un 5% adicional de la vida maxima del enemigo como daño verdadero"));

        return arr;
    }
}
