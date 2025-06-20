package policia.federal;
import javax.swing.JOptionPane;
/**
 *
 * @author Alassia
 */
public class Juez {
    private String nombre_apellido;
    private int codigo;
    private int anios_de_servicio;

     Tools tools = new Tools();
     
    public Juez(String nombre_apellido, int codigo, int anios_de_servicio) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.anios_de_servicio = anios_de_servicio;
    }    
    
    public Juez(){
        ingresarDatos();
    }
     public void ingresarDatos(){
        int codigo, anios_servicio;
        String nombre_apellido;
        nombre_apellido= tools.leerString("Ingrese nombre y apellido: "); 
        codigo= tools.leerEntero("Ingrese codigo de Juez: ");    
        anios_servicio=tools.leerEntero("Ingrese anios de servicio: ");
    }
    
}
