package com.dgpunam.UIMenu;

import com.dgpunam.Adiministrativo;
import com.dgpunam.Trabajador;
import com.dgpunam.util.DgpUnamUtil;

import java.util.Date;

public class UImenu {
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

            int answer = DgpUnamUtil.getInt(" Seleccione la opción deseada: ", "Error, ingrese un valor válido");

            switch (answer){
                case 1:
                    System.out.println(" :: ALTA DE EMPLEADOS ::");
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

}
