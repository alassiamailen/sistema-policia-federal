package policia.federal;
import javax.swing.JOptionPane;
/**
 *
 * @author Alassia
 */
public class Vigilante {
    private String nombre_apellido;
    private int codigo;
    private int edad;

    public Vigilante(String nombre_apellido, int codigo, int edad) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.edad = edad;
    }
   
    public void ingresarDatos(){
        String nombre_apellido,aux_codigo,aux_edad;
        int codigo, edad;
        nombre_apellido= JOptionPane.showInputDialog(null, "Ingrese nombre y apellido: ");
        aux_codigo=JOptionPane.showInputDialog(null, "Ingrese codigo: ");
        codigo= Integer.parseInt(aux_codigo);
        aux_edad=JOptionPane.showInputDialog(null, "Ingrese edad: ");
        edad= Integer.parseInt(aux_edad);
         
    }
    
}
