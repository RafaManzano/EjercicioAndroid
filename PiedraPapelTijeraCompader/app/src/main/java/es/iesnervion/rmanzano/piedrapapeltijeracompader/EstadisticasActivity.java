package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EstadisticasActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
    }

    /*
        Es la clase Adaptador para las listas
     */

    private class Adaptador extends BaseAdapter {
        private ArrayList<Estadistica> estadisticas;
        private Estadistica estadistica;

        public Adaptador(ArrayList<Estadistica> estadisticas) {
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
            TextView jugador;
            TextView maquina;
            TextView ganador;
            estadistica = (Estadistica) getItem(position);


            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.filaestadistica, parent, false);
                jugador = row.findViewById(R.id.jugador);
                maquina = row.findViewById(R.id.maquina);
                ganador = row.findViewById(R.id.ganador);
                holder = new ViewHolder(jugador, maquina, ganador);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }
            holder.getJugador().setText(estadistica.getJugador());
            holder.getMaquina().setText(estadistica.getMaquina());
            holder.getGanador().setText(estadistica.getGanador());

            return row;

        }
    }

    /*
    La clase ViewHolder, para poder hacer el reciclado
     */
    private class ViewHolder {
        TextView jugador;
        TextView maquina;
        TextView ganador;

        public ViewHolder(TextView jugador, TextView maquina, TextView ganador) {
            this.jugador = jugador;
            this.maquina = maquina;
            this.ganador = ganador;
        }

        public TextView getJugador() {
            return jugador;
        }

        public void setJugador(TextView jugador) {
            this.jugador = jugador;
        }

        public TextView getMaquina() {
            return maquina;
        }

        public void setMaquina(TextView maquina) {
            this.maquina = maquina;
        }

        public TextView getGanador() {
            return ganador;
        }

        public void setGanador(TextView ganador) {
            this.ganador = ganador;
        }
    }
}
