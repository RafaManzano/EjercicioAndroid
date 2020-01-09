package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button piedra;
    private Button papel;
    private Button tijera;
    private ImageView imagenJug;
    private ImageView imagenMaq;
    private TextView howGanador;
    //SharedPreferences
    SharedPreferences shared;
    SharedPreferences.Editor edit;
    ViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //SharedPreferences
        shared = this.getSharedPreferences("shared", Context.MODE_PRIVATE);
        edit = shared.edit();

        //ViewModel
        vm = new ViewModel();

        //Cogeremos los datos del sharedPreferences para mantener la persistencia de los datos
        vm.setEmpates(Integer.parseInt(shared.getString("Empates", null)));
        vm.setVictorias(Integer.parseInt(shared.getString("Victorias", null)));
        vm.setDerrotas(Integer.parseInt(shared.getString("Derrotas", null)));

        piedra = findViewById(R.id.piedra);
        papel = findViewById(R.id.papel);
        tijera = findViewById(R.id.tijera);
        imagenJug = findViewById(R.id.eJugador);
        imagenMaq = findViewById(R.id.eMaquina);
        howGanador = findViewById(R.id.howganador);

        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        tijera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Random random = new Random();
        int[] imagenes = eleccionMaquina();
        int numeroMaq = random.nextInt(3);
        int numeroJug = 0;
        switch (view.getId()) {
            case R.id.piedra:
                imagenJug.setImageResource(R.drawable.piedra);
                numeroJug = 0;
                imagenMaq.setImageResource(imagenes[numeroMaq]);
                break;

            case R.id.papel:
                imagenJug.setImageResource(R.drawable.papel);
                imagenMaq.setImageResource(imagenes[numeroMaq]);
                numeroJug = 1;
                break;

            case R.id.tijera:
                imagenJug.setImageResource(R.drawable.tijera);
                imagenMaq.setImageResource(imagenes[numeroMaq]);
                numeroJug = 2;
                break;
        }
        //bloquearBotones
        bloquearBotones();
        guardarEstadisticas(ganador(numeroJug, numeroMaq));
    }

    /*
    Este metodo se usa para cuando termine la partida, es decir el jugador y la maquina han elegido
    asi, no se pueden volver a usar los botones
     */
    public void bloquearBotones() {
        piedra.setClickable(false);
        papel.setClickable(false);
        tijera.setClickable(false);
    }

    /*
    Se usa cuando se pulsa el boton de volver a jugar para que se puedan pulsar los botones de nuevo
     */
    public void desbloquearBotones() {
        piedra.setClickable(true);
        papel.setClickable(true);
        tijera.setClickable(true);
    }

    /*
    Se usa para terminar las partidas y volver a la pantalla principal
     */
    public void terminarPartida(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    /*
    Con este boton se vuelve a jugar otra partida
     */
    public void resetearPartida(View view) {
        /*
        Intent intent = new Intent(this, JuegoActivity.class);
        finish();
        startActivity(intent);

         */
        //recreate(); //API 11 se resetea completamente la actividad (Borra ViewModel)
        imagenJug.setImageResource(0);
        imagenMaq.setImageResource(0);
        desbloquearBotones();
        howGanador.setText("");
    }

    /*
    Son las imagenes para la eleccion de la maquina
     */
    public int[] eleccionMaquina() {
        int[] imagenes = new int[3];
        imagenes[0] = R.drawable.piedra;
        imagenes[1] = R.drawable.papel;
        imagenes[2] = R.drawable.tijera;
        return imagenes;
    }

    /*
    Devolvemos el ganador de la partida
     */
    public int ganador(int jugador, int maquina) {
        int ganador = 0;

       switch (jugador) {
           case 0:
               //edit.putString("Jugador", "Piedra");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       ganador = 0;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       ganador = -1;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       ganador = 1;
                       break;
               }
               break;

           case 1:
               //edit.putString("Jugador", "Papel");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       ganador = 1;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       ganador = 0;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       ganador = -1;
                       break;
               }
               break;

           case 2:
               //edit.putString("Jugador", "Tijera");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       ganador = -1;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       ganador = 1;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       ganador = 0;
                       break;
               }
               break;
       }

       return ganador;
    }

    /*
    Se guardan las estadisticas dependiendo del ganador, se guarda en el sharedPreferences
     */
    public void guardarEstadisticas(int ganador) {
        switch (ganador) {
            case 0:
                vm.setEmpates(vm.getEmpates() + 1);
                edit.putString("Empates", "" + vm.getEmpates());
                edit.commit();
                howGanador.setText("EMPATE");
                howGanador.setTextColor(Color.BLUE);
                break;

            case 1:
                vm.setVictorias(vm.getVictorias() + 1);
                edit.putString("Victorias", "" + vm.getVictorias());
                edit.commit();
                howGanador.setText("VICTORIA");
                howGanador.setTextColor(Color.GREEN);
                break;

            case -1:
                vm.setDerrotas(vm.getDerrotas() + 1);
                edit.putString("Derrotas", "" + vm.getDerrotas());
                edit.commit();
                howGanador.setText("DERROTA");
                howGanador.setTextColor(Color.RED);
                break;
        }
    }
}
