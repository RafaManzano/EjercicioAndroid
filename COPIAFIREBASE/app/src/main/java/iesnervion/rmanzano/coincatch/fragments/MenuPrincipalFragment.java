package iesnervion.rmanzano.coincatch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import iesnervion.rmanzano.coincatch.R;

public class MenuPrincipalFragment {
    private Button play;
    private Button stats;
    private Button change;
    private Button info;

    public MenuPrincipalFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.menu_principal, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        play = v.findViewById(R.id.jugar);
        info = v.findViewById(R.id.info);
        stats = v.findViewById(R.id.estadisticas);
        change = v.findViewById(R.id.chNickname);
        //CoinViewModel
        //mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aceptar:
                //mainViewModel.setNickname(et.getText().toString());
                //mainViewModel.botonElegido(1);
                break;

            case R.id.cancelar:
                //mainViewModel.botonElegido(1);
                break;
        }
    }
}
