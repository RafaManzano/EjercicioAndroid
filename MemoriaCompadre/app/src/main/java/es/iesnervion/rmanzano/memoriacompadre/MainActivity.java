package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button facil;
    Button normal;
    Button dificil;

    /*
    Para los niveles de dificultad son
        Facil: 16 cartas
        Normal: 20 Cartas
        Dificil: 30 Cartas
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        facil = findViewById(R.id.facil);
        normal = findViewById(R.id.normal);
        dificil = findViewById(R.id.dificil);

        //setting listener to button
        facil.setOnClickListener(this);
        normal.setOnClickListener(this);
        dificil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentDatos;
        switch (view.getId()) {
            case R.id.facil:
               intentDatos = new Intent(this, facilActivity.class);
               startActivity(intentDatos);
            break;

            case R.id.normal:
                intentDatos = new Intent(this, normalActivity.class);
                startActivity(intentDatos);
            break;

            case R.id.dificil:
                intentDatos = new Intent(this, dificilActivity.class);
                startActivity(intentDatos);
            break;
        }
    }
}
