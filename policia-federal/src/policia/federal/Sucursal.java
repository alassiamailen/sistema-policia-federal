package policia.federal;

import java.util.ArrayList;

/**
 * Representa una sucursal bancaria que tiene empleados, vigilantes contratados,
 * asaltantes relacionados y contratos con vigilantes.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Sucursal implements Nombre{
    private int codigo;
    private static int contadorCodigo = 1;
    private int cantidad_de_empleados;  
    private ArrayList<Vigilante> vigilantes_contratados = new ArrayList<>();
    private ArrayList<Asaltante> asaltantes = new ArrayList<>();
    private ArrayList<ContratoSucVig> contrato = new ArrayList<>();
    private String nombre;
     private String domicilio;

    Tools tools = new Tools();

    /**
     * Constructor que inicializa una sucursal con cantidad de empleados y
     * nombre.
     *
     * @param cantidad_de_empleados cantidad de empleados de la sucursal
     * @param nombre nombre de la sucursal
     */
    public Sucursal(int cantidad_de_empleados, String nombre, String domicilio) {
        this.cantidad_de_empleados = cantidad_de_empleados;
        this.nombre = nombre;
        this.domicilio= domicilio;
        this.codigo=contadorCodigo++;
    }

    public Sucursal() {
        ingresarDatos();
        contadorCodigo++;
    }

    /**
     * Solicita al usuario ingresar la cantidad de empleados para la sucursal y
     * actualiza el atributo correspondiente.
     */
    public void ingresarDatos() {
        this.nombre=tools.leerString("Ingrese nombre de sucursal: ");
        this.cantidad_de_empleados = tools.leerEntero("Ingrese cantidad de empleados: ");
        this.domicilio=tools.leerString("Ingrese domicilio: ");
        
    }

    /**
     * Devuelve el nombre de la sucursal como representación en texto.
     *
     * @return nombre de la sucursal
     */

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========= SUCURSAL =========\n");
        sb.append("COdigo: ").append(codigo).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Domicilio: ").append(domicilio).append("\n");
        sb.append("Cantidad de empleados: ").append(cantidad_de_empleados).append("\n");
      
        sb.append("\n--- Vigilantes Contratados ---\n");
        if (vigilantes_contratados.isEmpty()) {
            sb.append("Sin vigilantes contratados\n");
        } else {
            for (int i = 0; i < vigilantes_contratados.size(); i++) {
                sb.append("[").append(i + 1).append("] ").append(vigilantes_contratados.get(i)).append("\n");
            }
        }

        sb.append("\n--- Asaltantes ---\n");
        if (asaltantes.isEmpty()) {
            sb.append("Sin asaltantes asociados\n");
        } else {
            for (int i = 0; i < asaltantes.size(); i++) {
                sb.append("[").append(i + 1).append("] ").append(asaltantes.get(i)).append("\n");
            }
        }

        sb.append("\n--- Contratos ---\n");
        if (contrato.isEmpty()) {
            sb.append("Sin contratos registrados\n");
        } else {
            for (int i = 0; i < contrato.size(); i++) {
                sb.append("[").append(i + 1).append("] ").append(contrato.get(i)).append("\n");
            }
        }

        sb.append("=============================\n");
        return sb.toString();
    }

    /**
     * Obtiene la lista de contratos entre la sucursal y vigilantes.
     *
     * @return lista de contratos
     */
    @Override
    public String getNombre() {
        return nombre;
    }

}
