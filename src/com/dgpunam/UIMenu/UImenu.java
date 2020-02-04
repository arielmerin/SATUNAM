package com.dgpunam.UIMenu;

import com.dgpunam.*;
import com.dgpunam.util.ArregloDinamico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
            System.out.println(" [3] Ver los datos de un empleado \n");
            System.out.println(" [4] Imrpmir cheque de un empleado \n");
            System.out.println(" [5] Ver antiüedad de un empleado \n");
            System.out.println(" [6] Modificar algún empleado \n");
            System.out.println(" [0] Salir \n");

            int answer = getInt(" Seleccione la opción deseada: ", "Error, ingrese un valor válido");

            switch (answer){
                case 1:
                    System.out.println(" :: ALTA DE EMPLEADOS ::");
                    altaMenu();
                    break;
                case 2:
                    System.out.println(" :: BAJA DE EMPLEADOS :: ");
                    break;
                case 3:
                    System.out.println(" :: CONSULTAR DATOS ::  ");
                    break;
                case 4:
                    System.out.println(" :: IMPRMIR CHEQUE ::  ");
                    break;
                case 5:
                    System.out.println(":: ANTIGÜEDAD ::  ");
                    break;
                case 6:
                    System.out.println(":: MODIFICAR EMPLEADO ::  ");
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
            System.out.println("[0] Salir");
            Scanner scan = new Scanner(System.in);
            int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
            switch (respuesta){

                case 1:
                    Trabajador inv = menuAltaGralTrabajador();

                    String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
                    String nivelInve = getStr("Ingrese el nivel de investigador: ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Investigador arielin = new Investigador(inv.getNombre(),inv.getApellidoPaterno(),inv.getApellidoMaterno(),inv.getCurp(),inv.getDireccion(),
                            inv.getCorreoElectronico(),inv.getMatricula(), inv.getSueldo(), inv.getDiaContrat(), inv.getMes(), inv.getYear(), facultity, nivelInve, nivelSni);

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

                    int titul = getInt("Ingrese los creditos del ayudante: ", "Errorm ingrese valores numericos");
                    boolean titulado = (titul == 1)?true: false;
                    String claseA = getStr("Ingresa la clase que imparte: " );

                    Trabajador.Horario horarioAyu = hacerHoraio();

                    Ayudante ayud = new Ayudante(ayu.getNombre(), ayu.getApellidoPaterno(), ayu.getApellidoMaterno(), ayu.getCurp(),
                            ayu.getDireccion(), ayu.getCorreoElectronico(), ayu.getMatricula(), ayu.getSueldo(), ayu.getDiaContrat(),
                            ayu.getMes(), ayu.getYear(), facultityAyu, creditos, titulado, claseA, horarioAyu);

                    trabajadores.agrega(ayud);

                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...\n");
                    continuar = false;
            }
        }while (continuar);
    }
}
