package es.iesnervion.rmanzano.profesorpokemoncompadre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments.AyudaDialogFragment;
import es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments.Pokemon;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private TextView pokemons;
    //private TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.boton1);
        b2 = findViewById(R.id.boton2);
        b3 = findViewById(R.id.boton3);
        b4 = findViewById(R.id.boton4);
        b5 = findViewById(R.id.boton5);
        b6 = findViewById(R.id.boton6);
        b7 = findViewById(R.id.boton7);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
    }

    public void ayuda(View view) {
        AyudaDialogFragment ay = new AyudaDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        ay.show(fm, "fragment_alert");
    }

    @Override
    public void onClick(View view) {
        Pokemon pok = new Pokemon();
        getSupportFragmentManager().beginTransaction().replace(R.id.framel, pok).commit();
        view.setClickable(false);
    }
}
