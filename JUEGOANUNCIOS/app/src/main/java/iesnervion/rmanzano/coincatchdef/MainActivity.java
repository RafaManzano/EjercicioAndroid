package iesnervion.rmanzano.coincatchdef;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import iesnervion.rmanzano.coincatchdef.fragments.FinishFragment;
import iesnervion.rmanzano.coincatchdef.fragments.GameFragment;
import iesnervion.rmanzano.coincatchdef.fragments.InfoDialogFragment;
import iesnervion.rmanzano.coincatchdef.fragments.MenuPrincipalFragment;
import iesnervion.rmanzano.coincatchdef.fragments.NicknameFragment;
import iesnervion.rmanzano.coincatchdef.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MenuPrincipalFragment menuPrincipalFragment;
    private MainViewModel mainViewModel;
    private NicknameFragment nicknameFragment;
    private FinishFragment finishFragment;
    private GameFragment gameFragment;
    private Intent intent;
    private Context context;
    SharedPreferences shared;
    SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        menuPrincipalFragment = new MenuPrincipalFragment();
        nicknameFragment = new NicknameFragment();
        gameFragment = new GameFragment();
        finishFragment = new FinishFragment();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        context = this;

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, menuPrincipalFragment).commit();

        shared = this.getSharedPreferences("shared", Context.MODE_PRIVATE);
        edit = shared.edit();

        //Aqui decide que hace cada boton del fragmento (1 jugar, 2 info, 3 estadististicas, 4 cambio nombre, 5 cerrar nombre fragment, 6 Agujero Negro, 7 Repetir juego, 8 Terminar Juego)
        mainViewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Integer pulsacion) {
                switch (pulsacion) {
                    case 1:
                        if(shared.getString("Nickname", "").equals("")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, nicknameFragment).commit();
                            mainViewModel.setPulsadoJugar(true);
                        }
                        else {
                            mainViewModel.setNickname(shared.getString("Nickname", ""));
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, gameFragment).commit();
                        }
                        break;

                    case 2:
                        InfoDialogFragment ay = new InfoDialogFragment();
                        FragmentManager fm = getSupportFragmentManager();
                        ay.show(fm, "fragment_alert");
                        break;

                    case 3:
                        //getSupportFragmentManager().beginTransaction().remove(menuPrincipalFragment).commit();
                        intent = new Intent(context, StatisticsActivity.class);
                        startActivity(intent);
                        break;

                    case 4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, nicknameFragment).commit();
                        break;

                    case 5:
                        if(mainViewModel.isPulsadoJugar()) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, gameFragment).commit();
                            mainViewModel.setPulsadoJugar(false);
                        }
                        else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, menuPrincipalFragment).commit();
                        }
                        break;

                    case 6:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, finishFragment).commit();
                        break;

                    case 7:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, gameFragment).commit();
                        break;

                    case 8:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, menuPrincipalFragment).commit();
                        break;

                    case 9:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, finishFragment).commit();
                        break;

                    case 10:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, menuPrincipalFragment).commit();
                        break;
                }

            }
        });
    }

    @Override
    public void onBackPressed() {

    }

}
