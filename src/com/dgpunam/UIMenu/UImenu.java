package com.dgpunam.UIMenu;

import com.dgpunam.Adiministrativo;
import com.dgpunam.Investigador;
import com.dgpunam.Trabajador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.dgpunam.util.DgpUnamUtil.*;

public class UImenu {
    private static ArrayList<Trabajador> trabajadores = new ArrayList();
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
            Scanner scan = new Scanner(System.in);
            int respuesta = getInt("Ingrese la opción deseada: ", "Error, ingrese un número");
            switch (respuesta){
                case 1:
                    String nombre = getStr("Ingrese el nombre del investigador: ");
                    System.out.println("Este es el nombre que le asignó: " + nombre);

                    String apellidoPaterno = getStr("Ingresse el apellido paterno: ");
                    System.out.println("Apellido paterno asignado " + apellidoPaterno);

                    String apellidoMaterno = getStr("Ingrese el apellido materno: ");
                    System.out.println("Apellido paterno asignado " + apellidoMaterno);

                    System.out.println("Ingresa el curp del investigador: ");
                    String curp = scan.nextLine();
                    System.out.println("El curp ingresado fue: " + curp);

                    System.out.println("Ingresa el domicilio del investigador: ");
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


                    String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
                    String nivelInve = getStr("Ingrese el nivel de investigador: ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Trabajador ariel = new Adiministrativo("Ariel", "Merino", "Peña", "MEPK010305MHCRXVA5","Calle tecalli ok",
                            "arielmerino@ciencias.unam.mx",317031326,197000.584,14, 11, 2001,
                            "Facultad de Ciencias","Investigador",new Trabajador.Horario(9,00,13,30));
                    Investigador arielin = new Investigador(nombre,apellidoPaterno,apellidoMaterno,curp,direccion,
                            correo,matricula, salario, dia, mes, agno, facultity, nivelInve, nivelSni);

                    //trabajadores.add(ariel);
                    trabajadores.add(arielin);
                    System.out.println(trabajadores);

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
