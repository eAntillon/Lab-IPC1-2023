import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {


    public JPanel Panel1;
    private JButton button1;
    private JTextField textoUsuario;
    private JTextField textoPass;

    private String UsuarioAdmin = "erick";
    private String PassAdmin = "hola";

    private String usuarioNormal = "erick1";
    private String passNormal = "adios";

    public static JFrame frame;

    public App() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoUsuario.getText().equals(UsuarioAdmin) && textoPass.getText().equals(PassAdmin)){
                    System.out.println("credenciales correctas");
                    frame.setContentPane(new Registro().Panel1);
                    frame.pack();
                    frame.setSize(600, 800);
                }else if(textoUsuario.getText().equals(usuarioNormal) && textoPass.getText().equals(passNormal)){
                    frame.setContentPane(new Informacion().panel1);
                    frame.pack();
                    frame.setSize(600, 800);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas");
                    textoUsuario.setText("");
                    textoPass.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        frame = new JFrame("App");
        frame.setContentPane(new App().Panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 800);
    }


}
