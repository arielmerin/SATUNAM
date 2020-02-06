package com.dgpunam;

/**
 * Esta clase permite manejar de forma correcta el comportamiento y los atributos particulares de unx trabajadorx
 */
public class Investigador extends Trabajador {

    private  String facultad;
    private String nivelInv;
    private  String nivelSNI;

    /**
     * Constructor principal, permite ingresar datos necesarios para dar de alta investigadores en el sistema
     * @param nombre Nombre que recibira la (el) Investigadorx
     * @param apellidoPaterno Apellido que se le otorga a la (al) Investigadorx
     * @param apellidoMaterno Apellido materno que se le asigna al Investigadorx
     * @param curp Clave unica de registro de poblacion que se le confiere al Investigadorx
     * @param direccion Direccion donde se encuentra ubicado el domicilio delx Investigadorx
     * @param correoElectronico Email delx Investigadorx
     * @param matricula Clave unica en el registro de Investigadorx
     * @param sueldo Salario por el cual realiza las labores de Investigadorx
     * @param diaContrat Dia en que fue contratadx
     * @param mes Mes en el que fue contratadx
     * @param year Año en el que fue contratadx
     * @param facultad Facultad a la que pertenece la (el) Investigadorx
     * @param nivelInv Nivel de investigadorx
     * @param nivelSNI Nivel en el sistema nacional de investigadorxs
     */
    public Investigador(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                        String correoElectronico, int matricula, double sueldo, int diaContrat, int mes, int year,
                        String facultad, String nivelInv, String nivelSNI) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo,
                diaContrat, mes, year);
        this.facultad = facultad;
        this.nivelInv = nivelInv;
        this.nivelSNI = nivelSNI;
    }

    /**
     * Permite acceder a la facultad delx Investigadorx
     * @return facultad donde labora
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * Permite acceder al nivel de Investigadorx
     * @return nivel de investigadrx
     */
    public String getNivelInv() {
        return nivelInv;
    }

    /**
     * Permite acceder al nivel que tiene en el sistema nacional de investigadorxs
     * @return nivel en el SNI
     */
    public String getNivelSNI() {
        return nivelSNI;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
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
}
