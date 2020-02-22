package com.dgpunam.util;

import com.dgpunam.Trabajador;
import java.util.Scanner;

/**
 * <h1>Utilidadaes</h1>
 * Clase que sirve de auxiliar a menu para permitir la entrada de datos desde la terminal y realizar las validaciones
 * necesarias para el requerimiento de tipo de dato
 * @author Aquino Chapa Armando Abraham and Ariel Merino Peña
 * @version 1
 */
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

    /**
     * Este metodo imprime el pantalla un mensaje solicitando al usuario que ingrese una cadena, capta ese valor y lo
     * devuelve
     * @param messaje Instrucciones para que el usuario haga la entrada correspondiente
     * @return cadena que el usuario ingreso por la terminal
     */
    public static String getStr(String messaje){
        Scanner scan = new Scanner(System.in);
        System.out.println(messaje);
        String cadena = scan.nextLine();

        return cadena.replaceAll("[\\d.]", "");
    }

    /**
     * Metodo que permite el ingreso de valores de tipo double y solo esos, pues restringe la entrada de valores de tipo
     * cadena o caracter
     * @param msg Instrucciones para el usuario
     * @param error Mensaje que se muestra cada vez que el usuario no ingresa un valor correcto
     * @return Numero que el usuario ingreso
     */
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

    /**
     * Sirve de apoyo en el ingreso de nuevo personal y en la modificacion de los trabajadores
     * @return trbajador con los datos que solicito
     */
    public static Trabajador menuAltaGralTrabajador(){
        Scanner scan = new Scanner(System.in);
        String nombre = getStr("Ingrese el nombre del Trabajador: ");
        System.out.println("Este es el nombre que le asignó: " + nombre);

        String apellidoPaterno = getStr("Ingresse el apellido paterno: ");
        System.out.println("Apellido paterno asignado " + apellidoPaterno);

        String apellidoMaterno = getStr("Ingrese el apellido materno: ");
        System.out.println("Apellido paterno asignado " + apellidoMaterno);

        System.out.println("Ingresa el curp del Trabajador: ");
        String curp = scan.nextLine();
        System.out.println("El curp ingresado fue: " + curp);

        System.out.println("Ingresa el domicilio del Trabajador: ");
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

    /**
     * Imprime en la pantalla instrucciones al usuario para que este se encargue de proporcionar los datos que permitiran
     * crear un horario de algun empleado, ademas otorga formato a la entrada
     * @return horario hecho
     */
    public static Trabajador.Horario hacerHorario(){

        System.out.println("Ingresa el horario de inicio: con el siguiente formato HH:MM");
        Scanner scan = new Scanner(System.in);

        int inicioH = getInt("Ingrese la hora en formato en que inicia la clase","Error ingrese un valor numrico");
        int inicioM = getInt("Ingrese los minutos en que inicia la clase", "Error, ingrese un valor numerico");
        int finH = getInt("Ingrese la hora en formato en que finaliza la clase","Error ingrese un valor numrico");
        int finM = getInt("Ingrese los minutos en que finaliza la clase", "Error, ingrese un valor numerico");
        return new Trabajador.Horario(inicioH,inicioM,finH,finM);
    }

    /**
     * <h1>BUSQUEDA</h1>
     * Se encaraga de hacer la busqueda en el conjunto de los trabajadores comparando la matricula proporcionada
     * @param arreglo Lugar donde sobre el que se va a iterar para obtener un resultado de busqueda
     * @param busqueda El numero de matricula que se esta intentando encntrar
     * @return la posicion donde lo encontro el el error que simboliza -1
     */
    public static int lookingFor(ArregloDinamico<Trabajador> arreglo, int busqueda){
        int contador = 0;
        for(Trabajador trab: arreglo){
            contador++;
            if (trab.getMatricula() == busqueda){
                return contador - 1;
            }
        }
        return -1;
    }
}


