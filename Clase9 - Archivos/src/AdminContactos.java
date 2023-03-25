import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminContactos {
    private static final String CONTACTS_FILE = "contacts.csv";
    private static final String BACKUP_FILE = "backup.bin";
    private static final String DATA_FOLDER = "data";
    private List<Contacto> contacts = new ArrayList<>();

    public void addContact(Contacto contact) {
        contacts.add(contact);
    }

    public List<Contacto> getContacts() {
        return contacts;
    }

    public void saveContacts() throws IOException {
        File dataFolder = new File(DATA_FOLDER);
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        File contactsFile = new File(DATA_FOLDER + "/" + CONTACTS_FILE);
        // limpiar el archivo
        FileWriter file = new FileWriter(contactsFile, true);
        BufferedWriter writer = new BufferedWriter(file);
        for (Contacto contact : contacts) {
            writer.write(contact.getNombre() + "," + contact.getEmail() + "," + contact.getTelefono());
            writer.newLine();
        }
        writer.close();

        File backupFile = new File(DATA_FOLDER + "/" + BACKUP_FILE);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(backupFile));
        oos.writeObject(contacts);
        oos.close();
    }

    public void loadContacts() throws IOException, ClassNotFoundException {
        File contactsFile = new File(DATA_FOLDER + "/" + CONTACTS_FILE);
        if(contactsFile.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(contactsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Contacto contact = new Contacto(parts[0], parts[1], parts[2]);
                contacts.add(contact);
            }
            reader.close();
        } else {
            File backupFile = new File(DATA_FOLDER + "/" + BACKUP_FILE);
            if (backupFile.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile));
                contacts = (List<Contacto>) ois.readObject();
                ois.close();
            }
        }
    }

}
