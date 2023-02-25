import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static JFrame frame;

    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public static ArrayList<Curso> cursos = new ArrayList<>();


    public static void main(String[] args) {

        cursos.add(new Curso("ASJESK", "IPC1", 4));
        cursos.add(new Curso("asdf", "IPC2", 4));
        cursos.add(new Curso("ASJEasdfSK", "IPC3", 4));
        cursos.add(new Curso("ASJErgSK", "IPC4", 4));

        frame = new JFrame("Tienda");
        frame.setContentPane(new Login().Panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 700);
    }


    public static boolean verificarExistencia(String nombre){

        for (Estudiante es: estudiantes
        ) {
            if(es.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

}
