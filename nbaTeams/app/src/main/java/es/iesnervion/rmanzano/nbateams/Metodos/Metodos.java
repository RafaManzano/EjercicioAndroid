package es.iesnervion.rmanzano.nbateams.Metodos;

import java.util.ArrayList;

import es.iesnervion.rmanzano.nbateams.Clases.Equipo;
import es.iesnervion.rmanzano.nbateams.Clases.Jugador;
import es.iesnervion.rmanzano.nbateams.R;

public class Metodos {
    public static ArrayList<Equipo> rellenarArrayList() {
        ArrayList equipos = new ArrayList<Equipo>();
        equipos.add(new Equipo(R.drawable.ah, "Atlanta Hawks", "EA"));
        equipos.add(new Equipo(R.drawable.cha, "Charlotte Hornets", "EA"));
        equipos.add(new Equipo(R.drawable.mia, "Miami Heat", "EA"));
        equipos.add(new Equipo(R.drawable.orl, "Orlando Magic", "EA"));
        equipos.add(new Equipo(R.drawable.was, "Whashington Wizards", "EA"));
        equipos.add(new Equipo(R.drawable.bos, "Boston Celtics", "EA"));
        equipos.add(new Equipo(R.drawable.bkn, "Brooklyn Nets", "EA"));
        equipos.add(new Equipo(R.drawable.nyk, "New York Knicks", "EA"));
        equipos.add(new Equipo(R.drawable.phi, "Philadelphia 76ERS", "EA"));
        equipos.add(new Equipo(R.drawable.tor, "Toronto Raptors", "EA"));
        equipos.add(new Equipo(R.drawable.chi, "Chicago Bulls", "EA"));
        equipos.add(new Equipo(R.drawable.cle, "Cleveland Cavaliers", "EA"));
        equipos.add(new Equipo(R.drawable.det, "Detroit Pistons", "EA"));
        equipos.add(new Equipo(R.drawable.ind, "Indiana Pacers", "EA"));
        equipos.add(new Equipo(R.drawable.mil, "Milwaukee Bucks", "EA"));
        equipos.add(new Equipo(R.drawable.dal, "Dallas Maverics", "WE"));
        equipos.add(new Equipo(R.drawable.hou, "Houston Rockets", "WE"));
        equipos.add(new Equipo(R.drawable.mem, "Memphis Grizzlies", "WE"));
        equipos.add(new Equipo(R.drawable.nop, "New Orleans Pelicans", "WE"));
        equipos.add(new Equipo(R.drawable.sas, "San Antonio Spurs", "WE"));
        equipos.add(new Equipo(R.drawable.den, "Denver Nuggets", "WE"));
        equipos.add(new Equipo(R.drawable.min, "Minnesota Timberwolves", "WE"));
        equipos.add(new Equipo(R.drawable.okc, "Oklahoma City Thunder", "WE"));
        equipos.add(new Equipo(R.drawable.por, "Portland Trail Blazers", "WE"));
        equipos.add(new Equipo(R.drawable.uta, "Utah Jazz", "WE"));
        equipos.add(new Equipo(R.drawable.gsw, "Golden State Warriors", "WE"));
        equipos.add(new Equipo(R.drawable.lac, "LA Clippers", "WE"));
        equipos.add(new Equipo(R.drawable.lal, "Los Angeles Lakers", "WE"));
        equipos.add(new Equipo(R.drawable.phx, "Phoenix Suns", "WE"));
        equipos.add(new Equipo(R.drawable.sac, "Sacramento Kings", "WE"));
        return equipos;
    }

    public static ArrayList<Jugador> rellenarArrayListJugadores(int idEquipo, ArrayList<Jugador> jugadores) {

        ArrayList jugadoresEquipo = new ArrayList<Jugador>();
        //Atlanta Hawks

        for(Object j : jugadores) {
            Jugador jug = (Jugador) j;
            if(jug.getIdEquipo() == idEquipo) {
                jugadoresEquipo.add(jug);
            }

        }
        return jugadoresEquipo;
    }

    public static ArrayList<Jugador> crearInicializarJugadores() {
        ArrayList todosJugadores = new ArrayList<Jugador>();
        //Atlanta Hawks
        todosJugadores.add(new Jugador(0, "Trae Young", "B", R.drawable.once));
        todosJugadores.add(new Jugador(0, "John Collins", "A", R.drawable.veinte));
        todosJugadores.add(new Jugador(0, "DeAndre Bembry", "A", R.drawable.noventaycinco));
        todosJugadores.add(new Jugador(0, "DeAndre Hunter", "A", R.drawable.doce));
        todosJugadores.add(new Jugador(0, "Jabari Parker", "A", R.drawable.cinco));

        //Charlotte Hornets
        todosJugadores.add(new Jugador(1, "Miles Bridges", "A", R.drawable.cero));
        todosJugadores.add(new Jugador(1, "Dwayne Bacon", "B", R.drawable.siete));
        todosJugadores.add(new Jugador(1, "Terry Rozier", "B", R.drawable.tres));
        todosJugadores.add(new Jugador(1, "PJ Washington", "A", R.drawable.venticinco));
        todosJugadores.add(new Jugador(1, "Devonte Graham", "B", R.drawable.cuatro));
        return  todosJugadores;
    }
}
