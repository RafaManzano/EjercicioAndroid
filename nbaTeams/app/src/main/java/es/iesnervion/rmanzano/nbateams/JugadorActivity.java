package es.iesnervion.rmanzano.nbateams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.nbateams.Adaptadores.AdaptadorJugador;
import es.iesnervion.rmanzano.nbateams.Clases.Jugador;
import es.iesnervion.rmanzano.nbateams.Metodos.Metodos;

public class JugadorActivity extends AppCompatActivity {
    private ArrayList<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();
        int id = datos.getInt("id");
        jugadores = Metodos.crearInicializarJugadores();
        jugadores = Metodos.rellenarArrayListJugadores(id, jugadores);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        AdaptadorJugador adapter = new AdaptadorJugador(getApplicationContext(), jugadores);
        ListView list = findViewById(R.id.listas);
        list.setAdapter(adapter);
    }
}
