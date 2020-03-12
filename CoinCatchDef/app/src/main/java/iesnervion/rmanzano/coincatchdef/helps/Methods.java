package iesnervion.rmanzano.coincatchdef.helps;

import java.util.ArrayList;
import java.util.Random;


import iesnervion.rmanzano.coincatchdef.R;
import iesnervion.rmanzano.coincatchdef.classes.Item;

public class Methods {
    public ArrayList<Item> listadeItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(1, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(2, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(3, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(4, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(5, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(6, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(7, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(8, R.drawable.ic_luna, "vacio"));
        items.add(new Item(9, R.drawable.ic_luna, "vacio"));
        items.add(new Item(10, R.drawable.ic_luna, "vacio"));
        items.add(new Item(11, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(12, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(13, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(14, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(15, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(16, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(17, R.drawable.ic_moneda, "moneda"));
        return items;
    }

    public ArrayList<Item> listadeItemsNormal() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(1, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(2, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(3, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(4, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(5, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(6, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(7, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(8, R.drawable.ic_luna, "vacio"));
        items.add(new Item(9, R.drawable.ic_luna, "vacio"));
        items.add(new Item(10, R.drawable.ic_luna, "vacio"));
        items.add(new Item(11, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(12, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(13, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(14, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(15, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(16, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(17, R.drawable.ic_moneda, "moneda"));
        return items;
    }

    public ArrayList<Item> listadeItemsFacil() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(1, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(2, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(3, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(4, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(5, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(6, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(7, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(8, R.drawable.ic_luna, "vacio"));
        items.add(new Item(9, R.drawable.ic_luna, "vacio"));
        items.add(new Item(10, R.drawable.ic_luna, "vacio"));
        items.add(new Item(11, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(12, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(13, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(14, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(15, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(16, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(17, R.drawable.ic_moneda, "moneda"));
        return items;
    }

    public ArrayList<Item> listadeItemsDificil() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(1, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(2, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(3, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(4, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(5, R.drawable.ic_meteorito, "menos"));
        items.add(new Item(6, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(7, R.drawable.ic_cohete, "multiplicador"));
        items.add(new Item(8, R.drawable.ic_luna, "vacio"));
        items.add(new Item(9, R.drawable.ic_luna, "vacio"));
        items.add(new Item(10, R.drawable.ic_luna, "vacio"));
        items.add(new Item(11, R.drawable.ic_agujeronegro, "final"));
        items.add(new Item(12, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(13, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(14, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(15, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(16, R.drawable.ic_moneda, "moneda"));
        items.add(new Item(17, R.drawable.ic_moneda, "moneda"));
        return items;
    }

    public ArrayList<Item> randomizarLista(ArrayList<Item> items) {
        ArrayList<Item> lista = new ArrayList<>();
        boolean novale = false;
        Random random = new Random();
        int numero = random.nextInt(18);

        for(int i = 0; i < items.size(); i++) {
            novale = false;
            if(lista.size() > 0) {
                numero = random.nextInt(18);
                for(int c = 0; c < lista.size(); c++) {
                    if(lista.get(c).getId() == items.get(numero).getId()) {
                        i--;
                        novale = true;
                    }
                }
            }
            if(!novale) {
                lista.add(items.get(numero));
            }


        }

        return lista;
    }
}
