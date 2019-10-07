package es.iesnervion.rmanzano.a3enraya;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int turno;
    //private ImageButton ib;
    private ImageButton uno;
    private ImageButton dos;
    private ImageButton tres;
    private ImageButton cuatro;
    private ImageButton cinco;
    private ImageButton seis;
    private ImageButton siete;
    private ImageButton ocho;
    private ImageButton nueve;
    private String[] tiradas;
    private TextView ganador;
    private TextView nombre;
    private String j1;
    private String j2;
    private Button replay;
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
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        replay = findViewById(R.id.replay);

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
    //SetOnClickListener para unificar los metodos de los botones

    public void uno(View view) {
        if(getTurno() == 1) {
            uno.setClickable(false);
            uno.setBackgroundResource(R.drawable.cruz);
            tiradas[0] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);
        }
        else {
            uno.setClickable(false);
            uno.setBackgroundResource(R.drawable.circulazo);
            tiradas[0] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void dos(View view) {
        if(getTurno() == 1) {
            dos.setClickable(false);
            dos.setBackgroundResource(R.drawable.cruz);
            tiradas[1] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            dos.setClickable(false);
            dos.setBackgroundResource(R.drawable.circulazo);
            tiradas[1] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void tres(View view) {
        if(getTurno() == 1) {
            tres.setClickable(false);
            tres.setBackgroundResource(R.drawable.cruz);
            tiradas[2] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            tres.setClickable(false);
            tres.setBackgroundResource(R.drawable.circulazo);
            tiradas[2] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void cuatro(View view) {
        if(getTurno() == 1) {
            cuatro.setClickable(false);
            cuatro.setBackgroundResource(R.drawable.cruz);
            tiradas[3] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            cuatro.setClickable(false);
            cuatro.setBackgroundResource(R.drawable.circulazo);
            tiradas[3] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void cinco(View view) {
        if(getTurno() == 1) {
            cinco.setClickable(false);
            cinco.setBackgroundResource(R.drawable.cruz);
            tiradas[4] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            cinco.setClickable(false);
            cinco.setBackgroundResource(R.drawable.circulazo);
            tiradas[4] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void seis(View view) {
        if(getTurno() == 1) {
            seis.setClickable(false);
            seis.setBackgroundResource(R.drawable.cruz);
            tiradas[5] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            seis.setClickable(false);
            seis.setBackgroundResource(R.drawable.circulazo);
            tiradas[5] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void siete(View view) {
        if(getTurno() == 1) {
            siete.setClickable(false);
            siete.setBackgroundResource(R.drawable.cruz);
            tiradas[6] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            siete.setClickable(false);
            siete.setBackgroundResource(R.drawable.circulazo);
            tiradas[6] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void ocho(View view) {
        if(getTurno() == 1) {
            ocho.setClickable(false);
            ocho.setBackgroundResource(R.drawable.cruz);
            tiradas[7] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            ocho.setClickable(false);
            ocho.setBackgroundResource(R.drawable.circulazo);
            tiradas[7] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    public void nueve(View view) {
        if(getTurno() == 1) {
            nueve.setClickable(false);
            nueve.setBackgroundResource(R.drawable.cruz);
            tiradas[8] = "x";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
        else {
            nueve.setClickable(false);
            nueve.setBackgroundResource(R.drawable.circulazo);
            tiradas[8] = "o";
            comprobarGanador(tiradas);
            cambioTurno(nombre);

        }
    }

    /*
    Analisis
    Necesidades: Un TextView //Se usara para modificar el turno del jugador
    Devoluciones: No hay
    Nec/Dev: No hay
    Requisitos: No hay

    Interfaz
    Nombre: cambioTurno
    Comentario: Este subprograma segun el turno escribe en el TextView nombre el jugador que tenga el turno
    Cabecera: public void cambioTurno(TextView nombre)
    Precondiciones: No hay
    Entrada: - TextView nombre
    Salida: No hay
    E/S: No hay
    Postcondiciones: Modifica dependiendo del jugador que tenga el turno su nombre.
    */

    public void cambioTurno(TextView nombre) {
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

    /*
    Analisis
    Necesidades: String[] tiradas //El array con las tiradas que han pulsado cada jugador
    Devoluciones: No hay
    Nec/Dev: No hay
    Requisitos: No hay

    Interfaz
    Nombre: comprobarGanador
    Comentario: Este subprograma muestra en el campo correspondiente el ganador de la partida
    Cabecera: public void comprobarGanador(String[] tiradas)
    Precondiciones: No hay
    Entrada: - String[] tiradas //El array con las tiradas que han pulsado cada jugador
    Salida: No hay
    E/S: No hay
    Postcondiciones: Muestra en el campo correspondiente el ganador de la partida
    */
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
                deshabilitarBotones();
                replay.setVisibility(View.VISIBLE);
                //Thread.sleep(2000);
                //finish();

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
                deshabilitarBotones();
                replay.setVisibility(View.VISIBLE);
                //Thread.sleep(2000);
                //finish();
            } else if (!comprobarArrayNoLleno(tiradas)) {
                ganador.setText("No ha habido ganador, EMPATE");
                deshabilitarBotones();
                replay.setVisibility(View.VISIBLE);
                //Thread.sleep(2000);
                //finish();
            }
        //}
        /*
        catch(InterruptedException e) {
                    e.printStackTrace();
        }
        */


    }

    /*
    Analisis
    Necesidades: String[] tiradas //El array con las tiradas que han pulsado cada jugador
    Devoluciones: Un booleano //Si la devolucion es false es que esta completo y si esta a true es
        que todavia no se ha llenado
    Nec/Dev: No hay
    Requisitos: No hay

    Interfaz
    Nombre: comprobarArrayNoLleno
    Comentario: Este subprograma devuelve un booleano dependiendo si el array esta lleno con las tiradas
     de la partida o vacio
    Cabecera: public boolean comprobarArrayNoLleno(String[] tiradas)
    Precondiciones: No hay
    Entrada: - String[] tiradas //El array con las tiradas que han pulsado cada jugador
    Salida: - boolean encontrado // Devuelve true si esta vacio y false si esta lleno
    E/S: No hay
    Postcondiciones: Asociado al nombre, devuelve true si esta vacio y false si esta lleno

    */
    public boolean comprobarArrayNoLleno(String[] tiradas) {
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
        //Se puede meter en un array de botones para hacer con un for (OPCION MAS ELEGANTE)
        uno.setClickable(false);
        dos.setClickable(false);
        tres.setClickable(false);
        cuatro.setClickable(false);
        cinco.setClickable(false);
        seis.setClickable(false);
        siete.setClickable(false);
        ocho.setClickable(false);
        nueve.setClickable(false);
    }

    public void volverJugar(View view) {
        finish();
    }
}