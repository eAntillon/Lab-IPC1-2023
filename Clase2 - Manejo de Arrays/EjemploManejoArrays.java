
package ejemplomanejoarrays;

import java.util.Scanner;

public class EjemploManejoArrays {

    // funcion para identificar numeros pares e impares
    public static void imprimirTipoNumero(int[] listaNumeros){
        for (int i = 0; i < listaNumeros.length; i++) {
            if(listaNumeros[i] %  2 == 0){
                System.out.println("El numero: " + String.valueOf(listaNumeros[i]) + " es par");
            }else{
                System.out.println("El numero: " + String.valueOf(listaNumeros[i]) + " es impar");
            }
        }
    }

    // funcion recursiva
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static void main(String[] args) {
        
        // Crear un array de tamaño 5
        int[] numeros = new int[5];
        // clase scanner
        Scanner input = new Scanner(System.in);

        // Leer 5 numerosy guardarlos en el array
        System.out.println("Ingresa 5 números enteros:");
        for (int i = 0; i < 5; i++) {
            numeros[i] = input.nextInt();
        }

        // imprimir los numeros
        System.out.println("\nLos números ingresados son:");
        // ciclo while
        int k = 0;
        while(k < numeros.length){
            System.out.println(String.valueOf(numeros[k]));
            k++;
        }
        
        System.out.println("\nNúmeros pares e impares:");
        // llamada de una funcion
        imprimirTipoNumero(numeros);
        

        int factorialCalculado = factorial(5);
        System.out.println("\nFactorial: " + String.valueOf(factorialCalculado));
        
    }
}