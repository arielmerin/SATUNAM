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
        String librearBuffer;
        boolean conti = true;

        Scanner scan = new Scanner(System.in);

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
}
