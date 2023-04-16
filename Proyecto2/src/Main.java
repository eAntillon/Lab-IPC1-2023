import Estructuras.ListaDoble;
import Estructuras.ListaSimple;
import Estructuras.Nodo;
import Modelos.Usuario;

import java.io.File;

public class Main {


    // lista doble donde se guardan las imagenes de nuestra biblioteca
    public static ListaDoble listaDoble = new ListaDoble();
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.add(new Usuario("Erick1"));
        lista.add(new Usuario("Erick2"));
        lista.add(new Usuario("Erick3"));
        // eliminar un elemento de la lista
        lista.delete(new Usuario("Erick2"));

        lista.add(new Usuario("Erick4"));
        System.out.println("Longitud de la lista: " + lista.getSize());
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println("Elemento " + i + ": " + ((Usuario)lista.get(i)).getNombre());
        }

//        iterar sobre la lista utilizando el getSiguiente()
        Nodo actual = (Nodo) lista.peek();
        while(actual != null){
            System.out.println("Elemento: " + ((Usuario)actual.getDato()).getNombre());
            actual = actual.getSiguiente();
        }


        Ventana ventana = new Ventana();
    }
}