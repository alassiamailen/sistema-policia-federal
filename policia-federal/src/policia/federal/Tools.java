package policia.federal;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class Tools {

    public Tools() {
    }
        
    private final Scanner sc = new Scanner(System.in);
    
    public int leerEntero(String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
    
    public String leerString(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }    
    
    public LocalDate leerFecha(String mensaje){
        System.out.println(mensaje);
        String fechaTexto = sc.nextLine();  // leer la fecha como texto
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(fechaTexto, formato);  // parsear a LocalDate
    }
     
}
