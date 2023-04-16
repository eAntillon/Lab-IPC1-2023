import Estructuras.Nodo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JButton siguienteButton;
    private JButton anteriorButton;
    private JPanel panel1;
    private JLabel labelImg;
    private JButton agregarImagenButton;
    private JButton eliminarImagenButton;


    private Nodo imagenActual;


    public Ventana() {
        super("Ventana");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setVisible(true);
        imagenActual = (Nodo) Main.listaDoble.peek();
        agregarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // abrir el explorador de archivos
                JFileChooser fileChooser = new JFileChooser();
                // seleccionar la imagen
                int seleccion = fileChooser.showOpenDialog(panel1);

                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    // Agregar la imagen a la lista
                    Main.listaDoble.add(fileChooser.getSelectedFile().getAbsolutePath());
                    // actualiza nuestro nodo actual al ultimo nodo agregado
                    imagenActual = (Nodo) Main.listaDoble.peek();
                    // Agregar la imagen al jlabel
                    setImagen(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // si imagen actual es null no hacer nada porque no se han agregado imagenes a la lista doble
                if (imagenActual == null) {
                    return;
                }

                // si el nodo actual tiene siguiente se coloca la siguiente
                if (imagenActual.getSiguiente() != null) {
                    imagenActual = imagenActual.getSiguiente();
                    setImagen((String) imagenActual.getDato());
                }
            }
        });
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // si imagen actual es null no hacer nada porque no se han agregado imagenes a la lista doble
                if (imagenActual == null) {
                    return;
                }
                // si el nodo actual tiene anterior se coloca el anterior
                if (imagenActual.getAnterior() != null) {
                    imagenActual = imagenActual.getAnterior();
                    setImagen((String) imagenActual.getDato());
                }
            }
        });
        eliminarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // si existe una imagen actual elimina la imagen
                if (imagenActual != null) {
                    // elimina la imagen  de la lista doble
                    Main.listaDoble.delete(imagenActual.getDato());
                    // si la imagen actual tiene siguiente se coloca la siguiente
                    if (imagenActual.getSiguiente() != null) {
                        imagenActual = imagenActual.getSiguiente();
                        setImagen((String) imagenActual.getDato());
                    } else if (imagenActual.getAnterior() != null) {
                        // si la imagen actual no tiene siguiente pero si anterior se coloca la anterior
                        imagenActual = imagenActual.getAnterior();
                        setImagen((String) imagenActual.getDato());
                    } else {
                        // si la imagen actual no tiene siguiente ni anterior se coloca null
                        imagenActual = null;
                        labelImg.setIcon(null);
                    }
                }
            }
        });
    }

// funcion para agregar la imagen al jlabel
    public void setImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        labelImg.setIcon(imagen);
        labelImg.setSize(imagen.getIconWidth(), imagen.getIconHeight());
        repaint();
    }
}
