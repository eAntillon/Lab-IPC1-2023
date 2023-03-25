import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
public class FileReaderEjemplo {
        public static void main(String[] args) throws IOException {
            System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
            File file = new File("doc.txt");
            if (!file.exists()) {
                System.out.println("archivo no existe");
                file.createNewFile();
            }
            System.out.println("FileReader:");
            try (FileReader fr = new FileReader(file))
            {
                int content;
                while ((content = fr.read()) != -1) {
                    System.out.print((char)content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("FileInputStream:");
            try (FileInputStream fr = new FileInputStream(file))
            {
                int content;
                while ((content = fr.read()) != -1) {
                    System.out.print((char)content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
