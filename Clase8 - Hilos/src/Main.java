import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static JFrame VentanaPrincipal;

    public static MovimientoObjetos VentanaObjetos;

    public static void main(String[] args) {
        VentanaPrincipal = new JFrame("Concurrencia");
        VentanaPrincipal.setContentPane(new VentanaConcurrencia().panel1);
        // Keyboard Listener solo cuando se tiene el foco en el Frame
//        VentanaPrincipal.addKeyListener(new Listener());

        VentanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        VentanaPrincipal.setFocusable(true);
        VentanaPrincipal.pack();
        VentanaPrincipal.setSize(800,600);
        VentanaPrincipal.setVisible(true);


        VentanaObjetos = new MovimientoObjetos();


        // Keyboard listener global
//        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
//            @Override
//            public boolean dispatchKeyEvent(KeyEvent e) {
//                if (e.getID() == KeyEvent.KEY_PRESSED) {
//                    // Lógica para manejar el evento de tecla presionada
//                    System.out.println("asdfad");
//                }
//                if (e.getID() == KeyEvent.KEY_RELEASED) {
//                    // Lógica para manejar el evento de tecla soltada
//                }
//                if (e.getID() == KeyEvent.KEY_TYPED) {
//                    // Lógica para manejar el evento de tecla escrita
//                }
//                return false;
//            }
//        });


    }

}
