package iesnervion.rmanzano.masterdetails.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import iesnervion.rmanzano.masterdetails.clases.Contacto;

public class ContactoViewModel extends ViewModel {
    private Contacto contactoSeleccionado;
    private MutableLiveData<ArrayList<Contacto>> contactosLiveData;
    private MutableLiveData<Integer> saberBotonPulsado;
    private ArrayList<Contacto> listaContactos;
    private Integer botonPulsado;

    public ContactoViewModel() {
        contactoSeleccionado = new Contacto();
        contactosLiveData = new MutableLiveData<>();
        saberBotonPulsado = new MutableLiveData<>();
        listaContactos = new ArrayList<>();
        botonPulsado = 0;

    }

    public Contacto getContactoSeleccionado() {
        return contactoSeleccionado;
    }

    public void setContactoSeleccionado(Contacto contactoSeleccionado) {
        this.contactoSeleccionado = contactoSeleccionado;
    }

    public MutableLiveData<ArrayList<Contacto>> getContactosLiveData() {
        return contactosLiveData;
    }

    public void setContactosLiveData(MutableLiveData<ArrayList<Contacto>> contactosLiveData) {
        this.contactosLiveData = contactosLiveData;
    }

    public ArrayList<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(ArrayList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public MutableLiveData<Integer> getSaberBotonPulsado() {
        return saberBotonPulsado;
    }

    public void setSaberBotonPulsado(MutableLiveData<Integer> saberBotonPulsado) {
        this.saberBotonPulsado = saberBotonPulsado;
    }

    public Integer getBotonPulsado() {
        return botonPulsado;
    }

    public void setBotonPulsado(Integer botonPulsado) {
        this.botonPulsado = botonPulsado;
        saberBotonPulsado.setValue(botonPulsado);
    }

    public void anhadirNuevoContacto(Contacto contacto) {
        listaContactos.add(contacto);
        contactosLiveData.setValue(listaContactos);
    }
}
