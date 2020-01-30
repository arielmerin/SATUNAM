package com.dgpunam;

public class Investigador extends Trabajador {

    private  String facultad;
    private String nivelInv;
    private  String nivelSNI;

    public Investigador(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                        String correoElectronico, int matricula, double sueldo, int diaContrat, int mes, int year,
                        String facultad, String nivelInv, String nivelSNI) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo,
                diaContrat, mes, year);
        this.facultad = facultad;
        this.nivelInv = nivelInv;
        this.nivelSNI = nivelSNI;
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
    public void nuevoPersonal() {
        super.nuevoPersonal();
    }
}
