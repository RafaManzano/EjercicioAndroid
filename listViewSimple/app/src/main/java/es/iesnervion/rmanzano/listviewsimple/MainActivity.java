package es.iesnervion.rmanzano.listviewsimple;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
    private static final String[] items={"Constantina", "Osuna", "Alanís de la Sierra",
            "Cazalla de la Sierra", "Villanueva del Río y Minas",
            "Olivares", "Guadalcanal", "Santiponce", "Montellano", "Villamanrique de la Condesa",
            "Estepa", "El Pedroso", "Gerena", "San Nicolás del Puerto", "Carmona",
            "Constantina", "Osuna", "Alanís de la Sierra",
            "Cazalla de la Sierra", "Villanueva del Río y Minas",
            "Olivares", "Guadalcanal", "Santiponce", "Montellano", "Villamanrique de la Condesa",
            "Estepa", "El Pedroso", "Gerena", "San Nicolás del Puerto", "Carmona",
            "Constantina", "Osuna", "Alanís de la Sierra",
            "Cazalla de la Sierra", "Villanueva del Río y Minas",
            "Olivares", "Guadalcanal", "Santiponce", "Montellano", "Villamanrique de la Condesa",
            "Estepa", "El Pedroso", "Gerena", "San Nicolás del Puerto", "Carmona",
            "Constantina", "Osuna", "Alanís de la Sierra",
            "Cazalla de la Sierra", "Villanueva del Río y Minas",
            "Olivares", "Guadalcanal", "Santiponce", "Montellano", "Villamanrique de la Condesa",
            "Estepa", "El Pedroso", "Gerena", "San Nicolás del Puerto", "Carmona"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                items));

    }
}
