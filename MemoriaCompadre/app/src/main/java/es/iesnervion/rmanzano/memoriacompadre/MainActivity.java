package es.iesnervion.rmanzano.memoriacompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button facil;
    Button normal;
    Button dificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        facil = findViewById(R.id.facil);
        normal = findViewById(R.id.normal);
        dificil = findViewById(R.id.dificil);

        //setting listener to button
        facil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facil:
            break;

            case R.id.normal:
            break;

            case R.id.dificil:
            break;
        }
    }
}
