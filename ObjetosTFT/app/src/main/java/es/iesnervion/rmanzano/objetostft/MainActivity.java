package es.iesnervion.rmanzano.objetostft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.objetostft.clases.Objeto;

public class MainActivity extends AppCompatActivity {
    private ArrayList objetos = new ArrayList<Objeto>();
    private ArrayList objetosString = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Objetos Adapter Personalizado para el Spinner
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Espadon"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Arco Curvo"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Vara Innecesariamente Grande"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Lagrima de la Diosa"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Chaleco de cadenas"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Capa Negatron"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Cinturon de Gigante"));
        objetos.add(new Objeto(R.drawable.ic_launcher_background, "Espatula"));

        //Array Adapter para el AutoCompleteTextView
        objetosString.add("Espadon");
        objetosString.add("Arco Curvo");
        objetosString.add("Vara Innecesariamente Grande");
        objetosString.add("Lagrima de la Diosa");
        objetosString.add("Chaleco de cadenas");
        objetosString.add("Capa Negatron");
        objetosString.add("Cinturon de Gigante");
        objetosString.add("Espatula");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter adapter = new Adapter(objetos);
        Spinner spinner = findViewById(R.id.spinner);
        AutoCompleteTextView auto = findViewById(R.id.edit);
        spinner.setAdapter(adapter);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, objetosString);
        auto.setThreshold(1);
        auto.setAdapter(adaptador);



    }

    //Adaptador del Spinner
    public class Adapter extends BaseAdapter implements SpinnerAdapter {
        private ArrayList<Objeto> objetos;
        private Objeto obj;

        public Adapter(ArrayList<Objeto> objetos) {
            this.objetos = objetos;
        }

        @Override
        public int getCount() {
            return objetos.size();
        }

        @Override
        public Objeto getItem(int position) {
            return objetos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return null;
            View row = convertView;
            ViewHolder holder;
            TextView nombre;
            ImageView imagen;
            obj = getItem(position);

            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.rowspinner, parent, false);
                nombre = row.findViewById(R.id.nombreObjeto);
                imagen = row.findViewById(R.id.imagen);
                holder = new ViewHolder(imagen, nombre);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }

            holder.getImagen().setBackgroundResource(obj.getImagen());
            holder.getNombre().setText(obj.getNombre());

            return row;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            //return null;
            View row = convertView;
            ViewHolder holder;
            TextView nombre;
            ImageView imagen;
            obj = getItem(position);

            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.rowspinner, parent, false);
                nombre = row.findViewById(R.id.nombreObjeto);
                imagen = row.findViewById(R.id.imagen);
                holder = new ViewHolder(imagen, nombre);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }

            holder.getImagen().setBackgroundResource(obj.getImagen());
            holder.getNombre().setText(obj.getNombre());

            return row;
        }

    }

    //TODO Realizar un metodo que pase los layout

    //Adaptador de AutoCompleteTextView
    /*
    public class AdapterAutoComplete extends BaseAdapter  {
        private ArrayList<Objeto> objetos;
        private Objeto obj;

        public AdapterAutoComplete(ArrayList<Objeto> objetos) {
            this.objetos = objetos;
        }

        @Override
        public int getCount() {
            return objetos.size();
        }

        @Override
        public Objeto getItem(int position) {
            return objetos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return null;
            View row = convertView;
            ViewHolder holder;
            TextView nombre;
            ImageView imagen;
            obj = getItem(position);

            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.rowspinner, parent, false);
                nombre = row.findViewById(R.id.nombreObjeto);
                imagen = row.findViewById(R.id.imagen);
                holder = new ViewHolder(imagen, nombre);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }

            holder.getImagen().setBackgroundResource(obj.getImagen());
            holder.getNombre().setText(obj.getNombre());

            return row;
        }


    }
     */



    public class ViewHolder {
        ImageView imagen;
        TextView nombre;

        public ViewHolder(ImageView imagen, TextView nombre) {
            this.imagen = imagen;
            this.nombre = nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }



}
