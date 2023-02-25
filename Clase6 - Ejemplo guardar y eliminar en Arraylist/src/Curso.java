public class Curso {

    private String ID;
    private String nombre;

    private int creditos;



    public Curso(String ID, String nombre, int creditos) {
        this.ID = ID;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
