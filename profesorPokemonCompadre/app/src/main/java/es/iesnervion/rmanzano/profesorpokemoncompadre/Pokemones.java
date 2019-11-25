package es.iesnervion.rmanzano.profesorpokemoncompadre;


public class Pokemones {
    private int imagen;
    private String nombre;

    public Pokemones() {

    }

    public Pokemones(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Pokemones[] listadoPokemones() {
        Pokemones[] pokemones = new Pokemones[25];
        pokemones[0] = new Pokemones(R.drawable.bunneary, "bunneary");
        pokemones[1] = new Pokemones(R.drawable.charmander, "charmander");
        pokemones[2] = new Pokemones(R.drawable.dragonite, "dragonite");
        pokemones[3] = new Pokemones(R.drawable.gengar, "gengar");
        pokemones[4] = new Pokemones(R.drawable.gyarados, "gyarados");
        pokemones[5] = new Pokemones(R.drawable.haunter, "haunter");
        pokemones[6] = new Pokemones(R.drawable.ivisaur, "ivysaur");
        pokemones[7] = new Pokemones(R.drawable.kingler, "kingler");
        pokemones[8] = new Pokemones(R.drawable.larvitar, "pupitar");
        pokemones[9] = new Pokemones(R.drawable.latios, "latios");
        pokemones[10] = new Pokemones(R.drawable.liilpet, "petilil");
        pokemones[11] = new Pokemones(R.drawable.lunala, "lunala");
        pokemones[12] = new Pokemones(R.drawable.mewto, "mewtwo");
        pokemones[13] = new Pokemones(R.drawable.ninetales, "ninetales");
        pokemones[14] = new Pokemones(R.drawable.pikachu, "pikachu");
        pokemones[15] = new Pokemones(R.drawable.raichu, "raichu");
        pokemones[16] = new Pokemones(R.drawable.rayquaza, "rayquaza");
        pokemones[17] = new Pokemones(R.drawable.rosahada, "snubull");
        pokemones[18] = new Pokemones(R.drawable.rufflet, "braviary");
        pokemones[19] = new Pokemones(R.drawable.shinx, "shinx");
        pokemones[20] = new Pokemones(R.drawable.starly, "starly");
        pokemones[21] = new Pokemones(R.drawable.tarracosta, "carracosta");
        pokemones[22] = new Pokemones(R.drawable.tepig, "tepig");
        pokemones[23] = new Pokemones(R.drawable.umbreon, "umbreon");
        pokemones[24] = new Pokemones(R.drawable.zoroark, "zoroark");

        return pokemones;
    }
}
