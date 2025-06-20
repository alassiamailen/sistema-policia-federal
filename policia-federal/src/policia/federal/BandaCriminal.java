package policia.federal;
import javax.swing.JOptionPane;
/**
 *
 * @author Alassia
 */
public class BandaCriminal {
    private double nro_de_identificacion;
    private double cantidad_de_miembros;

    public BandaCriminal(double nro_de_identificacion, double cantidad_de_miembros) {
        this.nro_de_identificacion = nro_de_identificacion;
        this.cantidad_de_miembros = cantidad_de_miembros;
    }
    
    public BandaCriminal(){
        ingresarDatos();
}
    public void ingresarDatos(){
        String aux_id, aux_cant_miembros;
        double nro_de_identificacion, cantidad_de_miembros;
        aux_id = JOptionPane.showInputDialog(null, "Ingrese numero de Identificacion de Banda Criminal: ");
        nro_de_identificacion= Double.parseDouble(aux_id);
        aux_cant_miembros=JOptionPane.showInputDialog(null,"Ingrese la cantidad de miembros que la componen");
        cantidad_de_miembros= Double.parseDouble(aux_cant_miembros);
    }
}
