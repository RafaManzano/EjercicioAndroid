package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class facilActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;
    private ImageButton b5;
    private ImageButton b6;
    private ImageButton b7;
    private ImageButton b8;
    private ImageButton b9;
    private ImageButton b10;
    private ImageButton b11;
    private ImageButton b12;
    private ImageButton b13;
    private ImageButton b14;
    private ImageButton b15;
    private ImageButton b16;
    private ImageButton cartaComparada1 = null;
    private ImageButton cartaComparada2 = null;
    private int[] imagenes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Chronometer chrono = new Chronometer();
        Chronometer chrono = findViewById(R.id.chrono);
        chrono.start();

        b1 = findViewById(R.id.ib1);
        b2 = findViewById(R.id.ib2);
        b3 = findViewById(R.id.ib3);
        b4 = findViewById(R.id.ib4);
        b5 = findViewById(R.id.ib5);
        b6 = findViewById(R.id.ib6);
        b7 = findViewById(R.id.ib7);
        b8 = findViewById(R.id.ib8);
        b9 = findViewById(R.id.ib9);
        b10 = findViewById(R.id.ib10);
        b11 = findViewById(R.id.ib11);
        b12 = findViewById(R.id.ib12);
        b13 = findViewById(R.id.ib13);
        b14 = findViewById(R.id.ib14);
        b15 = findViewById(R.id.ib15);
        b16 = findViewById(R.id.ib16);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);

        imagenes {R.drawable.c}
    }

    @Override
    public void onClick(final View view) {
        //b1.setBackgroundResource(R.drawable.ic_launcher_background);
        if(cartaComparada1 == null) {
            cartaComparada1 = (ImageButton)view;
        }
        else {
            cartaComparada2 = (ImageButton)view;
        }
        //final View v = view;
        //Con esto rotarias la carta para mostrarla
        view.animate().withLayer()
                .rotationY(90)
                .setDuration(300)
                .withEndAction(
                        new Runnable() {
                            @Override public void run() {

                                //view.setBackgroundResource(R.drawable.ic_launcher_foreground);

                                // second quarter turn
                                view.setRotationY(-90);
                                view.animate().withLayer()
                                        .rotationY(0)
                                        .setDuration(300)
                                        .start();
                            }
                        }
                ).start();

         //view.setBackgroundResource(R.drawable.ic_launcher_foreground);

    }

    /*
    Interfaz
    Nombre: compararCartas
    Comentario: Este comparador compara si las cartas levantadas son la misma o no
    Precondiciones: No hay
    Entrada: - ImageButton p1 //La primera carta a comparar
             - ImageButton p2 //La segunda carta a comparar
    Salida: - boolean igual //Si las cartas son iguales se devuelve true y si no lo son se devuelve false
    E/S: No hay
    Postcondiciones:Asociado al nombre. Se devuelve true cuando las cartas son iguales y false cuando no lo son
     */
    public boolean compararCartas(ImageButton p1, ImageButton p2) {
        boolean igual = false;
        if(p1.getTag().toString().equals(p2.getTag().toString())) {
            igual = true;
        }
        return igual;
    }

}
