package es.iesnervion.rmanzano.universosuperheroes.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.universosuperheroes.Metodos.Metodos;
import es.iesnervion.rmanzano.universosuperheroes.R;
import es.iesnervion.rmanzano.universosuperheroes.Clases.Companhia;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    /*
    Esto no se pone aqui pero por simpleza se queda aqui
     */
    private ArrayList<Companhia> companhias = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        companhias = Metodos.obtenerCompanhias();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adaptador adapter = new Adaptador(companhias);
        setListAdapter(adapter);
        ListView lv = getListView();
        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), PersonajesActivity.class);
        intent.putExtra("id", i);
        startActivity(intent);
    }

    private class Adaptador extends BaseAdapter {
        private ArrayList<Companhia> companhias;
        private Companhia companhia;

        public Adaptador(ArrayList<Companhia> companhias) {
            this.companhias = companhias;
        }


        @Override
        public int getCount() {
            return companhias.size();
        }

        @Override
        public Object getItem(int i) {
            return companhias.get(i);
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
            companhia = (Companhia) getItem(i);

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

            holder.getImagen().setBackgroundResource(companhia.getImagen());
            holder.getNombre().setText(companhia.getNombre());

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
