package com.dgpunam;

/**
 * Permite el manejo adecuado de los tipos Administrador dentro de los trabjadores
 */
public class Adiministrativo extends Trabajador {

    private String lugarTrabajo;
    private String puesto;
    private Horario horario;

    /**
     * Constructor que permite el ingreso correcto de valores necesarios para la creacion de un objeto de tipo Administradorx
     * @param nombre Nombre que recibira el Adimnistradorx
     * @param apellidoPaterno Apellido que se le otorga a la (al) administradorx
     * @param apellidoMaterno Apellido materno que se le asigna al administradorx
     * @param curp Clave unica de registro de poblacion que se le confiere al administradorx
     * @param direccion Direccion donde se encuentra ubicado el domicilio delx administradorx
     * @param correoElectronico Email delx administradorx
     * @param matricula Clave unica en el registro de trabajadorxs
     * @param sueldo Salario por el cual realiza las labores de asministrativx
     * @param dia Dia en que fue contratadx
     * @param mes Mes en el que fue contratadx
     * @param year Año en el que fue contratadx
     * @param lugarTrabajo Lugar donde labora la (el) administradorx
     * @param puesto Puesto que desempeña
     * @param horario Horario en el que brinda sus serivicos
     */
    public Adiministrativo(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                           String correoElectronico, int matricula, double sueldo, int dia, int mes, int year,
                           String lugarTrabajo, String puesto, Horario horario) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo, dia, mes, year);
        this.horario = horario;
        this.lugarTrabajo = lugarTrabajo;
        this.puesto = puesto;
    }

    /**
     * Permite acceder el lugar de trabajo de lx adminsitradorx
     * @return lugar de trabajo
     */
    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    /**
     * Permite acceder al puesto de lx administradorx
     * @return lugar de trabajo
     */
    public String getPuesto() {
        return puesto;
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
