package es.iesnervion.rmanzano.universosuperheroes.Activity;


import android.app.ListActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.universosuperheroes.Metodos.Metodos;
import es.iesnervion.rmanzano.universosuperheroes.R;
import es.iesnervion.rmanzano.universosuperheroes.Clases.Personaje;

public class PersonajesActivity extends ListActivity {

    /*
    Esto no se pone aqui pero por simpleza se queda aqui
     */
    private ArrayList<Personaje> personajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();
        int id = datos.getInt("id");
        personajes = Metodos.obtenerPersonajePorCompanhia(id);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adaptador adapter = new Adaptador(personajes);
        setListAdapter(adapter);
    }

    private class Adaptador extends BaseAdapter {
        private ArrayList<Personaje> personajes;
        private Personaje personaje;

        public Adaptador(ArrayList<Personaje> personajes) {
            this.personajes = personajes;
        }


        @Override
        public int getCount() {
            return personajes.size();
        }

        @Override
        public Object getItem(int i) {
            return personajes.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;
            ViewHolder holder;
            TextView texto;
            ImageView imagen;
            personaje = (Personaje) getItem(i);

            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, viewGroup, false);
                texto = row.findViewById(R.id.texto);
                imagen = row.findViewById(R.id.imagen);
                holder = new ViewHolder(imagen, texto);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }

            holder.getImagen().setBackgroundResource(personaje.getImagen());
            holder.getNombre().setText(personaje.getApodo());

            return row;
        }
    }

    private class ViewHolder {
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
