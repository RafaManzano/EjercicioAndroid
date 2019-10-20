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

import es.iesnervion.rmanzano.objetostft.clases.Metodos;
import es.iesnervion.rmanzano.objetostft.clases.Objeto;
import es.iesnervion.rmanzano.objetostft.clases.ObjetoFinal;

public class MainActivity extends AppCompatActivity {
    private ArrayList objetos = new ArrayList<Objeto>();
    private ArrayList objetosString = new ArrayList<String>();
    private ArrayList objetosCompletos = new ArrayList<ObjetoFinal>();
    private Spinner spinner;
    private AutoCompleteTextView auto;
    private TextView titulo;
    private TextView descripcion;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ArrayList de Objetos para Spinner
        objetos = Metodos.paraSpinner();


        //ArrayList de String para AutoCompleteTextView
        objetosString = Metodos.paraAutoComplete();

        //ArrayList de ObjetoFinal para facilitar la impresion del objeto completo
        objetosCompletos = Metodos.paraTextos();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter adapter = new Adapter(objetos);
        spinner = findViewById(R.id.spinner);
        auto = findViewById(R.id.edit);
        spinner.setAdapter(adapter);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, objetosString);
        auto.setThreshold(1);
        auto.setAdapter(adaptador);
        descripcion = findViewById(R.id.descripcion);
        imagen = findViewById(R.id.imagen);
        titulo = findViewById(R.id.tituloObjeto);


    }

    public void fusion(View view) {
        Objeto o1 = (Objeto) spinner.getSelectedItem();
        String o2 = auto.getText().toString();

        if(textoNoValido(o2)) {
            titulo.setText("No es correcto");
            titulo.setVisibility(View.VISIBLE);
            descripcion.setText("Ese objeto no esta disponible");
            descripcion.setVisibility(View.VISIBLE);
            imagen.setBackgroundResource(R.drawable.ic_launcher_background);
            imagen.setVisibility(View.VISIBLE);
        }
       else {
           for(Object o : objetosCompletos) {
               ObjetoFinal oF = (ObjetoFinal) o;

               if(oF.getPrimerObjeto().equalsIgnoreCase(o1.getNombre()) && oF.getSegundoObjeto().equalsIgnoreCase(o2)) {
                   titulo.setText(oF.getObjetoFinal());
                   titulo.setVisibility(View.VISIBLE);
                   descripcion.setText(oF.getDescripcion());
                   descripcion.setVisibility(View.VISIBLE);
                   imagen.setBackgroundResource(oF.getImagen());
                   imagen.setVisibility(View.VISIBLE);
               }
           }
        }
    }


    public boolean textoNoValido(String texto) {
        boolean fallido = true;

        for(int i = 0; i < objetosString.size() && fallido == true; i++) {

            if(objetosString.get(i).toString().equals(texto)) {
                fallido = false;
            }
        }

        return fallido;
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
