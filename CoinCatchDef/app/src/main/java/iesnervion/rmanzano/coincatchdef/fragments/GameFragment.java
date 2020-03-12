package iesnervion.rmanzano.coincatchdef.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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
    private ImageButton musica;
    private ImageButton efecto;
    SharedPreferences shared;
    SharedPreferences.Editor edit;



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
        //mainViewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //Con estos metodo ejecutamos el sharedPreferences e instanciamos el icono que queremos mostrar
        shared = getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        edit = shared.edit();
        musica = v.findViewById(R.id.musicaGame);
        musica.setImageResource(shared.getInt("FotoMusica", R.drawable.ic_musica));
        efecto = v.findViewById(R.id.efectosGame);
        efecto.setImageResource(shared.getInt("FotoEfecto", R.drawable.ic_efectos));
        if(shared.getInt("FotoEfecto", R.drawable.ic_efectos) == R.drawable.ic_efectomuted) {
            efecto.setTag("efectomuted");
            edit.putBoolean("Efecto", false);
            edit.putInt("FotoEfecto", R.drawable.ic_efectomuted);
            mainViewModel.setSonido(false);
            edit.apply();
        }
        else {
            efecto.setImageResource(R.drawable.ic_efectos);
            efecto.setTag("efecto");
            edit.putBoolean("Efecto", true);
            edit.putInt("FotoEfecto", R.drawable.ic_efectos);
            mainViewModel.setSonido(true);
            edit.apply();
        }


        //Para crear las imagenes y la logica del juego
        //Aqui definimos los niveles
        switch (mainViewModel.getLevel()) {
            case "facil":
                items = methods.listadeItemsFacil();
                break;

            case "normal":
                items = methods.listadeItemsNormal();
                break;

            case "dificil":
                items = methods.listadeItemsDificil();
                break;
        }
        items = methods.randomizarLista(items);

        //Los finds de los botones (18)
        todosfinds(v);


        //Para mostrar las monedas que estan capturadas
        monedasMostrar = v.findViewById(R.id.monedasgame);

        //El onclickListener de cada boton (18)
        todosclicks();




        //Musica de fondo
        mediaplayer = MediaPlayer.create(getActivity(), R.raw.cancionfondo);
        mediaplayer.setVolume(0.3f, 0.3f); //Con esto le ponemos un volumen mas bajo para que suene mas alto los sonidos
        mainViewModel.cambiarMusica(shared.getBoolean("Musica", true));

        //El observador para el cambio de la musica
        mainViewModel.getMusica().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Boolean musica) {
                //Se usa el adaptador
                if(musica) {
                    mediaplayer = MediaPlayer.create(getActivity(), R.raw.cancionfondo);
                    mediaplayer.start();
                }
                else {
                    mediaplayer.stop();
                }
            }
        });

        //El observador para el cambio de la sonido
        /* PIENSO QUE NO ME ES NECESARIO, PUESTO QUE EL CAMBIO NO VA EN TIEMPO REAL
        mainViewModel.getSonido().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Boolean sonido) {
                //Se usa el adaptador
                if(sonido) {
                    soundplayer.start();
                }
            }
        });
        */
    }

    @Override
    public void onClick(View v) {
        View view =  v;

        switch (view.getId()) { //Con este switch controlamos aquellos que no son los planetas
            case R.id.plantarse: //Boton plantarse
                mainViewModel.setBotonPulsado(9); //Enviamos a la actividad la pulsacion del boton "plantarse"
                break;

            case R.id.musicaGame: //Boton musicaGame
                if(musica.getTag().toString().equals("musica")) {
                    musica.setImageResource(R.drawable.ic_musicamuted);
                    musica.setTag("musicamuted");
                    edit.putBoolean("Musica", false);
                    edit.putInt("FotoMusica", R.drawable.ic_musicamuted);
                    edit.apply();
                    mainViewModel.cambiarMusica(shared.getBoolean("Musica", true));
                }
                else {
                    musica.setImageResource(R.drawable.ic_musica);
                    musica.setTag("musica");
                    edit.putBoolean("Musica", true);
                    edit.putInt("FotoMusica", R.drawable.ic_musica);
                    edit.apply();
                    mainViewModel.cambiarMusica(shared.getBoolean("Musica", true));

                }
                break;

            case R.id.efectosGame: //Boton efectosGame
                if(efecto.getTag().toString().equals("efecto")) {
                    efecto.setImageResource(R.drawable.ic_efectomuted);
                    efecto.setTag("efectomuted");
                    edit.putBoolean("Efecto", false);
                    edit.putInt("FotoEfecto", R.drawable.ic_efectomuted);
                    mainViewModel.setSonido(false);
                    edit.apply();
                }
                else {
                    efecto.setImageResource(R.drawable.ic_efectos);
                    efecto.setTag("efecto");
                    edit.putBoolean("Efecto", true);
                    edit.putInt("FotoEfecto", R.drawable.ic_efectos);
                    mainViewModel.setSonido(true);
                    edit.apply();
                }
                break;

            default: //Aquellos que no son los botones anteriores (Basicamente los planetas)
                view.setBackgroundResource(items.get(Integer.parseInt(view.getTag().toString())).getImagen());

                switch (items.get(Integer.parseInt(view.getTag().toString())).getImagen()) { //Dependiendo del tag que tiene cada imagen

                    case R.drawable.ic_moneda:
                        mainViewModel.setMonedas(mainViewModel.getMonedas() + 5);
                        soundplayer = MediaPlayer.create(getActivity(), R.raw.soundmoneda); //Sonido de moneda
                        //mainViewModel.cambiarSonido(isSonido);
                        empezarSonido();
                        break;

                    case R.drawable.ic_agujeronegro:
                        mainViewModel.setMonedas(0); //Ponemos las monedas a 0
                        mainViewModel.setBotonPulsado(6); //Enviamos a la actividad la pulsacion del boton "agujeroNegro"
                        break;

                    case R.drawable.ic_luna:
                        soundplayer = MediaPlayer.create(getActivity(), R.raw.soundluna); //Sonido de luna
                        empezarSonido();
                        //mainViewModel.cambiarSonido(isSonido);

                        break;

                    case R.drawable.ic_meteorito:
                        soundplayer = MediaPlayer.create(getActivity(), R.raw.soundmeteorito); //Sonido de meteorito
                        empezarSonido();
                        //mainViewModel.cambiarSonido(isSonido);

                        mainViewModel.setMonedas(mainViewModel.getMonedas() - 3);
                        break;

                    case R.drawable.ic_cohete:
                        soundplayer = MediaPlayer.create(getActivity(), R.raw.soundnave2); //Sonido de nave
                        empezarSonido();
                        //mainViewModel.cambiarSonido(isSonido);

                        mainViewModel.setMonedas(mainViewModel.getMonedas() * 2);
                        break;
                }

                view.setClickable(false);
                break;
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
        musica = v.findViewById(R.id.musicaGame);
        efecto = v.findViewById(R.id.efectosGame);

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
        musica.setOnClickListener(this);
        efecto.setOnClickListener(this);
    }


    public void empezarSonido() {
        if(mainViewModel.isSonido()) {
            soundplayer.start();
        }
    }


}
