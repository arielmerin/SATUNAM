package com.dgpunam;

public class Profesor extends Trabajador {

    private String facultad;
    private String clase;
    private Horario horario;
    private String nivelProf;
    private String titulo;


    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                    String correoElectronico, int matricula, double sueldo, int dia, int mes, int year,
                    String facultad, String clase, Horario horario, String nivelProf, String titulo) {
        super(nombre, apellidoMaterno, apellidoPaterno, curp, direccion, correoElectronico, matricula, sueldo, dia,
                mes, year);
        this.clase = clase;
        this.facultad = facultad;
        this.horario = horario;
        this.nivelProf = nivelProf;
        this.titulo = titulo;
    }
}
