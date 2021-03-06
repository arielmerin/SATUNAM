package com.dgpunam.util;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Permite el manejo y la creacion de Arreglos cuyo limite no tenga que estar precisamente limitando la incersion de datos
 * Ademas de contar con metodos que realizan operaciones dentro de la estructura
 * @param <T> Tipo de dato que se almacenara, para asegurar la homogeneidad
 * @author Merino Peña Kevin Ariel and Aquino Chapa Armando Abraham
 * @version 2.1
 */
public class ArregloDinamico<T> implements Iterable<T>, Serializable {

    private T[] arreglo;
    private int elementos;

    /**
     * No importa el nombre que se le ponga a la clase, solo es para fines didácticos
     * @param <T> Mismo tipo de la clase, sobre los cuales se va a iterar
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
    public ArregloDinamico(){
        /**
         * Crear un arreglo de este tamaño
         */
        this(20);
    }

    /**
     * Constructor que recibe el tamaño con el cual queremos inicializar el
     * arreglo dinámico.
     *
     * @param n es el numero de elementos con el que se inicializa
     */
    public ArregloDinamico(int n) {
        arreglo = (T[])new Object[n];
        elementos = 0;
    }

    /**
     * Método para insertar un elemento al final del arreglo dinamico. Si el
     * arreglo no tiene espacio, crecer el arreglo al doble de tamaño.
     *
     * @param elem elemento que se encargara de agregar
     */
    public void agrega(T elem) {
        if (elementos == arreglo.length-1){
            T[] a = (T[])new Object[elementos+2];
            for (int i = 0; i < arreglo.length ; i++) {
                a[i] = arreglo[i];
            }
            arreglo = a;
        }
        arreglo[elementos] = elem;
        elementos++;
    }

    public void agrega(T elem, int posicion) {
        this.arreglo[posicion] = elem;
    }

    /**
     * Método para acceder al elemento n-esimo del arreglo dinámico. El método
     * debe devolver el elemento buscado. Si no existe elemento n-esimo,
     * devolver null.
     *
     * @param n es el indice donde buscara
     * @return regresa el arreglo en esa posicion si lo encontro
     */
    public T busca(int n) {
        if (n < elementos && n >= 0){
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
     * @param n numero de elemento
     * @return el elemento eliminado
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
     * @param elem elemento con el cual se hara la busqueda
     * @return regresa el booleano true si lo encontro en otro caso false
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

    @Override
    public String toString() {
        StringBuilder std = new StringBuilder();
        Iterador it = new Iterador();
        while (it.hasNext()){
            std.append(it.next());
        }
        return std.toString();
    }
}
