import com.dgpunam.Adiministrativo;
import com.dgpunam.Trabajador;
import com.dgpunam.UIMenu.UImenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Arriba las locas!");

        Adiministrativo nuevo = new Adiministrativo("Ariel", "Merino", "Peña", "AqivaelCURP","Calle tecalli ok",
                "arielmerino@ciencias.unam.mx",317031326,100000,5411,
                "Facultad de Ciencias","Investigador",  new Trabajador.Horario(9,00,13,30));
        nuevo.mostrarCheque(nuevo.getMatricula());
        String jor = Trabajador.Horario.jornada( nuevo.getHorario());
        System.out.println("OKKKKKKK BEBA AHÍ VA \n" + jor);


    }
}
