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

    private int cantidad_de_empleados;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Vigilante> vigilantes_contratados = new ArrayList<>();
    private ArrayList<Asaltante> asaltantes = new ArrayList<>();
    private ArrayList<ContratoSucVig> contrato = new ArrayList<>();
    private String nombre;

    Tools tools = new Tools();

    /**
     * Constructor que inicializa una sucursal con cantidad de empleados y
     * nombre.
     *
     * @param cantidad_de_empleados cantidad de empleados de la sucursal
     * @param nombre nombre de la sucursal
     */
    public Sucursal(int cantidad_de_empleados, String nombre) {
        this.cantidad_de_empleados = cantidad_de_empleados;
        this.nombre = nombre;
    }

    /**
     * Solicita al usuario ingresar la cantidad de empleados para la sucursal y
     * actualiza el atributo correspondiente.
     */
    public void ingresarDatos() {
        this.cantidad_de_empleados = tools.leerEntero("Ingrese cantidad de empleados: ");
    }

    /**
     * Método placeholder para lógica relacionada a abrir una sucursal.
     * Actualmente sin implementación.
     */
    public void abrirSucursal() {

    }

    /**
     * Método placeholder para la contratación de un vigilante para esta
     * sucursal. Actualmente sin implementación completa.
     */
    public void contratarVigilante() {
        String nombre;
        int codigo, edad;
        nombre = tools.leerString("Ingrese nombre de Sucursal: ");

    }

    /**
     * Devuelve el nombre de la sucursal como representación en texto.
     *
     * @return nombre de la sucursal
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Obtiene el nombre de la sucursal.
     *
     * @return nombre de la sucursal
     */
//    public String getNombre() {
//        return nombre;
//    }

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
