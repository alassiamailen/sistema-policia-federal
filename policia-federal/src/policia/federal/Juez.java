package policia.federal;

/**
 * Representa un juez con nombre completo, código identificador y años de
 * servicio. Proporciona métodos para ingresar datos, obtener y modificar sus
 * atributos.
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
*/
public class Juez {

    private String nombre_apellido;
    private int codigo;
    private int anios_de_servicio;

    Tools tools = new Tools();

    /**
     * Constructor que inicializa un juez con los datos dados.
     *
     * @param nombre_apellido nombre y apellido del juez
     * @param codigo código identificador del juez
     * @param anios_de_servicio años que lleva en servicio
     */
    public Juez(String nombre_apellido, int codigo, int anios_de_servicio) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.anios_de_servicio = anios_de_servicio;
    }

    /**
     * Constructor sin parámetros que solicita ingresar los datos del juez por
     * consola.
     */
    public Juez() {
        ingresarDatos();
    }

    /**
     * Solicita al usuario ingresar los datos del juez por consola y actualiza
     * los atributos.
     */
    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo de Juez: ");
        this.anios_de_servicio = tools.leerEntero("Ingrese anios de servicio: ");
    }

    /**
     * Obtiene el nombre y apellido del juez.
     *
     * @return nombre y apellido
     */
    public String getNombre_apellido() {
        return nombre_apellido;
    }

    /**
     * Establece el nombre y apellido del juez.
     *
     * @param nombre_apellido nuevo nombre y apellido
     */
    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    /**
     * Obtiene el código identificador del juez.
     *
     * @return código del juez
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código identificador del juez.
     *
     * @param codigo nuevo código identificador
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene los años de servicio del juez.
     *
     * @return años de servicio
     */
    public int getAnios_de_servicio() {
        return anios_de_servicio;
    }

    /**
     * Establece los años de servicio del juez.
     *
     * @param anios_de_servicio nuevos años de servicio
     */
    public void setAnios_de_servicio(int anios_de_servicio) {
        this.anios_de_servicio = anios_de_servicio;
    }

    /**
     * Obtiene la instancia de la clase Tools utilizada para entrada de datos.
     *
     * @return instancia de Tools
     */
    public Tools getTools() {
        return tools;
    }

    /**
     * Establece la instancia de la clase Tools para entrada de datos.
     *
     * @param tools nueva instancia de Tools
     */
    public void setTools(Tools tools) {
        this.tools = tools;
    }

}
