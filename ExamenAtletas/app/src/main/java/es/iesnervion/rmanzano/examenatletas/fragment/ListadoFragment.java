package es.iesnervion.rmanzano.examenatletas.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.rmanzano.examenatletas.R;
import es.iesnervion.rmanzano.examenatletas.clases.Atleta;
import es.iesnervion.rmanzano.examenatletas.room.UsarDatabase;
import es.iesnervion.rmanzano.examenatletas.viewModel.MainViewModel;

public class ListadoFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Atleta> atletas;
    private ListView listView;
    private MainViewModel mainViewModel;
    private DetalleFragment detalleFragment;

    public ListadoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.listado_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {

        //La instanciacion del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        listView = v.findViewById(R.id.lista);
        Adaptador adapter = new Adaptador(mainViewModel.getAtletas());
        listView.setAdapter(adapter);
        detalleFragment = new DetalleFragment();



        listView.setOnItemClickListener(this);

        //En caso de cambio de la lista se refleja el movimiento
        mainViewModel.getMutableAtletas().observe(getViewLifecycleOwner(), new Observer<ArrayList<Atleta>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Atleta> atletas) {
                //Se usa el adaptador
                Adaptador adapter = new Adaptador(atletas);
                listView.setAdapter(adapter);
            }
        });

        //En caso de cambio del atleta para hacer el cambio
        mainViewModel.getMutableAtleta().observe(getViewLifecycleOwner(), new Observer<Atleta>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(Atleta atleta) {
                mainViewModel.setAtletaSeleccionado(atleta);
                detalleFragment = new DetalleFragment(); //Con esto creamos un nuevo fragment para hacer el cambio
                getFragmentManager().beginTransaction().replace(R.id.frameDet, detalleFragment).commit();


            }
        });

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ViewHolder viewHolder = (ViewHolder) view.getTag(); //Le he pasado en el tag el id, para mas comodidad
        int id = viewHolder.getId();
        mainViewModel.setAtletaSeleccionado(UsarDatabase.getDatabase(getActivity()).dao().atletaPorID(id));
        if(mainViewModel.isTablet()) {
        mainViewModel.cambiarAtleta(mainViewModel.getAtletaSeleccionado());
        }
        else {
            mainViewModel.botonElegido(3); //Los cambios de fragmentos se cambian desde el MainActivity
        }

    }

     /*
        Es la clase Adaptador para las listas
     */

    private class Adaptador extends BaseAdapter {
        private ArrayList<Atleta> atletas;
        private Atleta atleta;

        public Adaptador(ArrayList<Atleta> atletas) {
            this.atletas = atletas;
        }

        @Override
        public int getCount() {
            return atletas.size();
        }

        @Override
        public Object getItem(int position) {
            return atletas.get(position);
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
            TextView nombre;
            TextView apellidos;

            atleta = (Atleta) getItem(position);


            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.fila_atleta, parent, false);
                nombre = row.findViewById(R.id.tvNombre);
                apellidos = row.findViewById(R.id.tvApellidos);
                holder = new ViewHolder(position + 1, nombre, apellidos);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }
            holder.setId(position + 1); //Esto lo he tenido que haer para que no devuelva null, puesto que a veces la id no se generaba automaticamente
            holder.getNombre().setText(atleta.getNombre());
            holder.getApellidos().setText(atleta.getApellidos());

            return row;

        }
    }

    /*
    La clase ViewHolder, para poder hacer el reciclado
     */
    private class ViewHolder {
        int id;
        TextView nombre;
        TextView apellidos;

        public ViewHolder(int id, TextView nombre, TextView apellidos) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getApellidos() {
            return apellidos;
        }

        public void setApellidos(TextView apellidos) {
            this.apellidos = apellidos;
        }
    }
}
