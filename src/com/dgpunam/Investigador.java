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

    @Override
    public String toString() {
        return super.toString() +"\n\n:::Investigador:::\n" +
                "facultad de: '" + facultad + '\n' +
                "El nivel de investigador de " + getNombre() + " es:  " + facultad + '\n' +
                "El nivel en el SNI es: " + nivelSNI + '\n' +
                '\n';
    }
}
