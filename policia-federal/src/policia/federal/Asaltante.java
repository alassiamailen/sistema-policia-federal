
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
        this.nombre_apellido= tools.leerString("Ingrese nombre y apellido: ");      
        this.codigo= tools.leerEntero("Ingrese codigo del asaltado: ");       
        this.banda_criminal=tools.leerEntero("Ingrese codigo de banda criminal: ");
    }
}
