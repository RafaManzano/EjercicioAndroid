package iesnervion.rmanzano.masterdetails.fragments;

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
import androidx.lifecycle.ViewModelProviders;

import iesnervion.rmanzano.masterdetails.R;
import iesnervion.rmanzano.masterdetails.clases.Contacto;
import iesnervion.rmanzano.masterdetails.viewModel.ContactoViewModel;

public class InsertarFragment extends Fragment implements View.OnClickListener {
    private ImageView imagen;
    private EditText texto;
    private ContactoViewModel viewModel;
    private Contacto contacto;
    private Button guardar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.insertar_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(ContactoViewModel.class);
        contacto = new Contacto();

        guardar = v.findViewById(R.id.guardar);
        texto = v.findViewById(R.id.editNombre);
        guardar = v.findViewById(R.id.guardar);

        guardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        contacto.setImagen(R.drawable.cincuenta);
        contacto.setNombre(texto.getText().toString());
        viewModel.anhadirNuevoContacto(contacto);
        viewModel.setBotonPulsado(3);
    }
}
