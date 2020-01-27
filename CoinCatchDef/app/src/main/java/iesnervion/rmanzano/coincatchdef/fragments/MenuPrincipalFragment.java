package iesnervion.rmanzano.coincatchdef.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import iesnervion.rmanzano.coincatchdef.R;
import iesnervion.rmanzano.coincatchdef.viewModel.MainViewModel;

public class MenuPrincipalFragment extends Fragment implements View.OnClickListener {
    private Button play;
    private Button stats;
    private Button change;
    private Button info;
    private MainViewModel mainViewModel;

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
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        play.setOnClickListener(this);
        info.setOnClickListener(this);
        stats.setOnClickListener(this);
        change.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jugar:
                //mainViewModel.setNickname(et.getText().toString());
                mainViewModel.setBotonPulsado(1);
                break;

            case R.id.info:
                mainViewModel.setBotonPulsado(2);
                //mainViewModel.botonElegido(1);
                break;

            case R.id.estadisticas:
                mainViewModel.setBotonPulsado(3);
                break;

            case R.id.chNickname:
                mainViewModel.setBotonPulsado(4);
                break;
        }
    }
}
