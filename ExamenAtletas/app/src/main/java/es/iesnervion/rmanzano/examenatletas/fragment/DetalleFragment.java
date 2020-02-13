package es.iesnervion.rmanzano.examenatletas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.iesnervion.rmanzano.examenatletas.R;
import es.iesnervion.rmanzano.examenatletas.viewModel.MainViewModel;

public class DetalleFragment extends Fragment {
    private MainViewModel mainViewModel; //Para instanciar el viewModel
    private TextView nombre;
    private TextView apellidos;
    private TextView observaciones;

    public DetalleFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.detalle_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        nombre = v.findViewById(R.id.nombreDetalle);
        apellidos = v.findViewById(R.id.apellidosDetalle);
        observaciones = v.findViewById(R.id.obsDetalle);

        //La instanciacion del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        nombre.setText(mainViewModel.getAtletaSeleccionado().getNombre());
        apellidos.setText(mainViewModel.getAtletaSeleccionado().getApellidos());
        observaciones.setText(mainViewModel.getAtletaSeleccionado().getObservaciones());
    }
}
