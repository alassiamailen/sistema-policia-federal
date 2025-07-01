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
public class Asaltante implements Codigo, Nombre{
    
    private static int contadorCodigo = 1;
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
    public Asaltante(String nombre_apellido, BandaCriminal banda_criminal) {
       this.codigo = contadorCodigo++;
        this.nombre_apellido = nombre_apellido;
        this.banda_criminal = banda_criminal;

    }


    /**
     * Constructor que solicita datos por consola.
     * <p>
     * Utiliza el método {@link #ingresarDatos()} para capturar la información.
     */
    public Asaltante() {
        ingresarDatos();
         this.codigo = contadorCodigo++;
    }

    /**
     * Solicita al usuario que ingrese los datos del asaltante.
     * <p>
     * Pide nombre completo y código identificador.
     */
    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");   
        

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
        StringBuilder sb = new StringBuilder();
        sb.append("========= ASALTANTE =========\n");
        sb.append("ID:").append(codigo).append("\n");
        sb.append("Nombre:").append(nombre_apellido).append("\n");

        if (banda_criminal != null) {
            sb.append("ID Banda Criminal: ").append(banda_criminal.getCodigoIdentificacion()).append("\n");
        } else {
            sb.append("ID Banda Criminal: [Sin asignar]\n");
        }

        sb.append("=============================");
        return sb.toString();
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

    }

    @Override
    public int obtenerCodigo() {
        return codigo;
    }

}
