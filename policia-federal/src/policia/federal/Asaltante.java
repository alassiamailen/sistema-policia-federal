package policia.federal;

import java.util.ArrayList;

/**
 * Representa a un asaltante dentro del sistema policial.
 * <p>
 * Contiene información personal del asaltante, su afiliación a bandas
 * criminales y el historial de asaltos cometidos.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
public class Asaltante {

    private int codigo;
    private String nombre_apellido;
    private BandaCriminal banda_criminal;
    private ArrayList<Asalto> asaltos = new ArrayList<>();
    private int contadorAsaltos = 1;
    private ArrayList<Condena> condenas = new ArrayList<>();
    private int contador_condena = 1;

    Tools tools = new Tools();

    /**
     * Constructor básico para crear un asaltante.
     *
     * @param codigo Código identificador único
     * @param nombre_apellido Nombre completo del asaltante
     */
    public Asaltante(int codigo, String nombre_apellido) {
        this.codigo = codigo;
        this.nombre_apellido = nombre_apellido;
    }

    /**
     * Constructor completo para crear un asaltante con banda criminal asociada.
     *
     * @param codigo Código identificador único
     * @param nombre_apellido Nombre completo del asaltante
     * @param banda_criminal Banda criminal a la que pertenece
     */
    public Asaltante(int codigo, String nombre_apellido, BandaCriminal banda_criminal) {
        this.codigo = codigo;
        this.nombre_apellido = nombre_apellido;
        this.banda_criminal = banda_criminal;

    }

    /////////////BORRAR ESTO/////////////     
    Contexto contexto = new Contexto();

    /**
     * Constructor que solicita datos por consola.
     * <p>
     * Utiliza el método {@link #ingresarDatos()} para capturar la información.
     */
    public Asaltante() {
        ingresarDatos();
    }

    /**
     * Solicita al usuario que ingrese los datos del asaltante.
     * <p>
     * Pide nombre completo y código identificador.
     */
    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo del asaltado: ");

    }

    /**
     * Obtiene el nombre completo del asaltante.
     *
     * @return Nombre y apellido
     */
    public String getNombre() {
        return nombre_apellido;
    }

    /**
     * Devuelve una representación en cadena del asaltante.
     *
     * @return String con información básica del asaltante
     */
    @Override
    public String toString() {
        return "ID: " + codigo + "\nNombre: " + nombre_apellido + "\nID Banda Criminal: " + banda_criminal.getCodigoIdentificacion();
    }

    /**
     * Obtiene la banda criminal a la que pertenece el asaltante.
     *
     * @return Objeto BandaCriminal o null si no tiene asignada
     */
    public BandaCriminal obtenerBandaCriminal() {
        return banda_criminal;
    }

    /**
     * Agrega un nuevo asalto al historial del asaltante.
     *
     * @param nuevo_asalto Objeto Asalto a agregar
     */
    /// Agregar un [Asalto] al ArrayList [asaltos]
    public void agregarAsalto(Asalto nuevo_asalto) {
        // Le asigno un codigo unico al contrato antes de guardarlo en el array
        nuevo_asalto.setCodigo(contadorAsaltos);
        asaltos.add(nuevo_asalto);
        contadorAsaltos++;

        /////////////BORRAR ESTO///////////// 
        contexto.mostrarAsaltos(asaltos);
    }

    /**
     * Obtiene la lista de asaltos cometidos.
     *
     * @return ArrayList de objetos Asalto
     */
    public ArrayList<Asalto> getAsaltos() {
        return new ArrayList<>(asaltos); // Devuelve copia para proteger encapsulamiento
    }

    /**
     * Establece la banda criminal a la que pertenece el asaltante.
     *
     * @param banda Nueva banda criminal
     */
    public void setBandaCriminal(BandaCriminal banda) {
        this.banda_criminal = banda;
    }
    /// Agregar una [Condena] al ArrayList [condenas]

    public void agregarCondena(Condena nueva_condena) {
        nueva_condena.setCodigo(contador_condena);
        condenas.add(nueva_condena);
        contador_condena++;
        /////////////BORRAR ESTO///////////// 
        contexto.mostrarCondenas(condenas);

    }
}
