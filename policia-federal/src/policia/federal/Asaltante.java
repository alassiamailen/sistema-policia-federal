
package policia.federal;

import javax.swing.JOptionPane;

/**
 *
 * @author Alassia
 */
public class Asaltante {
    private int codigo;
    private String nombre_apellido;
    private int banda_criminal;
    
    Tools tools = new Tools();
    
    public Asaltante(int codigo, String nombre_apellido, int banda_criminal) {
        this.codigo = codigo;
        this.nombre_apellido = nombre_apellido;
        this.banda_criminal = banda_criminal;
    }
    
    public Asaltante(){
        ingresarDatos();
    }
    public void ingresarDatos(){
        int codigo, banda_criminal;
        String nombre_apellido;
        nombre_apellido= tools.leerString("Ingrese nombre y apellido: ");      
        codigo= tools.leerEntero("Ingrese codigo del asaltado: ");       
        banda_criminal=tools.leerEntero("Ingrese codigo de banda criminal: ");
    }
}
