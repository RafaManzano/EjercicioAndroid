package iesnervion.rmanzano.masterdetails.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import iesnervion.rmanzano.masterdetails.R;
import iesnervion.rmanzano.masterdetails.viewModel.ContactoViewModel;


public class DetalleFragment extends Fragment {
    private ImageView imagen;
    private TextView texto;
    private ContactoViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detalle_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(ContactoViewModel.class);

        imagen = v.findViewById(R.id.imagenDetalle);
        texto = v.findViewById(R.id.nombreDetalle);
        imagen.setImageResource(viewModel.getContactoSeleccionado().getImagen());
        texto.setText(viewModel.getContactoSeleccionado().getNombre());

    }
}
