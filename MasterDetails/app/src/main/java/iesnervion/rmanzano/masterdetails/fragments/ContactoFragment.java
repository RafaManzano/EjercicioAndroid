package iesnervion.rmanzano.masterdetails.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import iesnervion.rmanzano.masterdetails.R;
import iesnervion.rmanzano.masterdetails.clases.Contacto;
import iesnervion.rmanzano.masterdetails.utiles.Utiles;
import iesnervion.rmanzano.masterdetails.viewModel.ContactoViewModel;

public class ContactoFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ArrayList<Contacto> contactos;
    private ListView listContactos;
    private ContactoViewModel viewModel;
    private Utiles utiles = new Utiles();
    private ImageButton mas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contacto_fragment, container, false);
        listContactos = v.findViewById(R.id.lista);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        //La instanciacion del viewModel
        viewModel = ViewModelProviders.of(getActivity()).get(ContactoViewModel.class);

        contactos = new ArrayList<Contacto>();
        viewModel.setListaContactos(utiles.listaCargadaContactos());
        contactos = (ArrayList<Contacto>) viewModel.getListaContactos();
        Adaptador adapter = new Adaptador(contactos);
        listContactos.setAdapter(adapter);
        listContactos.setOnItemClickListener(this);
        mas = v.findViewById(R.id.mas);
        mas.setOnClickListener(this);



        //Con esto se crea la lista de tarjetas del equipo local
        viewModel.getContactosLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contacto>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Contacto> contactos) {
                //Se usa el adaptador
                Adaptador adaptador = new Adaptador(contactos);
                listContactos.setAdapter(adaptador);
            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contacto contacto = new Contacto();
        ViewHolder vh = (ViewHolder) view.getTag();
        contacto.setImagen(Integer.parseInt(vh.getImagen().getTag().toString()));
        contacto.setNombre(vh.getNombre().getText().toString());
        viewModel.setContactoSeleccionado(contacto);
        viewModel.setBotonPulsado(1);
    }

    @Override
    public void onClick(View v) {
        viewModel.setBotonPulsado(2);
    }

      /*
        Es la clase Adaptador para las listas
     */

    private class Adaptador extends BaseAdapter {
        private ArrayList<Contacto> contactos;
        private Contacto contacto;

        public Adaptador(ArrayList<Contacto> contactos) {
            this.contactos = contactos;
        }

        @Override
        public int getCount() {
            return contactos.size();
        }

        @Override
        public Object getItem(int position) {
            return contactos.get(position);
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
            ImageView imagen;
            TextView nombre;
            contacto = (Contacto) getItem(position);


            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.fila_contacto, parent, false);
                imagen = row.findViewById(R.id.imagen);
                nombre = row.findViewById(R.id.nombre);

                holder = new ViewHolder(imagen, nombre);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }
            holder.getImagen().setImageResource(contacto.getImagen());
            holder.getImagen().setTag(contacto.getImagen());
            holder.getNombre().setText(contacto.getNombre());

            return row;

        }
    }

    /*
    La clase ViewHolder, para poder hacer el reciclado
     */
    private class ViewHolder {
        ImageView imagen;
        TextView nombre;

        public ViewHolder(ImageView imagen, TextView nombre) {
            this.imagen = imagen;
            this.nombre = nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }
    }
}
