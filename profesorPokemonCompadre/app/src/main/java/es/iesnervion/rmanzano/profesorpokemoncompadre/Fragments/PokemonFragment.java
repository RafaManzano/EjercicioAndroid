package es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Random;

import es.iesnervion.rmanzano.profesorpokemoncompadre.Pokemones;
import es.iesnervion.rmanzano.profesorpokemoncompadre.R;
import es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel.ViewModelPokemon;

public class PokemonFragment extends Fragment implements  View.OnClickListener {
    private EditText et;
    private Button b;
    private ImageView iv;
    private ViewModelPokemon vm;
    private Pokemones[] pokemones = Pokemones.listadoPokemones();
    private Pokemones p;
    private int numero;

    public PokemonFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.pokemon, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        Random rnd = new Random();
        p = pokemones[rnd.nextInt(25)];
        b = v.findViewById(R.id.resolver);
        et = v.findViewById(R.id.escribir);
        iv = v.findViewById(R.id.imagen);
        iv.setImageResource(p.getImagen());
        b.setOnClickListener(this);
        vm = new ViewModelPokemon();
        vm = ViewModelProviders.of(this).get(ViewModelPokemon.class);

        //TODO realizar los MutableLiveData para que cuando se elija un pokemon se baje o aumente los numeros

        vm.getDatosAcambiar().observe(this, new Observer<ArrayList<Integer>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Integer> numeros) {
               vm.setDescubierto("POKEMON ENCONTRADOS: " + numeros.get(0));
               vm.setPuntuacion("PUNTUACION: " + numeros.get(1));
            }
        });

    }



    @Override
    public void onClick(View v) {
        String respuesta = et.getText().toString();
        if(respuesta.equalsIgnoreCase(p.getNombre())) {
            vm.setPunto(vm.getPunto()+1);
        }

        vm.setPokemon(vm.getPokemon() - 1);

        vm.modificarNumeros();
        //Quitar de aqui, excede de sus competencias
        //De momento se queda aqui hasta acabar el programa
        getFragmentManager().beginTransaction().remove(this).commit();

        //Puede ser tambien el cambio por el ViewModelPokemon
        //Podemos usar con MutableLiveData y observar el dato en caso de cambio

    }


    /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof )
    }
    */

}
