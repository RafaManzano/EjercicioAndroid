package iesnervion.rmanzano.sumatoriocompadre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import iesnervion.rmanzano.sumatoriocompadre.Clases.Suma;
import iesnervion.rmanzano.sumatoriocompadre.ViewModel.SumaViewModel;

public class MainActivity extends AppCompatActivity {
    private TextView numeroIzq;
    private TextView numeroDcha;
    private SumaViewModel vm;
    private ListView lista;
    public static Integer contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroDcha = findViewById(R.id.contadordcha);
        numeroIzq = findViewById(R.id.contadorizq);
        lista = findViewById(R.id.lista);

        //ViewModel
        vm = new SumaViewModel();
        vm = ViewModelProviders.of(this).get(SumaViewModel.class);

        //
        //Con esto se crea la lista de tarjetas del equipo local
        vm.getMutableSuma().observe(this, new Observer<ArrayList<Suma>>() {
            @Override
            //Si entra en este metodo quiere decir que hay un cambio para notificar
            public void onChanged(ArrayList<Suma> sumas) {
                //Se usa el adaptador
                Adaptador adapter = new Adaptador(sumas);
                lista.setAdapter(adapter);
            }
        });

        valoresCambioConfiguracion();
    }

    public void valoresCambioConfiguracion() {
        numeroIzq.setText(vm.getNumeroIzq().toString());
        numeroDcha.setText(vm.getNumeroDcha().toString());
    }

    public void sumaizq(View view) {
        vm.setNumeroIzq(vm.getNumeroIzq() + 1);
        numeroIzq.setText(vm.getNumeroIzq().toString());

    }

    public void sumadcha(View view) {
        vm.setNumeroDcha(vm.getNumeroDcha() + 1);
        numeroDcha.setText(vm.getNumeroDcha().toString());
    }

    public void sumarlista(View view) {
        vm.anhadirNumero(new Suma(contador, vm.getNumeroDcha() + vm.getNumeroIzq()));
        contador++;
    }

    public void restarizq(View view) {
        vm.setNumeroIzq(vm.getNumeroIzq() - 1);
        numeroIzq.setText(vm.getNumeroIzq().toString());
    }

    public void restardcha(View view) {
        vm.setNumeroDcha(vm.getNumeroDcha() - 1);
        numeroDcha.setText(vm.getNumeroDcha().toString());
    }



    /*
        Es la clase Adaptador para las listas
     */

    private class Adaptador extends BaseAdapter {
        private ArrayList<Suma> sumas;
        private Suma suma;

        public Adaptador(ArrayList<Suma> sumas) {
            this.sumas = sumas;
        }

        @Override
        public int getCount() {
            return sumas.size();
        }

        @Override
        public Object getItem(int position) {
            return sumas.get(position);
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
            TextView contador;
            TextView numeroSuma;
            suma = (Suma) getItem(position);


            if(row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
                contador = row.findViewById(R.id.numero);
                numeroSuma = row.findViewById(R.id.suma);
                holder = new ViewHolder(contador, numeroSuma);
                row.setTag(holder);
            }
            else {
                holder = (ViewHolder) row.getTag();
            }
            holder.getContador().setText(suma.getContador() + ".");
            holder.getSuma().setText(suma.getSuma().toString());

            return row;

        }
    }

    /*
    La clase ViewHolder, para poder hacer el reciclado
     */
    private class ViewHolder {
        TextView contador;
        TextView suma;

        public ViewHolder(TextView contador, TextView suma) {
            this.contador = contador;
            this.suma = suma;
        }

        public TextView getContador() {
            return contador;
        }

        public void setContador(TextView contador) {
            this.contador = contador;
        }

        public TextView getSuma() {
            return suma;
        }

        public void setSuma(TextView suma) {
            this.suma = suma;
        }
    }
}
