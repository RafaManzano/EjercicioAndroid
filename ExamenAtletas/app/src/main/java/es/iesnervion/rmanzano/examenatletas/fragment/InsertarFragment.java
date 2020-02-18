package es.iesnervion.rmanzano.examenatletas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.iesnervion.rmanzano.examenatletas.R;
import es.iesnervion.rmanzano.examenatletas.clases.Atleta;
import es.iesnervion.rmanzano.examenatletas.room.UsarDatabase;
import es.iesnervion.rmanzano.examenatletas.viewModel.MainViewModel;

public class InsertarFragment extends Fragment implements View.OnClickListener {
    private EditText nombre;
    private EditText apellidos;
    private EditText observaciones;
    private Button limpiar;
    private Button aceptar;
    private MainViewModel mainViewModel;


    public InsertarFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.insertar_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        nombre = v.findViewById(R.id.edNombre);
        apellidos = v.findViewById(R.id.edApellidos);
        observaciones = v.findViewById(R.id.edObs);
        limpiar = v.findViewById(R.id.limpiar);
        aceptar = v.findViewById(R.id.aceptar);

        //La instanciacion del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //SetonclickListener
        limpiar.setOnClickListener(this);
        aceptar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aceptar:
                //Eliminar la BBDD por estetica
                Atleta atleta = new Atleta();
                atleta.setNombre(nombre.getText().toString());
                atleta.setApellidos(apellidos.getText().toString());
                atleta.setObservaciones(observaciones.getText().toString());
                UsarDatabase.getDatabase(getActivity()).dao().insertarAtleta(atleta);
                Toast.makeText(getContext(), "Atleta introducido correctamente", Toast.LENGTH_LONG); //El toast no funciona
                mainViewModel.anhadirNuevoAtleta(atleta);
                limpiarForm();
                break;

            case R.id.limpiar:
                limpiarForm();
                break;
        }
    }

    //Con este metodo limpiamos los campos, lo hacemos tanto en aceotar como en limpiar
    public void limpiarForm() {
        nombre.setText("");
        apellidos.setText("");
        observaciones.setText("");
    }
}
