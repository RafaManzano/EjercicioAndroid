package iesnervion.rmanzano.coincatchdef.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatchdef.R;
import iesnervion.rmanzano.coincatchdef.classes.Item;
import iesnervion.rmanzano.coincatchdef.helps.Methods;
import iesnervion.rmanzano.coincatchdef.viewModel.MainViewModel;

public class GameFragment extends Fragment implements View.OnClickListener {

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
    private Button plantarse;
    private Methods methods = new Methods();
    private ArrayList<Item> items = new ArrayList<>();
    private TextView monedasMostrar;
    private MainViewModel mainViewModel;
    private MediaPlayer mediaplayer;
    private MediaPlayer soundplayer;


    public GameFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.game_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        //Para crear las imagenes y la logica del juego
        items = methods.randomizarLista(methods.listadeItems());

        //Los finds de los botones (18)
        todosfinds(v);


        //Para mostrar las monedas que estan capturadas
        monedasMostrar = v.findViewById(R.id.monedasgame);

        //El onclickListener de cada boton (18)
        todosclicks();


        //mainViewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //Musica de fondo
        mediaplayer = MediaPlayer.create(getActivity(), R.raw.cancionfondo);
        mediaplayer.setVolume(0.3f, 0.3f); //Con esto le ponemos un volumen mas bajo para que suene mas alto los sonidos
        mediaplayer.start(); //Iniciamos la musica

    }

    @Override
    public void onClick(View v) {
        View view =  v;

        if(v.getId() == R.id.plantarse) {
            mainViewModel.setBotonPulsado(9); //Enviamos a la actividad la pulsacion del boton "plantarse"
        }
        else {
            //Con la lista de elementos que antes hemos cargado y la clase Item elegimos la imagen para mostrar
            view.setBackgroundResource(items.get(Integer.parseInt(view.getTag().toString())).getImagen());


            switch (items.get(Integer.parseInt(view.getTag().toString())).getImagen()) { //Dependiendo del tag que tiene cada imagen

                case R.drawable.ic_moneda:
                    mainViewModel.setMonedas(mainViewModel.getMonedas() + 5);
                    soundplayer = MediaPlayer.create(getActivity(), R.raw.soundmoneda); //Sonido de moneda
                    soundplayer.start();
                    break;

                case R.drawable.ic_agujeronegro:
                    mainViewModel.setMonedas(0); //Ponemos las monedas a 0
                    mainViewModel.setBotonPulsado(6); //Enviamos a la actividad la pulsacion del boton "agujeroNegro"
                    break;

                case R.drawable.ic_luna:
                    soundplayer = MediaPlayer.create(getActivity(), R.raw.soundluna); //Sonido de luna
                    soundplayer.start();
                    break;

                case R.drawable.ic_meteorito:
                    soundplayer = MediaPlayer.create(getActivity(), R.raw.soundmeteorito); //Sonido de meteorito
                    soundplayer.start();
                    mainViewModel.setMonedas(mainViewModel.getMonedas() - 3);
                    break;

                case R.drawable.ic_cohete:
                    soundplayer = MediaPlayer.create(getActivity(), R.raw.soundnave2); //Sonido de nave
                    soundplayer.start();
                    mainViewModel.setMonedas(mainViewModel.getMonedas() * 2);
                    break;

            }

        }

        //Mostramos en la pantalla las monedas
        if(mainViewModel.getMonedas() < 0) {
            mainViewModel.setMonedas(0);
            monedasMostrar.setText( "" + mainViewModel.getMonedas());
        }
        else {
            monedasMostrar.setText("" + mainViewModel.getMonedas());
        }


    }

    /*
    Cuando el movil se pausa detenemos la musica
     */
    @Override
    public void onPause() {
        mediaplayer.pause();
        super.onPause();
    }

    /*
    Cuando el movil vuelve en primer plano, iniciamos de nuevo la musica de fondo
     */
    @Override
    public void onResume() {
        super.onResume();
        mediaplayer.start();

    }

    /*
    Con este metodo tenemos todos los findViewById fuera del onViewCreated
     */
    public void todosfinds(View v) {
        uno = v.findViewById(R.id.uno);
        dos = v.findViewById(R.id.dos);
        tres = v.findViewById(R.id.tres);
        cuatro = v.findViewById(R.id.cuatro);
        cinco = v.findViewById(R.id.cinco);
        seis = v.findViewById(R.id.seis);
        siete = v.findViewById(R.id.siete);
        ocho = v.findViewById(R.id.ocho);
        nueve = v.findViewById(R.id.nueve);
        diez = v.findViewById(R.id.diez);
        once = v.findViewById(R.id.once);
        doce = v.findViewById(R.id.doce);
        trece = v.findViewById(R.id.trece);
        catorce = v.findViewById(R.id.catorce);
        quince = v.findViewById(R.id.quince);
        dieciseis = v.findViewById(R.id.dieciseis);
        diecisiete = v.findViewById(R.id.diecisiete);
        dieciocho = v.findViewById(R.id.dieciocho);
        plantarse = v.findViewById(R.id.plantarse);
    }

    /*
    Con este metodo tenemos todos los setOnClickListener fuera del onViewCreated
     */
    public void todosclicks() {
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
        plantarse.setOnClickListener(this);
    }
}
