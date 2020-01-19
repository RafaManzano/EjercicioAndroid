package iesnervion.rmanzano.coincatch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iesnervion.rmanzano.coincatch.R;

public class FragmentFinalizar extends Fragment implements View.OnClickListener {
    public FragmentFinalizar() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        //Aqui se introducen los datos que se muestran a la vista

    }



    @Override
    public void onClick(View v) {

        //Quitar de aqui, excede de sus competencias
        //De momento se queda aqui hasta acabar el programa
        //getFragmentManager().beginTransaction().remove(this).commit();

        //Puede ser tambien el cambio por el ViewModelPokemon
        //Podemos usar con MutableLiveData y observar el dato en caso de cambio
        //vm.setBotonPulsado(true);

    }

}
