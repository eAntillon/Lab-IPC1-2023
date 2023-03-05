package Modelos;

import java.util.ArrayList;
import java.util.UUID;

public class Producto {


    private String id;
    private String nombre;

    private double precio;

    private ArrayList<String> colores = new ArrayList<>();

    public Producto(String nombre, double precio) {
        this.id = UUID.randomUUID().toString().substring(0,5);
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void agregarColor(String c){
        this.colores.add(c);
    }

    public ArrayList<String> getColores() {
        return colores;
    }

    public void setColores(ArrayList<String> colores) {
        this.colores = colores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
