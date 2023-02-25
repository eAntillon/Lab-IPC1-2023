import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.UUID;

public class Admin {
    public JPanel Panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarButton;
    private JButton regresarButton;
    private JButton cargarReporteButton;
    private JComboBox<Curso> comboBox1;
    private JButton eliminarCursoButton;
    private JButton generarButton;

    public Admin() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new Login().Panel1);
            Main.frame.pack();
            Main.frame.setSize(600, 800);
        }
    });

    cargarReporteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            DefaultTableModel table = new DefaultTableModel();
//
//            table.addColumn("Id");
//            table.addColumn("Curso");
//            table.addColumn("Fecha");
//
//            for (Estudiante es: Main.estudiantes) {
//                Object[] data = new Object[3];
//                data[0] = es.getNombre();
//                data[1] = es.getPassword();
//                data[2] = es.getFechaNacimiento();
//                table.addRow(data);
//            }
//            table1.setModel(table);
        }
    });
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = UUID.randomUUID().toString().substring(0,5);
                textField2.setText(id);
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cursos.add(new Curso(textField2.getText(), textField1.getText(), Integer.parseInt(textField3.getText())));
                comboBox1.removeAllItems();
                for (Curso c :
                        Main.cursos) {
                    comboBox1.addItem(c);
                }
            }
        });
        eliminarCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEliminar = comboBox1.getSelectedIndex();
                Main.cursos.remove(indexEliminar);

                comboBox1.removeAllItems();
                for (Curso c :
                        Main.cursos) {
                    comboBox1.addItem(c);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        comboBox1 = new JComboBox<Curso>();
        for (Curso c :
                Main.cursos) {
            comboBox1.addItem(c);
        }


    }
}
