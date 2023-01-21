import java.util.Scanner; //importa la clase Scanner para leer datos del usuario

public class AreaCirculo {
    public static void main(String[] args) {
        final double PI = 3.14159; //declara una constante para el valor de PI
        double radio, area; //declara las variables para el radio y área del círculo

        Scanner entrada = new Scanner(System.in); //crea un nuevo objeto Scanner para leer datos del usuario

        System.out.print("Ingrese el radio del círculo: "); //pide al usuario que ingrese el radio del círculo
        radio = entrada.nextDouble(); //lee el radio ingresado por el usuario

        area = PI * radio * radio; //calcula el área del círculo utilizando el radio ingresado

        System.out.printf("El área del círculo es: %.2f", area); //imprime el área del círculo con 2 decimales
    }
}