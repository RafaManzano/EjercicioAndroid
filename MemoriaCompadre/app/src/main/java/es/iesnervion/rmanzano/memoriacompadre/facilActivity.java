package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

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
    private Integer[] imagenes;
    private ImageButton[] botones;
    private String[] tags;
    private Integer puntuacion;


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

        imagenes = new Integer[]{R.drawable.uno, R.drawable.dos, R.drawable.tres, R.drawable.cuatro, R.drawable.cinco, R.drawable.seis, R.drawable.siete, R.drawable.ocho};
        botones = new ImageButton[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16};
        tags = new String [] {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho"};
        puntuacion = 0;


    }

    @Override
    public void onClick(final View view) {

        //b1.setBackgroundResource(R.drawable.ic_launcher_background);
        barajarCartas();
        /*
        if(cartaComparada1 == null) {
            cartaComparada1 = (ImageButton)view;
        }
        else {
            cartaComparada2 = (ImageButton)view;
        }

         */
        //final View v = view;
        //Con esto rotarias la carta para mostrarla
        view.animate().withLayer()
                .rotationY(90)
                .setDuration(300)
                .withEndAction(
                        new Runnable() {
                            @Override public void run() {

                                //view.setBackgroundResource(R.drawable.ic_launcher_foreground);
                                view.setBackgroundResource(imagenes[conversionStringNumero(view.getTag().toString())]);

                                // second quarter turn
                                view.setRotationY(-90);
                                view.animate().withLayer()
                                        .rotationY(0)
                                        .setDuration(300)
                                        .start();
                            }
                        }
                ).start();


        //Comprobar las cartas para ganar
        if(cartaComparada1 == null) {
            cartaComparada1 = (ImageButton)view;
        }
        else {
            cartaComparada2 = (ImageButton)view;
            if(compararCartas(cartaComparada1, cartaComparada2)) {
                puntuacion += 10;
                TextView punt = findViewById(R.id.puntuacion);
                //punt.setText(punt.getText());
            }
            else {
                cartaComparada1 = null;
                cartaComparada2 = null;
            }
        }

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
    public boolean compararCartas(final ImageButton p1, final ImageButton p2) {
        boolean igual = false;
        if(p1.getTag().toString().equals(p2.getTag().toString())) {
            igual = true;
            p1.setClickable(false);
            p2.setClickable(false);
        }
        else {
            p1.animate().withLayer()
                    .rotationY(90)
                    .setDuration(300)
                    .withEndAction(
                            new Runnable() {
                                @Override public void run() {

                                    //view.setBackgroundResource(R.drawable.ic_launcher_foreground);
                                    p1.setBackgroundResource(R.drawable.card);

                                    // second quarter turn
                                    p1.setRotationY(-90);
                                    p1.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(300)
                                            .start();
                                }
                            }
                    ).start();

            p2.animate().withLayer()
                    .rotationY(90)
                    .setDuration(300)
                    .withEndAction(
                            new Runnable() {
                                @Override public void run() {

                                    //view.setBackgroundResource(R.drawable.ic_launcher_foreground);
                                    p2.setBackgroundResource(R.drawable.card);

                                    // second quarter turn
                                    p2.setRotationY(-90);
                                    p2.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(300)
                                            .start();
                                }
                            }
                    ).start();
           //p1.setBackgroundResource(R.drawable.card);
           //p2.setBackgroundResource(R.drawable.card);
        }
        return igual;
    }

    /*

    */
    public void barajarCartas() {
        Random random = new Random();
        int numero = 0;
        for (int i = 0; i < botones.length; i++) {
            numero = random.nextInt(8);
            botones[i].setTag(tags[numero]);
            if(arrayRepetidos(botones[i].getTag().toString())) {
                botones[i].setTag("");
                i--;
            }
            //else {

            //}

        }
    }


    public boolean arrayRepetidos(String numero) {
        boolean encontrado = false;
        int repeticiones = 0;

        for (int i = 0; i < botones.length && encontrado == false; i++)
            if (botones[i].getTag().toString().equals(numero)) {
                repeticiones++;
                if (repeticiones == 3) {
                    encontrado = true;
                }
            }

        return encontrado;
    }

    public int conversionStringNumero(String tag) {
        int numero = 0;
        switch (tag) {
            case "uno":
                numero = 0;
            break;

            case "dos":
                numero = 1;
            break;

            case "tres":
                numero = 2;
            break;

            case "cuatro":
                numero = 3;
            break;

            case "cinco":
                numero = 4;
            break;

            case "seis":
                numero = 5;
            break;

            case "siete":
                numero = 6;
            break;

            case "ocho":
                numero = 7;
            break;
        }
        return numero;
    }
}
