package es.iesnervion.rmanzano.productosinformatica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spin;
    private String[] elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spin);
        elementos = new String[3];
        elementos[0] = "Impresoras";
        elementos[1] = "Portatiles";
        elementos[2] = "Todos";

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,elementos);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }


    public void confirmar(View view) {
        //String g = spin.getSelectedItem().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("producto", spin.getSelectedItem().toString());
        startActivity(intent);
    }
}
