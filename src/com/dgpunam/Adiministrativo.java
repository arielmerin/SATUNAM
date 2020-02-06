package com.dgpunam;
//Hola
import java.util.Date;

public class Adiministrativo extends Trabajador {

    private String lugarTrabajo;
    private String puesto;
    private Horario horario;

    public Horario getHorario() {
        return horario;
    }

    public Adiministrativo(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                           String correoElectronico, int matricula, double sueldo, int dia, int mes, int year,
                           String lugarTrabajo, String puesto, Horario horario) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo, dia, mes, year);
        this.horario = horario;
        this.lugarTrabajo = lugarTrabajo;
        this.puesto = puesto;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }


    @Override
    public String getApellidoMaterno() {
        return super.getApellidoMaterno();
    }

    @Override
    public String getApellidoPaterno() {
        return super.getApellidoPaterno();
    }

    @Override
    public String getCurp() {
        return super.getCurp();
    }

    @Override
    public String getDireccion() {
        return super.getDireccion();
    }

    @Override
    public String getCorreoElectronico() {
        return super.getCorreoElectronico();
    }

    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public double getSueldo() {
        return super.getSueldo();
    }

    @Override
    public String getFechaContrato() {
        return super.getFechaContrato();
    }

}
