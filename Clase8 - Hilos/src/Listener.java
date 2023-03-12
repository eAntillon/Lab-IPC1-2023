import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("tecla presionada");
        int codigo = e.getKeyCode();
        char caracter = e.getKeyChar();
        System.out.println("Tecla presionada: " + KeyEvent.getKeyText(codigo));
        System.out.println("Código de tecla: " + codigo);
        System.out.println("Carácter de tecla: " + caracter);

        if(e.getKeyCode() == 37){
            Main.VentanaObjetos.moverObjIzq();
        }else if(e.getKeyCode() == 38){
            Main.VentanaObjetos.moverObjArriba();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("tecla liberada");
    }
}
