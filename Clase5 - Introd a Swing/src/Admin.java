import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public JPanel Panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarButton;
    private JTable table1;
    private JButton regresarButton;
    private JButton cargarButton;

    public Registro() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new App().Panel1);
            Main.frame.pack();
            Main.frame.setSize(600, 800);
        }
    });
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.estudiantes.add(new Estudiante(textField1.getText(), textField2.getText(), textField3.getText()));
        }
    });
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel table = new DefaultTableModel();

                table.addColumn("Nombre");
                table.addColumn("Id");
                table.addColumn("Fecha");

                for (Estudiante es: Main.estudiantes) {
                    Object[] data = new Object[3];
                    data[0] = es.getNombre();
                    data[1] = es.getID();
                    data[2] = es.getFechaNacimiento();
                    table.addRow(data);
                }
                table1.setModel(table);
            }
        });
    }
}
