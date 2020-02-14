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
    private static ArregloDinamico<Trabajador> trabajadores = new ArregloDinamico();

    /**
     * Menu prinicpal que permite mostrar las primeras opciones de naviegacion, obteniendo la respuesta del usuaraio
     * ingresa a los demas metodos de la misma clase.
     */
    public static void uiMenu(){
        Serializer q = new Serializer();
        String label = "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\\n" +
                "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\ \n\n";


        System.out.println( label + " BIENVENIDO A DGP UNAM \n");
        trabajadores = q.read("Base_Datos.ser");
        boolean continuar = true;
        do {
            try {
                System.out.println(" :: MENÚ PRINCIPAL ::   \n");
                System.out.println(" [1] Dar de alta un empleado \n");
                System.out.println(" [2] Dar de baja un empleado \n");
                System.out.println(" [3] Ver los datos de un empleado, (proporcionando su matricula) \n");
                System.out.println(" [4] Imrpmir cheque de un empleado (proporcionando su matricula)\n");
                System.out.println(" [5] Ver antigüedad de un empleado (proporcionando su matricula)\n");
                System.out.println(" [6] Modificar algún empleado (proporcionando su matricula)\n");
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
                        Trabajador tab = trabajadores.busca(lookingFor(trabajadores, matricula));
                        tab.cheque();
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
                        System.out.println("¡¡¡Hasta pronto!!!\n\n" + label);
                        q.write(trabajadores, "Base_Datos.ser");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Error, seleccione una opción válida\n");
                        break;
                }
                q.write(trabajadores, "Base_Datos.ser");
            }catch(NullPointerException e){
                System.out.println(">>No se ha actualizado la base de datos<<<");
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
        System.out.println(trabajadores);
        do {
            System.out.println("Ingrese una opción válida");
            System.out.println("[1] Investigador");
            System.out.println("[2] Profesor");
            System.out.println("[3] Ayudante");
            System.out.println("[4] Administrativo");
            System.out.println("[0] Regresar al menu princial");
            Scanner scan = new Scanner(System.in);
            int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
            switch (respuesta){
                case 1:
                    Trabajador inv = menuAltaGralTrabajador();
                    String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
                    String nivelInve = getStr("Ingrese el nivel de investigador: ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Investigador arielin = new Investigador(inv.getNombre(),inv.getApellidoPaterno(),inv.getApellidoMaterno(),
                            inv.getCurp(),inv.getDireccion(), inv.getCorreoElectronico(),inv.getMatricula(), inv.getSueldo(),
                            inv.getDiaContrat(), inv.getMes(), inv.getYear(), facultity, nivelInve, nivelSni);

                    trabajadores.agrega(arielin);
                    System.out.println(trabajadores);

                    break;
                case 2:
                    Trabajador prof = menuAltaGralTrabajador();
                    String facultityProfe = getStr("Ingrese la facultad a la que pertenece el profesor: ");
                    String claseP = getStr("Ingresa la clase que imparte: " );
                    Trabajador.Horario horarioProf = hacerHorario();
                    System.out.print("Ingresa el nivel del profesor: ");
                    String nivelProf = scan.nextLine();
                    System.out.print("Ingresa el titulo del profesor: ");
                    String tituloProf = scan.nextLine();

                    Profesor profe = new Profesor(prof.getNombre(),prof.getApellidoPaterno(), prof.getApellidoMaterno(),
                            prof.getCurp(), prof.getDireccion(), prof.getCorreoElectronico(), prof.getMatricula(),
                            prof.getSueldo(), prof.getDiaContrat(), prof.getMes(), prof.getYear(), facultityProfe,
                            claseP, horarioProf, nivelProf, tituloProf);

                    trabajadores.agrega(profe);
                    System.out.println(trabajadores);

                    break;
                case 3:
                    Trabajador ayu = menuAltaGralTrabajador();
                    String facultityAyu = getStr("Ingrese la facultad a la que pertenece el profesor: ");
                    int creditos = getInt("Ingrese los creditos del ayudante: ", "Errorm ingrese valores numericos");
                    int titul = getInt("Ingrese 1 si el ayudante esta titulado, 0 si no lo esta  ", "Errorm ingrese valores numericos");
                    boolean titulado = (titul == 1)?true: false;
                    String claseA = getStr("Ingresa la clase que imparte: " );
                    Trabajador.Horario horarioAyu = hacerHorario();

                    Ayudante ayud = new Ayudante(ayu.getNombre(), ayu.getApellidoPaterno(), ayu.getApellidoMaterno(), ayu.getCurp(),
                            ayu.getDireccion(), ayu.getCorreoElectronico(), ayu.getMatricula(), ayu.getSueldo(), ayu.getDiaContrat(),
                            ayu.getMes(), ayu.getYear(), facultityAyu, creditos, titulado, claseA, horarioAyu);

                    trabajadores.agrega(ayud);
                    System.out.println(trabajadores);
                    System.out.println("Base de datos actualizada");
                    break;
                case 4:
                    Trabajador admin = menuAltaGralTrabajador();
                    String lugar = getStr("Ingresa el lugar de trabajo: ");
                    String puesto = getStr("Ingresa el lugar de trabajo: ");
                    Trabajador.Horario horarioAd = hacerHorario();

                    Trabajador adm = new Adiministrativo(admin.getNombre(), admin.getApellidoPaterno(), admin.getApellidoMaterno(),
                            admin.getCurp(),admin.getDireccion(),admin.getCorreoElectronico(),admin.getMatricula(),admin.getSueldo(),
                            admin.getDiaContrat(),admin.getMes(),admin.getYear(),lugar,puesto,horarioAd);

                    trabajadores.agrega(adm);
                    System.out.println(trabajadores);
                    
                case 0:
                    System.out.println("Volviendo al menú principal...\n");
                    continuar = false;
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
        trabajadores.elimina(lookingFor(trabajadores, buscado));
    }

    /**
     * <h2>Busqueda</h2>
     * <p>  Realiza la parte interactiva con el usuario cuando este desea buscar un empleado en la base de datos, y ademas
     * lo imprime</p>
     */
    public static void buscaEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)));
    }

    /**
     * <h2>Antiguedad</h2>
     * En esta opcion se permite visualizar la antiguedad de algun empleado y dado su numero de matricula y ademas se encarga
     * de imprimir dicho valor
     */
    public static void antiguedadEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)).getAntiguedad());
    }

    /**
     * Haciendo uso de la busqueda este metodo realiza el cambio en los datos de algun empleado volviendo a pedir todos
     * sus datos de nuevo, una vez que fue encontrado en la base de datos.
     */
    public static void modificarEmpleado(){

        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        int indice = lookingFor(trabajadores, matricula);
        Trabajador modificaTrabajador = trabajadores.busca(indice);
        System.out.println("Este es el empleado a modificar: \n" + modificaTrabajador);
        Trabajador gral = menuAltaGralTrabajador();
        Scanner scan = new Scanner(System.in);
        if(modificaTrabajador instanceof Profesor){
            String facultityProfe = getStr("Ingrese la facultad a la que pertenece el profesor: ");
            String claseP = getStr("Ingresa la clase que imparte: " );
            Trabajador.Horario horarioProf = hacerHorario();
            System.out.print("Ingresa el nivel del profeso  r: ");
            String nivelProf = scan.nextLine();
            System.out.print("Ingresa el titulo del profesor: ");
            String tituloProf = scan.nextLine();

            Profesor profe = new Profesor(gral.getNombre(),gral.getApellidoPaterno(), gral.getApellidoMaterno(),
                    gral.getCurp(), gral.getDireccion(), gral.getCorreoElectronico(), gral.getMatricula(),
                    gral.getSueldo(), gral.getDiaContrat(), gral.getMes(), gral.getYear(), facultityProfe,
                    claseP, horarioProf, nivelProf, tituloProf);

            trabajadores.agrega(profe, indice);
        }else if(modificaTrabajador instanceof Ayudante){
            String facultityAyu = getStr("Ingrese la facultad a la que pertenece el profesor: ");
            int creditos = getInt("Ingrese los creditos del ayudante: ", "Errorm ingrese valores numericos");
            int titul = getInt("Ingrese 1 si el ayudante esta titulado, 0 si no lo esta  ", "Errorm ingrese valores numericos");
            boolean titulado = (titul == 1)?true: false;
            String claseA = getStr("Ingresa la clase que imparte: " );
            Trabajador.Horario horarioAyu = hacerHorario();

            Ayudante ayudante = new Ayudante(gral.getNombre(), gral.getApellidoPaterno(), gral.getApellidoMaterno(), gral.getCurp(),
                    gral.getDireccion(), gral.getCorreoElectronico(), gral.getMatricula(), gral.getSueldo(), gral.getDiaContrat(),
                    gral.getMes(), gral.getYear(), facultityAyu, creditos, titulado, claseA, horarioAyu);

            trabajadores.agrega(ayudante, indice);

        }else if (modificaTrabajador instanceof Investigador){
            String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
            String nivelInve = getStr("Ingrese el nivel de investigador: ");
            String nivelSni = getStr("Ingrese la categoría en el SNI");

            Investigador investigador = new Investigador(gral.getNombre(),gral.getApellidoPaterno(),gral.getApellidoMaterno(),
                    gral.getCurp(),gral.getDireccion(), gral.getCorreoElectronico(),gral.getMatricula(), gral.getSueldo(),
                    gral.getDiaContrat(), gral.getMes(), gral.getYear(), facultity, nivelInve, nivelSni);

            trabajadores.agrega(investigador, indice);
        }else{
            String lugar = getStr("Ingresa el lugar de trabajo: ");
            String puesto = getStr("Ingresa el lugar de trabajo: ");
            Trabajador.Horario horarioAd = hacerHorario();

            Trabajador adm = new Adiministrativo(gral.getNombre(), gral.getApellidoPaterno(), gral.getApellidoMaterno(),
                    gral.getCurp(),gral.getDireccion(),gral.getCorreoElectronico(),gral.getMatricula(),gral.getSueldo(),
                    gral.getDiaContrat(),gral.getMes(),gral.getYear(),lugar,puesto,horarioAd);

            trabajadores.agrega(adm, indice);
        }

        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)));
    }

}
