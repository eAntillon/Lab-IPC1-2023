package Estructuras;


import ArchivosProyecto.EstructuraDeDatos;
import Modelos.Usuario;

public class ListaSimple extends EstructuraDeDatos {

    private Nodo cabeza;
    private int longitud;

    public ListaSimple() {
        cabeza = null;
        longitud = 0;
    }

//    agregar al inicio
    @Override
    public void add(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        longitud++;
    }

    @Override
    public Object peek() {
        return cabeza;
    }

    @Override
    public Object find(Object e) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (comparar(actual.getDato(), e)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        return null;
    }

    @Override
    public int getSize() {
        return longitud;
    }

    @Override
    public Object get(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void delete(Object e) {
        if (cabeza == null) {
            return;
        }
        Usuario usuario = (Usuario) e;
        if (( (Usuario) cabeza.getDato()).getNombre().equals(usuario.getNombre())) {
            cabeza = cabeza.getSiguiente();
            longitud--;
            return;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && !comparar(actual.getSiguiente().getDato(), e)) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            longitud--;
        }
    }

    public boolean comparar(Object ob1, Object ob2){
        // en la lista simple se almacenan usuarios
        Usuario usuario1 = (Usuario) ob1;
        Usuario usuario2 = (Usuario) ob2;
        return usuario1.getNombre().equals(usuario2.getNombre());
    }
}

