package es.iesnervion.rmanzano.nbateams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.rmanzano.nbateams.Adaptadores.Adaptador;
import es.iesnervion.rmanzano.nbateams.Clases.Equipo;
import es.iesnervion.rmanzano.nbateams.Metodos.Metodos;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    /*private Integer[] images;
    private String[] nombres;
    private String[] conferencias;

     */
    private ArrayList<Equipo> equipos;
    /*
    Para el equipo foto, texto y conferencia
    Jugador dorsal, nombre, nacionalidad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        Anhadir a los equipos en un arrayList y probar
         */
        equipos = Metodos.rellenarArrayList();


        /*
        images = new Integer[] {};
        nombres = new String[] {"Atlanta Hawks", "Charlotte Hornets", "Miami Heat", "Orlando Magic",
                "Whashington Wizards", "Boston Celtics", "New York Knicks", "Philadelphia 76ERS", "Toronto Raptors",
                "Chicago Bulls", "Cleveland Cavaliers", "Detroit Pistons", "Indiana Pacers", "Milwaukee Bucks",
                "Dallas Maverics", "Houston Rockets", "Memphis Grizzlies", "New Orleans Pelicans", "San Antonio Spurs",
                "Denver Nuggets", "Minnesota Timberwolves", "Oklahoma City Thunder", "Portland Trail Blazers",
                "Utah Jazz", "Atlanta Hawks", "Golden State Warriors", "LA Clippers", "Los Angeles Lakers",
                "Phoenix Suns", "Sacramento Kings"};
        conferencias = new String[] {"EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA", "EA",
                "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE", "WE"};

         */
        ListView lv = getListView();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setListAdapter(new Adaptador(this, R.layout.rowequipo, images, nombres, conferencias));
        setListAdapter(new Adaptador(this, R.layout.rowequipo, equipos));
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

}
