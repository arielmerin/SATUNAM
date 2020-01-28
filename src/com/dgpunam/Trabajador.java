package com.dgpunam;

public abstract class Trabajador {
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String curp;
    private String direccion;
    private String correoElectronico;
    private int matricula;
    private int sueldo;
    private int antiguedad;

    public Trabajador(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String direccion, String correoElectronico, int matricula, int sueldo, int antiguedad) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.curp = curp;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.matricula = matricula;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
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
        public String jornada() {
            int duration = this.terminoHoras - this.inicioHoras;
            int durationMin = this.terminoMin - this.inicioMin;
            return duration + ":" + durationMin;
        }
    }

    public void mostrarCheque(int matricula){
        String msj = "\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "|                Datos del trabajador                 |            Impuestos             |         Jornad          | Salario+++++ |  |\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "| Nombre: "+nombre + apellidoPaterno + apellidoMaterno +"                                      | SITUMAN:                         | Horas labordas: +++++++ |              |  |\n" +
                "| Dirección: " + direccion +"                                      | ISR:                             |                         |              |  |\n" +
                "| Puesto:" +"                                      | Ahorro para el retiro:++++++++++ |                         |              |  |\n" +
                "| Matricula:                                          |                                  |                         |              |  |\n" +
                "| CURP:                                               |                                  |                         |              |  |\n" +
                "| Antigüedad:                                         |                                  |                         |              |  |\n" +
                "| e-mail:                                             |                                  |                         |              |  |\n" +
                "+-----------------------------------------------------+----------------------------------+-------------------------+--------------+--+\n" +
                "\n";
        System.out.printf( msj +"\n" +
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

