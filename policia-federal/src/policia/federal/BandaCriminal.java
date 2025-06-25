package policia.federal;


/**
 *
 * @author Alassia
 */
public class BandaCriminal {

    private int nro_de_identificacion;
    private int cantidad_de_miembros;

    Tools tools = new Tools();

    public BandaCriminal(int nro_de_identificacion, int cantidad_de_miembros) {
        this.nro_de_identificacion = nro_de_identificacion;
        this.cantidad_de_miembros = cantidad_de_miembros;
    }

    public BandaCriminal() {
        ingresarDatos();
    }

    public void ingresarDatos() {

        this.nro_de_identificacion = tools.leerEntero("Ingrese numero de Identificacion de Banda Criminal: ");
        this.cantidad_de_miembros = tools.leerEntero("Ingrese la cantidad de miembros que la componen");
    }
    
     public int getCodigoIdentificacion() {
        return nro_de_identificacion;
    }
    
    
   
}
