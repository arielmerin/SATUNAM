package com.dgpunam.UIMenu;

import com.dgpunam.*;
import com.dgpunam.util.ArregloDinamico;
import com.dgpunam.serializer.*;
import java.util.Scanner;
import static com.dgpunam.util.DgpUnamUtil.*;

/**
 * <h1>CLASE MENU </h1>
 * Clase que se encarga de mostrar el menu y a interaccion con el usuario, en general despliega menus y llama a sus
 * propios metodos para satisfacer las demandas del usuario.
 *
 * @author Aquino Chapa Armando Abraham and Merino Peña Kevin Ariel
 * @version 1.0
 */
public class UImenu {
    static Serializer serializer = new Serializer();
    static String ruta = "Base_Datos.dat";
    static ArregloDinamico<Trabajador> trabajadorArregloDinamico = new ArregloDinamico<>(50);

    /**
     * Menu prinicpal que permite mostrar las primeras opciones de naviegacion, obteniendo la respuesta del usuaraio
     * ingresa a los demas metodos de la misma clase.
     */
    public static void uiMenu(){
        System.out.println(serializer.read(ruta));
        if(serializer.read(ruta) != null){
            trabajadorArregloDinamico = (ArregloDinamico<Trabajador>) serializer.read(ruta);
            System.out.println("La ruta no tenia null");
        }
        System.out.println( trabajadorArregloDinamico == null ? "Esta en null": "NO es null");
        String label = "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\ \n";
        System.out.println( label + " BIENVENIDO A DGP UNAM \n");
        boolean continuar = true;
        do {
            System.out.println(" :: MENÚ PRINCIPAL ::   \n");
            System.out.println(" [1] Dar de alta un empleado");
            System.out.println(" [2] Dar de baja un empleado");
            System.out.println(" [3] Ver los datos de un empleado, (proporcionando su matricula)");
            System.out.println(" [4] Imrpmir cheque de un empleado (proporcionando su matricula)");
            System.out.println(" [5] Ver antigüedad de un empleado (proporcionando su matricula)");
            System.out.println(" [6] Modificar algún empleado (proporcionando su matricula)");
            System.out.println(" [7] Mostrar la lista de todos los empleados");
            System.out.println(" [0] Salir \n");
            int answer = getInt(" Seleccione la opción deseada: ", "Error, ingrese un valor válido");
            switch (answer) {
                case 1:
                    System.out.println(" :: ALTA DE EMPLEADOS ::");
                    altaMenu();
                    break;
                case 2:
                    System.out.println(" :: BAJA DE EMPLEADOS :: ");
                    eraseMenu();
                    break;
                case 3:
                    System.out.println(" :: CONSULTAR DATOS ::  ");
                    buscaEmpleado();
                    break;
                case 4:
                    System.out.println(" :: IMPRMIR CHEQUE ::  ");
                    int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
                    System.out.println(trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico,matricula)) == null ? "Hello nada por aqui" : trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico,matricula)).cheque());;
                    break;
                case 5:
                    System.out.println(":: ANTIGÜEDAD ::  ");
                    antiguedadEmpleado();
                    break;
                case 6:
                    System.out.println(":: MODIFICAR EMPLEADO ::  ");
                    modificarEmpleado();
                    break;
                case 0:
                    serializer.write(trabajadorArregloDinamico, ruta);
                    System.out.println("¡¡¡Hasta pronto!!!\n\n" + label);
                    continuar = false;
                    break;
                case 7:
                    System.out.println(trabajadorArregloDinamico != null ? trabajadorArregloDinamico : "La lista se encuentra vacia");
                    break;
                default:
                    System.out.println("Error, seleccione una opción válida\n");
            }
        }while (continuar);
    }

    /**
     * En este metodo se interactua con el usuario al requerir los tipos de trabajador que se crearan para posteriormente
     * demandar los datos correspondientes, este metodo se encarga de llamar los metodos necesarios para capturar dicha
     * informacion desde la terminal y asignarla a un nuevo empleado.
     */
    public static void altaMenu(){
        boolean continuar = true;
        Scanner scan = new Scanner(System.in);
        String nombre = getStr("Ingrese el nombre del Trabajador: ");
        System.out.println("Este es el nombre que le asignó: " + nombre);

        String apellidoPaterno = getStr("Ingresse el apellido paterno: ");
        System.out.println("Apellido paterno asignado " + apellidoPaterno);

        String apellidoMaterno = getStr("Ingrese el apellido materno: ");
        System.out.println("Apellido paterno asignado " + apellidoMaterno);

        System.out.println("Ingresa el curp del Trabajador: ");
        String curp = scan.nextLine();
        System.out.println("El curp ingresado fue: " + curp);

        System.out.println("Ingresa el domicilio del Trabajador: ");
        String direccion = scan.nextLine();
        System.out.println("La dirección ingresada fue: "+ direccion );

        System.out.println("Ingresa el e-mail del investigador: ");
        String correo = scan.nextLine();
        System.out.println("El correo ingresado fue: "+ correo );

        int matricula = getInt("Ingresa la matrícula del investigador: ","Error, ingrese un valor numérico");
        System.out.println("La matricula ingresada fue: "+matricula);

        double salario = getDouble("Ingrese el salario","Error, ingrese valores numéricos con decimales");
        System.out.println("El salario registrado de " + nombre + " es: $"+salario);

        int dia = getInt("Ingrese el día en que fue contratado: ", "Error, debe ingresar un valor numérico");
        int mes = getInt("Ingrese el mes en que fue contratado: ", "Error, debe ingresar un valor numérico");
        int agno = getInt("Ingrese el año en que fue contratado: ", "Error, debe ingresar un valor numérico");
        System.out.println("La fecha de contratación fue: " + dia+"/"+mes+"/"+agno);

        do {
            System.out.println("El tipo de trabajador");
            System.out.println("[1] Investigador");
            System.out.println("[2] Profesor");
            System.out.println("[3] Ayudante");
            System.out.println("[4] Administrativo");
            continuar = false;
            int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
            switch (respuesta){
                case 1:
                    String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
                    String nivelInve = getStr("Ingrese el nivel de investigador: ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Investigador investigador = new Investigador(nombre, apellidoPaterno, apellidoMaterno, curp, direccion,
                            correo, matricula, salario,dia, mes, agno, facultity, nivelInve, nivelSni);
                    System.out.println(investigador);
                    trabajadorArregloDinamico.agrega(investigador);
                    serializer.write(trabajadorArregloDinamico, ruta);
                    break;
                case 2:
                    String facultityProfe = getStr("Ingrese la facultad a la que pertenece el profesor: ");
                    String claseP = getStr("Ingresa la clase que imparte: " );
                    Trabajador.Horario horarioProf = hacerHorario();
                    System.out.print("Ingresa el nivel del profesor: ");
                    String nivelProf = scan.nextLine();
                    System.out.print("Ingresa el titulo del profesor: ");
                    String tituloProf = scan.nextLine();

                    Profesor profe = new Profesor(nombre, apellidoPaterno,apellidoMaterno, curp, direccion, correo,
                            matricula, salario, dia, mes, agno, facultityProfe, claseP, horarioProf, nivelProf, tituloProf);
                    trabajadorArregloDinamico.agrega(profe);
                    serializer.write(trabajadorArregloDinamico, ruta);
                    break;
                case 3:
                    String facultityAyu = getStr("Ingrese la facultad a la que pertenece el profesor: ");
                    int creditos = getInt("Ingrese los creditos del ayudante: ", "Errorm ingrese valores numericos");
                    int titul = getInt("Ingrese 1 si el ayudante esta titulado, 0 si no lo esta  ", "Errorm ingrese valores numericos");
                    boolean titulado = (titul == 1)?true: false;
                    String claseA = getStr("Ingresa la clase que imparte: " );
                    Trabajador.Horario horarioAyu = hacerHorario();

                    Ayudante ayud = new Ayudante(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correo,
                            matricula, salario, dia, mes, agno, facultityAyu, creditos, titulado, claseA, horarioAyu);

                    trabajadorArregloDinamico.agrega(ayud);
                    serializer.write(trabajadorArregloDinamico, ruta);
                    break;
                case 4:
                    String lugar = getStr("Ingresa el lugar de trabajo: ");
                    String puesto = getStr("Ingresa el lugar de trabajo: ");
                    Trabajador.Horario horarioAd = hacerHorario();

                    Trabajador adm = new Adiministrativo(nombre, apellidoPaterno, apellidoMaterno, curp, direccion,
                            correo, matricula, salario, dia, mes, agno, lugar,puesto,horarioAd);
                    trabajadorArregloDinamico.agrega(adm);
                    serializer.write(trabajadorArregloDinamico, ruta);
                    break;
                default:
                    continuar = true;
                    System.out.println("Selecciona un tipo de trabajador, es necesario\n");
            }
        }while (continuar);
    }

    /**
     * Es el encargado de mostrar la opcion de eliminar que se encuentra contenida en el metodo uIMenu() de esta misma clase
     * haciendo uso del numero de matricula proporcionado elimina al empleado en cuestion
     */
    public static void eraseMenu(){
        int buscado = getInt("Ingrese la maatricula del empleado que desea eliminar",
                "Error, ingrese un valor numerico");
        Trabajador buscando = trabajadorArregloDinamico.elimina(lookingFor(trabajadorArregloDinamico, buscado));
        System.out.println(buscando != null ? "Eliminamos correctamente a: " + buscando.getNombre() : "No se encontro en la base de datos");

    }

    /**
     * <h2>Busqueda</h2>
     * <p>  Realiza la parte interactiva con el usuario cuando este desea buscar un empleado en la base de datos, y ademas
     * lo imprime</p>
     */
    public static void buscaEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println(trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico, matricula)) != null ? trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico, matricula)): matricula + " No se encontro en la base de datos");
    }

    /**
     * <h2>Antiguedad</h2>
     * En esta opcion se permite visualizar la antiguedad de algun empleado y dado su numero de matricula y ademas se encarga
     * de imprimir dicho valor
     */
    public static void antiguedadEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println("La antiguedad de " + trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico, matricula)).getNombre() + "  es \n");
        System.out.println(trabajadorArregloDinamico.busca(lookingFor(trabajadorArregloDinamico, matricula)).getAntiguedad());
    }

    /**
     * Haciendo uso de la busqueda este metodo realiza el cambio en los datos de algun empleado volviendo a pedir todos
     * sus datos de nuevo, una vez que fue encontrado en la base de datos.
     */
    public static void modificarEmpleado(){

        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        int indice = lookingFor(trabajadorArregloDinamico, matricula);
        Trabajador modificaTrabajador = trabajadorArregloDinamico.busca(2);
        System.out.println("Este es el empleado a modificar: \n" + modificaTrabajador);
        altaMenu();

        //System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)));
    }

}
