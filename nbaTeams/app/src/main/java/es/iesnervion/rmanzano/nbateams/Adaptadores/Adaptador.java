package es.iesnervion.rmanzano.nbateams.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.nbateams.R;
import es.iesnervion.rmanzano.nbateams.ViewHolder.ViewHolder;
import es.iesnervion.rmanzano.nbateams.Clases.Equipo;

public class Adaptador extends ArrayAdapter <Equipo>{
    private ArrayList<Equipo> equipos;

    /*
    private Integer[] images;
    private String[] nombres;
    private String[] conferencias;

    */

    /*
    public Adaptador(Context c, int resourceId, Integer[] images, String[] nombres, String[] conferencia) {
        super(c, resourceId);
        this.images = images;
        this.nombres = nombres;
        this.conferencias = conferencia;
    }

    */
    public Adaptador(Context c, int textViewResourceId, ArrayList<Equipo> e) {
        super(c,textViewResourceId, e);
        equipos = e;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;
        ImageView imagen;
        TextView nombre;
        TextView conferencia;
        Equipo e = getItem(position);

        if (row==null){

            row=LayoutInflater.from(getContext()).inflate(R.layout.rowequipo, parent, false);

            nombre = row.findViewById(R.id.nombreEquipo);
            imagen = row.findViewById(R.id.icono);
            conferencia = row.findViewById(R.id.conferencia);
            holder = new ViewHolder (imagen,nombre, conferencia);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        holder.getNombre().setText(e.getNombre());
        holder.getConferencia().setText(e.getConferencia());
        holder.getImagen().setBackgroundResource(e.getImagen());

        return row;
    }
}


/*
class IconicAdapter<T> extends ArrayAdapter<T> {
    IconicAdapter( Context c, int resourceId, int textId, T[] objects) {
      super(c, resourceId, textId, objects);
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {

      View row = convertView;
      ViewHolder holder;
      TextView lab;
      ImageView imgV;

      if (row==null){
    	  LayoutInflater inflater=getLayoutInflater();
    	  row=inflater.inflate(R.layout.row, parent, false);

          lab = (TextView) row.findViewById(R.id.label);
          imgV = (ImageView) row.findViewById(R.id.icon);
          holder = new ViewHolder (lab,imgV);
    	  row.setTag(holder);
      }
      else{
    	  holder = (ViewHolder) row.getTag();
      }

      holder.getLab().setText(items[position]);

      if (items[position].equals("calendario")) {
        holder.getImgV().setImageResource(R.drawable.calendar48x48);
      }
      else if (items[position].equals("GPS")){
    	  holder.getImgV().setImageResource(R.drawable.compass48x48);
      }
      else if (items[position].equals("alarma")){
    	  holder.getImgV().setImageResource(R.drawable.alarm48x48);
      }
      else{
    	  holder.getImgV().setImageResource(R.drawable.delete);
      }

      return(row);
    }
  }
 */