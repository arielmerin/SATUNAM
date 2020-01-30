package com.dgpunam.util;

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


}


