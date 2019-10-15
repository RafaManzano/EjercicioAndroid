package es.iesnervion.rmanzano.nbateams.Metodos;

import java.util.ArrayList;

import es.iesnervion.rmanzano.nbateams.Clases.Equipo;
import es.iesnervion.rmanzano.nbateams.R;

public class Metodos {
    public static ArrayList<Equipo> rellenarArrayList() {
        ArrayList<Equipo> equipos = null;
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Atlanta Hawks", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Charlotte Hornets", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Miami Heat", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Orlando Magic", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Whashington Wizards", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Boston Celtics", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Brooklyn Nets", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "New York Knicks", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Philadelphia 76ERS", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Toronto Raptors", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Chicago Bulls", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Cleveland Cavaliers", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Detroit Pistons", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Indiana Pacers", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Milwaukee Bucks", "EA"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Dallas Maverics", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Houston Rockets", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Memphis Grizzlies", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "New Orleans Pelicans", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "San Antonio Spurs", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Denver Nuggets", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Minnesota Timberwolves", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Oklahoma City Thunder", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Portland Trail Blazers", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Utah Jazz", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Golden State Warriors", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "LA Clippers", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Los Angeles Lakers", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Phoenix Suns", "WE"));
        equipos.add(new Equipo(R.drawable.ic_launcher_background, "Sacramento Kings", "WE"));
        return equipos;
    }
}
