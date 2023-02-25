import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {


    public JPanel Panel1;
    private JButton button1;
    private JTextField textoUsuario;
    private JTextField textoPass;
    private JButton registroButton;

    private String UsuarioAdmin = "admin";
    private String PassAdmin = "admin";



    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoUsuario.getText().equals(UsuarioAdmin) && textoPass.getText().equals(PassAdmin)){
                    System.out.println("Credenciales correctas");
                    Main.frame.setContentPane(new Admin().Panel1);
                    Main.frame.pack();
                    Main.frame.setSize(600, 800);
                    return;
                }
                if(Main.verificarExistencia(textoUsuario.getText())){
                    Main.frame.setContentPane(new Informacion().panel1);
                    Main.frame.pack();
                    Main.frame.setSize(600, 800);
                }
                else{
                    JOptionPane.showMessageDialog(Main.frame, "Credenciales incorrectas");
                    textoUsuario.setText("");
                    textoPass.setText("");
                }
            }
        });
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Registro().panel1);
                Main.frame.pack();
                Main.frame.setSize(600, 800);
            }
        });
    }




}
