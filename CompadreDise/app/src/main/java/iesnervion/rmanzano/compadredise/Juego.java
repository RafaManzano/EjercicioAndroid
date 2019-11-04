package iesnervion.rmanzano.compadredise;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Juego extends AppCompatActivity implements View.OnClickListener {
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
    private static int ocasiones = 1;
    //Animation an;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
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
        d = this.getDrawable(R.drawable.rojo);
        base = this.getDrawable(R.drawable.blanco);
        mp = MediaPlayer.create(this, R.raw.musica);

    }

    @Override
    protected void onResume() {
        super.onResume();
        empezarMusica(mp);
        realizarTransicion(3);
        //realizarTransicion();
        //realizarTransicion();
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
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                base,
                d//Imagen 2
        });
        uno.setImageDrawable(td);
        td.startTransition(1500);
        td.reverseTransition(750);

    }

    public void realizarTransicion(int veces) {
        Random random = new Random();
        final ImageButton b = botones[random.nextInt(botones.length)];
        b.animate().setListener(new Animator.AnimatorListener() {
    @Override
    public void onAnimationStart(Animator animation) {

        TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                base,
                d//Imagen 2
        });
        b.setImageDrawable(td);
        td.startTransition(5000);
        td.reverseTransition(5000);
        ocasiones++;
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        realizarTransicion(ocasiones);
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
});
        /*
        final Random random = new Random();
        ImageButton b = botones[random.nextInt(botones.length)];
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                base,
                d//Imagen 2
        });
        b.setImageDrawable(td);
        td.startTransition(5000);
        td.reverseTransition(5000);
        ocasiones++;
        if(isFinishing()) {
            realizarTransicion(ocasiones);
        }
        */

        /*
        Random random = new Random();
        for(int i = 0; i < veces; i++) {
            ImageButton b = botones[random.nextInt(botones.length)];
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                    base,
                    d//Imagen 2
            });
            b.setImageDrawable(td);
            td.startTransition(5000);
            td.reverseTransition(5000);
            TransitionSet ts = new TransitionSet();
            ts.setStartDelay(1000);
        }
        */
    }
/*
    public void realizarTransicion(final int veces) {
        //Sirve para hacer la transicion de la foto imagen a otra
        Transition transition = getWindow().getSharedElementEnterTransition();
        transition.addTarget(android.R.transition.slide_top);
        transition.addListener(new Transition.TransitionListener() {

            Random random = new Random();

            @Override
            public void onTransitionStart(Transition transition) {
                ImageButton b = botones[random.nextInt(botones.length)];
                TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                        base,
                        d//Imagen 2
                });
                b.setImageDrawable(td);
                td.startTransition(5000);
                td.reverseTransition(5000);
                ocasiones++;
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                if (ocasiones <= veces) {
                    realizarTransicion(veces);
                }
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });


        //td.setCrossFadeEnabled(false);
            /*
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             */


    //}

    public void empezarMusica(MediaPlayer mp) {
        //MediaPlayer mp = MediaPlayer.create(this, R.raw.musica);
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }
    }
}

/*
AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.setOneShot(true);
            animationDrawable.start();

    Animation animation = AnimationUtils.loadAnimation(YourActivity.this, android.R.anim.fade_in);

    imageView.setAnimation(animation);
        animation.start();
        animation.setAnimationListener(new Animation.AnimationListener() {
          @Override
          public void onAnimationStart(Animation animation) {
          }
          @Override
          public void onAnimationEnd(Animation animation) {
              Animation fadeOut = AnimationUtils.loadAnimation(YourActivity.this, android.R.anim.fade_out);
              imageView.startAnimation(fadeOut);
          }
          @Override
          public void onAnimationRepeat(Animation animation) {
          }
});
 */
