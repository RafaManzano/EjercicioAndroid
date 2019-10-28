package es.iesnervion.rmanzano.compadredise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton uno;
    private ImageButton dos;
    private ImageButton tres;
    private ImageButton cuatro;
    private ImageButton cinco;
    private ImageButton push;
    private ImageButton[] botones;
    Drawable d;
    Drawable base;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);

        botones = new ImageButton[]{uno, dos, tres, cuatro, cinco};

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        //push.setOnClickListener(this);
        d = this.getDrawable(R.drawable.circulo);
        base = this.getDrawable(R.drawable.ic_launcher_background);
        mp = MediaPlayer.create(this, R.raw.musica);

    }

    @Override
    protected void onResume() {
        super.onResume();
        empezarMusica(mp);
        realizarTransicion(3);
        //empezarMusica(mp);
    }

    /*
    @Override
    protected void onResume(Bundle saveInstanceState) {
        realizarTransicion(3);
    }
    */


    @Override
    public void onClick(View view) {
        //Sirve para hacer la transicion de la foto imagen a otra
        uno = (ImageButton) view;
        TransitionDrawable td = new TransitionDrawable( new Drawable [] {
               base,
               d//Imagen 2
        });
        uno.setImageDrawable(td);
        td.startTransition(1500);
        td.reverseTransition(750);

    }

    public void realizarTransicion(int veces) {
        //Sirve para hacer la transicion de la foto imagen a otra
        Random random = new Random();
        for (int i = 0; i < veces; i++) {
            ImageButton b = botones[random.nextInt(botones.length)];
            TransitionDrawable td = new TransitionDrawable( new Drawable [] {
                    base,
                    d//Imagen 2
            });
            b.setImageDrawable(td);
            td.startTransition(5000);
            td.reverseTransition(5000);
        }
    }

    public void empezarMusica(MediaPlayer mp) {
        //MediaPlayer mp = MediaPlayer.create(this, R.raw.musica);
        if(mp.isPlaying()) {
            mp.pause();
        }
        else {
            mp.start();
        }



    }
}
