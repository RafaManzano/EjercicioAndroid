package es.iesnervion.rmanzano.profesorpokemoncompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments.Pokemon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prueba1(View view) {
        Pokemon pok = new Pokemon();
        getSupportFragmentManager().beginTransaction().add(R.id.framel, pok).commit();
    }
}
