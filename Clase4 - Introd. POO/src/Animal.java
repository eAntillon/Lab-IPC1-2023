public class Animal {

    private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    //getter y setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public void comunicarse(){
        System.out.println("Hola soy un animal");
    }
}
