package es.iesnervion.rmanzano.profesorpokemoncompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalPantalla extends AppCompatActivity {

    private Integer puntos;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_pantalla);
        texto = findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        puntos = extras.getInt("puntos");
        texto.setText(texto.getText().toString() + puntos);

    }
}
