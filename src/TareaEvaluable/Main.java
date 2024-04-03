package TareaEvaluable;

import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;

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
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para añadir un empleado"+
                "\nSeleccione 2 para eliminar un empleado"+
                "\nSeleccione 3 para buscar un empleado y ver sus datos"+
                "\nSeleccione 4 para ver los empleados bajo un orden"+
                "\nSeleccione 5 para calcular el gasto total de los empleados de la empresa"+
                "\nSeleccione 6 para salir del programa"));
        return opcion;
    }//Faltan excepciones

    public static void introducirEmpleado() {

        //Introduce el nombre
        String nombreTemp = JOptionPane.showInputDialog("Indique el nombre del nuevo empleado");

        //Introduce el apellido
        String apellidoTemp = JOptionPane.showInputDialog("Indique el apellido del nuevo empleado");

        //Introduce la fehca de nacimiento
        int añoN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el año de nacimiento"));
        int mesN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el mes de nacimiento"));
        int diaN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el dia de nacimiento"));
        LocalDate fechaNacimientoTemp = LocalDate.of(añoN, mesN, diaN);

        //Introduce la fecha de ingreso
        int añoI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el año de ingreso"));
        int mesI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el mes de ingreso"));
        int diaI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el dia de ingreso"));
        LocalDate fechaIngresoTemp = LocalDate.of(añoI, mesI, diaI);

        //Introduce el puesto
        String puestoTemp = JOptionPane.showInputDialog("Indique el puesto del nuevo empleado");

        //Introduce el salario
        double salarioTemp = Double.parseDouble(JOptionPane.showInputDialog("Indique el salario del nuevo empleado"));

        //Se muestra el empleado recien creado
        JOptionPane.showMessageDialog(null, "El nuevo empleado "+nombreTemp+" "+apellidoTemp+" nacido en "+fechaNacimientoTemp+" ha sido contratado en "+fechaIngresoTemp+" con puesto de "+puestoTemp+" y salario de "+salarioTemp+"€", "Datos del nuevo empleado contratado", 1);

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
                JOptionPane.showMessageDialog(null, empleado, "Datos del empleado", 1);
                //System.out.println(empleado);
                return;
            }//Fin if
        }//Fin for
        JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el nombre introducido", "Error de busqueda", 0);//En caso de no encontrarse al empleado se mostrara el mensaje de no encontrado
    }//Terminado

    public static void mostrarEmpresa() {
        int opcionOrden = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones"+
                "\nSeleccione 1 para ver los empleados ordenados por su antiguedad"+
                "\nSeleccione 2 para ver los empleados ordenados por su salario de menor a mayor"+
                "\nSeleccione 3 para ver los empleados ordenados por su apellido"));
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
        JOptionPane.showMessageDialog(null, "El gasto total de todos los empleados de la empresa es de "+total+"€", "Gastos de la empresa", 1);
    }//Terminado

    public static void ejecucion(){
        int opcion;
        do {
            opcion = menu();
            switch (opcion){
                case 1:
                    introducirEmpleado();
                    break;
                case 2:
                    String eliminarE = JOptionPane.showInputDialog("Introduce el nombre del empleado que desea despedir");
                    eliminarEmpleado(empresa, eliminarE);
                    break;
                case 3:
                    String mostrarE = JOptionPane.showInputDialog("Introduce el nombre del empleado del que desea ver sus datos");
                    mostrarEmpleado(empresa, mostrarE);
                    break;
                case 4:
                    mostrarEmpresa();
                    int j = 1;
                    String mostrar = "";
                    for (Empleado empresa : empresa){
                        mostrar += j+"-"+empresa;
                        mostrar += "\n";
                        j++;
                    }
                    JOptionPane.showMessageDialog(null, mostrar, "Empleados de la empresa", 1);
                    break;
                case 5:
                    gastoTotal();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...", "Saliendo", 2);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Intentelo de nuevo ingresando una de las acciones validas", "Accion no valida", 0);
                    break;
            }
        }while (opcion!=6);
    }//Faltan excepciones

    public static void main(String[] args) {
        ListaEmpleados();
        ejecucion();
    }//Terminado
}
