package es.iesnervion.rmanzano.profesorpokemoncompadre;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments.*;
import es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private TextView pokemons;
    private TextView puntuacion;
    private ViewModelPokemon vm;

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
        pokemons = findViewById(R.id.descubiertos);
        puntuacion = findViewById(R.id.puntuacion);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        pokemons.setText(vm.getDescubierto());
        puntuacion.setText(vm.getPuntuacion());
        //viewModel
        /*
        vm = new ViewModelPokemon();
        vm = ViewModelProviders.of(this).get(ViewModelPokemon.class);


        //TODO realizar los MutableLiveData para que cuando se elija un pokemon se baje o aumente los numeros

        vm.getDatosAcambiar().observe(this, new Observer<ArrayList<Integer>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Integer> numeros) {

                pokemons.setText(pokemons.getText() + " " + numeros.get(0));
                puntuacion.setText(puntuacion.getText() + " " + numeros.get(1));
            }
        });
        */


    }

    public void ayuda(View view) {
        AyudaDialogFragment ay = new AyudaDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        ay.show(fm, "fragment_alert");
    }

    @Override
    public void onClick(View view) {
        PokemonFragment pok = new PokemonFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framel, pok).commit();
        view.setClickable(false);
        vm.modificarNumeros();
        //pokemons.setText("" + vm.getPokemon());
        //puntuacion.setText("" + vm.getPunto());
    }
}
