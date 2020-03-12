package iesnervion.rmanzano.coincatchdef;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatchdef.classes.Stats;
import iesnervion.rmanzano.coincatchdef.viewModel.StatsViewModel;

public class StatisticsActivity extends AppCompatActivity implements OnCheckedChangeListener {
    private ArrayList<Stats> stats;
    private ListView listEstadisitica;
    private StatsViewModel vm;
    private String level;



    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private android.widget.RadioGroup radio;

    //CollectionReference stats = db.collection("Stats");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        stats = new ArrayList<>();
        listEstadisitica = findViewById(R.id.lista);
        radio = findViewById(R.id.radiogroup);
        radio.setOnCheckedChangeListener(this);

        //Adaptador adapter = new Adaptador(stats);

        //CoinViewModel
        vm = ViewModelProviders.of(this).get(StatsViewModel.class);

        //stats.orderBy("Score", Query.Direction.ASCENDING).limit(100);

        vm.getLevel().observe(this, new Observer<String>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(String level) {
                db.collection("Stats").whereEqualTo("Level", level).orderBy("Score", Query.Direction.DESCENDING).limit(50)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("Funciona", document.getId() + " => " + document.getData());
                                        stats.add(new Stats(document.getData().get("Nickname").toString(), Integer.parseInt(document.getData().get("Score").toString())));
                                        //Aqui hacemos MutableLiveData para que cuando venga la informacion la muestre en el listado
                                    }
                                    vm.cargarListaEstadistica(stats);
                                } else {
                                    Log.w("Error", "Error getting documents.", task.getException());
                                }
                            }
                        });
            }
        });


        //Con esto se muestra la lista despues de que sea cargada
        vm.getMutableStats().observe(this, new Observer<ArrayList<Stats>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Stats> stats) {
                //Se usa el adaptador
                Adaptador adapter = new Adaptador(stats);
                listEstadisitica.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rFacil:
                vm.cambiarLevel("facil");
                break;

            case R.id.rNormal:
                vm.cambiarLevel("normal");
                break;

            case R.id.rDificil:
                vm.cambiarLevel("dificil");
                break;
        }
    }

        /*
        Es la clase Adaptador para las listas
     */

    private class Adaptador extends BaseAdapter {
        private ArrayList<Stats> estadisticas;
        private Stats estadistica;

        public Adaptador(ArrayList<Stats> estadisticas) {
            this.estadisticas = estadisticas;
        }

        @Override
        public int getCount() {
            return estadisticas.size();
        }

        @Override
        public Object getItem(int position) {
            return estadisticas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //GetView con ViewHolder
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder;
            TextView nickname;
            TextView puntuacion;
            estadistica = (Stats) getItem(position);


            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.filaestadistica, parent, false);
                nickname = row.findViewById(R.id.jugador);
                puntuacion = row.findViewById(R.id.puntuacion);

                holder = new ViewHolder(nickname, puntuacion);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }
            holder.getNickname().setText(estadistica.getNickname());
            holder.getPuntuacion().setText(estadistica.getScore().toString());

            return row;

        }
    }

    /*
    La clase ViewHolder, para poder hacer el reciclado
     */
    private class ViewHolder {
        TextView nickname;
        TextView puntuacion;

        public ViewHolder(TextView nickname, TextView puntuacion) {
            this.nickname = nickname;
            this.puntuacion = puntuacion;
        }

        public TextView getNickname() {
            return nickname;
        }

        public void setNickname(TextView nickname) {
            this.nickname = nickname;
        }

        public TextView getPuntuacion() {
            return puntuacion;
        }

        public void setPuntuacion(TextView puntuacion) {
            this.puntuacion = puntuacion;
        }
    }
}
