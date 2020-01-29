package com.dgpunam;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Trabajador {
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String curp;
    private String direccion;
    private String correoElectronico;
    private int matricula;
    private double sueldo;
    private String fechaContrato;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAntiguedad(){
        LocalDate ld =  LocalDate.now();
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate origen = LocalDate.parse(getFechaContrato(), ftm);


        Period antiguedad = Period.between(origen, ld);
        return "Antiguedad:" + antiguedad.getYears() +" años, " +antiguedad.getMonths() +" meses y "+ antiguedad.getDays() +" días";
    }


    public String getFechaContrato() {
        return fechaContrato;
    }


    public void nuevoPersonal(){

    }

    public static class Horario{
        int inicioHoras;
        int terminoHoras;
        int inicioMin;
        int terminoMin;


        public Horario(int inicioHoras, int inicioMin,  int terminoHoras, int terminoMin) {
            this.inicioHoras = inicioHoras;
            this.inicioMin = inicioMin;
            this.terminoHoras = terminoHoras;
            this.terminoMin = terminoMin;

        }
        public static String jornada(Horario horario) {
            int duration = horario.terminoHoras - horario.inicioHoras;
            int durationMin = horario.terminoMin - horario.inicioMin;
            return duration + ":" + durationMin;
        }
    }

    public void mostrarCheque(int matricula) {
        String msj = "\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "|                Datos del trabajador                 |            Impuestos             |         Jornada          | Salario+++++ |  |\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "| Nombre: " + nombre + apellidoPaterno + apellidoMaterno + "                                      | SITUMAN:                         | Horas labordas: +++++++ |              |  |\n" +
                "| Dirección: " + direccion + "                                      | ISR:                             |                         |              |  |\n" +
                "| Puesto:" + "                                      | Ahorro para el retiro:++++++++++ |                         |              |  |\n" +
                "| Matricula:                                          |                                  |                         |              |  |\n" +
                "| CURP:                                               |                                  |                         |              |  |\n" +
                "| Antigüedad:                                         |                                  |                         |              |  |\n" +
                "| e-mail:                                             |                                  |                         |              |  |\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "\n";
        System.out.printf(msj + "\n" +
                "\n" +
                " __    __  __    __   ______   __       __ \n" +
                "|  \\  |  \\|  \\  |  \\ /      \\ |  \\     /  \\\n" +
                "| $$  | $$| $$\\ | $$|  $$$$$$\\| $$\\   /  $$\n" +
                "| $$  | $$| $$$\\| $$| $$__| $$| $$$\\ /  $$$\n" +
                "| $$  | $$| $$$$\\ $$| $$    $$| $$$$\\  $$$$\n" +
                "| $$  | $$| $$\\$$ $$| $$$$$$$$| $$\\$$ $$ $$\n" +
                "| $$__/ $$| $$ \\$$$$| $$  | $$| $$ \\$$$| $$\n" +
                " \\$$    $$| $$  \\$$$| $$  | $$| $$  \\$ | $$\n" +
                "  \\$$$$$$  \\$$   \\$$ \\$$   \\$$ \\$$      \\$$\n" +
                "                                           \n" +
                "                                           \n" +
                "                                           \n" +
                "\n");

    }
}

