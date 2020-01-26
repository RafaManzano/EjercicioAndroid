package iesnervion.rmanzano.coincatch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import javax.annotation.Nullable;

import iesnervion.rmanzano.coincatch.R;
import iesnervion.rmanzano.coincatch.viewModel.CoinViewModel;
import iesnervion.rmanzano.coincatch.viewModel.MainViewModel;

public class NicknameFragment extends Fragment implements View.OnClickListener {
    private EditText et;
    private Button aceptar;
    private Button cancelar;
    private MainViewModel mainViewModel;

    public NicknameFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_nickname, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        et = v.findViewById(R.id.editNick);
        aceptar = v.findViewById(R.id.aceptar);
        cancelar = v.findViewById(R.id.cancelar);
        aceptar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        //CoinViewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aceptar:
                mainViewModel.setNickname(et.getText().toString());
                mainViewModel.botonElegido(1);
                break;

            case R.id.cancelar:
                mainViewModel.botonElegido(1);
                break;
        }
    }
}
