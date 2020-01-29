import com.dgpunam.Adiministrativo;
import com.dgpunam.Trabajador;
import com.dgpunam.UIMenu.UImenu;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Trabajador ariel = new Adiministrativo("Ariel", "Merino", "Peña", "AqivaelCURP","Calle tecalli ok",
                "arielmerino@ciencias.unam.mx",317031326,100000,14, 11, 2001,
                "Facultad de Ciencias","Investigador",new Trabajador.Horario(9,00,13,30));

        System.out.println("Esta debe de ser la fecha\n");
        System.out.println(ariel.getFechaContrato());
        System.out.println(ariel.getAntiguedad());


    }
}
