package es.iesnervion.rmanzano.profesorpokemoncompadre.Fragments;

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

import es.iesnervion.rmanzano.profesorpokemoncompadre.R;

public class Pokemon extends Fragment implements  View.OnClickListener {
    private EditText et;
    private TextView tv;
    private Button b;
    private ImageView iv;
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
        b = v.findViewById(R.id.resolver);
        et = v.findViewById(R.id.escribir);
        tv = v.findViewById(R.id.pokemon);
        iv = v.findViewById(R.id.imagen);
        iv.setImageResource(R.drawable.shinxxx);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int punto = 0;
        String respuesta = et.getText().toString();
        if(respuesta.equalsIgnoreCase(tv.getText().toString())) {
            //Aqui guardar en el viewModel
            punto++;
        }

        getFragmentManager().beginTransaction().remove(this).commit();

    }
}
