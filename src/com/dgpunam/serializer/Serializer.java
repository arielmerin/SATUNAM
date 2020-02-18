package com.dgpunam.serializer;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.dgpunam.*;
import com.dgpunam.Trabajador;
import com.dgpunam.util.ArregloDinamico;
/**
 * @author Armando Aquino and Kevin Ariel Merino Peña
 * @version 1
 */
public class Serializer {
    /**
     * Metodo que crea un flujo de salida y almacena objetos en archivos
     * @param arregloDinamico Objeto que queremos almacenar
     * @param ruta Nombre del archivo donde se almacenaran nuestros objetos
     */
    public void write(Object arregloDinamico, String ruta){
        ObjectOutputStream writer = null;
        try{
            writer = new ObjectOutputStream(new FileOutputStream(ruta));
            writer.writeObject(arregloDinamico);
        }catch(NotSerializableException exc){
            System.out.println(exc);
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
                    System.out.println("NO se puedo cerrar el documento");
                }
            }
        }
    }

    /**
     * Metodo que crea un flujo de entrada para leer objetos almacenados
     * @param cadena Nombre donde estan almacenados los objetos a los que queremos acceder
     * @return Conjunto guardado en el archivo
     */
    public Object read(String cadena){
        ObjectInputStream in = null;
        Object obj = null;
        try{
            in = new ObjectInputStream(new FileInputStream(cadena));
            obj = in.readObject();
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
                write(obj, cadena);
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
