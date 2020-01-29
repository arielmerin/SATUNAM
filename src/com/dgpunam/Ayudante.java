package com.dgpunam;

public class Ayudante extends Trabajador {

    private String facultad;
    private int creditos;
    private boolean estaTitulado;
    private String clase;
    private Horario horario;


    public Ayudante(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                    String correoElectronico, int matricula, double sueldo, int antiguedad, int dia, int mes, int year,
                    String facultad, int creditos, boolean estaTitulado, String clase, Horario horario) {
        super(nombre, apellidoMaterno, apellidoPaterno, curp, direccion, correoElectronico, matricula, sueldo, dia, mes, year);
        this.clase = clase;
        this.creditos =creditos;
        this.estaTitulado = estaTitulado;
        this.horario = horario;
        this.facultad = facultad;
    }
}
