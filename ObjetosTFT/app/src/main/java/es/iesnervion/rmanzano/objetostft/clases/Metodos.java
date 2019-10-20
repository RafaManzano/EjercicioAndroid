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
        arr.add("Guante de combate");
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
        arr.add(new Objeto(R.drawable.ic_launcher_background, "Guante de combate"));
        return arr;
    }

    public static ArrayList<ObjetoFinal> paraTextos() {
        ArrayList arr = new ArrayList<ObjetoFinal>();
        //TODO Tengo que revisar todo con la web: https://as.com/meristation/2019/10/09/noticias/1570614655_770390.html

        //Objetos con Espadon de primero
        arr.add(new ObjetoFinal("Espadon", "Espadon", R.drawable.ic_launcher_background, "Filo Mortal", "15 de daño en ataque"));
        arr.add(new ObjetoFinal("Espadon", "Arco Curvo", R.drawable.ic_launcher_background, "Verdugo de gigantes", "+ 15 de daño en ataque y 20% de velocidad en ataque"));
        arr.add(new ObjetoFinal("Espadon", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Filo de Shojin", "Tras lanzar la habilidad especial por primera vez, los ataques básicos restauran un 15% de maná máximo adicional al atacar"));
        arr.add(new ObjetoFinal("Espadon", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Angel de la guarda", "Al morir, revive con 500 puntos de vida, sólo puede ocurrir una vez por partida"));
        arr.add(new ObjetoFinal("Espadon", "Capa negatron", R.drawable.ic_launcher_background, "Sanguinaria", "Cura un 50% del daño infligido con ataques básicos, obtiene un 40% de robo de vida"));
        arr.add(new ObjetoFinal("Espadon", "Cinturon de gigante", R.drawable.ic_launcher_background, "Heraldo de Zeke", "al comienzo del combate todos los aliados adyacentes en una línea de dos hexágonos obtienen un 15% de velocidad de ataque"));
        arr.add(new ObjetoFinal("Espadon", "Espatula", R.drawable.ic_launcher_background, "Filo Fantasmal de Youmuu", "El portador también es un asesino, aporta un +30 de daño en ataque"));
        arr.add(new ObjetoFinal("Espadon", "Guantes de combate", R.drawable.ic_launcher_background, "Filo Infinito", "Otorga un 125% de daño crítico adicional"));
        arr.add(new ObjetoFinal("Espadon", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Sablepistola Hextech", "Cura un 25% del daño infligido, además de un 20% de daño mágico y 15% de daño en ataque"));

        //Objetos con Arco Curvo de primero
        arr.add(new ObjetoFinal("Arco Curvo", "Arco Curvo", R.drawable.ic_launcher_background, "Cañon de fuego rapido", "Duplica el alcance de los ataques básicos y estos no pueden fallar"));
        arr.add(new ObjetoFinal("Arco Curvo", "Espadon", R.drawable.ic_launcher_background, "Verdugo de gigantes", "Aplica un 5% de la vida máxima del objetivo como daño verdadero adicional en cada ataque básico"));
        arr.add(new ObjetoFinal("Arco Curvo", "Vara Innecesariamente Grande", R.drawable.ic_launcher_background, "Hoja de furia de Guinsoo", "Otorga un 5% de velocidad de ataque al atacar y se acumula sin límite"));
        arr.add(new ObjetoFinal("Arco Curvo", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Bailarin espectral", "Esquiva todos los Golpes Críticos"));
        arr.add(new ObjetoFinal("Arco Curvo", "Cinturon de gigante", R.drawable.ic_launcher_background, "Hidra titanica", "los ataques básicos infligen un 3% de la vida máxima del portador como daño adicional al objetivo y a los enemigos adyacentes"));
        arr.add(new ObjetoFinal("Arco Curvo", "Espatula", R.drawable.ic_launcher_background, "Hoja del Rey Arruinado", "El portador es también un Espadachín"));
        arr.add(new ObjetoFinal("Arco Curvo", "Guantes de combate", R.drawable.ic_launcher_background, "Ballesta de repeticion", "Cada vez que el portador mure, este objeto pasa a otro aliado. Cuando ocurra, éste gana un 20 % de velocidad de ataque y de crítico"));
        arr.add(new ObjetoFinal("Arco Curvo", "Capa negatron", R.drawable.ic_launcher_background, "Espada Maldita", "Los ataques tienen un 20% de encoger al enemigo y que reduzca el nivel de estrellas del enemigo en 1"));
        arr.add(new ObjetoFinal("Arco Curvo", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Puñal de Statikk", "Cada tercer ataque básico inflige 100 puntos de daño mágico al objetivo y a los enemigos adyacentes"));
        
        //Objetos con Vara innecesariamente Grande de primero
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Sombrero mortal de Rabadon", "Aumenta el poder de habilidad en un 50%"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Espadon", R.drawable.ic_launcher_background, "Sable-pistola hextech", "Cura un 25% del daño infligido"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Arco Curvo", R.drawable.ic_launcher_background, "Hoja de furia de Guinsoo", "Otorga un 5% de velocidad de ataque al atacar y se acumula sin límite"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Eco de Luden", "Los hechizos inflingen 180 puntos de daño mágico a todos los enemigos adyacentes al objetivo"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Medallón de los Solari de Hierro", "Al principio del combate, todos los aliados adyacentes reciben un escudo de 300 puntos"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Capa negatron", R.drawable.ic_launcher_background, "Chispa iónica", "Cuando un enemigo lanza un hechizo recibe 125 de daño"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Cinturon de gigante", R.drawable.ic_launcher_background, "Morellonomicon", "Los hechizos aplican un daño por quemadura equivalente al 20% de la vida máxima del enemigo durante 10 segundos y evita que se curen"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Espatula", R.drawable.ic_launcher_background, "Yummi", "El portador es también un Hechicero"));
        arr.add(new ObjetoFinal("Vara innecesariamente grande", "Guantes de combate", R.drawable.ic_launcher_background, "Guantele Enjoyado ", "La habilidad principal del campeón, podría hacer daño crítico"));

		//Objetos con Espatula de primero
		arr.add(new ObjetoFinal("Espatula", "Espatula", R.drawable.ic_launcher_background, "Fuerza de la naturaleza", "Aumenta el límite de unidades en 1"));
		arr.add(new ObjetoFinal("Espatula", "Espadon", R.drawable.ic_launcher_background, "Filo espectral de Youmuu", "El portador es también un Asesino y 30% daño de ataque"));
		arr.add(new ObjetoFinal("Espatula", "Arco Curvo", R.drawable.ic_launcher_background, "Hoja del Rey Arruinado", "El portador también es un Espadachín, + 40% de velocidad de ataque"));
		arr.add(new ObjetoFinal("Espatula", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Yuumi", "El portador también es un Hechicero"));
		arr.add(new ObjetoFinal("Espatula", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Darkin", "El portador también es un Demonio"));
		arr.add(new ObjetoFinal("Espatula", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Promesa de caballero", "El portador también es un Caballero"));
		arr.add(new ObjetoFinal("Espatula", "Capa negatron", R.drawable.ic_launcher_background, "Huracan de Runaan", "Los ataques básicos golpean a un objetivo adicional con un 75% del daño y aplican efectos por impactos, + 40% de resistencia mágica"));
		arr.add(new ObjetoFinal("Espatula", "Cinturon de gigante", R.drawable.ic_launcher_background, "Mazo Helado", "El portador también es un Glacial, además, aporta un + 400% puntos de vida"));
		arr.add(new ObjetoFinal("Espatula", "Guantes de combate", R.drawable.ic_launcher_background, "Mitones", "El portador también es de clase yordle, además aporta un 20% de probabilidad de esquivar y de crítico adicional"));

		//Objetos con Lagrima de la diosa de primero
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Bastón del Arcángel", "Devuelve 20 de maná cada vez que se lanza un hechizo"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Espadon", R.drawable.ic_launcher_background, "Lanza de Shojin", "Tras lanzar la habilidad especial por primera vez, los ataques básicos restauran un 15% de maná máximo adicional al atacar"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Arco Curvo", R.drawable.ic_launcher_background, "Puñal de Statikk", "Cada tercer ataque básica inflige 100 puntos de daño mágico al objetivo y a los enemigos adyacentes"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Eco de Luden", "Los hechizos inflingen 180 puntos de daño mágico a 3 enemigos adyacentes al objetivo"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Corazon Helado", "Los enemigos adyacentes pierden un 35% de Velocidad de ataque durante 1 segundo"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Capa negatron", R.drawable.ic_launcher_background, "Silencio", "Los ataques tienen un alto porcentaje de probabilidad de silenciar al objetivo e impedir que regenere maná"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Cinturon de gigante", R.drawable.ic_launcher_background, "Redencion", "Cuando la vida del portador baja al 25%, cura 1.200 puntos de salud a los aliados"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Espatula", R.drawable.ic_launcher_background, "Darkin", "El portador también es un Demonio"));
		arr.add(new ObjetoFinal("Lagrima de la diosa", "Guantes de combate", R.drawable.ic_launcher_background, "Mano de la justicia", "En el comienzo de cada turno, el portador, podría tener una de las siguientes mejores: Aumento del 40% en el daño y curación adicional por cada golpe básico"));
		
		//Objetos con Chaleco de cadenas de primero
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Malla de espinas", "Retorna al enemigo el 100% de daño amortiguado, como mágico"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Espadon", R.drawable.ic_launcher_background, "Angel de la guarda", "Al morir, revive con 500 puntos de vida"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Arco Curvo", R.drawable.ic_launcher_background, "Bailarin Especttral", "Esquiva todos los Golpes Críticos"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Medallón de los Solari de Hierro", "Al principio del combate, todos los aliados adyacentes reciben un escudo de 200 puntos"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Corazón helado", "Los enemigos adyacentes pierden un 20% de Velocidad de ataque"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Capa negatron", R.drawable.ic_launcher_background, "Rompeespadas", "Los ataques básicos tienen un 35% de probabilidad de desarmar al enemigo"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Cinturon de gigante", R.drawable.ic_launcher_background, "Mejora Roja", "Los ataques básicos infligen un 20 de la vida máxima del objetivo como daño verdadero durante 10 segundos y evitan que el enemigo se cure"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Espatula", R.drawable.ic_launcher_background, "Promesa de caballero", "El portador también es un Caballero"));
		arr.add(new ObjetoFinal("Chaleco de cadenas", "Guantes de combate", R.drawable.ic_launcher_background, "Guantele de Hielo", "Cuando se esquiva el ataque, se despliega un aura que hace que los enemigos que estén alrededor, bajen su velocidad un 30%"));
		
		//Objetos con Capa negatron de primero
		arr.add(new ObjetoFinal("Capa negatron", "Capa negatron", R.drawable.ic_launcher_background, "Garra de dragon", "Otorga un 83% de resistencia al daño mágico"));
		arr.add(new ObjetoFinal("Capa negatron", "Espadon", R.drawable.ic_launcher_background, "Sanguinaria", "Cura un 50% del daño infligido con ataques básicos"));
		arr.add(new ObjetoFinal("Capa negatron", "Arco Curvo", R.drawable.ic_launcher_background, "Espada Maldita", "Los ataques tienen un 20% de encoger al enémigo y que reduzca el nivel de estrellas del enemigo en 1"));
		arr.add(new ObjetoFinal("Capa negatron", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Chispa ionica", "Cuando un enemigo lanza un hechizo recibe 125 de daño"));
		arr.add(new ObjetoFinal("Capa negatron", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Silencio", "Los ataques tienen un alto porcentaje de probabilidad de silenciar al objetivo e impedir que regenere maná"));
		arr.add(new ObjetoFinal("Capa negatron", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Rompeespadas", "Los ataques básicos tienen un 20% de probabilidad de desarmar al enemigo"));
		arr.add(new ObjetoFinal("Capa negatron", "Cinturon de gigante", R.drawable.ic_launcher_background, "Cefiro", "Al principio del combate destierra a un enemigo durante 5 segundos"));
		arr.add(new ObjetoFinal("Capa negatron", "Espatula", R.drawable.ic_launcher_background, "Huracan de Runaan", "Los ataques básicos golpean a un objetivo adicional con un 75% del daño y aplican efectos por impactos"));
		arr.add(new ObjetoFinal("Capa negatron", "Guantes de combate", R.drawable.ic_launcher_background, "Fajin", "Previene algunos efectos que le puedan producir al personaje"));
		
		//Objetos con Cinturon de gigante de primero
		arr.add(new ObjetoFinal("Cinturon de gigante", "Cinturon de gigante", R.drawable.ic_launcher_background, "Armadura de Warmog", "Regenera un 6% de la vida máxima por segundo"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Espadon", R.drawable.ic_launcher_background, "Heraldo de Zeke", "Al comienzo del combate todos los aliados adyacentes en una línea de dos hexágonos obtienen un 15% de velocidad de ataque"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Arco Curvo", R.drawable.ic_launcher_background, "Hidra titánica", "Los ataques básicos infligen un 10% de la vida máxima del portador como daño adicional al objetivo y a los enemigos adyacentes"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Morellonomicón", "Los hechizos aplican un daño por quemadura equivalente al 20% de la vida máxima del enemigo durante 10 segundos y evita que se curen"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Redención", "Cuando la vida del portador baja al 25%, cura 1.000 puntos de salud a los aliados"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Mejora roja", "Los ataques básicos infligen un 20 de la vida máxima del objetivo como daño verdadero durante 10 segundos y evitan que el enemigo se cure"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Capa negatron", R.drawable.ic_launcher_background, "Cefiro", "Al principio del combate destierra a un enemigo durante 5 segundos"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Espatula", R.drawable.ic_launcher_background, "Mazo Helado", "El portador tambien es un Glacial"));
		arr.add(new ObjetoFinal("Cinturon de gigante", "Guantes de combate", R.drawable.ic_launcher_background, "Garra trampa", "Al inicio de cada turno, se obtiene un escudo de hechizos, quien lo rompa, quedará aturdido 5 segundos"));
		
		//Objetos con Guantes de combate de primero
		arr.add(new ObjetoFinal("Guantes de combate", "Guantes de combate", R.drawable.ic_launcher_background, "Guantes del ladron", "Se aumenta un 20% la probabilidad de esquivar y crítico. Hay algunos personajes como el campeón que no podrá llevarlo. Con el parche 9.20, se reduce la calidad media de la creación de objetos"));
		arr.add(new ObjetoFinal("Guantes de combate", "Espatula", R.drawable.ic_launcher_background, "Mitones", "El portador también es de clase yordle, además aporta un 20% de probabilidad de esquivar y de crítico adicional"));
		arr.add(new ObjetoFinal("Guantes de combate", "Espadon", R.drawable.ic_launcher_background, "Filo infinito", "Otorga un 125% de daño crítico adicional"));
		arr.add(new ObjetoFinal("Guantes de combate", "Arco Curvo", R.drawable.ic_launcher_background, "Ballesta de repetición", "Cada vez que el portador mure, este objeto pasa a otro aliado. Cuando ocurra, éste gana un 20 % de velocidad de ataque y de crítico"));
		arr.add(new ObjetoFinal("Guantes de combate", "Vara innecesariamente grande", R.drawable.ic_launcher_background, "Guantelete Enjoyado", "La habilidad principal del campeón, podría hacer daño crítico"));
		arr.add(new ObjetoFinal("Guantes de combate", "Lagrima de la diosa", R.drawable.ic_launcher_background, "Mano de la justicia", "En el comienzo de cada turno, el portador, podría tener una de las siguientes mejores: Aumento del 40% en el daño y curación adicional por cada golpe básico"));
		arr.add(new ObjetoFinal("Guantes de combate", "Chaleco de cadenas", R.drawable.ic_launcher_background, "Guantelete de Hielo", "Cuando se esquiva el ataque, se despliega un aura que hace que los enemigos que estén alrededor, bajen su velocidad un 30%"));
		arr.add(new ObjetoFinal("Guantes de combate", "Capa negatron", R.drawable.ic_launcher_background, "Fajin", "Previene algunos efectos que le puedan producir al personaje"));
		arr.add(new ObjetoFinal("Guantes de combate", "Cinturon de gigante", R.drawable.ic_launcher_background, "Garra trampa", "Al inicio de cada turno, se obtiene un escudo de hechizos, quien lo rompa, quedará aturdido 5 segundos"));
		
        return arr;
    }
}
