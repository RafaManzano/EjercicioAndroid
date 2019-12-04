package iesnervion.rmanzano.artecompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import iesnervion.rmanzano.artecompadre.Clases.Danza;
import iesnervion.rmanzano.artecompadre.Clases.Escultura;
import iesnervion.rmanzano.artecompadre.Clases.FraseCelebre;
import iesnervion.rmanzano.artecompadre.Clases.Pintura;
import iesnervion.rmanzano.artecompadre.Utiles.Metodos;

public class MainActivity extends ListActivity {
    private ArrayList<Object> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Cargar la lista
        lista = Metodos.rellenarListado();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adaptador adapter = new Adaptador(lista);
        setListAdapter(adapter);
    }

    public class Adaptador extends BaseAdapter {
        private ArrayList<Object> objetos;
        private TextView txt1;
        private TextView txt2;
        private TextView txt3;
        private TextView txt4;
        private ImageView ft1;
        private ImageView ft2;
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

            if (getItem(position) instanceof Danza) {
                tipo = 1;
            } else if (getItem(position) instanceof Escultura) {
                tipo = 2;
            } else if (getItem(position) instanceof FraseCelebre) {
                tipo = 3;
            }

            return tipo;
        }

        @Override
        public int getViewTypeCount() {
            return 4;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolderPintura holderPintura = null;
            ViewHolderDanza holderDanza = null;
            ViewHolderEscultura holderEscultura = null;
            ViewHolderFraseCelebre holderFraseCelebre = null;
            objeto = (Object) getItem(position);
            LayoutInflater inflater = getLayoutInflater();

            if (row == null) {
                switch (getItemViewType(position)) {

                    case 0:
                        row = inflater.inflate(R.layout.pintura_row, parent, false);
                        ft1 = row.findViewById(R.id.fotopintura);
                        txt1 = row.findViewById(R.id.nombrepintura);
                        holderPintura = new ViewHolderPintura(ft1, txt1);
                        row.setTag(holderPintura);
                        break;

                    case 1:
                        objeto = (Danza) getItem(position);
                        row = inflater.inflate(R.layout.danza_row, parent, false);
                        ft1 = row.findViewById(R.id.fotodanza);
                        txt1 = row.findViewById(R.id.textodanza);
                        txt2 = row.findViewById(R.id.cancion);
                        ft2 = row.findViewById(R.id.continente);
                        holderDanza = new ViewHolderDanza(ft1, txt1, txt2, ft2);
                        row.setTag(holderDanza);
                        break;

                    case 2:
                        row = inflater.inflate(R.layout.escultura_row, parent, false);
                        ft1 = row.findViewById(R.id.fotoescultura);
                        txt1 = row.findViewById(R.id.fecha);
                        txt2 = row.findViewById(R.id.esc1);
                        txt3 = row.findViewById(R.id.esc2);
                        txt4 = row.findViewById(R.id.esc3);
                        holderEscultura = new ViewHolderEscultura(ft1, txt1,txt2,txt3,txt4);
                        row.setTag(holderEscultura);
                        break;

                    case 3:
                        row = inflater.inflate(R.layout.frase_celebre_row, parent, false);
                        txt1 = row.findViewById(R.id.escritor);
                        txt2 = row.findViewById(R.id.frase);
                        holderFraseCelebre = new ViewHolderFraseCelebre(txt1,txt2);
                        row.setTag(holderFraseCelebre);
                        break;

                }
            }
            else {
                switch (getItemViewType(position)) {
                    case 0:
                        holderPintura = (ViewHolderPintura) row.getTag();
                        break;

                    case 1:
                        holderDanza = (ViewHolderDanza) row.getTag();
                        break;

                    case 2:
                        holderEscultura = (ViewHolderEscultura) row.getTag();
                        break;

                    case 3:
                        holderFraseCelebre = (ViewHolderFraseCelebre) row.getTag();
                        break;
                }
            }

            switch (getItemViewType(position)) {
                case 0:
                    Pintura p = (Pintura) objeto;
                    holderPintura.getFoto().setBackgroundResource(p.getFoto());
                    holderPintura.getTexto().setText(p.getEstilo());
                    break;

                case 1:
                    Danza d = (Danza) objeto;
                    holderDanza.getFoto1().setBackgroundResource(d.getFoto());
                    holderDanza.getTexto1().setText(d.getGenero());
                    holderDanza.getTexto2().setText(d.getCancion());
                    holderDanza.getFoto2().setBackgroundResource(d.getContinente());
                    break;

                case 2:
                    Escultura e = (Escultura) objeto;
                    holderEscultura.getFoto1().setBackgroundResource(e.getFoto());
                    holderEscultura.getTexto1().setText(e.getFecha());
                    holderEscultura.getTexto2().setText(e.getObras().get(0));
                    holderEscultura.getTexto2().setText(e.getObras().get(1));
                    holderEscultura.getTexto3().setText(e.getObras().get(2));
                    break;

                case 3:
                    FraseCelebre f = (FraseCelebre) objeto;
                    holderFraseCelebre.getTexto1().setText(f.getEscritor());
                    holderFraseCelebre.getTexto2().setText(f.getFrase());
                    break;
            }

            return row;
        }
    }

    public class ViewHolderPintura {
        private ImageView foto;
        private TextView texto;

        public ViewHolderPintura(ImageView foto, TextView texto) {
            this.foto = foto;
            this.texto = texto;
        }

        public ImageView getFoto() {
            return foto;
        }

        public void setFoto(ImageView foto) {
            this.foto = foto;
        }

        public TextView getTexto() {
            return texto;
        }

        public void setTexto(TextView texto) {
            this.texto = texto;
        }
    }

    public class ViewHolderDanza {
        private ImageView foto1;
        private TextView texto1;
        private TextView texto2;
        private ImageView foto2;

        public ViewHolderDanza(ImageView foto1, TextView texto1, TextView texto2, ImageView foto2) {
            this.foto1 = foto1;
            this.texto1 = texto1;
            this.texto2 = texto2;
            this.foto2 = foto2;
        }

        public ImageView getFoto1() {
            return foto1;
        }

        public void setFoto1(ImageView foto1) {
            this.foto1 = foto1;
        }

        public TextView getTexto1() {
            return texto1;
        }

        public void setTexto1(TextView texto1) {
            this.texto1 = texto1;
        }

        public TextView getTexto2() {
            return texto2;
        }

        public void setTexto2(TextView texto2) {
            this.texto2 = texto2;
        }

        public ImageView getFoto2() {
            return foto2;
        }

        public void setFoto2(ImageView foto2) {
            this.foto2 = foto2;
        }
    }

    public class ViewHolderEscultura {
        private ImageView foto1;
        private TextView texto1;
        private TextView texto2;
        private TextView texto3;
        private TextView texto4;

        public ViewHolderEscultura(ImageView foto1, TextView texto1, TextView texto2, TextView texto3, TextView texto4) {
            this.foto1 = foto1;
            this.texto1 = texto1;
            this.texto2 = texto2;
            this.texto3 = texto3;
            this.texto4 = texto4;
        }

        public ImageView getFoto1() {
            return foto1;
        }

        public void setFoto1(ImageView foto1) {
            this.foto1 = foto1;
        }

        public TextView getTexto1() {
            return texto1;
        }

        public void setTexto1(TextView texto1) {
            this.texto1 = texto1;
        }

        public TextView getTexto2() {
            return texto2;
        }

        public void setTexto2(TextView texto2) {
            this.texto2 = texto2;
        }

        public TextView getTexto3() {
            return texto3;
        }

        public void setTexto3(TextView texto3) {
            this.texto3 = texto3;
        }

        public TextView getTexto4() {
            return texto4;
        }

        public void setTexto4(TextView texto4) {
            this.texto4 = texto4;
        }
    }

    public class ViewHolderFraseCelebre {
        private TextView texto1;
        private TextView texto2;


        public ViewHolderFraseCelebre(TextView texto1, TextView texto2) {
            this.texto1 = texto1;
            this.texto2 = texto2;
        }

        public TextView getTexto1() {
            return texto1;
        }

        public void setTexto1(TextView texto1) {
            this.texto1 = texto1;
        }

        public TextView getTexto2() {
            return texto2;
        }

        public void setTexto2(TextView texto2) {
            this.texto2 = texto2;
        }
    }
}
