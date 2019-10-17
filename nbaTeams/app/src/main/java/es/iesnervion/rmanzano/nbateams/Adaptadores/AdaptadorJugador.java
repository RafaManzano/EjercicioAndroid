package es.iesnervion.rmanzano.nbateams.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.rmanzano.nbateams.Clases.Jugador;
import es.iesnervion.rmanzano.nbateams.R;

public class AdaptadorJugador extends BaseAdapter {
    private List<Jugador> jugadores;
    private Context c;
    private Jugador j;

    public AdaptadorJugador(Context c, ArrayList<Jugador> j) {
       jugadores = j;
       this.c = c;
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int i) {
        return jugadores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder;
        TextView posicion;
        TextView nombre;
        ImageView dorsal;
        j = (Jugador)getItem(i);

        if (row==null){
            //row=LayoutInflater.from(getContext()).inflate(R.layout.rowequipo, parent, false);
            LayoutInflater inflater = LayoutInflater.from(c);
            row=inflater.inflate(R.layout.rowjugador, viewGroup, false);

            dorsal = row.findViewById(R.id.dorsal);
            nombre = row.findViewById(R.id.nombreJugador);
            posicion = row.findViewById(R.id.posicion);

            holder = new ViewHolder (dorsal,nombre, posicion);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        holder.getNombre().setText(j.getNombre());
        holder.getPosicion().setText(j.getPosicion());
        holder.getDorsal().setBackgroundResource(j.getDorsal());

        return(row);
        }
    }

    class ViewHolder {
        TextView nombre;
        ImageView dorsal;
        TextView posicion;

        ViewHolder (ImageView dorsal, TextView nombre, TextView posicion){
            this.dorsal = dorsal;
            this.nombre = nombre;
            this.posicion = posicion;
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getDorsal() {
            return dorsal;
        }

        public TextView getPosicion() {
            return posicion;
        }
}


