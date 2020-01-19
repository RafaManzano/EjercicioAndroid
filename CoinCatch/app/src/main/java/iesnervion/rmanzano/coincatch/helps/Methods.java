package iesnervion.rmanzano.coincatch.helps;

import java.util.ArrayList;
import java.util.Random;

import iesnervion.rmanzano.coincatch.R;
import iesnervion.rmanzano.coincatch.classes.Item;

public class Methods {
    public ArrayList<Item> listadeItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.agujeronegro, "final"));
        items.add(new Item(R.drawable.agujeronegro, "final"));
        items.add(new Item(R.drawable.meteorito, "menos"));
        items.add(new Item(R.drawable.meteorito, "menos"));
        items.add(new Item(R.drawable.meteorito, "menos"));
        items.add(new Item(R.drawable.meteorito, "menos"));
        items.add(new Item(R.drawable.nave, "multiplicador"));
        items.add(new Item(R.drawable.nave, "multiplicador"));
        items.add(new Item(R.drawable.luna, "vacio"));
        items.add(new Item(R.drawable.luna, "vacio"));
        items.add(new Item(R.drawable.luna, "vacio"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        items.add(new Item(R.drawable.moneda, "moneda"));
        return items;
    }

    public ArrayList<Item> randomizarLista(ArrayList<Item> items) {
        ArrayList<Item> lista = new ArrayList<>();
        Random random = new Random();
        int numero = 0;

        for(int i = 0; i < items.size(); i++) {
            numero = random.nextInt(18);
            for(Item item : lista) {

            }
        }
        //Revisar, tengo que hacer introducir los datos de una lista a otra aleatoriamente y sin repetidos

        return lista;
    }
}
