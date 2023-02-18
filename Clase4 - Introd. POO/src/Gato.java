public class Gato extends Animal{

    private String raza;

    public Gato(String nombre, int edad, String raza){
        super(nombre, edad);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void comunicarse(){
        System.out.println("Hola soy un gato " + this.raza);
    }
}
