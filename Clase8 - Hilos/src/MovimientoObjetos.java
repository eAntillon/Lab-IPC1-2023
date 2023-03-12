import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MovimientoObjetos extends JFrame{
    public JPanel panel1;
    private JLabel izqLabel;
    private JLabel derLabel;
    private JLabel abajoLabel;
    private JLabel arribaLabel;
    private JLabel obj;

    public MovimientoObjetos() {
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        pack();
        setSize(800,600);
        setVisible(true);
        addKeyListener(new Listener());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        izqLabel = new JLabel("izq");
        derLabel = new JLabel("der");
        abajoLabel = new JLabel("arriba");
        arribaLabel = new JLabel("abajo");
        obj = new JLabel("obj");

        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        izqLabel.setBorder(raisedetched);
        derLabel.setBorder(raisedetched);
        abajoLabel.setBorder(raisedetched);
        arribaLabel.setBorder(raisedetched);
        obj.setBorder(raisedetched);

    }

    public void moverObjIzq(){

        Rectangle posInicial = obj.getBounds();
        obj.setBounds(posInicial.x - 10,posInicial.y,posInicial.width,posInicial.height);

        if(izqLabel.getBounds().intersects(posInicial)){
            JOptionPane.showMessageDialog(null, "interseccion con objeto izq");
        }
        System.out.println(obj.getBounds());
    }

    public void moverObjArriba(){
        Rectangle posInicial = obj.getBounds();
        obj.setBounds(posInicial.x,posInicial.y - 10,posInicial.width,posInicial.height);

    }

}
