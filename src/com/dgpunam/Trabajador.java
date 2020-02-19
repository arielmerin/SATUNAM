package com.dgpunam;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * <h1>Trabajador</h1>
 *
 * Clase cuyo uso prinicipal es proveer de atributos a las clases hija que seran especializaciones de los tipos de trabajador
 * aqui se alojan los valores que se veran repetidos en todas las clases que usan algun registro o usuario.
 * @author Aquino Chapa Armando Abraham, Merino Peña Kevin Ariel
 * @version 1
 */
public abstract class Trabajador implements Serializable {
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String curp;
    private String direccion;
    private String correoElectronico;
    private int matricula;
    private double sueldo;
    private String fechaContrato;
    private int diaContrat;
    private int mes;
    private int year;

    /**
     *  Este metodo permite acceder al valor del dia contratado
     * @return dia contratado
     */
    public int getDiaContrat() {
        return diaContrat;
    }

    /**
     *  Este metodo permite acceder al valor delmes
     * @return valor del mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Este metodo sirve para acceder al valor del año
     * @return valor del año
     */
    public int getYear() {
        return year;
    }

    /**
     * Constructor princial que permite construir objetos de tipo trabajador con los siguientes requerimientos
     * @param nombre Nombre que se le asginara al trabajador
     * @param apellidoPaterno Apellido que se asignara al trabajador
     * @param apellidoMaterno Apellido materno que se asignara al trabajador
     * @param curp Clave unica de registro de poblacion del trabajador
     * @param direccion Domicilio del trabajador
     * @param correoElectronico email del trabajador
     * @param matricula numero unico de cuenta que tendra asignado el trabjadaor
     * @param sueldo Monto que se le paga al trabjadaor por brindar sus servicios
     * @param diaContrat Dia 1-31 en el que fue contratado el trabajador
     * @param mes mes 1-12 en el que fue contratado
     * @param year 1900-2020 en el que fue contratado el trabajador
     */
    public Trabajador(String nombre, String apellidoPaterno, String apellidoMaterno, String curp,
                      String direccion, String correoElectronico, int matricula, double sueldo, int diaContrat,
                      int mes, int year) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.curp = curp;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.matricula = matricula;
        this.sueldo = sueldo;
        GregorianCalendar calendar = new GregorianCalendar(year, mes-1, diaContrat);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fechaContrato = df.format(calendar.getTime());

    }

    /**
     * Regresara el nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite ver el apellido materno
     * @return apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Permite ver el apellido paterno
     * @return apellido paterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Permite ver el curp
     * @return curp del empleado
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Permite acceder a la direccion
     * @return direccion del empleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Permite acceder al correo electronico del empleado
     * @return correo electronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Permite acceder a la matricula del trabajador
     * @return matricula del trabajador
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Permite acceder al sueldo del trabajador
     * @return sueldo del trabajador
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Permite acceder a la antiguedad del trabajador
     * @return antiguedad del trabajador
     */
    public String getAntiguedad(){
        LocalDate ld =  LocalDate.now();
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate origen = LocalDate.parse(getFechaContrato(), ftm);


        Period antiguedad = Period.between(origen, ld);
        return " " + antiguedad.getYears() +" años, " +antiguedad.getMonths() +" meses y "+ antiguedad.getDays() +" días\n";
    }

    /**
     * Permite acceder a la fecha en que fue contratado el empleado
     * @return fecha en que se contrato
     */
    public String getFechaContrato() {
        return fechaContrato;
    }

    /**
     * Esta clase interna permite la implementacion adecuada del parametro horario para los trabajadores que lo requieran
     *
     */
    public static class Horario implements Serializable{
        int inicioHoras;
        int terminoHoras;
        int inicioMin;
        int terminoMin;

        /**
         * Permite el correcto manejo del horario en los empleados
         * @param inicioHoras Inicio de dos digitos
         * @param inicioMin Inicio de la jornada en minutos
         * @param terminoHoras Fin de la jornada en horas
         * @param terminoMin Fin de la jornada en minutos
         */
        public Horario(int inicioHoras, int inicioMin,  int terminoHoras, int terminoMin) {
            this.inicioHoras = inicioHoras;
            this.inicioMin = inicioMin;
            this.terminoHoras = terminoHoras;
            this.terminoMin = terminoMin;

        }

        @Override
        public String toString() {
            return  "Inicio " + inicioHoras +
                    ":" + terminoHoras +
                    " Termina " + inicioMin +
                    ":" + terminoMin + "\n";
        }
    }

    @Override
    public String toString() {
        String datosTrabajador = "\n" +
                "+--------------------------------------+\n" +
                "|          Datos del trabajador        |\n" +
                "+--------------------------------------+\n" +
                "  Nombre: " +apellidoPaterno + " " + apellidoMaterno + " " + nombre+ "\n"+
                "  Número de trabajador: " + matricula + "\n"+
                "  Antiguedad: " + getAntiguedad() + "\n"+
                "  CURP: " + curp + "\n"+
                "  Dirección: " + direccion + "\n"+
                "  Correo electrónico: " + correoElectronico + "\n";

        String logo =  "\n" +
                " __    __  __    __   ______   __       __ \n" +
                "|  \\  |  \\|  \\  |  \\ /      \\ |  \\     /  \\\n" +
                "| $$  | $$| $$\\ | $$|  $$$$$$\\| $$\\   /  $$\n" +
                "| $$  | $$| $$$\\| $$| $$__| $$| $$$\\ /  $$$\n" +
                "| $$  | $$| $$$$\\ $$| $$    $$| $$$$\\  $$$$\n" +
                "| $$  | $$| $$\\$$ $$| $$$$$$$$| $$\\$$ $$ $$\n" +
                "| $$__/ $$| $$ \\$$$$| $$  | $$| $$ \\$$$| $$\n" +
                " \\$$    $$| $$  \\$$$| $$  | $$| $$  \\$ | $$\n" +
                "  \\$$$$$$  \\$$   \\$$ \\$$   \\$$ \\$$      \\$$\n";

        return datosTrabajador + logo;
    }

    /**
     * Permite imprimir el cheque del empleado en un formato adecuado
     */
    public String cheque(){
        String salarioImpuestos = "\n \n" +
                "+--------------------------+\n" +
                "|          Cheque          |\n" +
                "+--------------------------+\n" +
                " Nombre de la (el) empleada(o): " + nombre + " " + apellidoPaterno + " "+ apellidoMaterno+ "\n" +
                " Salario base:  $ "+sueldo + "\n"+
                " Deduccciones  -$ 540.36" + "\n"+
                " Total:  $ "+  String.format("%.02f",sueldo-540.36) + "\n";
        return salarioImpuestos;
    }

}

