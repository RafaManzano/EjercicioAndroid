package es.iesnervion.rmanzano.mesafutsalcompadre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import es.iesnervion.rmanzano.mesafutsalcompadre.ViewModel.PartidoViewModel;


public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {

    private String equipo1;
    private String equipo2;
    private Chronometer chrono;
    private TextView nombreEquipo1;
    private TextView nombreEquipo2;
    private PartidoViewModel viewModel;
    private TextView golLocal;
    private TextView golVisitante;
    private TextView faltaL;
    private TextView faltaV;
    //private Button locales;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        viewModel = new PartidoViewModel();
        nombreEquipo1 = findViewById(R.id.equipo1);
        nombreEquipo2 = findViewById(R.id.equipo2);
        golLocal = findViewById(R.id.golLocal);
        golVisitante = findViewById(R.id.golVisitante);
        Bundle extras = getIntent().getExtras();
        //locales = findViewById(R.id.local);
        //SystemClock.setCurrentTimeMillis(1200000);

        equipo1 = extras.getString("j1");
        equipo2 = extras.getString("j2");
        nombreEquipo1.setText(equipo1);
        nombreEquipo2.setText(equipo2);
        faltaL = findViewById(R.id.faltasLocal);
        faltaV = findViewById(R.id.faltasLocal);
        //Cronometro
        chrono = findViewById(R.id.chrono);

        //chrono.base
        chrono.setBase(SystemClock.elapsedRealtime() + 1200000);

        //chrono.setCountDown(true);
        //chrono.start();
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel.class);

        //locales.setOnClickListener(this);


    }

    public void sumaGolLocal(View view) {
        viewModel.setGolLocal(viewModel.getGolLocal() + 1);
        golLocal.setText(viewModel.getGolLocal().toString());
    }

    public void sumaGolVisitante(View view) {
        viewModel.setGolVisitante(viewModel.getGolVisitante() + 1);
        golVisitante.setText(viewModel.getGolVisitante().toString());
    }

    public void faltaLocal(View view) {
        viewModel.setFaltaLocal(viewModel.getFaltaLocal() + 1);
        faltaL.setText(viewModel.getFaltaLocal().toString());
    }

    public void faltaVisitante(View view) {
        viewModel.setFaltaVisitante(viewModel.getFaltaVisitante() + 1);
        faltaV.setText(viewModel.getFaltaVisitante().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.local:
                sumaGolLocal(v);
            break;

            case R.id.visitante:
                sumaGolVisitante(v);
            break;

            case R.id.btnFaltasLocal:
                faltaLocal(v);
            break;

            case R.id.btnFaltasVisitante:
                faltaVisitante(v);
            break;
        }
    }
}
