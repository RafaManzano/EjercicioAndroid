package iesnervion.rmanzano.coincatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import iesnervion.rmanzano.coincatch.classes.Stats;

public class StatisticsActivity extends AppCompatActivity {
    private ArrayList<Stats> estadisticas;
    private ListView listEstadisitica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        estadisticas = new ArrayList<>();
        listEstadisitica = findViewById(R.id.lista);
        Adaptador adapter = new Adaptador(estadisticas);
        listEstadisitica.setAdapter(adapter);
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
            holder.getPuntuacion().setText(estadistica.getScore());

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
