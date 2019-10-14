package es.iesnervion.rmanzano.nbateams.ViewHolder;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView imagen;
    private TextView nombre;
    private TextView conferencia;

    public ViewHolder(ImageView imagen, TextView nombre, TextView conferencia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.conferencia = conferencia;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getConferencia() {
        return conferencia;
    }
}
