package iesnervion.rmanzano.coincatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import iesnervion.rmanzano.coincatch.fragments.FragmentFinalizar;
import iesnervion.rmanzano.coincatch.fragments.InfoDialogFragment;
import iesnervion.rmanzano.coincatch.fragments.NicknameFragment;
import iesnervion.rmanzano.coincatch.viewModel.CoinViewModel;
import iesnervion.rmanzano.coincatch.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    //private MainViewModel mainViewModel;
    //private NicknameFragment nicknameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        /*
        //CoinViewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //Fragment
        nicknameFragment = new NicknameFragment();

        //Aqui decide que hace cada boton del fragmento (1 Repetir Juego, 2 Terminar Juego)
        mainViewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Integer pulsacion) {
                    getSupportFragmentManager().beginTransaction().remove(nicknameFragment).commit();

            }
        });
    }

    public void play(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void statistics(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void info(View view) {
        InfoDialogFragment ay = new InfoDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        ay.show(fm, "fragment_alert");
    }

    public void cambiarNombre(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framel, nicknameFragment).commit();
    }
    */

}
