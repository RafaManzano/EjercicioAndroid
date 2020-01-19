package iesnervion.rmanzano.coincatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatch.classes.Item;
import iesnervion.rmanzano.coincatch.helps.Methods;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton uno;
    private ImageButton dos;
    private ImageButton tres;
    private ImageButton cuatro;
    private ImageButton cinco;
    private ImageButton seis;
    private ImageButton siete;
    private ImageButton ocho;
    private ImageButton nueve;
    private ImageButton diez;
    private ImageButton once;
    private ImageButton doce;
    private ImageButton trece;
    private ImageButton catorce;
    private ImageButton quince;
    private ImageButton dieciseis;
    private ImageButton diecisiete;
    private ImageButton dieciocho;
    private Methods methods = new Methods();
    ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        items = methods.randomizarLista(methods.listadeItems());
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        diez = findViewById(R.id.diez);
        once = findViewById(R.id.once);
        doce = findViewById(R.id.doce);
        trece = findViewById(R.id.trece);
        catorce = findViewById(R.id.catorce);
        quince = findViewById(R.id.quince);
        dieciseis = findViewById(R.id.dieciseis);
        diecisiete = findViewById(R.id.diecisiete);
        dieciocho = findViewById(R.id.dieciocho);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        diez.setOnClickListener(this);
        once.setOnClickListener(this);
        doce.setOnClickListener(this);
        trece.setOnClickListener(this);
        catorce.setOnClickListener(this);
        quince.setOnClickListener(this);
        dieciseis.setOnClickListener(this);
        diecisiete.setOnClickListener(this);
        dieciocho.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
