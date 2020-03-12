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

public class LevelFragment extends Fragment implements View.OnClickListener {
    private Button facil;
    private Button normal;
    private Button dificil;
    private MainViewModel mainViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.level_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        //La instancia del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        facil = v.findViewById(R.id.facil);
        normal = v.findViewById(R.id.normal);
        dificil = v.findViewById(R.id.dificil);

        facil.setOnClickListener(this);
        normal.setOnClickListener(this);
        dificil.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.facil:
                mainViewModel.setLevel("facil");
                mainViewModel.setBotonPulsado(5);
                break;

            case R.id.normal:
                mainViewModel.setLevel("normal");
                mainViewModel.setBotonPulsado(5);
                break;

            case R.id.dificil:
                mainViewModel.setLevel("dificil");
                mainViewModel.setBotonPulsado(11);
                break;
        }

    }


}
