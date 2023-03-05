import Modelos.Pedido;
import Modelos.Producto;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public JPanel panel1;
    private JComboBox comboBox1;
    private JButton agregarButton;
    private JRadioButton pequeñoRadioButton;
    private JRadioButton medianoRadioButton;
    private JRadioButton grandeRadioButton;
    private JCheckBox extra1CheckBox;
    private JCheckBox extra2CheckBox;
    private JCheckBox extra3CheckBox;
    private JLabel lblTotal;
    private JComboBox comboBox2;
    private JTable table1;
    private JButton finalizarCompraButton;
    private JButton cotizarButton;

    private Double total = 0.0;

    public App() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Obtener el producto seleccionado
                int indexSeleccionado = comboBox1.getSelectedIndex();
                Producto seleccionado = Main.productos.get(indexSeleccionado);

                // Agregar un nuevo pedido al arraylist de pedidos
                Main.pedidos.add(
                        //nuevo objeto de tipo pedido con los datos de la interfaz grafica
                        new Pedido(seleccionado.getNombre(), comboBox2.getSelectedItem().toString(),total.toString())
                );

                // Reconstruir tabla

                //Obtener el modelo
                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

                // Eliminar las filas existentes
                tableModel.setRowCount(0);

                // Recorrer el arraylist de pedidos
                for (Pedido p :
                        Main.pedidos) {

                    // Construir un array de string con los datos a mostrar
                    String[] data = new String[3];
                    // Llenar el array con los datos del pedido actual
                    data[0] = p.getProducto();
                    data[1] = p.getTotal();
                    data[2] = p.getColor();
                    // Agregar los datos al modelo
                    tableModel.addRow(data);
                }
            }
        });


        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Cambiar los colores en base a qué producto se seleccionó

                int seleccionado = comboBox1.getSelectedIndex();
                // Eliminar elementos del combobox de colores
                comboBox2.removeAllItems();
                // Convertir los colores a un array
                Object[] colores = Main.productos.get(seleccionado).getColores().toArray();

                //Agregarlos al combobox
                for (Object c: colores){
                    comboBox2.addItem(c);
                }
            }
        });
        cotizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Obtener el producto seleccionado
                int seleccionado = comboBox1.getSelectedIndex();



                // Sumar el precio del producto seleccionado

                total =  Main.productos.get(seleccionado).getPrecio();
                
                if(pequeñoRadioButton.isSelected()){
                    total += 10.0;
                } else if (medianoRadioButton.isSelected()) {
                    total += 30.0;
                } else if (grandeRadioButton.isSelected()) {
                    total += 50.0;
                }

                if(extra1CheckBox.isSelected()){
                    total += 1.0;
                }
                if (extra2CheckBox.isSelected()) {
                    total += 5.0;
                }
                if (extra3CheckBox.isSelected()) {
                    total += 10.0;
                }

                lblTotal.setText(total.toString());
            }
        });
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter fileWriter = null;
                try {
                    // Crear un nuevo archivo .html
                    fileWriter = new FileWriter("example1.html");

                    // Escribir contenido en el archivo
                    fileWriter.write("<html><head><title>Ejemplo de archivo .html</title></head><body> \n");

                    for (Pedido p :
                            Main.pedidos) {
                        fileWriter.write("<h1>"+p.toString()+"</h1>");
                    }
                    
                    fileWriter.write(    "</body></html>");

                    // Cerrar el archivo
                    fileWriter.close();

                    System.out.println("El archivo ha sido creado y escrito con éxito.");

                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        comboBox1 = new JComboBox(Main.productos.toArray());

        int seleccionado = comboBox1.getSelectedIndex();


        comboBox2 = new JComboBox<>(Main.productos.get(seleccionado).getColores().toArray());


        pequeñoRadioButton = new JRadioButton("Pequeño", true);


        String[] columnNames = new String[] {"Producto", "Color", "Total"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);


        model.addRow( new String[] {"Producto1", "Rojo" , "5"});
        model.addRow( new String[] {"Producto2", "Azul" , "123"});
        model.addRow( new String[] {"Producto3", "Rojo" , "5"});


        table1 = new JTable();
        table1.setModel(model);



    }
}
