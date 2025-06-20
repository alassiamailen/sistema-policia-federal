
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
        String aux_codigo, aux_banda_criminal,nombre_apellido;
        nombre_apellido= JOptionPane.showInputDialog(null, "Ingrese nombre y apellido: ");
        aux_codigo=JOptionPane.showInputDialog(null, "Ingrese codigo del asaltado: ");
        codigo= Integer.parseInt(aux_codigo);
        aux_banda_criminal=JOptionPane.showInputDialog(null, "Ingrese codigo de banda criminal: ");
        banda_criminal=Integer.parseInt(aux_banda_criminal);
    }
}
