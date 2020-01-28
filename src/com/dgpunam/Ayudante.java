package com.dgpunam;

public class Ayudante extends Trabajador {

    private String facultad;
    private int creditos;
    private boolean estaTitulado;
    private String clase;
    private Horario horario;


    public Ayudante(String nombre, String apellidoMaterno, String apellidoPaterno, String curp, String direccion,
                    String correoElectronico, int matricula, int sueldo, int antiguedad, String facultad, int creditos,
                    boolean estaTitulado, String clase, Horario horario) {
        super(nombre, apellidoMaterno, apellidoPaterno, curp, direccion, correoElectronico, matricula, sueldo, antiguedad);
        this.clase = clase;
        this.creditos =creditos;
        this.estaTitulado = estaTitulado;
        this.horario = horario;
        this.facultad = facultad;
    }
}
