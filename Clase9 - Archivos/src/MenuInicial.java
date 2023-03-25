import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuInicial extends JFrame {


    public JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public ArrayList<JLabel> pelotas = new ArrayList<>();
    public MenuInicial() throws HeadlessException {

        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        pack();
        setSize(800,600);
        setVisible(true);
    }


    public void IniciarSimulacion() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            JLabel nuevo = new JLabel("Producto:" + i);
            System.out.println("Agregar " + i);
            nuevo.setBounds(10*i,0,200, 200);
            nuevo.setForeground(Color.BLUE);
            panel2.add(nuevo);
            Thread.sleep(3000);
            panel2.repaint();
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    panel2.remove(nuevo);
                    panel2.repaint();
                    panel3.add(nuevo);
                    panel3.repaint();
                }
            });
            hilo.start();
        }
    }

}
