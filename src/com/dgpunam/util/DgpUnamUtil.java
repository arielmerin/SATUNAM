package com.dgpunam.util;

import java.util.Scanner;

public class DgpUnamUtil {

    public static int getInt(String msg, String error){
        int i = 0;
        String s;
        boolean conti = true;

        Scanner scan = new Scanner(System.in);

        do{
            System.out.println(msg);
            if(scan.hasNextInt())
            {
                i = scan.nextInt();
                conti = false;
            }else{
                s = scan.next();
                System.out.println(error);
            }
        }while(conti);
        return i;
    }
}
