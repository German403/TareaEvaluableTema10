package TareaEvaluable;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * @author German Escudero Rodriguez
 * @version jdk-17
 * 21/03/2024
 * Este programa registra empleados de una empresa y los almacena en un ArrayList simulando una base de datos
 * En el programa tambien se podran tratar esos datos como añadir nuevos empleados, eliminarlos o verlos mediante los diferentes metodos del programa
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean repetir = false;//Variable que se usara para los bucles de las excepciones de los diferentes metodos del codigo
    public static ArrayList<Empleado> empresa = new ArrayList<Empleado>();

    /**
     * Metodo donde se crean los objetos de los empleados que estaran en el ArrayList desde el principio y los añade a esta
     * Primero crea los objetos de cada uno de los 5 empleados que deben existir desde el principio y fueron dados por el enunciado
     * Luego los añade al ArrayList
     */
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
    }//Fin metodo listaEmpleados

    /**
     * Metodo menu donde se detallan las opciones que da el codigo para manipular los datos
     * Retonra la opcion elegida
     * @return opcion
     * @throws NumberFormatException excepcion para los casos en que se utilice un caracter diferente a un numero entero
     * @throws IllegalAccessException excepcion personalizada para los casos en que el entero se menor a 1 o mayor a 6
     */
    public static int menu() {
        int opcion = 0;
        do {
            repetir = false;
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones"+
                        "\nSeleccione 1 para añadir un empleado"+
                        "\nSeleccione 2 para eliminar un empleado"+
                        "\nSeleccione 3 para buscar un empleado y ver sus datos"+
                        "\nSeleccione 4 para ver los empleados bajo un orden"+
                        "\nSeleccione 5 para calcular el gasto total de los empleados de la empresa"+
                        "\nSeleccione 6 para salir del programa"));
                if (opcion < 1 || opcion > 6){
                    throw new IllegalAccessException();
                }
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "Valor no valido, error de formato", "Error de opcion", 0);
                repetir = true;
            }catch (IllegalAccessException e2){
                JOptionPane.showMessageDialog(null, "Las opciones son de 1 a 6", "Error de opcion", 0 );
                repetir = true;
            }
        }while(repetir);
        return opcion;
    }//Fin metodo menu

    /**
     * Metodo para añadir un nuevo empleado al ArrayList
     * En el se crearan unas variables temporales donde se les dara los valores correspondientes que introducira el usuario y luego se creara el objeto con esos valores
     * Una vez creado el objeto se añadira al ArrayList en ultima posicion
     * En el metodo se le asignara un sistema de excepciones que no permitira avanzar hasta que las condiciones sean correctas
     * @throws InputMismatchException
     * @throws NumberFormatException excepcion para los casos en que se utilice un caracter diferente a un numero entero
     * @throws IllegalAccessException excepcion personalizada para los casos en que el entero este fuera del rango establecido
     * @throws DateTimeException excepcion solo para las variables de tipo LocalDate que se activara en caso de que la fehca sea imposible
     */
    public static void introducirEmpleado() {
        String nombreTemp = "";
        String apellidoTemp = "";
        int añoN = 0;
        int mesN = 0;
        int diaN = 0;
        LocalDate fechaNacimientoTemp = null;
        int añoI = 0;
        int mesI = 0;
        int diaI = 0;
        LocalDate fechaIngresoTemp = null;
        String puestoTemp = "";
        double salarioTemp = 0;
        //Introduce el nombre
        do {
            repetir = false;
            try{
                nombreTemp = JOptionPane.showInputDialog("Indique el nombre del nuevo empleado");
            }catch (InputMismatchException e1){
                JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de texto", "Error de formato", 0);
                repetir = true;
            }
        }while(repetir);

        //Introduce el apellido
        do {
            repetir = false;
            try{
                apellidoTemp = JOptionPane.showInputDialog("Indique el apellido del nuevo empleado");
            }catch (InputMismatchException e1){
                JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de texto", "Error de formato", 0);
                repetir = true;
            }
        }while(repetir);


        //Introduce la fehca de nacimiento
        do{
            repetir = false;
            do {
                repetir = false;
                try{
                    añoN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el año de nacimiento"));
                    if (añoN < 1950){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "La fecha debe ser posterior a 1950", "Error de feccha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    mesN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el mes de nacimiento"));
                    if (mesN < 01 || mesN > 12){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "Elige un mes de 1 a 12", "Error de fecha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    diaN = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de nacimiento del nuevo empleado"+ "\nIndique el dia de nacimiento"));
                    if (diaN < 01 || diaN > 31){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "Elige un dia de 1 a 31", "Error de fecha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    fechaNacimientoTemp = LocalDate.of(añoN, mesN, diaN);
                }catch (DateTimeException e1){
                    JOptionPane.showMessageDialog(null, "Fecha no posible", "Error de fehca", 0);
                    repetir = true;
                }
                break;
            }while(repetir);
        }while(repetir);

        //Introduce la fecha de ingreso
        do {
            repetir = false;
            do {
                repetir = false;
                try{
                    añoI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el año de ingreso"));
                    if (añoN < 1980){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "La fecha de contratacion debe ser posterior a 1980", "Error de fecha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    mesI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el mes de ingreso"));
                    if (mesI < 01 || mesI > 12){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "Elige un mes de 1 a 12", "Error de fecha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    diaI = Integer.parseInt(JOptionPane.showInputDialog("Indique la fecha de ingreso del nuevo empleado"+ "\nIndique el dia de ingreso"));
                    if (diaI < 01 || diaI > 31){
                        throw new IllegalAccessException();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros enteros", "Error de formato", 0);
                    repetir = true;
                }catch (IllegalAccessException e2){
                    JOptionPane.showMessageDialog(null, "Elige un dia de 1 a 31", "Error de fecha", 0);
                    repetir = true;
                }
            }while(repetir);
            do {
                repetir = false;
                try{
                    fechaIngresoTemp = LocalDate.of(añoI, mesI, diaI);
                }catch (DateTimeException e1){
                    JOptionPane.showMessageDialog(null, "Fecha no posible", "Error de fehca", 0);
                    repetir = true;
                }
                break;
            }while(repetir);
        }while (repetir);

        //Introduce el puesto
        do {
            repetir = false;
            try{
                puestoTemp = JOptionPane.showInputDialog("Indique el puesto del nuevo empleado");
            }catch (InputMismatchException e1){
                JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de texto", "Error de formato", 0);
                repetir = true;
            }
        }while(repetir);

        //Introduce el salario
        do {
            repetir = false;
            try{
                salarioTemp = Double.parseDouble(JOptionPane.showInputDialog("Indique el salario del nuevo empleado"));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "Solo se permiten numeros y decimales, recuerde que el decimal se usa con el '.'", "Error de formato", 0);
                repetir = true;
            }
        }while(repetir);

        //Se muestra el empleado recien creado
        JOptionPane.showMessageDialog(null, "El nuevo empleado "+nombreTemp+" "+apellidoTemp+" nacido en "+fechaNacimientoTemp+" ha sido contratado en "+fechaIngresoTemp+" con puesto de "+puestoTemp+" y salario de "+salarioTemp+"€", "Datos del nuevo empleado contratado", 1);

        //Crea el nuevo empleado usando todas las variables anteriores
        Empleado empleadoTemp = new Empleado(nombreTemp, apellidoTemp, fechaNacimientoTemp, fechaIngresoTemp, puestoTemp, salarioTemp);
        empresa.add(empleadoTemp);
    }//Fin metodo introducir empleado

    /**
     * Metododo que busca y compara los empleados existentes con el nombre dado y en caso de coincidencia lo borra del ArrayList
     * @param empresa
     * @param nombre
     */
    public static void eliminarEmpleado(ArrayList<Empleado> empresa, String nombre) {
        Iterator<Empleado> eliminar = empresa.iterator();
        while (eliminar.hasNext()){
            Empleado empleado = eliminar.next();
            if (empleado.getNombre().equals(nombre)){
                eliminar.remove();
                return;
            }//Fin if
        }//Fin while
        JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el nombre introducido", "Error de busqueda", 0);//En caso de no encontrarse al empleado se mostrara el mensaje de no encontrado
    }//Fin metodo eliminarEmpleado

    /**
     * Metododo que busca y compara los empleados existentes con el nombre dado y en caso de coincidencia lo muestra en pantalla
     * @param empresa
     * @param nombre
     */
    public static void mostrarEmpleado(ArrayList<Empleado> empresa, String nombre) {
        for (Empleado empleado : empresa) {
            if (empleado.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, empleado, "Datos del empleado", 1);
                //System.out.println(empleado);
                return;
            }//Fin if
        }//Fin for
        JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el nombre introducido", "Error de busqueda", 0);//En caso de no encontrarse al empleado se mostrara el mensaje de no encontrado
    }//Fin metodo mostrarEmpleado

    /**
     * Metodo de ordencion del ArrayList de mediante diferentes preferencias segun el caso elegido
     * Los empleados se ordenaran segun su antigÜedad en la empresa, segun su salario o segun su apellido mediante la comparacion de sus valores
     * @throws NumberFormatException excepcion para los casos en que se utilice un caracter diferente a un numero entero
     * @throws IllegalAccessException excepcion personalizada para los casos en que el entero se menor a 1 o mayor a 3
     */
    public static void mostrarEmpresa() {
        int opcionOrden = 0;
        do {
            repetir = false;
            try{
                opcionOrden = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones"+
                        "\nSeleccione 1 para ver los empleados ordenados por su antiguedad"+
                        "\nSeleccione 2 para ver los empleados ordenados por su salario de menor a mayor"+
                        "\nSeleccione 3 para ver los empleados ordenados por su apellido"));
                if (opcionOrden < 1 || opcionOrden > 3){
                    throw new IllegalAccessException();
                }
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "Valor no valido, error de formato", "Error de opcion", 0);
                repetir = true;
            }catch (IllegalAccessException e2){
                JOptionPane.showMessageDialog(null, "Las opciones son de 1 a 3", "Error de opcion", 0 );
                repetir = true;
            }
        }while(repetir);
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
        }
    }//Fin metodo mostrarEmpresa

    /**
     * Metodo que toma el valor del salario de todos los empleados y los suma devolviendo el valor total de la suma de todos los empleados del ArrayList
     */
    public static void gastoTotal() {
        double total = 0;
        Iterator<Empleado> salarios = empresa.iterator();
        while (salarios.hasNext()){
            Empleado empleado = salarios.next();
            total += empleado.getSalario();
        }//Fin while
        JOptionPane.showMessageDialog(null, "El gasto total de todos los empleados de la empresa es de "+total+"€", "Gastos de la empresa", 1);
    }//Fin metodo gastoTotal

    /**
     * Metodo donde se ejecutara la opcion segun la elegida en el metodo menu y este usara el metodo al que corresponda cada caso del switch
     * @throws InputMismatchException
     */
    public static void ejecucion(){
        int opcion;
        do {
            opcion = menu();
            switch (opcion){
                case 1:
                    introducirEmpleado();
                    break;
                case 2:
                    String eliminarE = "";
                    do {
                        repetir = false;
                        try{
                            eliminarE = JOptionPane.showInputDialog("Introduce el nombre del empleado que desea despedir");
                        }catch (InputMismatchException e1){
                            JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de texto", "Error de formato", 0);
                            repetir = true;
                        }
                    }while (repetir);
                    eliminarEmpleado(empresa, eliminarE);
                    break;
                case 3:
                    String mostrarE = "";
                    do {
                        repetir = false;
                        try{
                            mostrarE = JOptionPane.showInputDialog("Introduce el nombre del empleado del que desea ver sus datos");
                        }catch (InputMismatchException e1){
                            JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de texto", "Error de formato", 0);
                            repetir = true;
                        }
                    }while (repetir);
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
            }//Fin switch
        }while (opcion!=6);//Fin do-while
    }//Fin metodo ejecucion

    /**
     * Metodo main del programa
     * Se invoca el metodo ListaEmpleados que es en el cual se crearon los objetos y fueron añadidos al ArrayList para que la lista contenga datos desde el principio
     * Se invoca el metodo ejecucion donde estan todas las opcion para la manipulacion de los datos
     * @param args
     */
    public static void main(String[] args) {
        ListaEmpleados();
        ejecucion();
    }//Fin main
}
