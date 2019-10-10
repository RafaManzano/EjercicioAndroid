package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Chronometer;

public class facilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Chronometer chrono = new Chronometer();
        Chronometer chrono = findViewById(R.id.chrono);
        chrono.start();
    }
}
