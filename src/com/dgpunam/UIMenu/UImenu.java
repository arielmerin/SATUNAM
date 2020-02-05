package com.dgpunam.UIMenu;

import com.dgpunam.*;
import com.dgpunam.util.ArregloDinamico;

import java.io.IOException;
import java.util.Scanner;

import static com.dgpunam.util.DgpUnamUtil.*;

public class UImenu {
    private static ArregloDinamico<Trabajador> trabajadores;

    static {
        try {
            trabajadores = new ArregloDinamico();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void uiMenu(){
        String label = "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\\n" +
                "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\ \n\n";


        System.out.println( label + " BIENVENIDO A DGP UNAM \n");
        boolean continuar = true;
        do {
            System.out.println(" :: MENÚ PRINCIPAL ::   \n");
            System.out.println(" [1] Dar de alta un empleado \n");
            System.out.println(" [2] Dar de baja un empleado \n");
            System.out.println(" [3] Ver los datos de un empleado, (proporcionando su matricula) \n");
            System.out.println(" [4] Imrpmir cheque de un empleado (proporcionando su matricula)\n");
            System.out.println(" [5] Ver antiüedad de un empleado (proporcionando su matricula)\n");
            System.out.println(" [6] Modificar algún empleado (proporcionando su matricula)\n");
            System.out.println(" [0] Salir \n");

            int answer = getInt(" Seleccione la opción deseada: ", "Error, ingrese un valor válido");

            switch (answer){
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
                    imprimirCheque();
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
                    System.out.println("¡¡¡Hasta pronto!!!\n\n"+label);
                    continuar = false;
                    break;
                default:
                    System.out.println("Error, seleccione una opción válida\n");
            }
        }while (continuar);
    }
    public static void altaMenu(){
        boolean continuar = true;
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
                    Trabajador.Horario horarioProf = hacerHoraio();
                    System.out.print("Ingresa el nivel del profesor: ");
                    String nivelProf = scan.nextLine();
                    System.out.print("Ingresa el titulo del profesor: ");
                    String tituloProf = scan.nextLine();

                    Profesor profe = new Profesor(prof.getNombre(),prof.getApellidoPaterno(), prof.getApellidoMaterno(),
                            prof.getCurp(), prof.getDireccion(), prof.getCorreoElectronico(), prof.getMatricula(),
                            prof.getSueldo(), prof.getDiaContrat(), prof.getMes(), prof.getYear(), facultityProfe,
                            claseP, horarioProf, nivelProf, tituloProf);

                    trabajadores.agrega(profe);
                    break;
                case 3:
                    Trabajador ayu = menuAltaGralTrabajador();
                    String facultityAyu = getStr("Ingrese la facultad a la que pertenece el profesor: ");
                    int creditos = getInt("Ingrese los creditos del ayudante: ", "Errorm ingrese valores numericos");
                    int titul = getInt("Ingrese 1 si el ayudante esta titulado, 0 si no lo esta  ", "Errorm ingrese valores numericos");
                    boolean titulado = (titul == 1)?true: false;
                    String claseA = getStr("Ingresa la clase que imparte: " );
                    Trabajador.Horario horarioAyu = hacerHoraio();

                    Ayudante ayud = new Ayudante(ayu.getNombre(), ayu.getApellidoPaterno(), ayu.getApellidoMaterno(), ayu.getCurp(),
                            ayu.getDireccion(), ayu.getCorreoElectronico(), ayu.getMatricula(), ayu.getSueldo(), ayu.getDiaContrat(),
                            ayu.getMes(), ayu.getYear(), facultityAyu, creditos, titulado, claseA, horarioAyu);

                    trabajadores.agrega(ayud);
                    break;
                case 4:
                    Trabajador admin = menuAltaGralTrabajador();
                    String lugar = getStr("Ingresa el lugar de trabajo: ");
                    String puesto = getStr("Ingresa el lugar de trabajo: ");
                    Trabajador.Horario horarioAd = hacerHoraio();

                    Trabajador adm = new Adiministrativo(admin.getNombre(), admin.getApellidoPaterno(), admin.getApellidoMaterno(),
                            admin.getCurp(),admin.getDireccion(),admin.getCorreoElectronico(),admin.getMatricula(),admin.getSueldo(),
                            admin.getDiaContrat(),admin.getMes(),admin.getYear(),lugar,puesto,horarioAd);

                    trabajadores.agrega(adm);
                case 0:
                    System.out.println("Volviendo al menú principal...\n");
                    continuar = false;
            }
        }while (continuar);
    }
    public static void eraseMenu(){
        int buscado = getInt("Ingrese la maatricula del empleado que desea eliminar",
                "Error, ingrese un valor numerico");
        trabajadores.elimina(lookingFor(trabajadores, buscado));
    }
    public static void buscaEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)));
    }
    public static void antiguedadEmpleado(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)).getAntiguedad());
    }
    public static void modificarEmpleado(){

        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        Trabajador modificaTrabajador = trabajadores.busca(lookingFor(trabajadores, matricula));
        System.out.println("Este es el empleado a eliminar: \n" + modificaTrabajador);
        if(modificaTrabajador instanceof Profesor){

        }else if(modificaTrabajador instanceof Ayudante){
            
        }else if (modificaTrabajador instanceof Investigador){

        }else{

        }
        System.out.println("Ingrese el area al que pertenece\n[1] Investigador\n[2] Profesor\n[3] Ayudante\n[4] Administrativo");
        int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
        Trabajador obtenido = menuAltaGralTrabajador();
        Trabajador aModificar = trabajadores.busca(lookingFor(trabajadores, matricula));
        switch (respuesta){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:

        }
        aModificar.setNombre(obtenido.getNombre());
        System.out.println(trabajadores.busca(lookingFor(trabajadores, matricula)));
    }
    public static void imprimirCheque(){
        int matricula = getInt("Ingrese el numero de matricula: ", "Error, ingrese un valor numerico");
        Trabajador tab = trabajadores.busca(lookingFor(trabajadores, matricula));
        tab.cheque();

    }
}
