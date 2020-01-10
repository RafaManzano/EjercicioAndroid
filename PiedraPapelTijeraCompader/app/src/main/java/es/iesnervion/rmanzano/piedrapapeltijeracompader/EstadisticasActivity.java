package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class EstadisticasActivity extends AppCompatActivity {
    private TextView victorias;
    private TextView derrotas;
    private TextView empates;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        victorias = findViewById(R.id.victorias);
        derrotas = findViewById(R.id.derrotas);
        empates = findViewById(R.id.empates);
        SharedPreferences shared = this.getSharedPreferences("shared", Context.MODE_PRIVATE);
        edit = shared.edit();
        empates.setText(shared.getString("Empates", null));
        victorias.setText(shared.getString("Victorias", null));
        derrotas.setText(shared.getString("Derrotas", null));
    }

    public void reset(View view) {
        edit.putString("Derrotas", "" + 0);
        edit.putString("Empates", "" + 0);
        edit.putString("Victorias", "" + 0);
        edit.commit();
        recreate();
    }
}
