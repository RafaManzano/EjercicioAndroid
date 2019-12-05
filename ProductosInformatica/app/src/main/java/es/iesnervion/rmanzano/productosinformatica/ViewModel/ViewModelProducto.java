package es.iesnervion.rmanzano.productosinformatica.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.rmanzano.productosinformatica.Clases.Impresora;
import es.iesnervion.rmanzano.productosinformatica.Clases.Portatil;

public class ViewModelProducto extends ViewModel {
    MutableLiveData<Object> producto;
    MutableLiveData<ArrayList<Object>> productos;
    ArrayList<Object> objetos;

    public ViewModelProducto() {
        this.producto = new MutableLiveData<Object>();
        this.productos = new MutableLiveData<ArrayList<Object>>();
        objetos = new ArrayList<>();
    }

    public ArrayList<Object> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<Object> objetos) {
        this.objetos = objetos;
    }

    public MutableLiveData<Object> getProducto() {
        return producto;
    }

    public MutableLiveData<ArrayList<Object>> getProductos() {
        return productos;
    }

    public void cambiarProducto(Object pr) {
        producto.setValue(pr);
    }

    //TODO Por terminar
    public void cambiarProductoEnListaProducto(Object obj, int color, int indice) {
        if(obj.getClass() == Impresora.class) {
            Impresora obj1 = (Impresora) obj;
            obj1.setDisponibilidad(color);
            objetos.set(indice, obj1);
            productos.setValue(objetos);

        }
        else {
            Portatil obj1 = (Portatil) obj;
            obj1.setDisponibilidad(color);
            objetos.set(indice, obj1);
            productos.setValue(objetos);
        }
    }

    public void filtrarLista(ArrayList<Object> lista) {
        productos.setValue(lista);
    }
}
