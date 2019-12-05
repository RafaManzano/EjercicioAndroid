package es.iesnervion.rmanzano.productosinformatica.Listados;

import java.util.ArrayList;

import es.iesnervion.rmanzano.productosinformatica.Clases.Impresora;
import es.iesnervion.rmanzano.productosinformatica.Clases.Portatil;
import es.iesnervion.rmanzano.productosinformatica.R;

public class MetodosListados {
    public static ArrayList<Object> listadoProductos() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Impresora(R.drawable.verde, R.drawable.hp5010, "HP 5010", "Tinta"));
        list.add(new Impresora(R.drawable.verde, R.drawable.canonts705,  "Canon TS 705", "Laser"));
        list.add(new Portatil(R.drawable.verde, R.drawable.acera315, "Acer A315", R.drawable.intel));
        list.add(new Impresora(R.drawable.rojo, R.drawable.epsonwf2810, "Epson WF 2810", "Laser"));
        list.add(new Portatil(R.drawable.rojo, R.drawable.acera515, "Acer A515", R.drawable.amd));
        list.add(new Portatil(R.drawable.rojo, R.drawable.hp255g7, "HP 255 G7", R.drawable.intel));
        list.add(new Impresora(R.drawable.verde, R.drawable.hp2630, "HP 2630", "Laser"));
        list.add(new Portatil(R.drawable.verde, R.drawable.ideapads340, "Lenovo Ideapad S340", R.drawable.amd));

        return list;
    }

    public static ArrayList<Object> listadoPortatil() {
        ArrayList<Object> list = new ArrayList<>();
        for(Object p : listadoProductos()) {
            if(p instanceof Portatil) {
                list.add((Portatil) p);
            }
        }

        return list;
    }

    public static ArrayList<Object> listadoImpresora() {
        ArrayList<Object> list = new ArrayList<>();
        for(Object i : listadoProductos()) {
            if(i instanceof Impresora) {
                list.add((Impresora) i);
            }
        }

        return list;
    }

    //Con esto filtra por amd, de momento no contempla si estan todos los elementos
    public static ArrayList<Object> listadoPorAMD(boolean todos) {
        ArrayList<Object> list = new ArrayList<>();
        if(todos) {
            for(Object i : listadoProductos()) {
                if (i instanceof Portatil) {
                    if (((Portatil) i).getImagenCpu() == R.drawable.amd) {
                        list.add((Portatil) i);
                    }
                }
                else if(i instanceof Impresora) {
                    list.add((Impresora) i);
                }
            }
        }
        else {
            for(Object i : listadoPortatil()) {
                if(i instanceof Portatil) {
                    if(((Portatil) i).getImagenCpu() == R.drawable.amd) {
                        list.add((Portatil) i);
                    }
                }

            }
        }

        return list;
    }

    //Con esto filtra por intel, de momento no contempla si estan todos los elementos
    public static ArrayList<Object> listadoPorIntel(boolean todos) {
        ArrayList<Object> list = new ArrayList<>();
        if(todos)  {
            for(Object i : listadoProductos()) {
                if(i instanceof Portatil) {
                    if(((Portatil) i).getImagenCpu() == R.drawable.intel) {
                        list.add((Portatil) i);
                    }
                }
                else if(i instanceof Impresora) {
                    list.add((Impresora) i);
                }
            }
        }
        else {
            for(Object i : listadoPortatil()) {
                if (i instanceof Portatil) {
                    if (((Portatil) i).getImagenCpu() == R.drawable.intel) {
                        list.add((Portatil) i);
                    }
                }
            }
        }

        return list;
    }

    public static ArrayList<Object> listadoSinFiltrar(boolean todos) {
        ArrayList<Object> list = new ArrayList<>();
        if(todos)  {
            for(Object i : listadoProductos()) {
                if(i instanceof Portatil) {
                    list.add((Portatil) i);

                }
                else if(i instanceof Impresora) {
                    list.add((Impresora) i);
                }
            }
        }
        else {
            for(Object i : listadoPortatil()) {
                if (i instanceof Portatil) {
                        list.add((Portatil) i);

                }
            }
        }

        return list;
    }
}
