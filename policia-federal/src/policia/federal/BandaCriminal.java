package policia.federal;

/**
 * Representa una banda criminal con información básica de identificación y
 * miembros.
 * <p>
 * Esta clase permite gestionar los datos de bandas criminales, incluyendo su
 * número de identificación y cantidad de miembros, con opción para ingresar
 * datos manualmente.
 *
 * @author Alassia
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
public class BandaCriminal implements Codigo {

    private int nro_de_identificacion;
    private int cantidad_de_miembros;

    Tools tools = new Tools();

    /**
     * Constructor principal que inicializa una banda criminal con datos
     * específicos.
     *
     * @param nro_de_identificacion Número único de identificación.
     * @param cantidad_de_miembros Cantidad de miembros de la banda.
     */
    public BandaCriminal(int nro_de_identificacion, int cantidad_de_miembros) {
        this.nro_de_identificacion = nro_de_identificacion;
        this.cantidad_de_miembros = cantidad_de_miembros;
    }

    /**
     * Constructor secundario que solicita los datos al usuario mediante
     * consola.
     * <p>
     * Utiliza el método {@link #ingresarDatos()} para capturar la información.
     */
    public BandaCriminal() {
        ingresarDatos();
    }

    /**
     * Solicita al usuario que ingrese los datos de la banda criminal.
     * <p>
     * Pide el número de identificación y la cantidad de miembros mediante la
     * clase {@link Tools}.
     */
    public void ingresarDatos() {

        this.nro_de_identificacion = tools.leerEntero("Ingrese numero de Identificacion de Banda Criminal: ");
        this.cantidad_de_miembros = tools.leerEntero("Ingrese la cantidad de miembros que la componen");
    }

    /**
     * Obtiene el número de identificación de la banda criminal.
     *
     * @return Número de identificación actual.
     */
    public int getCodigoIdentificacion() {
        return nro_de_identificacion;
    }

    /**
     * Establece una nueva cantidad de miembros para la banda criminal.
     *
     * @param cantidad Nueva cantidad de miembros.
     */
    public void setCantidadMiembros(int cantidad) {
        this.cantidad_de_miembros = cantidad;
    }

    @Override
    public int obtenerCodigo() {
        return this.nro_de_identificacion;
    }

}
