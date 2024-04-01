package TareaEvaluable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean repetir = false;
    public static ArrayList<Empleado> empresa = new ArrayList<Empleado>();
    public static void ListaEmpleados(){

        Empleado empleado1 = new Empleado("Juan", "Torres",	"01-01-1960",	"24-5-1980",	"Jefe",	60.000);
        Empleado empleado2 = new Empleado("Sara", "Gonzalez", "02-05-1980", "03-06-1999", "Secretaria",	25.000);
        Empleado empleado3 = new Empleado("Elena", "Sanchez", "03-09-1990","02-11-2010", "TecnicoFP", 30.000);
        Empleado empleado4 = new Empleado("Pepe", "Uriel", "04-10-1991", "01-10-2015", "Administrativo", 24.000);
        Empleado yo = new Empleado("German", "Escudero", "04-07-2024", "21-03-2024", "Programador", 20000);

        empresa.add(empleado1);
        empresa.add(empleado2);
        empresa.add(empleado3);
        empresa.add(empleado4);
        empresa.add(yo);
    }

    public static int menu() {
        System.out.println("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para añadir un empleado"+
                "\nSeleccione 2 para eliminar un empleado"+
                "\nSeleccione 3 para buscar un empleado y ver sus datos"+
                "\nSeleccione 4 para ver los empleados bajo un orden"+
                "\nSeleccione 5 para calcular el gasto total de los empleados empleado"+
                "\nSeleccione 6 para salir del programa");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static void introducirEmpleado() {
        //Introduce el nombre
        System.out.println("Indique el nombre del nuevo empleado");
        String nombreTemp = scanner.nextLine();
        scanner.nextLine();
        //Introduce el apellido
        System.out.println("Indique el apellido del nuevo empleado");
        String apellidoTemp = scanner.nextLine();
        scanner.nextLine();
        //Introduce la fehca de nacimiento
        System.out.println("Indique la fecha de nacimiento del nuevo empleado");
        String textoFechaNacTemp = scanner.nextLine();
        scanner.nextLine();
        LocalDate fechaNacimientoTemp = LocalDate.parse(textoFechaNacTemp);
        //Introduce la fecha de ingreso
        System.out.println("Indique la fecha de ingreso del nuevo empleado");
        String textoFechaIngTemp = scanner.nextLine();
        scanner.nextLine();
        LocalDate fechaIngresoTemp = LocalDate.parse(textoFechaIngTemp);
        //Introduce el puesto
        System.out.println("Indique el puesto del nuevo empleado");
        String puestoTemp = scanner.nextLine();
        scanner.nextLine();
        //Introduce el salario
        System.out.println("Indique el salario del nuevo empleado");
        double salarioTemp = scanner.nextDouble();
        //Crea el nuevo empleado usando todas las variables anteriores
        Empleado empleadoTemp = new Empleado(nombreTemp, apellidoTemp, fechaNacimientoTemp, fechaIngresoTemp, puestoTemp, salarioTemp);
        empresa.add(empleadoTemp);
    }//Faltan excepciones

    public static void eliminarEmpleado() {
        System.out.println("Introduce el nombre o el apellido del empleado que desea despedir");
        String eliminar = scanner.nextLine();
        scanner.nextLine();
        empresa.remove(eliminar);
    }//Hay q acabarlo

    public static void mostrarEmpleado() {

    }//Hay q acabarlo

    public static void mostrarEmpresa() {
        System.out.println("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para ver los empleados ordenados por su antiguedad"+
                "\nSeleccione 2 para ver los empleados ordenados por su salario"+
                "\nSeleccione 3 para ver los empleados ordenados por su apellido");
        int opcionOrden = scanner.nextInt();
        switch (opcionOrden){
            case 1:
                //Ordenacion de objetos por antiguedad (fecha de ingreso)
                Collections.sort(empresa, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado a1, Empleado a2) {
                        return a1.getFechaIngreso().compareTo(a2.getFechaIngreso());
                    }//Fin compare
                });//Fin iterator
                break;
            case 2:
                //Ordenacion de objetos por salario
                break;
            case 3:
                //Ordenacion de objetos por apellido
                Collections.sort(empresa, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado a1, Empleado a2) {
                        return a1.getApellidos().compareTo(a2.getApellidos());
                    }//Fin compare
                });//Fin iterator
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }//Hay q acabarlo

    public static void gastoTotal() {

    }//Hay q acabarlo

    public static void main(String[] args) {
        ListaEmpleados();
        do {
            repetir = false;
            switch (menu()){
                case 1:
                    introducirEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    mostrarEmpleado();
                    break;
                case 4:
                    mostrarEmpresa();
                    break;
                case 5:
                    gastoTotal();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    repetir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (repetir);

    }
}
