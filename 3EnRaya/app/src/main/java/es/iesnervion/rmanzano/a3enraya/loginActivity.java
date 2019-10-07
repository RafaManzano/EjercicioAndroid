package es.iesnervion.rmanzano.a3enraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {

    private EditText j1;
    private EditText j2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        j1 = findViewById(R.id.j1ET);
        j2 = findViewById(R.id.j2ET);
    }


    public void play(View view) {
        Intent intentDatos = new Intent(this, MainActivity.class);
        intentDatos.putExtra("j1",j1.getText().toString());
        intentDatos.putExtra("j2",j2.getText().toString());
        startActivity(intentDatos);
    }
}
