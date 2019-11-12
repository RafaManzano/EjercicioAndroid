package es.iesnervion.rmanzano.mesafutsalcompadre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import es.iesnervion.rmanzano.mesafutsalcompadre.ViewModel.PartidoViewModel;


public class JuegoActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 1200000;

    private String equipo1;
    private String equipo2;
    private Chronometer chrono;
    private TextView nombreEquipo1;
    private TextView nombreEquipo2;
    private PartidoViewModel viewModel;
    private TextView golLocal;
    private TextView golVisitante;
    private TextView faltaL;
    private TextView faltaV;
    //private Long tiempoParado = Long.valueOf(0);
   // private Long diferencia = Long.valueOf(0);
    private CountDownTimer mCountDownTimer;
    private TextView mTextViewCountDown;
    private ListView equipoLocalTarjetas;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    //private Button locales;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Fila> filas = new ArrayList<Fila>();
        filas.add(new Fila(R.drawable.amarilla, "7"));
        filas.add(new Fila(R.drawable.roja, "2"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        viewModel = new PartidoViewModel();
        nombreEquipo1 = findViewById(R.id.equipo1);
        nombreEquipo2 = findViewById(R.id.equipo2);
        golLocal = findViewById(R.id.golLocal);
        golVisitante = findViewById(R.id.golVisitante);
        equipoLocalTarjetas = findViewById(R.id.listaLocal);
        Bundle extras = getIntent().getExtras();

        //locales = findViewById(R.id.local);
        //SystemClock.setCurrentTimeMillis(1200000);

        equipo1 = extras.getString("j1");
        equipo2 = extras.getString("j2");
        nombreEquipo1.setText(equipo1);
        nombreEquipo2.setText(equipo2);
        faltaL = findViewById(R.id.numeroFaltaLocal);
        faltaV = findViewById(R.id.numeroFaltaVisitante);
        Adaptador adapter = new Adaptador(filas);
        equipoLocalTarjetas.setAdapter(adapter);
        //Cronometro
        mTextViewCountDown = findViewById(R.id.mTextViewCountDown);

        //chrono.base
        //chrono.setBase(SystemClock.elapsedRealtime() + 1200000);

        //chrono.setCountDown(true);
        //chrono.start();
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel.class);
        mostrarNumerosViewModel();

        //locales.setOnClickListener(this);


    }

    public void sumaGolLocal(View view) {
        viewModel.setGolLocal(viewModel.getGolLocal() + 1);
        golLocal.setText(viewModel.getGolLocal().toString());
    }

    public void sumaGolVisitante(View view) {
        viewModel.setGolVisitante(viewModel.getGolVisitante() + 1);
        golVisitante.setText(viewModel.getGolVisitante().toString());
    }

    public void faltaLocal(View view) {
        viewModel.setFaltaLocal(viewModel.getFaltaLocal() + 1);
        faltaL.setText(viewModel.getFaltaLocal().toString());
    }

    public void faltaVisitante(View view) {
        viewModel.setFaltaVisitante(viewModel.getFaltaVisitante() + 1);
        faltaV.setText(viewModel.getFaltaVisitante().toString());
    }

    public void iniciarCronometro(View view) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                //viewModel.setChrono(millisUntilFinished);
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        //chrono.setBase(viewModel.getChrono() + diferencia);
        //chrono.start();
    }

    public void pararCronometro(View view) {
        mCountDownTimer.cancel();
        //tiempoParado = SystemClock.elapsedRealtime();
        //chrono.stop();
        //viewModel.setChrono(chrono.getBase());
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.local:
                sumaGolLocal(v);
            break;

            case R.id.visitante:
                sumaGolVisitante(v);
            break;

            case R.id.btnFaltasLocal:
                faltaLocal(v);
            break;

            case R.id.btnFaltasVisitante:
                faltaVisitante(v);
            break;

            case R.id.iniciar:
                iniciarCronometro(v);
            break;

            case R.id.parar:
                pararCronometro(v);
            break;
        }
    }
    */


    public void mostrarNumerosViewModel() {
        golLocal.setText(viewModel.getGolLocal().toString());
        golVisitante.setText(viewModel.getGolVisitante().toString());
        faltaL.setText(viewModel.getFaltaLocal().toString());
        faltaV.setText(viewModel.getFaltaVisitante().toString());
        //mTextViewCountDown.setText(viewModel.);
    }

    /*
        Lista heterogenea
     */

    public class Adaptador extends BaseAdapter {
        private ArrayList<Fila> filas;
        private Fila fila;

        public Adaptador(ArrayList<Fila> filas) {
            this.filas = filas;
        }

        @Override
        public int getCount() {
            return filas.size();
        }

        @Override
        public Object getItem(int position) {
            return filas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /*
        @Override
        public int getItemViewType(int position) {
            int lugar = 0;
            if((Fila)getItem(position).getFoto() == R.drawable.amarilla) {
                lugar = 1;
            }
            return lugar;
        }
        */

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder;
            TextView texto;
            ImageView imagen;
            fila = (Fila) getItem(position);


            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
                texto = row.findViewById(R.id.texto);
                imagen = row.findViewById(R.id.imagen);
                holder = new ViewHolder(imagen, texto);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }
            holder.getImagen().setBackgroundResource(fila.getFoto());
            holder.getNombre().setText(fila.getTexto());

            return row;

        }
    }

    public class ViewHolder {
        ImageView imagen;
        TextView texto;

        public ViewHolder(ImageView imagen, TextView texto) {
            this.imagen = imagen;
            this.texto = texto;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return texto;
        }
    }

}
