package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class facilActivity extends AppCompatActivity {

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

        b1.setOnClickListener(this.);
    }
}
