package es.iesnervion.rmanzano.mesafutsalcompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;


public class JuegoActivity extends AppCompatActivity {
    private String equipo1;
    private String equipo2;
    private Chronometer chrono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Bundle extras = getIntent().getExtras();
        //SystemClock.setCurrentTimeMillis(1200000);

        equipo1 = extras.getString("j1");
        equipo2 = extras.getString("j2");
        chrono = findViewById(R.id.chrono);

        //chrono.base
        chrono.setBase(SystemClock.elapsedRealtime() + 1200000);

        //chrono.setCountDown(true);
        chrono.start();

    }
}
