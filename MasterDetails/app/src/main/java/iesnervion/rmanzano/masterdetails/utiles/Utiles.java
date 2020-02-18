package iesnervion.rmanzano.masterdetails.utiles;

import java.util.ArrayList;
import java.util.List;

import iesnervion.rmanzano.masterdetails.R;
import iesnervion.rmanzano.masterdetails.clases.Contacto;

public class Utiles {
    public ArrayList<Contacto> listaCargadaContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.cincuenta, "Rafael Manzano Medina"));
        contactos.add(new Contacto(R.drawable.cincuenta, "Maria del Carmen Osuna Rodriguez"));
        contactos.add(new Contacto(R.drawable.cincuenta, "Luisa Gavira Sola"));
        contactos.add(new Contacto(R.drawable.cincuenta, "Lucero Gavira Sola"));
        return contactos;
    }
}
