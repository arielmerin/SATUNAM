package com.dgpunam.UIMenu;

import com.dgpunam.Adiministrativo;
import com.dgpunam.Investigador;
import com.dgpunam.Profesor;
import com.dgpunam.Trabajador;
import com.dgpunam.util.ArregloDinamico;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.dgpunam.util.DgpUnamUtil.*;

public class UImenu {
    private static ArregloDinamico<Trabajador> trabajadores = new ArregloDinamico<>();
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
                    Trabajador inv = menuAltaGralTrabajador();

                    String facultity = getStr("Ingrese la facultad a la que pertenece el investigador: ");
                    String nivelInve = getStr("Ingrese el nivel de investigador: ");
                    String nivelSni = getStr("Ingrese la categoría en el SNI");

                    Trabajador ariel = new Adiministrativo("Ariel", "Merino", "Peña", "MEPK010305MHCRXVA5","Calle tecalli ok",
                            "arielmerino@ciencias.unam.mx",317031326,197000.584,14, 11, 2001,
                            "Facultad de Ciencias","Investigador",new Trabajador.Horario(9,00,13,30));
                    Investigador arielin = new Investigador(inv.getNombre(),inv.getApellidoPaterno(),inv.getApellidoMaterno(),inv.getCurp(),inv.getDireccion(),
                            inv.getCorreoElectronico(),inv.getMatricula(), inv.getSueldo(), inv.get, mes, agno, facultity, nivelInve, nivelSni);

                    trabajadores.agrega(ariel);
                    trabajadores.agrega(arielin);
                    break;
                case 2:
                    String nombreProfe = getStr("Ingrese el nombre del investigador: ");
                    System.out.println("Este es el nombre que le asignó: " + nombreProfe);

                    String apellidoPaternoProfe = getStr("Ingresse el apellido paterno: ");
                    System.out.println("Apellido paterno asignado " + apellidoPaternoProfe);

                    String apellidoMaternoProfe = getStr("Ingrese el apellido materno: ");
                    System.out.println("Apellido paterno asignado " + apellidoMaternoProfe);

                    System.out.println("Ingresa el curp del investigador: ");
                    String curpProfe = scan.nextLine();
                    System.out.println("El curp ingresado fue: " + curpProfe);

                    System.out.println("Ingresa el domicilio del investigador: ");
                    String direccionProfe = scan.nextLine();
                    System.out.println("La dirección ingresada fue: "+ direccionProfe );

                    System.out.println("Ingresa el e-mail del investigador: ");
                    String correoProfe = scan.nextLine();
                    System.out.println("El correo ingresado fue: "+ correoProfe );

                    int matriculaProfe = getInt("Ingresa la matrícula del investigador: ","Error, ingrese un valor numérico");
                    System.out.println("La matricula ingresada fue: "+matriculaProfe);

                    double salarioProfe = getDouble("Ingrese el salario","Error, ingrese valores numéricos con decimales");
                    System.out.println("El salario registrado de " + nombreProfe + " es: $"+salarioProfe);

                    int diaProfe = getInt("Ingrese el día en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    int mesProfe = getInt("Ingrese el mes en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    int agnoProfe = getInt("Ingrese el año en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    System.out.println("La fecha de contratación fue: " + diaProfe+"/"+mesProfe+"/"+agnoProfe);

                    String facultityProfe = getStr("Ingrese la facultad a la que pertenece el investigador: ");

                    String claseP = getStr("Ingresa la clase que imparte: " );

                    System.out.println("Ingresa el horario de inicio: con el siguiente formato HH:MM");
                    String horarioini = scan.nextLine();
                    String[] horariosini =  horarioini.split(":");
                    int inicioHP = Integer.parseInt(horariosini[0]);
                    int inicioMP = Integer.parseInt(horariosini[1]);

                    System.out.println("Ingresa la hora en que termina la clase, con el siguiente formato HH:MM");
                    String horariofin = scan.nextLine();
                    String[] horariosfin =  horariofin.split(":");
                    int finHP = Integer.parseInt(horariosfin[0]);
                    int finMP = Integer.parseInt(horariosfin[1]);

                    System.out.println("Ingresa la hora en que termina la clase, con el siguiente formato HH:MM");
                    String nivelAyu = scan.nextLine();

                    System.out.println("Ingresa el titulo del ayudante: ");
                    String tituloAyud = scan.nextLine();

                    Profesor prof = new Profesor(nombreProfe,apellidoPaternoProfe, apellidoMaternoProfe, curpProfe,
                            direccionProfe, correoProfe, matriculaProfe, salarioProfe, diaProfe, mesProfe, agnoProfe,
                            facultityProfe, claseP, new Trabajador.Horario(inicioHP,inicioMP,finHP,finMP), nivelAyu,
                            tituloAyud);
                    break;
                case 3:
                    String nombreAyu = getStr("Ingrese el nombre del investigador: ");
                    System.out.println("Este es el nombre que le asignó: " + nombreAyu);

                    String apellidoPaternoAyu = getStr("Ingresse el apellido paterno: ");
                    System.out.println("Apellido paterno asignado " + apellidoPaternoAyu);

                    String apellidoMaternoAyu = getStr("Ingrese el apellido materno: ");
                    System.out.println("Apellido paterno asignado " + apellidoMaternoAyu);

                    System.out.println("Ingresa el curp del investigador: ");
                    String curpAyu = scan.nextLine();
                    System.out.println("El curp ingresado fue: " + curpAyu);

                    System.out.println("Ingresa el domicilio del investigador: ");
                    String direccionAyu = scan.nextLine();
                    System.out.println("La dirección ingresada fue: "+ direccionAyu );

                    System.out.println("Ingresa el e-mail del investigador: ");
                    String correoAyu = scan.nextLine();
                    System.out.println("El correo ingresado fue: "+ correoAyu );

                    int matriculaAyu = getInt("Ingresa la matrícula del investigador: ","Error, ingrese un valor numérico");
                    System.out.println("La matricula ingresada fue: "+matriculaAyu);

                    double salarioAyu = getDouble("Ingrese el salario","Error, ingrese valores numéricos con decimales");
                    System.out.println("El salario registrado de " + nombreAyu + " es: $"+salarioAyu);

                    int diaAyu = getInt("Ingrese el día en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    int mesAyu = getInt("Ingrese el mes en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    int agnoAyu = getInt("Ingrese el año en que fue contratado: ", "Error, debe ingresar un valor numérico");
                    System.out.println("La fecha de contratación fue: " + diaAyu+"/"+mesAyu+"/"+agnoAyu);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...\n");
                    continuar = false;

            }


        }while (continuar);
    }
    public static Trabajador menuAltaGralTrabajador(){
        Scanner scan = new Scanner(System.in);
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
    }
}
