package com.dgpunam;

/**
 *
 * Hereda de {@link Trabajador}
 * Forma parte de las clases donde se especializa el uso de la Abstracta trabajador
 */
public class Ayudante extends Trabajador {

    private String facultad;
    private int creditos;
    private boolean estaTitulado;
    private String clase;
    private Horario horario;

    /**
     *
     * @param nombre Nombre que recibira el ayudante
     * @param apellidoPaterno Apellido que se le otorga a la (al) ayudante
     * @param apellidoMaterno Apellido materno que se le asigna al ayudante
     * @param curp Clave unica de registro de poblacion que se le confiere al ayudante
     * @param direccion Direccion donde se encuentra ubicado el domicilio delx ayudante
     * @param correoElectronico Email delx ayudante
     * @param matricula Clave unica en el registro de ayudante
     * @param sueldo Salario por el cual realiza las labores de ayudante
     * @param dia Dia en que fue contratadx
     * @param mes Mes en el que fue contratadx
     * @param year Año en el que fue contratadx
     * @param facultad facultad a la que pertenece
     * @param creditos Numero de creditos con los que cuenta
     * @param estaTitulado Es un valor que pemite saber si ya esta tituladx
     * @param clase Es la materia que impartira
     * @param horario El horario en que su jornada correra
     */
    public Ayudante(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion,
                    String correoElectronico, int matricula, double sueldo, int dia, int mes, int year,
                    String facultad, int creditos, boolean estaTitulado, String clase, Horario horario) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp, direccion, correoElectronico, matricula, sueldo, dia, mes, year);
        this.clase = clase;
        this.creditos =creditos;
        this.estaTitulado = estaTitulado;
        this.horario = horario;
        this.facultad = facultad;
    }

    /**
     * Tiene que regresar la facultad a la que pertenece (la) el ayudante
     * @return facultad a la que pertenece la (el) ayudante
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * Permite acceder el numero de creditos de la (el) ayudante
     * @return porcentaje de creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Permite concoer si la (el) ayudante esta titulado
     * @return valor de preguntar si esta titulado o no
     */
    public boolean isEstaTitulado() {
        return estaTitulado;
    }

    /**
     * Regeresa la materia que imparte
     * @return materia en la que es ayudante
     */
    public String getClase() {
        return clase;
    }

    /**
     * Permite obtener el horario de la (el ) ayudante
     * @return horario de la (el) ayudante
     */
    public Horario getHorario() {
        return horario;
    }
}
