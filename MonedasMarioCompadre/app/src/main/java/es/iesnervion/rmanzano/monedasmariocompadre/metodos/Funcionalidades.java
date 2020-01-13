package es.iesnervion.rmanzano.monedasmariocompadre.metodos;

import java.util.ArrayList;
import java.util.Random;

import es.iesnervion.rmanzano.monedasmariocompadre.clases.Item;

public class Funcionalidades {
    public ArrayList<Item> listadeItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, "bowser"));
        items.add(new Item(0, "bowser"));
        items.add(new Item(0, "bomba"));
        items.add(new Item(0, "bomba"));
        items.add(new Item(0, "bomba"));
        items.add(new Item(0, "bomba"));
        items.add(new Item(0, "seta"));
        items.add(new Item(0, "seta"));
        items.add(new Item(0, "ladrillo"));
        items.add(new Item(0, "ladrillo"));
        items.add(new Item(0, "ladrillo"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        items.add(new Item(0, "moneda"));
        return items;
    }

    public ArrayList<Item> randomizarLista(ArrayList<Item> items) {
        ArrayList<Item> lista = new ArrayList<>();
        Random random = new Random();
        int numero = 0;

        for(int i = 0; i < items.size(); i++) {
            numero = random.nextInt(18);
            if(lista.size() != 0) {
                //Revisar error ConcurrentModificationException
                for(Item item : lista) {
                    if(!item.equals(items.get(numero))) {
                        lista.add(items.get(numero));
                    }
                    else {
                        i--;
                    }
                }
            }
            else {
                lista.add(items.get(numero));
            }

        }
        return lista;
    }
}
