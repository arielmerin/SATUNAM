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

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getApellidoMaterno() {
        return super.getApellidoMaterno();
    }

    @Override
    public void setApellidoMaterno(String apellidoMaterno) {
        super.setApellidoMaterno(apellidoMaterno);
    }

    @Override
    public String getApellidoPaterno() {
        return super.getApellidoPaterno();
    }

    @Override
    public void setApellidoPaterno(String apellidoPaterno) {
        super.setApellidoPaterno(apellidoPaterno);
    }

    @Override
    public String getCurp() {
        return super.getCurp();
    }

    @Override
    public void setCurp(String curp) {
        super.setCurp(curp);
    }

    @Override
    public String getDireccion() {
        return super.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    @Override
    public String getCorreoElectronico() {
        return super.getCorreoElectronico();
    }

    @Override
    public void setCorreoElectronico(String correoElectronico) {
        super.setCorreoElectronico(correoElectronico);
    }

    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public double getSueldo() {
        return super.getSueldo();
    }

    @Override
    public void setSueldo(double sueldo) {
        super.setSueldo(sueldo);
    }

    @Override
    public String getFechaContrato() {
        return super.getFechaContrato();
    }

}
