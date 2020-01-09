package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button piedra;
    private Button papel;
    private Button tijera;
    private ImageView imagenJug;
    private ImageView imagenMaq;
    private Estadistica estadistica;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        piedra = findViewById(R.id.piedra);
        papel = findViewById(R.id.papel);
        tijera = findViewById(R.id.tijera);
        imagenJug = findViewById(R.id.eJugador);
        imagenMaq = findViewById(R.id.eMaquina);
        estadistica = new Estadistica();
        context = this.getApplicationContext();


        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        tijera.setOnClickListener(this);



        /*
        IMPORTANTE, DE MOMENTO SE QUEDA EN EL HILO PRINCIPAL PERO DEBERIA ESTAR EN SEGUNDO PLANO
        EL ACCESO A LA BBDD
         */

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

    public void terminarPartida(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void resetearPartida(View view) {
        imagenJug.setImageResource(0);
        imagenMaq.setImageResource(0);
        desbloquearBotones();
        //howGanador.setText("");
    }

    public int[] eleccionMaquina() {
        int[] imagenes = new int[3];
        imagenes[0] = R.drawable.piedra;
        imagenes[1] = R.drawable.papel;
        imagenes[2] = R.drawable.tijera;
        return imagenes;
    }

    public int ganador(int jugador, int maquina) {
        int ganador = 0;

       switch (jugador) {
           case 0:
               //edit.putString("Jugador", "Piedra");
               estadistica.setJugador("Piedra");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       estadistica.setMaquina("Piedra");
                       ganador = 0;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       estadistica.setMaquina("Papel");
                       ganador = -1;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       estadistica.setMaquina("Tijera");
                       ganador = 1;
                       break;
               }
               break;

           case 1:
               //edit.putString("Jugador", "Papel");
               estadistica.setJugador("Papel");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       estadistica.setMaquina("Piedra");
                       ganador = 1;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       estadistica.setMaquina("Papel");
                       ganador = 0;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       estadistica.setMaquina("Tijera");
                       ganador = -1;
                       break;
               }
               break;

           case 2:
               //edit.putString("Jugador", "Tijera");
               estadistica.setJugador("Tijera");
               switch (maquina) {
                   case 0:
                       //edit.putString("Maquina", "Piedra");
                       estadistica.setMaquina("Piedra");
                       ganador = -1;
                       break;

                   case 1:
                       //edit.putString("Maquina", "Papel");
                       estadistica.setMaquina("Papel");
                       ganador = 1;
                       break;

                   case 2:
                       //edit.putString("Maquina", "Tijera");
                       estadistica.setMaquina("Tijera");
                       ganador = 0;
                       break;
               }
               break;
       }

       return ganador;
    }

    public void guardarEstadisticas(int ganador) {
        switch (ganador) {
            case 0:
                //edit.putString("Ganador", "Empate");
                estadistica.setGanador("Empate");
                break;

            case 1:
                //edit.putString("Ganador", "Jugador");
                estadistica.setGanador("Jugador");
                break;

            case -1:
                //edit.putString("Ganador", "Maquina");
                estadistica.setGanador("Maquina");
                break;
        }

        UsarDatabase.getDatabase(context).dao().insertarEstadistica(estadistica);
    }
}
