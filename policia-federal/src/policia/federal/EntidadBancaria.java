package policia.federal;

/**
 * Representa una entidad bancaria con informacion basica como codigo, domicilio
 * y nombre.
 * <p>
 * Esta clase permite gestionar los datos de una entidad bancaria y proporciona
 * metodos para interactuar con ellos (creacion, modificacion y consulta).
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class EntidadBancaria implements Nombre{
    private static int contadorCodigo = 1;
    private int codigo;
    private String domicilio;
    private String nombre;

    Tools tools = new Tools();

    /**
     * Constructor principal que inicializa una entidad bancaria con datos
     * especificos.
     *
     * @param nombre Nombre de la entidad bancaria.
     * @param codigo Codigo unico de la entidad.
     * @param domicilio Domicilio fisico de la entidad.
     */
    public EntidadBancaria(String nombre, int codigo, String domicilio) {
        this.nombre = nombre;
        this.codigo = contadorCodigo++;
        this.domicilio = domicilio;
    }

    /**
     * Constructor secundario que solicita los datos al usuario mediante
     * consola.
     * <p>
     * Utiliza el metodo {@link #ingresarDatos()} para capturar la informacion.
     */
    public EntidadBancaria() {
        ingresarDatos();
        this.codigo = contadorCodigo++;
    }

    /**
     * Solicita al usuario que ingrese los datos de la entidad bancaria (codigo,
     * domicilio y nombre).
     * <p>
     * Los datos se capturan a traves de la clase {@link Tools}.
     */
    public void ingresarDatos() {             
        this.nombre = tools.leerString("Ingrese el nombre: ");
    }

    /**
     * Devuelve una representacion en String del nombre de la entidad bancaria.
     *
     * @return Nombre de la entidad.
     */
    @Override
    public String toString() {
        return nombre;
    }
    // --- Getters y Setters documentados ---

    /**
     * Obtiene el nombre de la entidad bancaria.
     *
     * @return Nombre actual.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el codigo de la entidad bancaria.
     *
     * @return Codigo actual.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el domicilio de la entidad bancaria.
     *
     * @return Domicilio actual.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece un nuevo domicilio para la entidad bancaria.
     *
     * @param domicilio Nuevo domicilio.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Establece un nuevo nombre para la entidad bancaria.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
