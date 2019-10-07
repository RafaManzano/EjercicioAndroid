package es.iesnervion.rmanzano.a3enraya;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int turno;
    private ImageButton ib;
    private String[] tiradas;
    private TextView ganador;
    private TextView nombre;
    private String j1;
    private String j2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] arr = {1, -1};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        turno = arr[random.nextInt(2)];
        tiradas = new String[9];
        ganador = findViewById(R.id.ganador);
        nombre = findViewById(R.id.turno);

        Bundle extras = getIntent().getExtras();

        j1 = extras.getString("j1");
        j2 = extras.getString("j2");

        if(turno == 1) {
            nombre.setText("El turno es de " + j1 );
            nombre.setTextColor(Color.RED);
        }
        else {
            nombre.setText("El turno es de " + j2 );
            nombre.setTextColor(Color.BLUE);
        }
    }

    //Tengo que comprobar si ha ganado en cada partida
    //Tambien tengo que saber de quien es el turno (1 j1 o -1 j2) con multiplicar por -1 ya sabria quien es quien
    //Tengo que modificar aquellos que no se han pulsado. Lo he solucionado con clickeable

    public void uno(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.uno);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[0] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);
        }
        else {
            ib = findViewById(R.id.uno);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[0] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void dos(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.dos);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[1] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.dos);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[1] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void tres(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.tres);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[2] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.tres);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[2] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void cuatro(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.cuatro);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[3] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.cuatro);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[3] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void cinco(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.cinco);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[4] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.cinco);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[4] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void seis(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.seis);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[5] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.seis);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[5] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void siete(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.siete);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[6] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.siete);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[6] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void ocho(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.ocho);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[7] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.ocho);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[7] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }

    public void nueve(View view) {
        if(getTurno() == 1) {
            ib = findViewById(R.id.nueve);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.cruz);
            tiradas[8] = "x";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
        else {
            ib = findViewById(R.id.nueve);
            ib.setClickable(false);
            ib.setBackgroundResource(R.drawable.circulazo);
            tiradas[8] = "o";
            comprobarGanador(tiradas);
            setTurno(nombre);

        }
    }


    public void setTurno(TextView nombre) {
        this.turno *= -1;
        if(turno == 1) {
            nombre.setText("El turno es de " + j1 );
            nombre.setTextColor(Color.RED);
        }
        else {
            nombre.setText("El turno es de " + j2 );
            nombre.setTextColor(Color.BLUE);
        }

    }

    public int getTurno() {
        return turno;
    }

    public void comprobarGanador(String[] tiradas) {
        //try {

            if (tiradas[0] == "x" && tiradas[3] == "x" && tiradas[6] == "x" ||
                    tiradas[0] == "x" && tiradas[1] == "x" && tiradas[2] == "x" ||
                    tiradas[3] == "x" && tiradas[4] == "x" && tiradas[5] == "x" ||
                    tiradas[8] == "x" && tiradas[7] == "x" && tiradas[6] == "x" ||
                    tiradas[1] == "x" && tiradas[4] == "x" && tiradas[7] == "x" ||
                    tiradas[2] == "x" && tiradas[5] == "x" && tiradas[8] == "x" ||
                    tiradas[0] == "x" && tiradas[4] == "x" && tiradas[8] == "x" ||
                    tiradas[2] == "x" && tiradas[4] == "x" && tiradas[6] == "x") {
                ganador.setText("El ganador es " + j1);
                nombre.setTextColor(Color.RED);
                //Thread.sleep(2000);
                finish();

            } else if (tiradas[0] == "o" && tiradas[3] == "o" && tiradas[6] == "o" ||
                    tiradas[0] == "o" && tiradas[1] == "o" && tiradas[2] == "o" ||
                    tiradas[3] == "o" && tiradas[4] == "o" && tiradas[5] == "o" ||
                    tiradas[8] == "o" && tiradas[7] == "o" && tiradas[6] == "o" ||
                    tiradas[1] == "o" && tiradas[4] == "o" && tiradas[7] == "o" ||
                    tiradas[2] == "o" && tiradas[5] == "o" && tiradas[8] == "o" ||
                    tiradas[0] == "o" && tiradas[4] == "o" && tiradas[8] == "o" ||
                    tiradas[2] == "o" && tiradas[4] == "o" && tiradas[6] == "o") {
                ganador.setText("El ganador es " + j2);
                nombre.setTextColor(Color.BLUE);
                //Thread.sleep(2000);
                finish();
            } else if (!comprobarArrayLleno(tiradas)) {
                ganador.setText("No ha habido ganador, EMPATE");
                //Thread.sleep(2000);
                finish();
            }
        //}
        /*
        catch(InterruptedException e) {
                    e.printStackTrace();
        }
        */


    }

    public boolean comprobarArrayLleno(String[] tiradas) {
        boolean encontrado = false;
        for(int i = 0; i < tiradas.length && encontrado == false; i++) {
            if(tiradas[i] == "" || tiradas[i] == null) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    /*
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    */

    /*
    Analisis
    Necesidades: No hay
    Devoluciones: No hay
    Nec/Dev: No hay

    Interfaz
    Nombre: deshabilitarBotones
    Comentario: Este subprograma deshabilita todas las imagenes para que no puedan usarse en caso de ganar o empatar
    Cabecera: public void deshabilitarBotones()
    Precondiciones: No hay
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: Deshabilita los botones en caso de que haya un ganador o empates
    */

    public void deshabilitarBotones() {
        ImagenButton uno = findViewById(R.id.uno);
        uno.setClickable(false);
        /*ImagenButton dos = findViewById(R.id.dos);
        ImagenButton tres = findViewById(R.id.tres);
        ImagenButton cuatro = findViewById(R.id.cuatro);
        ImagenButton cinco = findViewById(R.id.cinco);
        ImagenButton seis = findViewById(R.id.seis);
        ImagenButton siete = findViewById(R.id.siete);
        ImagenButton ocho = findViewById(R.id.ocho);
        ImagenButton nueve = findViewById(R.id.nueve);
        ib.setClickable(false);
        */
    }
}