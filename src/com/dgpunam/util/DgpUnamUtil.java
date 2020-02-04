package com.dgpunam.util;

import com.dgpunam.Trabajador;

import java.util.Scanner;

public class DgpUnamUtil {
    /**
     * Este método sirve para controlar que en las entradas de enteros
     * lo único que se pueda ingresar sean justo sólo valores numéricos y nada de cadenas
     *
     * @param msg mensaje de instrucciones al usuario o indicaciones
     * @param error mensaje de error al detectar que la entrada no es un valor nummérico
     * @return entero que validó y ahora puede ser utilizado
     */
    public static int getInt(String msg, String error){
        int entero = 0;
        Scanner scan = new Scanner(System.in);
        String librearBuffer;
        boolean conti = true;


        do{
            System.out.println(msg);
            if(scan.hasNextInt())
            {
                entero = scan.nextInt();
                conti = false;
            }else{
                librearBuffer = scan.next();
                System.out.println(error);
            }
        }while(conti);
        return entero;
    }

    public static String getStr(String messaje){
        Scanner scan = new Scanner(System.in);
        System.out.println(messaje);
        String cadena = scan.nextLine();

        return cadena.replaceAll("[\\d.]", "");
    }

    public static double getDouble(String msg, String error){
        double entero = 0.0;
        Scanner scan = new Scanner(System.in);
        String librearBuffer;
        boolean conti = true;

        do{
            System.out.println(msg);
            if(scan.hasNextDouble())
            {
                entero = scan.nextDouble();
                conti = false;
            }else{
                librearBuffer = scan.next();
                System.out.println(error);
            }
        }while(conti);
        return entero;
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
        return new Trabajador(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correo, matricula, salario, dia,
                mes, agno);
    }
    public static Trabajador.Horario hacerHoraio(){

        System.out.println("Ingresa el horario de inicio: con el siguiente formato HH:MM");
        Scanner scan = new Scanner(System.in);

        String horarioAini = scan.nextLine();
        String[] horariosAini =  horarioAini.split(":");
        int inicioH = Integer.parseInt(horariosAini[0]);
        int inicioM = Integer.parseInt(horariosAini[1]);

        System.out.println("Ingresa la hora en que termina la clase, con el siguiente formato HH:MM");
        String horarioAfin = scan.nextLine();
        String[] horariosAfin =  horarioAfin.split(":");
        int finH = Integer.parseInt(horariosAfin[0]);
        int finM = Integer.parseInt(horariosAfin[1]);
        return new Trabajador.Horario(inicioH,inicioM,finH,finM);
    }
    public static int lookingFor(ArregloDinamico<Trabajador> arreglo, int busqueda){
        int contador = 0;
        for(Trabajador trab: arreglo){
            contador++;
            if (trab.getMatricula() == busqueda){
                return contador;
            }
        }
        return -1;
    }
}


