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
     * Imprime en la pantalla instrucciones al usuario para que este se encargue de proporcionar los datos que permitiran
     * crear un horario de algun empleado, ademas otorga formato a la entrada
     * @return horario hecho
     */
    public static Trabajador.Horario hacerHorario(){

        System.out.println("Ingresa el horario de inicio: con el siguiente formato HH:MM");
        Scanner scan = new Scanner(System.in);

        String horarioAini = scan.nextLine();
        String[] horariosAini =  horarioAini.split(":");
        int inicioH = getInt(" ","Error ingrese un valor numrico");
        Integer.parseInt(horariosAini[0]);
        int inicioM = Integer.parseInt(horariosAini[1]);

        System.out.println("Ingresa la hora en que termina la clase, con el siguiente formato HH:MM");
        String horarioAfin = scan.nextLine();
        String[] horariosAfin =  horarioAfin.split(":");
        int finH = Integer.parseInt(horariosAfin[0]);
        int finM = Integer.parseInt(horariosAfin[1]);
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
                return contador;
            }
        }
        return -1;
    }
}


