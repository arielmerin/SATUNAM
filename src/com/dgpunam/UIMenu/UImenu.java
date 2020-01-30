package com.dgpunam.UIMenu;

import com.dgpunam.Adiministrativo;
import com.dgpunam.Trabajador;
import static com.dgpunam.util.DgpUnamUtil.getInt;
import static com.dgpunam.util.DgpUnamUtil.getStr;

import java.util.ArrayList;
import java.util.Date;

public class UImenu {
    private ArrayList<Trabajador> trabajadores = new ArrayList();
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
            System.out.println("[2] Ayudante");
            System.out.println("[3] Administrativo");
            System.out.println("[0] Salir");

            int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
            switch (respuesta){
                case 1:
                    String nombre = getStr("Ingrese el nombre del trabajador: ");
                    System.out.println("Este es el nombre que le asignó: " + nombre);
                    String apellidoPaterno = getStr("Ingresse el apellido paterno: ");
                    System.out.println("Apellido paterno asignado " + apellidoPaterno);
                    String apellidoMaterno = getStr("Ingrese el apellido materno: ");
                    System.out.println("Apellido paterno asignado " + apellidoMaterno);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...\n");
                    continuar = false;

            }


        }while (continuar);
    }
}
