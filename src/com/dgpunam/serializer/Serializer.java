package com.dgpunam.serializer;
import java.util.*;
import java.io.*;
import com.dgpunam.*;
import com.dgpunam.util.ArregloDinamico;
/**
 * @author Armando Aquino and Kevin Ariel Merino Peña
 * @version 1
 */
public class Serializer {
    /**
     * Metodo que crea un flujo de salida y almacena objetos en archivos
     * @param a Objeto que queremos almacenar
     * @param ruta Nombre del archivo donde se almacenaran nuestros objetos
     */
    public void write(ArregloDinamico<Trabajador> a, String ruta){
        FileOutputStream file;
        ObjectOutputStream writer = null;
        try{
            file = new FileOutputStream(ruta);
            writer = new ObjectOutputStream(file);
            writer.writeObject(a);
        }catch(NotSerializableException e){
            System.out.println(e);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }finally{
            if(writer == null){
                System.out.println("El archivo no esta abierto");
            }else{
                try{
                    writer.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * Metodo que crea un flujo de entrada para leer objetos almacenados
     * @param cad Nombre donde estan almacenados los objetos a los que queremos acceder
     * @return Conjunto guardado en el archivo
     */
    public ArregloDinamico<Trabajador> read(String cad){
        ObjectInputStream in = null;
        FileInputStream input;
        ArregloDinamico<Trabajador> obj = null;
        try{
            input = new FileInputStream(cad);
            in = new ObjectInputStream(input);
            obj = (ArregloDinamico<Trabajador>)in.readObject();
        }catch(EOFException e){
            System.out.println("Fin del archivo");
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }finally{
            if(in == null){
                System.out.println("Nuevo archivo creado");
                write(obj, cad);
            }else{
                try{
                    in.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return obj;
    }
}
