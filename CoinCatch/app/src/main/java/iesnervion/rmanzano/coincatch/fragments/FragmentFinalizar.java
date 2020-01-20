package iesnervion.rmanzano.coincatch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import iesnervion.rmanzano.coincatch.R;
import iesnervion.rmanzano.coincatch.viewModel.CoinViewModel;

public class FragmentFinalizar extends Fragment implements View.OnClickListener {
    private TextView monedasCapturadas;
    private CoinViewModel coinViewModel;
    private Button repetir;
    private Button terminar;

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
        terminar = v.findViewById(R.id.terminar);
        repetir = v.findViewById(R.id.repetir);
        monedasCapturadas = v.findViewById(R.id.mostrarMonedas);
        //coinViewModel = new CoinViewModel(); Esto no puede ser porque sino habria dos instancias
        //ViewModel
        coinViewModel = ViewModelProviders.of(getActivity()).get(CoinViewModel.class);

        if(coinViewModel.getMonedas() < 0) {
            coinViewModel.setMonedas(0);
            monedasCapturadas.setText(monedasCapturadas.getText() + " " + coinViewModel.getMonedas());
        }
        else {
            monedasCapturadas.setText(monedasCapturadas.getText() + " " + coinViewModel.getMonedas());
        }

        //onclick
        terminar.setOnClickListener(this);
        repetir.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.repetir:
                //Mandamos la pulsacion del boton a la actividad
                coinViewModel.setBotonPulsado(1);
                break;

            case R.id.terminar:
                //Mandamos la pulsacion del boton a la actividad
                coinViewModel.setBotonPulsado(2);
                break;
        }

    }

}
