import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AdminContactos manager = new AdminContactos();
        try {
            manager.loadContacts();
            for (Contacto c :
                    manager.getContacts()) {
                System.out.println(c.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando contactos: " + e.getMessage());
        }

        //
        Contacto erick = new Contacto("Erick Antillon", "erick@gmail.com", "555-1234");
        manager.addContact(erick);
        Contacto daniel = new Contacto("Daniel Chinchilla", "daniel@gmail.com", "555-5678");
        manager.addContact(daniel);
        try {
            manager.saveContacts();
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
    }
}