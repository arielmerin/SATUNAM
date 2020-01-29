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
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\\n" +
                "\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\";


        System.out.println(" BIENVENIDO A DGP UNAM \n");
        System.out.println(" [1] Dar de alta un empleado \n");
        System.out.println(" [2] Dar de baja un empleado \n");
        System.out.println(" [3] Ver los datos de un empleado \n");
        System.out.println(" [4] Imrpmir cheque de un empleado \n");
        System.out.println(" [5] Ver antiüedad de un empleado \n");
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
            default:
                System.out.println("Error, seleccione una opción válida\n");
        }
    }

}
