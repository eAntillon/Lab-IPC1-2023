import javax.swing.*;

import Modelos.Pedido;
import Modelos.Producto;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.util.ArrayList;

public class Main {

    public static JFrame VentanaPrincipal;
    public static ArrayList<Producto> productos = new ArrayList<>();
    public static ArrayList<Pedido> pedidos = new ArrayList<>();

    public String usuario;
    public static void main(String[] args) {


        VentanaPrincipal = new JFrame("App");

        Producto p1 = new Producto("Camisa", 45.0);
        p1.agregarColor("Rojo");
        p1.agregarColor("Azul");
        p1.agregarColor("Amarillo");
        productos.add(p1);

        Producto p2 = new Producto("Pantalon", 70.45);
        p2.agregarColor("Blanco");
        p2.agregarColor("Negro");
        p2.agregarColor("Gris");
        productos.add(p2);

        Producto p3 = new Producto("Sueter", 60.5);
        p3.agregarColor("Morado");
        p3.agregarColor("Naranja");
        p3.agregarColor("Verde");
        productos.add(p3);


        Producto p4 = new Producto("Zapatos", 100.0);
        p4.agregarColor("Café");
        p4.agregarColor("Negro");
        p4.agregarColor("Blanco");
        productos.add(p4);


        FlatLightLaf.setup();
        try {
            UIManager.LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
            for(int i =0; i < laf.length; i++){
                System.out.println("Nombre: " + laf[i].getName());
                System.out.println("Clase: " + laf[i].getClassName());
            }
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        VentanaPrincipal.setContentPane(new App().panel1);
        VentanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        VentanaPrincipal.pack();
        VentanaPrincipal.setSize(800,600);
        VentanaPrincipal.setVisible(true);

    }

}