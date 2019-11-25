package es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

import es.iesnervion.rmanzano.profesorpokemoncompadre.Pokemones;
import es.iesnervion.rmanzano.profesorpokemoncompadre.R;
import es.iesnervion.rmanzano.profesorpokemoncompadre.ViewModel.ViewModel;

public class Pokemon extends Fragment implements  View.OnClickListener {
    private EditText et;
    private Button b;
    private ImageView iv;
    private ViewModel vm = new ViewModel();
    private Pokemones[] pokemones = Pokemones.listadoPokemones();
    private Pokemones p;
    private int numero;

    public Pokemon() {

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
    }

    @Override
    public void onClick(View v) {
        String respuesta = et.getText().toString();
        if(respuesta.equalsIgnoreCase(p.getNombre())) {
            vm.setPunto(vm.getPunto()+1);
        }

        //Quitar de aqui, excede de sus competencias
        getFragmentManager().beginTransaction().remove(this).commit();

        //Puede ser tambien el cambio por el ViewModel
        //botonPulsado.shinx

    }


    /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof )
    }
    */

}
