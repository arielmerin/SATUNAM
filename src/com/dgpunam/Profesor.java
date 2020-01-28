package com.dgpunam;

public class Profesor extends Trabajador {

    private String facultad;
    private String clase;
    private Horario horario;
    private char nivelProf;
    private String titulo;


    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                    String correoElectronico, int matricula, int sueldo, int antiguedad, String facultad, String clase,
                    Horario horario, char nivelProf, String titulo) {
        super(nombre, apellidoMaterno, apellidoPaterno, curp, direccion, correoElectronico, matricula, sueldo, antiguedad);
        this.clase = clase;
        this.facultad = facultad;
        this.horario = horario;
        this.nivelProf = nivelProf;
        this.titulo = titulo;
    }
}
