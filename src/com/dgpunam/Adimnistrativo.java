package com.dgpunam;

public class Adimnistrativo extends Trabajador {

    private String lugarTrabajo;
    private String puesto;
    private Horario horario;


    public Adimnistrativo(String nombre, String apellidoMaterno, String apellidoPaterno, String curp, String direccion,
                          String correoElectronico, int matricula, int sueldo, int antiguedad, String lugarTrabajo,
                          String puesto, Horario horario) {
        super(nombre, apellidoMaterno, apellidoPaterno, curp, direccion, correoElectronico, matricula, sueldo, antiguedad);
        this.horario = horario;
        this.lugarTrabajo = lugarTrabajo;
        this.puesto = puesto;
    }
}
