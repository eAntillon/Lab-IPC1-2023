import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConcurrencia {
    private JButton agregarElementoButton;
    private JList list1;
    public JPanel panel1;
    private JProgressBar progressBar1;

    public VentanaConcurrencia() {
        agregarElementoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        // Actualizamos la lista de elementos en la interfaz de usuario
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                list1.setModel(new DefaultListModel<String>() {{
                                    addElement("Nuevo item");
                                }});
                            }
                        });
                    }
                });


                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            int finalI = i;
                            System.out.println(Thread.currentThread().getName());
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    System.out.println(Thread.currentThread().getName());
                                    progressBar1.setValue(finalI);
                                }
                            });

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                t1.start();
                t2.start();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        list1 = new JList<>(new String[] {"Item 1", "Item 2", "Item 3"});
    }
}
