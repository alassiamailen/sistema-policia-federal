package policia.federal;

import java.util.ArrayList;

/**
 * Representa un vigilante con nombre, código, edad y contratos asociados.
 * Permite ingresar datos, agregar contratos y mostrar información.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Vigilante {

    private String nombre_apellido;
    private int codigo;
    private int edad;
    private int contadorContratos = 0;
    private ArrayList<ContratoSucVig> contratos = new ArrayList<>();

    Tools tools = new Tools();

    /////////////BORRAR ESTO/////////////     
    Contexto contexto = new Contexto();

    /**
     * Constructor para crear un vigilante con sus datos iniciales.
     *
     * @param nombre_apellido nombre y apellido del vigilante
     * @param codigo código identificador del vigilante
     * @param edad edad del vigilante
     */
    public Vigilante(String nombre_apellido, int codigo, int edad) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.edad = edad;
    }

    
    /**
     * Solicita al usuario ingresar los datos del vigilante por consola.
     */
    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo: ");
        this.edad = tools.leerEntero("Ingrese edad: ");

    }

    /**
     * Agrega un contrato al vigilante asignándole un código único.
     *
     * @param contrato el contrato a agregar
     */
    /// Agregar un [ContratoSucVig] al ArrayList [contratos]
    public void agregarContrato(ContratoSucVig contrato) {
        // Le asigno un codigo unico al contrato antes de guardarlo en el array
        contrato.setCodigo(contadorContratos);
        contratos.add(contrato);
        contadorContratos++;

        /////////////BORRAR ESTO/////////////
        contexto.mostrarContratos(contratos);

    }

    /**
     * Devuelve una representación en String con los datos del vigilante.
     *
     * @return String con nombre, edad y código
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== Datos del Vigilante =====\n");
        sb.append("Nombre y Apellido : ").append(nombre_apellido).append("\n");
        sb.append("Codigo            : ").append(codigo).append("\n");
        sb.append("Edad              : ").append(edad).append("\n");
        sb.append("Cantidad contratos: ").append(contadorContratos).append("\n");

        sb.append("Contratos:\n");
        if (contratos.isEmpty()) {
            sb.append("  (No hay contratos asignados)\n");
        } else {
            for (int i = 0; i < contratos.size(); i++) {
                sb.append("  [").append(i + 1).append("] ").append(contratos.get(i)).append("\n");
            }
        }

        sb.append("================================\n");
        return sb.toString();
    }

    /**
     * Devuelve el código del vigilante.
     *
     * @return código identificador
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el nombre y apellido del vigilante.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre_apellido;
    }

    /**
     * Establece el nombre y apellido del vigilante.
     *
     * @param nombre_apellido nuevo nombre completo
     */
    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    /**
     * Devuelve la edad del vigilante.
     *
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del vigilante.
     *
     * @param edad nueva edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
