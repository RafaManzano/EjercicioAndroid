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
        //TODO Tengo que revisar todo con la web: https://as.com/meristation/2019/10/09/noticias/1570614655_770390.html

        //Objetos con Espadon de primero
        arr.add(new ObjetoFinal("Espadon", "Espadon", R.drawable.ic_launcher_background, "Filo Infinito", "Al participar en una eliminacion, obtienes 15 de daño adicional"));
        arr.add(new ObjetoFinal("Espadon", "Arco Curvo", R.drawable.ic_launcher_background, "Verdugo de gigantes", "Los ataques infligen un 5% adicional de la vida maxima del enemigo como daño verdadero"));
        arr.add(new ObjetoFinal("Espadon", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Filo de Shojin", "Tras realizar una habilidad, recuperas un 15% del maná por ataque"));
        arr.add(new ObjetoFinal("Espadon", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Angel de la guarda", "Revives con 800 puntos de vida"));
        arr.add(new ObjetoFinal("Espadon", "Capa negatron", R.drawable.ic_launcher_background, "Sanguinaria", "Obtienes +50% de robo de vida"));
        arr.add(new ObjetoFinal("Espadon", "Cinturon de gigante", R.drawable.ic_launcher_background, "Heraldo de Zeke", "Emite un aura que afecta a todos los aliados a un máximo de dos casillas de distancia a izquierda y derecha del ortador. Aumenta la velocidad de ataque un 15%"));
        arr.add(new ObjetoFinal("Espadon", "Espatula", R.drawable.ic_launcher_background, "Filo Espectral de Youmuu", "El portador es también un Asesino"));
        arr.add(new ObjetoFinal("Espadon", "Guantes de combate", R.drawable.ic_launcher_background, "Filo Infinito", "El daño crítico se incrementa un 125%, +20% de posibilidad de golpe crítico"));

        //Objetos con Arco Curvo de primero
        arr.add(new ObjetoFinal("Arco Curvo", "Arco Curvo", R.drawable.ic_launcher_background, "Cañon de fuego rapido", "El Rango de ataque se modifica según los cambios de alcance de cada Campeón"));
        arr.add(new ObjetoFinal("Arco Curvo", "Espadon", R.drawable.ic_launcher_background, "Verdugo de gigantes", "Los ataques infligen un 5% adicional de la vida maxima del enemigo como daño verdadero"));
        arr.add(new ObjetoFinal("Arco Curvo", "Vara Innecesariamente Grande", R.drawable.ic_launcher_background, "Hoja de furia de Guinsoo", "Los ataques obtienen un 3% de Velocidad de ataque) Se acumula infinitamente"));
        arr.add(new ObjetoFinal("Arco Curvo", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Bailarin espectral", "El portador esquiva todos los Golpes Críticos"));
        arr.add(new ObjetoFinal("Arco Curvo", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Puñal de Statikk", "Cada tercer ataque golpea a 3 objetivos adicionales. Solamente se activa una vez por cada ataque lanzado, hace 100 puntos de daño por cada rebote"));
        arr.add(new ObjetoFinal("Arco Curvo", "Cinturon de gigante", R.drawable.ic_launcher_background, "Hidra titanica", "Los ataques hacen un daño de salpicadura equivalente al 3 % de la vida máxima al objetivo y a los enemigos adyacentes que estén detrás de este"));
        arr.add(new ObjetoFinal("Arco Curvo", "Espatula", R.drawable.ic_launcher_background, "Hoja del Rey Arruinado", "El portador es también un Espadachín"));
        arr.add(new ObjetoFinal("Arco Curvo", "Guantes de combate", R.drawable.ic_launcher_background, "Ballesta de repeticion", "l morir el portador, pasa a un campeón aliado y le otorga un 20 % adicional de velocidad de ataque y de probabilidad de impacto crítico"));
        arr.add(new ObjetoFinal("Arco Curvo", "Capa negatron", R.drawable.ic_launcher_background, "Ballesta de repeticion", "l morir el portador, pasa a un campeón aliado y le otorga un 20 % adicional de velocidad de ataque y de probabilidad de impacto crítico"));


        //Objetos con Vara innecesariamente Grande de primero
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Sombrero mortal de Rabadon", "Otorga un 50% más de Poder de habilidad"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Espadon", R.drawable.ic_launcher_background, "Sable-pistola hextech", "Cura un 25% del daño infligido"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Arco Curvo", R.drawable.ic_launcher_background, "Hoja de furia de Guinsoo", "Los ataques obtienen un 3% de Velocidad de ataque, se acumula infinitamente"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Eco de Luden", "Los hechizos hacen 180 de daño al objetivo directo y hasta 200 de daño de área"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Medallón de los Solari de Hierro", "Al principio del combate, todos los aliados a una distancia de dos casillas a izquierda y derecha del portador y el propio portador reciben un escudo de 300 durante 7 segundos"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Capa negatron", R.drawable.ic_launcher_background, "Chispa iónica", "Cuando un enemigo lanza un hechizo recibe 125 de daño"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Cinturon de gigante", R.drawable.ic_launcher_background, "Morellonomicon", "Los hechizos hacen daño equivalente a un 20 % de la vida máxima a lo largo de 10 segundos"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Espatula", R.drawable.ic_launcher_background, "Yummi", "El portador es también un Hechicero"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Guantes de combate", R.drawable.ic_launcher_background, "Guantele ", "El portador es también un Hechicero"));




        return arr;
    }
}
