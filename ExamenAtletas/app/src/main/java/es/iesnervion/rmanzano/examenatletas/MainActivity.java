package es.iesnervion.rmanzano.examenatletas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceScreen;
import android.widget.FrameLayout;

import java.util.ArrayList;

import es.iesnervion.rmanzano.examenatletas.clases.Atleta;
import es.iesnervion.rmanzano.examenatletas.fragment.DetalleFragment;
import es.iesnervion.rmanzano.examenatletas.fragment.EleccionFragment;
import es.iesnervion.rmanzano.examenatletas.fragment.InsertarFragment;
import es.iesnervion.rmanzano.examenatletas.fragment.ListadoFragment;
import es.iesnervion.rmanzano.examenatletas.room.UsarDatabase;
import es.iesnervion.rmanzano.examenatletas.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private EleccionFragment eleccionFragment;
    private InsertarFragment insertarFragment;
    private ListadoFragment listadoFragment;
    private DetalleFragment detalleFragment;
    private MainViewModel mainViewModel; //Para instanciar el viewModel
    private FrameLayout fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eleccionFragment = new EleccionFragment();
        listadoFragment = new ListadoFragment();
        insertarFragment = new InsertarFragment();
        detalleFragment = new DetalleFragment();
        fr = findViewById(R.id.frameIns);


        //La instanciacion del viewModel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.setAtletas(new ArrayList<Atleta>(UsarDatabase.getDatabase(this).dao().listarAtleta()));

        if(fr != null) {
            mainViewModel.setTablet(true); //Si es true, es que estamos en una tablet
        }

        if(mainViewModel.isTablet()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameIns, insertarFragment).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameList, listadoFragment).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.frameDet, detalleFragment).commit();
        }
        else {


            getSupportFragmentManager().beginTransaction().replace(R.id.frame, eleccionFragment).addToBackStack(null).commit();

            mainViewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {
                @Override
                //Si entra en este metodo quiere decir que hay un cambio para notificar
                public void onChanged(Integer pulsacion) {
                    switch (pulsacion) {
                        case 1:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, listadoFragment).addToBackStack(null).commit();
                            break;

                        case 2:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, insertarFragment).addToBackStack(null).commit();
                            break;

                        case 3:
                            detalleFragment = new DetalleFragment(); //Con esto creamos un nuevo fragment para hacer el cambio
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, detalleFragment).addToBackStack(null).commit();
                            break;
                    }
                }
            });
        }
    }
}
