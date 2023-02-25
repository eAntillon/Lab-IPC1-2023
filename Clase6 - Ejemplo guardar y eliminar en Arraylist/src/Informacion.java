import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informacion {
    public JPanel panel1;
    private JButton button1;
public Informacion() {
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new Login().Panel1);
            Main.frame.pack();
            Main.frame.setSize(600, 800);
        }
    });
}
}
