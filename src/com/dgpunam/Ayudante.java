package com.dgpunam;

/**
 *
 * Hereda de {@link Trabajador}
 * Forma parte de las clases donde se especializa el uso de la Abstracta trabajador
 */
public class Ayudante extends Trabajador {

    private String facultad;
    private int creditos;
    private boolean estaTitulado;
    private String clase;
    private Horario horario;


    public Ayudante(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                    String correoElectronico, int matricula, double sueldo, int dia, int mes, int year,
                    String facultad, int creditos, boolean estaTitulado, String clase, Horario horario) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo, dia, mes, year);
        this.clase = clase;
        this.creditos =creditos;
        this.estaTitulado = estaTitulado;
        this.horario = horario;
        this.facultad = facultad;
    }
}
