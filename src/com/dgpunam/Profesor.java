package com.dgpunam;

/**
 * Faculta al programa para manejar de manera adecuada los profesores en la base de datos
 */
public class Profesor extends Trabajador {

    private String facultad;
    private String clase;
    private Horario horario;
    private String nivelProf;
    private String titulo;

    /**
     * Constructor principal que permite recibir los datos necesarios para crear unx profesorx
     * @param nombre Nombre que recibira la (el) profesorx
     * @param apellidoPaterno Apellido que se le otorga a la (al) profesorx
     * @param apellidoMaterno Apellido materno que se le asigna a la (el) profesorx
     * @param curp Clave unica de registro de poblacion que se le confiere a la (el) profesorx
     * @param direccion Direccion donde se encuentra ubicado el domicilio delx profesorx
     * @param correoElectronico Email delx profesorx
     * @param matricula Clave unica en el registro de profesorx
     * @param sueldo Salario por el cual realiza las labores de profesorx
     * @param dia Dia en que fue contratadx
     * @param mes Mes en el que fue contratadx
     * @param year Año en el que fue contratadx
     * @param facultad facultad a la que pertenece
     * @param clase Es la materia que impartira
     * @param horario El horario en que su jornada correra
     * @param nivelProf nivel en el que se encuentra lx profesorx
     * @param titulo titulo que ostenta lx profesorx
     */
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

    @Override
    public String toString() {
        return super.toString() + "\n\n:::Profesor:::\n" +
                 getNombre() +" estudio en: " + facultad + '\n' +
                "Imparte la clase: " + clase + '\n' +
                "En un horario de: " + horario +
                "Nivel de profesor: " + nivelProf + '\n' +
                "Titulo: " + titulo + '\n' +
                '\n';
    }
}
