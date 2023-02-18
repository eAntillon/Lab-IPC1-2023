

public class Main {
    public static void main(String[] args) {
        Animal an = new Animal("pato", 4);

        an.setNombre("perro");
        an.comunicarse();
        System.out.println(an.getNombre());

        Gato gato1 = new Gato("michi", 2, "angora");

        gato1.setNombre("michito");
        gato1.comunicarse();
        System.out.println(gato1.getRaza());

    }
}