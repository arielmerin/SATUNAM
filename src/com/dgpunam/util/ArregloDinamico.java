package com.dgpunam.util; /**
 *
 * @author Ariel Merino Peña
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;


public class ArregloDinamico<T> implements Iterable<T>, Serializable {

    private T[] arreglo;
    private int elementos;

    public T[] getArreglo() {
        return arreglo;
    }

    public int getElementos() {
        return elementos;
    }

    /**
     * No importa el nombre que se le ponga a la clase, solo es para fines didácticos
     * @param <T>
     */
    private class Iterador<T> implements Iterator<T> {

        private int siguiente;

        public Iterador() {
            this.siguiente = 0;
        }

        @Override
        public boolean hasNext() {
            return elementos > siguiente;
        }

        @Override
        public T next() {
            T aux = (T) arreglo[siguiente];
            siguiente++;
            return aux;
        }

        @Override
        public void remove() {
            /**
             * Nuncahay que implementar este método, no tiene sentido en la encapsulacion
             */
            Iterator.super.remove();
        }

    }

    /**
     * Constructor por omisión
     */
    public ArregloDinamico() throws IOException {
        /**
         * Crear un arreglo de este tamaño
         */
        this(2);
    }

    /**
     * Constructor que recibe el tamaño con el cual queremos inicializar el
     * arreglo dinámico.
     *
     * @param n
     */
    public ArregloDinamico(int n) {
        arreglo = (T[])new Object[n];
        elementos = 0;
        /**
         * Crear un arreglo de este tamaño
         */
    }

    /**
     * Método para insertar un elemento al final del arreglo dinamico. Si el
     * arreglo no tiene espacio, crecer el arreglo al doble de tamaño.
     *
     * @param elem
     */
    public void agrega(T elem) {
        /**
         * No debe de haber huecos en el arreglo
         * si se nos acaba el espacio hay que crecer el arreglo
         */
        if (elementos == arreglo.length-1){
            T[] a = (T[])new Object[elementos+2];
            for (int i = 0; i < arreglo.length ; i++) {
                a[i] = arreglo[i];
            }
            this.arreglo = a;
        }
        this.arreglo[elementos] = elem;
        elementos++;
    }

    /**
     * Método para acceder al elemento n-esimo del arreglo dinámico. El método
     * debe devolver el elemento buscado. Si no existe elemento n-esimo,
     * devolver null.
     *
     * @param n
     * @return
     */
    public T busca(int n) {
        if (n < elementos && arreglo[n] != null){
            return arreglo[n];
        }else {
            return null;
        }
    }

    /**
     * Método para eliminar al elemento n-esimo del arreglo dinámico, no debe
     * haber espacios sin elementos. El método debe devolver el elemento
     * eliminado. Si no existe elemento n-esimo, devolver null.
     *
     * @param n
     * @return
     */
    public T elimina(int n) {
        T result = arreglo[n];
        T[] aux = (T[])new Object[elementos];
        for (int i = 0; i < n; i++){
            aux[i] = arreglo[i];
        }
        for (int i = n +1; i < elementos; i++){
            aux[i-1] = arreglo[i];
        }
        arreglo = aux;
        elementos--;
        return result;
    }

    /**
     * Método para saber si un elemento esta en el arreglo dinámico, devuelve
     * true si esta en el arreglo, false en otro caso.
     *
     * @param elem
     * @return
     */
    public boolean contiene(T elem) {
        for (int i = 0; i < elementos; i++){
            if (busca(i).equals(elem)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Método para representar el arreglo en una cadena.
     *
     * @return
     */
    @Override
    public String toString() {

        StringBuilder std = new StringBuilder();
        Iterador it = new Iterador();
        while (it.hasNext()){

            std.append(it.next() + ", ");

        }
        String result = "";
        if (std.length() > 1){
            result = std.substring(0,std.length() - 2);
        }
        return "[" + result + "]";
    }
}
