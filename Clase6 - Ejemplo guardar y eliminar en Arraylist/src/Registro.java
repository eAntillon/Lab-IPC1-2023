import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Registro {
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JButton registrarseButton;
    private JButton regresarButton;
    public JPanel panel1;

    public Registro() {
    registrarseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Registro
            if(Main.verificarExistencia(textField1.getText())){
                JOptionPane.showMessageDialog(null, "Usuario no registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // si no existe, registrarlo
            if(textField1.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Main.estudiantes.add(new Estudiante(textField1.getText(), textField2.getText(), Arrays.toString(passwordField1.getPassword())));
            JOptionPane.showMessageDialog(null, "Usuario correctamente registrado");

        }
    });
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // salir de la pantalla de registro
            Main.frame.setContentPane(new Login().Panel1);
            Main.frame.pack();
            Main.frame.setSize(600, 800);
        }
    });
}
}
