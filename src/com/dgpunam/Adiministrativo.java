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

    @Override
    public String toString() {
        return super.toString() + "::: Adiministrativo :::\n" +
                "Labora en: " + lugarTrabajo + '\n' +
                "Puesto: " + puesto + '\n' +
                "Horario: " + horario  + "\n";
    }
}
