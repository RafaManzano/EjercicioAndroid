package iesnervion.rmanzano.coincatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatch.classes.Item;
import iesnervion.rmanzano.coincatch.fragments.FragmentFinalizar;
import iesnervion.rmanzano.coincatch.helps.Methods;
import iesnervion.rmanzano.coincatch.viewModel.CoinViewModel;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton uno;
    private ImageButton dos;
    private ImageButton tres;
    private ImageButton cuatro;
    private ImageButton cinco;
    private ImageButton seis;
    private ImageButton siete;
    private ImageButton ocho;
    private ImageButton nueve;
    private ImageButton diez;
    private ImageButton once;
    private ImageButton doce;
    private ImageButton trece;
    private ImageButton catorce;
    private ImageButton quince;
    private ImageButton dieciseis;
    private ImageButton diecisiete;
    private ImageButton dieciocho;
    private Methods methods = new Methods();
    private ArrayList<Item> items = new ArrayList<>();
    private CoinViewModel coinViewModel;
    private FragmentFinalizar finalizar;
    private TextView monedasMostrar;
    private Activity miactividad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Para crear las imagenes y la logica del juego
        items = methods.randomizarLista(methods.listadeItems());

        //Los finds de los botones (18)
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        diez = findViewById(R.id.diez);
        once = findViewById(R.id.once);
        doce = findViewById(R.id.doce);
        trece = findViewById(R.id.trece);
        catorce = findViewById(R.id.catorce);
        quince = findViewById(R.id.quince);
        dieciseis = findViewById(R.id.dieciseis);
        diecisiete = findViewById(R.id.diecisiete);
        dieciocho = findViewById(R.id.dieciocho);

        //Para mostrar las monedas que estan capturadas
        monedasMostrar = findViewById(R.id.monedasgame);

        //Cogemos la actividad para hacer un reload
        miactividad = this;

        //El onclickListener de cada boton (18)
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        diez.setOnClickListener(this);
        once.setOnClickListener(this);
        doce.setOnClickListener(this);
        trece.setOnClickListener(this);
        catorce.setOnClickListener(this);
        quince.setOnClickListener(this);
        dieciseis.setOnClickListener(this);
        diecisiete.setOnClickListener(this);
        dieciocho.setOnClickListener(this);

        //CoinViewModel
        coinViewModel = ViewModelProviders.of(this).get(CoinViewModel.class);

        //Fragment
        finalizar = new FragmentFinalizar();

        //Aqui decide que hace cada boton del fragmento (1 Repetir Juego, 2 Terminar Juego)
        coinViewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Integer pulsacion) {
                if(pulsacion == 1) {
                    getSupportFragmentManager().beginTransaction().remove(finalizar).commit();
                    finish();
                    Intent intent = new Intent(miactividad, GameActivity.class);
                    startActivity(intent);
                    //miactividad.recreate();
                }
                else {
                    getSupportFragmentManager().beginTransaction().remove(finalizar).commit();
                    finish();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        ImageView view = (ImageView) v;
        //Con la lista de elementos que antes hemos cargado y la clase Item elegimos la imagen para mostrar
        view.setBackgroundResource(items.get(Integer.parseInt(view.getTag().toString())).getImagen());
        switch (items.get(Integer.parseInt(view.getTag().toString())).getImagen()) {

            case R.drawable.moneda:
                coinViewModel.setMonedas(coinViewModel.getMonedas() + 5);
                break;

            case R.drawable.agujeronegro:
                coinViewModel.setMonedas(0);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, finalizar).commit();
                break;

            case R.drawable.luna:
                //La luna no hace nada
                break;

            case R.drawable.meteorito:
                coinViewModel.setMonedas(coinViewModel.getMonedas() - 3);
                break;

            case R.drawable.nave:
                coinViewModel.setMonedas(coinViewModel.getMonedas() * 2);
                break;
        }

        if(coinViewModel.getMonedas() < 0) {
            coinViewModel.setMonedas(0);
            monedasMostrar.setText( "" + coinViewModel.getMonedas());
        }
        else {
            monedasMostrar.setText("" + coinViewModel.getMonedas());
        }

    }


    public void plantarse(View view) {
        //Iniciar el fragmento porque el usuario se ha plantado
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, finalizar).commit();
    }

}
