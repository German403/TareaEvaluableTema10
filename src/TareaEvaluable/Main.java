package TareaEvaluable;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean repetir = false;//Variable que se usara para los bucles de las excepciones de los diferentes metodos del codigo
    public static ArrayList<Empleado> empresa = new ArrayList<Empleado>();

    public static void ListaEmpleados(){
        Empleado empleado1 = new Empleado("Juan", "Torres", LocalDate.parse("1960-01-01"),	LocalDate.parse("1980-05-25"),	"Jefe",	60000);
        Empleado empleado2 = new Empleado("Sara", "Gonzalez", LocalDate.parse("1980-05-02"), LocalDate.parse("1999-06-03"), "Secretaria",	25000);
        Empleado empleado3 = new Empleado("Elena", "Sanchez", LocalDate.parse("1990-09-03"),LocalDate.parse("2010-11-02"), "TecnicoFP", 30000);
        Empleado empleado4 = new Empleado("Pepe", "Uriel", LocalDate.parse("1991-10-04"), LocalDate.parse("2015-10-01"), "Administrativo", 24000);
        Empleado empleado5 = new Empleado("German", "Escudero", LocalDate.parse("2024-07-04"), LocalDate.parse("2024-03-21"), "Programador", 20000);

        empresa.add(empleado1);
        empresa.add(empleado2);
        empresa.add(empleado3);
        empresa.add(empleado4);
        empresa.add(empleado5);
    }//Terminado

    public static int menu() {
        System.out.println("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para añadir un empleado"+
                "\nSeleccione 2 para eliminar un empleado"+
                "\nSeleccione 3 para buscar un empleado y ver sus datos"+
                "\nSeleccione 4 para ver los empleados bajo un orden"+
                "\nSeleccione 5 para calcular el gasto total de los empleados de la empresa"+
                "\nSeleccione 6 para salir del programa");
        int opcion = scanner.nextInt();
        return opcion;
    }//Faltan excepciones

    public static void introducirEmpleado() {
        scanner.nextLine();
        //Introduce el nombre
        System.out.println("Indique el nombre del nuevo empleado");
        String nombreTemp = scanner.nextLine();

        //Introduce el apellido
        System.out.println("Indique el apellido del nuevo empleado");
        String apellidoTemp = scanner.nextLine();


        //Introduce la fehca de nacimiento
        System.out.println("Indique la fecha de nacimiento del nuevo empleado");
        System.out.println("Indique el dia de año de nacimiento");
        int añoN = scanner.nextInt();
        System.out.println("Indique el mes de nacimiento");
        int mesN = scanner.nextInt();
        System.out.println("Indique el dia de nacimiento");
        int diaN = scanner.nextInt();
        LocalDate fechaNacimientoTemp = LocalDate.of(añoN, mesN, diaN);

        //Introduce la fecha de ingreso
        System.out.println("Indique la fecha de ingreso del nuevo empleado");
        System.out.println("Indique el dia de año de ingreso");
        int añoI = scanner.nextInt();
        System.out.println("Indique el mes de ingreso");
        int mesI = scanner.nextInt();
        System.out.println("Indique el dia de ingreso");
        int diaI = scanner.nextInt();
        LocalDate fechaIngresoTemp = LocalDate.of(añoI, mesI, diaI);

        scanner.nextLine();
        //Introduce el puesto
        System.out.println("Indique el puesto del nuevo empleado");
        String puestoTemp = scanner.nextLine();

        //Introduce el salario
        System.out.println("Indique el salario del nuevo empleado");
        double salarioTemp = scanner.nextDouble();

        //Crea el nuevo empleado usando todas las variables anteriores
        Empleado empleadoTemp = new Empleado(nombreTemp, apellidoTemp, fechaNacimientoTemp, fechaIngresoTemp, puestoTemp, salarioTemp);
        empresa.add(empleadoTemp);
    }//Faltan excepciones

    public static void eliminarEmpleado(ArrayList<Empleado> empresa, String nombre) {
        Iterator<Empleado> eliminar = empresa.iterator();
        while (eliminar.hasNext()){
            Empleado empleado = eliminar.next();
            if (empleado.getNombre().equals(nombre)){
                eliminar.remove();
                return;
            }//Fin if
        }//Fin while
        System.out.println("No se encontro ningun empleado con el nombre introducido");//En caso de no encontrarse al empleado se mostrara el mensaje de no encontrado
    }//Terminado

    public static void mostrarEmpleado(ArrayList<Empleado> empresa, String nombre) {
        for (Empleado empleado : empresa) {
            if (empleado.getNombre().equals(nombre)) {
                System.out.println(empleado);
                return;
            }//Fin if
        }//Fin for
        System.out.println("No se encontró ningún empleado con el nombre introducido");//En caso de no encontrarse al empleado se mostrara el mensaje de no encontrado
    }//Terminado

    public static void mostrarEmpresa() {
        System.out.println("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para ver los empleados ordenados por su antiguedad"+
                "\nSeleccione 2 para ver los empleados ordenados por su salario de menor a mayor"+
                "\nSeleccione 3 para ver los empleados ordenados por su apellido");
        int opcionOrden = scanner.nextInt();
        switch (opcionOrden){
            case 1:
                //Ordenacion de la lista de objetos por la antiguedad (fecha de ingreso)
                Collections.sort(empresa, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado a1, Empleado a2) {
                        return a1.getFechaIngreso().compareTo(a2.getFechaIngreso());
                    }//Fin compare
                });//Fin iterator
                break;
            case 2:
                //Ordenacion de la lista de objetos por el salario
                Collections.sort(empresa, new Comparator<Empleado>() {
                    @Override
                    public int compare(Empleado a1, Empleado a2) {
                        return Double.compare(a1.getSalario(), a2.getSalario());
                    }//Fin compare
                });//Fin iterator
                break;
            case 3://Terminado
                //Ordenacion de la lista de objetos por el apellido
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
    }//Faltan excepciones

    public static void gastoTotal() {
        double total = 0;
        Iterator<Empleado> salarios = empresa.iterator();
        while (salarios.hasNext()){
            Empleado empleado = salarios.next();
            total += empleado.getSalario();
        }
        System.out.println("El gasto total de todos los empleados de la empresa son "+total+"€");
    }//Terminado

    public static void ejecucion(){
        int opcion;
        do {
            System.out.println();
            opcion = menu();
            switch (opcion){
                case 1:
                    introducirEmpleado();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Introduce el nombre del empleado que desea despedir");
                    String eliminarE = scanner.nextLine();
                    eliminarEmpleado(empresa, eliminarE);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Introduce el nombre del empleado del que desea ver sus datos");
                    String mostrarE = scanner.nextLine();
                    mostrarEmpleado(empresa, mostrarE);
                    break;
                case 4:
                    mostrarEmpresa();
                    int j = 1;
                    for (Empleado empresa : empresa){
                        System.out.println(j+"-"+empresa);
                        j++;
                    }
                    break;
                case 5:
                    gastoTotal();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion!=6);
    }//Faltan excepciones

    public static void main(String[] args) {
        ListaEmpleados();
        ejecucion();
    }//Terminado
}
