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
        if(serializer.read(ruta) != null){
            trabajadorArregloDinamico = (ArregloDinamico<Trabajador>) serializer.read(ruta);
        }
        String label = "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\ \n";
        System.out.println( label + " BIENVENIDO A DGP UNAM \n");
        boolean continuar = true;
        do {
            System.out.println(" :: MENÚ PRINCIPAL ::   \n");
            System.out.println(" [1] Dar de alta un empleado");
            System.out.println(" [2] Dar de baja un empleado (proporcionando su matricula)");
            System.out.println(" [3] Ver los datos de un empleado (proporcionando su matricula)");
            System.out.println(" [4] Imprimir cheque de un empleado (proporcionando su matricula)");
            System.out.println(" [5] Modificar algún empleado (proporcionando su matricula)");
            System.out.println(" [6] Mostrar la lista de todos los empleados");
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
                    System.out.println(":: MODIFICAR EMPLEADO ::  ");
                    modificarEmpleado();
                    break;
                case 0:
                    serializer.write(trabajadorArregloDinamico, ruta);
                    System.out.println("¡¡¡Hasta pronto!!!\n\n" + label);
                    continuar = false;
                    break;
                case 6:
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
        do {
            System.out.println("Seleccione una opcion");
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
                    String facultity = getStr("Ingrese la facultad a la que pertenece el(la) investigadora: ");
                    String nivelInve = getStr("Ingrese el nivel del(la) investigador(a): ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Investigador investigador = new Investigador(inv.getNombre(), inv.getApellidoPaterno(), inv.getApellidoMaterno(),
                            inv.getCurp(), inv.getDireccion(), inv.getCorreoElectronico(),inv.getMatricula(),
                            inv.getSueldo(), inv.getDiaContrat(), inv.getMes(), inv.getYear(), facultity,
                            nivelInve, nivelSni);
                    trabajadorArregloDinamico.agrega(investigador);
                    serializer.write(trabajadorArregloDinamico, ruta);
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

                    Profesor profe = new Profesor(prof.getNombre(), prof.getApellidoPaterno(),prof.getApellidoMaterno(),
                            prof.getCurp(), prof.getDireccion(), prof.getCorreoElectronico(), prof.getMatricula(),
                            prof.getSueldo(), prof.getDiaContrat(), prof.getMes(), prof.getYear(), facultityProfe,
                            claseP, horarioProf, nivelProf, tituloProf);

                    trabajadorArregloDinamico.agrega(profe);
                    serializer.write(trabajadorArregloDinamico, ruta);
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

                    trabajadorArregloDinamico.agrega(ayud);
                    serializer.write(trabajadorArregloDinamico, ruta);
                    break;
                case 4:
                    Trabajador admin = menuAltaGralTrabajador();
                    String lugar = getStr("Ingresa el lugar de trabajo: ");
                    String puesto = getStr("Ingresa el lugar de trabajo: ");
                    Trabajador.Horario horarioAd = hacerHorario();

                    Trabajador adm = new Adiministrativo(admin.getNombre(), admin.getApellidoPaterno(), admin.getApellidoMaterno(),
                            admin.getCurp(),admin.getDireccion(),admin.getCorreoElectronico(),admin.getMatricula(),admin.getSueldo(),
                            admin.getDiaContrat(),admin.getMes(),admin.getYear(),lugar,puesto,horarioAd);

                    trabajadorArregloDinamico.agrega(adm);
                    serializer.write(trabajadorArregloDinamico, ruta);
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
     * Haciendo uso de la busqueda este metodo realiza el cambio en los datos de algun empleado volviendo a pedir todos
     * sus datos de nuevo, una vez que fue encontrado en la base de datos.
     */
    public static void modificarEmpleado(){

        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        int indice = lookingFor(trabajadorArregloDinamico, matricula);
        Trabajador modificaTrabajador = trabajadorArregloDinamico.busca(2);
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

            trabajadorArregloDinamico.agrega(profe, indice);
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

            trabajadorArregloDinamico.agrega(ayudante, indice);

        }else if (modificaTrabajador instanceof Investigador){
            String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
            String nivelInve = getStr("Ingrese el nivel de investigador: ");
            String nivelSni = getStr("Ingrese la categoría en el SNI");

            Investigador investigador = new Investigador(gral.getNombre(),gral.getApellidoPaterno(),gral.getApellidoMaterno(),
                    gral.getCurp(),gral.getDireccion(), gral.getCorreoElectronico(),gral.getMatricula(), gral.getSueldo(),
                    gral.getDiaContrat(), gral.getMes(), gral.getYear(), facultity, nivelInve, nivelSni);

            trabajadorArregloDinamico.agrega(investigador, indice);
        }else{
            String lugar = getStr("Ingresa el lugar de trabajo: ");
            String puesto = getStr("Ingresa el lugar de trabajo: ");
            Trabajador.Horario horarioAd = hacerHorario();

            Trabajador adm = new Adiministrativo(gral.getNombre(), gral.getApellidoPaterno(), gral.getApellidoMaterno(),
                    gral.getCurp(),gral.getDireccion(),gral.getCorreoElectronico(),gral.getMatricula(),gral.getSueldo(),
                    gral.getDiaContrat(),gral.getMes(),gral.getYear(),lugar,puesto,horarioAd);

            trabajadorArregloDinamico.agrega(adm, indice);
        }
    }
}
