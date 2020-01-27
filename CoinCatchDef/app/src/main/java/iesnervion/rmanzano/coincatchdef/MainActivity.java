package iesnervion.rmanzano.coincatchdef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import iesnervion.rmanzano.coincatchdef.fragments.MenuPrincipalFragment;
import iesnervion.rmanzano.coincatchdef.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MenuPrincipalFragment menuPrincipalFragment;
    private MainViewModel mainViewModel;
    Intent intent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuPrincipalFragment = new MenuPrincipalFragment();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        context = this;

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, menuPrincipalFragment).addToBackStack(null).commit();

        //Aqui decide que hace cada boton del fragmento (1 Jugar, 2 Terminar Juego)
        mainViewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Integer pulsacion) {
                switch (pulsacion) {
                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        intent = new Intent(context, StatisticsActivity.class);
                        startActivity(intent);
                        break;

                    case 4:
                        break;
                }

            }
        });
    }


}

