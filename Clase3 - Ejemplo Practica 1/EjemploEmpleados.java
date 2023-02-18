import java.util.Scanner;

public class Main {
    public static String[] nombres = new String[3];
    public static int[] horasTrabajadas = new int[3];
    public static double[] pagos = new double[3];

    public static void crearEmpleados(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo empleado: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese las horas trabajadas: ");
        int horas;
        try{
            horas = input.nextInt();
        }catch(Exception e){
            System.out.println("Solo valores enteros!");
            return;
        }
        // validar que no existe ese empleado
        for (int i = 0;i<nombres.length; i++){
            if(nombres[i] != null && nombres[i].equals(nombre)){
                System.out.println("Ese nombre ya existe!");
                return;
            }
        }

        // agregar nuevo empleado
        for (int i = 0;i<nombres.length; i++){
            if(nombres[i] == null){
                nombres[i] = nombre;
                horasTrabajadas[i] = horas;
                System.out.println("usuario ingresado");
                return;
            }
        }
        System.out.println("Ya no caben!");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n Bienvenido al sistema");
            System.out.println("Menu principal");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Calcular sueldos");
            System.out.println("4. Salir");

            System.out.println("Ingrese la opcion: ");
            opcion = input.nextInt();


            switch (opcion){
                case 1:
                    crearEmpleados();
                    break;
                case 2:
                    System.out.println("Empleados guardados");
                    for(String nombre : nombres){
                        if(nombre != null){
                            System.out.println(nombre);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese pago por hora");
                    int pagoHora = input.nextInt();
                    System.out.println("Ingrese porcentaje de bonificacion (0-100)");
                    double boni = input.nextDouble()/100;
                    for (int i = 0;i<nombres.length; i++){
                        pagos[i] = (horasTrabajadas[i] * pagoHora) * (1+boni);
                    }

                    // 1 0 34
                    // j j+1
                    // ordenamiento burbuja
                    for (int i = 0;i<nombres.length - 1; i++){
                        for (int j = 0;j<nombres.length - i - 1; j++){
                            //ordenar por pagos
                            if(pagos[j] < pagos[j+1]){
                                double temp = pagos[j];
                                pagos[j] = pagos[j+1];
                                pagos[j+i] = temp;

                                String temp1 = nombres[j];
                                nombres[j] = nombres[j+1];
                                nombres[j+i] = temp1;

                                int temp2 = horasTrabajadas[j];
                                horasTrabajadas[j] = horasTrabajadas[j+1];
                                horasTrabajadas[j+i] = temp2;
                            }
                        }
                    }
                    // imprimir los datos ordenados
                    for (int i = 0;i<nombres.length; i++){
                        System.out.println("-> Empleado " + nombres[i] + " - horas " + horasTrabajadas[i] + " - pago " + pagos[i]);
                    }
                case 4:
            }
        }while(opcion != 4);
    }
}