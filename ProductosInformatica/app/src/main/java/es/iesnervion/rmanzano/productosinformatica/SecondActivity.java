package es.iesnervion.rmanzano.productosinformatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import es.iesnervion.rmanzano.productosinformatica.Clases.Impresora;
import es.iesnervion.rmanzano.productosinformatica.Clases.Portatil;
import es.iesnervion.rmanzano.productosinformatica.Listados.MetodosListados;
import es.iesnervion.rmanzano.productosinformatica.ViewModel.ViewModelProducto;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener{
    //private ArrayList<Object> objetos;
    private ListView lista;
    private EditText nombre;
    private ImageView imagen;
    private ImageView imagenCpu;
    private ViewModelProducto vm;
    private String bundle;
    private ToggleButton disponibilidad;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ViewModel
        vm = new ViewModelProducto();
        vm = ViewModelProviders.of(this).get(ViewModelProducto.class);

        //Recogemos los datos de la otra actividad
        Bundle extras = getIntent().getExtras();
        bundle = extras.getString("producto");
        //Esto no deberia ir aqui pero por simpleza
        //Es un switch para elegir lo necesario en cada momento
        switch (bundle) {
            case "Impresoras" :
                vm.setObjetos(MetodosListados.listadoImpresora());
                break;

            case "Portatiles":
                vm.setObjetos(MetodosListados.listadoPortatil());
                break;

            case "Todos":
                vm.setObjetos(MetodosListados.listadoProductos());
                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        lista = findViewById(R.id.lista);
        nombre = findViewById(R.id.ETnombre);
        imagen = findViewById(R.id.imgproducto);
        imagenCpu = findViewById(R.id.imgCPU);
        //todo Falta poner la disponibilidad
        disponibilidad = findViewById(R.id.Toggdisponibilidad);
        radio = findViewById(R.id.RGfiltrarCPU);
        Adaptador adapter = new Adaptador(vm.getObjetos());
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
        radio.setOnCheckedChangeListener(this);



        //El observer para cambiar el producto
        vm.getProducto().observe(this, new Observer<Object>() {
            @Override
            //Aqui hacemos los cambios en la parte de abajo con el objeto
            public void onChanged(Object objeto) {
                if(objeto.getClass() == Impresora.class) {
                    Impresora imp = (Impresora) objeto;
                    imagen.setImageResource(imp.getImagen());
                    nombre.setText(imp.getModelo());
                    imagenCpu.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    Portatil portatil = (Portatil) objeto;
                    nombre.setText(portatil.getModelo());
                    imagen.setImageResource(portatil.getImagen());
                    imagenCpu.setImageResource(portatil.getImagenCpu());
                }
            }
        });

        //El observer con el que cambiamos la lista
        vm.getProductos().observe(this, new Observer<ArrayList<Object>>() {
            @Override
            public void onChanged(ArrayList<Object> objetos) {
                //Se usa el adaptador
                Adaptador adapter = new Adaptador(objetos);
                lista.setAdapter(adapter);
            }
        });
    }

    //Con este metodo es el clickado de la lista, aqui hacemos el cambio
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Con este metodo cambiamos el objeto de la lista
        vm.cambiarProducto(lista.getItemAtPosition(i));
    }

    //Este es el boton anterior
    public void anterior(View view) {
        if(lista.getCheckedItemPosition() != 0) {
            lista.setItemChecked(lista.getCheckedItemPosition() - 1, true);
            vm.cambiarProducto(lista.getItemAtPosition(lista.getCheckedItemPosition()));

        }

    }

    //Este es el boton siguiente
    public void siguiente(View view) {
        if(lista.getCheckedItemPosition() < vm.getObjetos().size() -1) {
            lista.setItemChecked(lista.getCheckedItemPosition() + 1, true);
            vm.cambiarProducto(lista.getItemAtPosition(lista.getCheckedItemPosition()));
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        boolean todos = false;
        if(bundle.equals("Portatiles") || bundle.equals("Todos")) {
            if(bundle.equals("Todos")) {
                todos = true;
            }
            switch (i) {
                case R.id.RBtodos:
                    vm.filtrarLista(MetodosListados.listadoSinFiltrar(todos));
                    break;

                case R.id.RBintel:
                    vm.filtrarLista(MetodosListados.listadoPorIntel(todos));
                    break;

                case R.id.RBamd:
                    vm.filtrarLista(MetodosListados.listadoPorAMD(todos));
                    break;
            }
        }
    }



    /* Este es el boton para guarda cambios. No me ha dado tiempo
    Para guardar los cambios
    public void guardarCambios(View view) {
    }



    //Este es el boton para cambiar el estado del stock, me ha dado errores y no he podido corregirlo
    public void cambioDisponibilidad(View view) {
        Object obj = vm.getProducto().getValue();
        if(view.isActivated()) {
            vm.cambiarProductoEnListaProducto(obj, R.drawable.rojo, lista.getCheckedItemPosition());
        }
        else {
            vm.cambiarProductoEnListaProducto(obj, R.drawable.verde, lista.getCheckedItemPosition());
        }

    }
 */



    //Adaptador
    public class Adaptador extends BaseAdapter {
        private ArrayList<Object> objetos;
        private ImageView disponibilidad;
        private ImageView imagen;
        private TextView nombre;
        private TextView tipo;
        private ImageView imagenCpu;
        private Object objeto;

        public Adaptador(ArrayList<Object> objetos) {
            this.objetos = objetos;
        }

        @Override
        public int getCount() {
            return objetos.size();
        }

        @Override
        public Object getItem(int position) {
            return objetos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            int tipo = 0;

            if (getItem(position) instanceof Portatil) {
                tipo = 1;
            }

            return tipo;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolderPortatil holderPortatil = null;
            ViewHolderImpresora holderImpresora= null;
            objeto = (Object) getItem(position);
            LayoutInflater inflater = getLayoutInflater();

            if (row == null) {
                switch (getItemViewType(position)) {

                    case 0:
                        row = inflater.inflate(R.layout.fila_impresora, parent, false);
                        disponibilidad = row.findViewById(R.id.imgDisponibilidadImpr);
                        imagen = row.findViewById(R.id.imgImpr);
                        nombre = row.findViewById(R.id.TVnombreImpr);
                        tipo = row.findViewById(R.id.TVtipoImpr);
                        holderImpresora = new ViewHolderImpresora(disponibilidad, imagen, nombre, tipo);
                        row.setTag(holderImpresora);
                        break;

                    case 1:
                        row = inflater.inflate(R.layout.fila_ordenador, parent, false);
                        disponibilidad = row.findViewById(R.id.imgDisponibilidadOrd);
                        imagen = row.findViewById(R.id.imgOrd);
                        nombre = row.findViewById(R.id.TVnombreOrd);
                        imagenCpu = row.findViewById(R.id.imgCPU);
                        holderPortatil = new ViewHolderPortatil(disponibilidad, imagen, nombre, imagenCpu);
                        row.setTag(holderPortatil);
                        break;
                }
            }
            else {
                switch (getItemViewType(position)) {
                    case 0:
                        holderImpresora = (ViewHolderImpresora) row.getTag();
                        break;

                    case 1:
                        holderPortatil = (ViewHolderPortatil) row.getTag();
                        break;
                }
            }

            switch (getItemViewType(position)) {
                case 0:
                    Impresora i = (Impresora) objeto;
                    holderImpresora.getDisponibilidad().setImageResource(i.getDisponibilidad());
                    holderImpresora.getImagen().setImageResource(i.getImagen());
                    holderImpresora.getNombre().setText(i.getModelo());
                    holderImpresora.getTipo().setText(i.getTipo());
                    break;

                case 1:
                    Portatil p = (Portatil) objeto;
                    holderPortatil.getDisponibilidad().setImageResource(p.getDisponibilidad());
                    holderPortatil.getImagen().setImageResource(p.getImagen());
                    holderPortatil.getModelo().setText(p.getModelo());
                    holderPortatil.getImagenCPU().setImageResource(p.getImagenCpu());
                    break;

            }

            return row;
        }
    }

    //ViewModelImpresora
    public class ViewHolderImpresora {
        private ImageView disponibilidad;
        private ImageView imagen;
        private TextView nombre;
        private TextView tipo;

        public ViewHolderImpresora(ImageView disponibilidad, ImageView imagen, TextView nombre, TextView tipo) {
            this.disponibilidad = disponibilidad;
            this.imagen = imagen;
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public ImageView getDisponibilidad() {
            return disponibilidad;
        }

        public void setDisponibilidad(ImageView disponibilidad) {
            this.disponibilidad = disponibilidad;
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

        public TextView getTipo() {
            return tipo;
        }

        public void setTipo(TextView tipo) {
            this.tipo = tipo;
        }
    }

    //ViewHolderPortatil
    public class ViewHolderPortatil {
        private ImageView disponibilidad;
        private ImageView imagen;
        private TextView modelo;
        private ImageView imagenCPU;


        public ViewHolderPortatil(ImageView disponibilidad, ImageView imagen, TextView modelo, ImageView imagenCPU) {
            this.disponibilidad = disponibilidad;
            this.imagen = imagen;
            this.modelo = modelo;
            this.imagenCPU = imagenCPU;
        }

        public ImageView getDisponibilidad() {
            return disponibilidad;
        }

        public void setDisponibilidad(ImageView disponibilidad) {
            this.disponibilidad = disponibilidad;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getModelo() {
            return modelo;
        }

        public void setModelo(TextView modelo) {
            this.modelo = modelo;
        }

        public ImageView getImagenCPU() {
            return imagenCPU;
        }

        public void setImagenCPU(ImageView imagenCPU) {
            this.imagenCPU = imagenCPU;
        }
    }
}
