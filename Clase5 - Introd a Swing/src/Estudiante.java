public class Estudiante {

    private String nombre;

    private String ID;
    private String fechaNacimiento;


    public Estudiante(String nombre, String ID, String fechaNacimiento) {
        this.nombre = nombre;
        this.ID = ID;
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
