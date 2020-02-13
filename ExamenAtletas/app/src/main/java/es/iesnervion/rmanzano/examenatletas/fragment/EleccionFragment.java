package es.iesnervion.rmanzano.examenatletas.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.iesnervion.rmanzano.examenatletas.R;
import es.iesnervion.rmanzano.examenatletas.viewModel.MainViewModel;

public class EleccionFragment extends Fragment implements View.OnClickListener {
    private Button listar;
    private Button insertar;
    private MainViewModel mainViewModel; //Para instanciar el viewModel

    public EleccionFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.eleccion_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        listar = v.findViewById(R.id.bListar);
        insertar = v.findViewById(R.id.bInsertar);

        //La instanciacion del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //SetonclickListener
        listar.setOnClickListener(this);
        insertar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bListar:
                //Pulsa el boton de listar
                mainViewModel.botonElegido(1);
                break;

            case R.id.bInsertar:
                //Pulsa el boton de insertar
                mainViewModel.botonElegido(2);
                break;
        }
    }
}
