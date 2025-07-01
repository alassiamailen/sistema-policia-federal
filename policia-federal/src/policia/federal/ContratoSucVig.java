package policia.federal;

import java.time.LocalDate;

/**
 * Representa un contrato entre una sucursal bancaria y un vigilante.
 * <p>
 * Gestiona informacion sobre fechas de contrato, entidad bancaria, sucursal,
 * vigilante asignado y condiciones de portacion de arma.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
public class ContratoSucVig {

    private LocalDate fecha_de_inicio;
    private LocalDate fecha_de_fin;
    private String entidad_bancaria;
    private String sucursal;
    private String vigilante;
    private boolean portar_arma;
    private String armado;
    private int codigo_contrato;

    Tools tools = new Tools();

    /**
     * Constructor principal que inicializa un contrato con datos basicos.
     *
     * @param entidad_bancaria Nombre de la entidad bancaria.
     * @param sucursal Nombre de la sucursal.
     * @param vigilante Nombre del vigilante asignado.
     */
    public ContratoSucVig(String entidad_bancaria, String sucursal, String vigilante) {
        this.entidad_bancaria = entidad_bancaria;
        this.sucursal = sucursal;
        this.vigilante = vigilante;
        crearContrato();
    }

    /**
     * Crea un nuevo contrato solicitando datos al usuario.
     * <p>
     * Pide fechas de inicio/fin y determina si el vigilante porta arma. Valida
     * que la opcion de arma sea correcta (1/0).
     */
    public void crearContrato() {
        //String entidad_bancaria, sucursal, armado;
        boolean flag = false;

        this.fecha_de_inicio = tools.leerFecha("Ingrese fecha de inicio de contrato en formato (dd-MM-yyyy)");
        this.fecha_de_fin = tools.leerFecha("Ingrese fecha de fin de contrato en formato (dd-MM-yyyy)");

        do {
            armado = tools.leerString("Ingrese <1> si el vigilante porta arma o <0> en caso contrario");
            if (armado.equals("1")) {
                this.portar_arma = true;
                this.armado = "SI";
                flag = true;
            } else if (armado.equals("0")) {
                this.portar_arma = false;
                this.armado = "NO";
                flag = true;
            } else {
                System.err.println("Ingrese una opcion valida. (1 o 0)");
                flag = false;
            }
        } while (!flag);

    }

    /**
     * Establece el codigo unico del contrato.
     *
     * @param codigo Codigo numerico a asignar.
     */
    public void setCodigo(int codigo) {
        this.codigo_contrato = codigo;
    }

    /**
     * Devuelve una representacion detallada del contrato en formato String.
     *
     * @return Datos del contrato formateados.
     */
    @Override
    public String toString() {
        return "Codigo: #" + codigo_contrato + "\n"
                + "Entidad: " + entidad_bancaria + "\n"
                + "Sucursal: " + sucursal + "\n"
                + "Vigilante: " + vigilante + "\n"
                + "Porta Arma: " + armado + "\n"
                + "Fecha de inicio: " + fecha_de_inicio + "\n"
                + "Fecha de fin: " + fecha_de_fin;
    }

    /**
     * Obtiene el nombre del vigilante asignado.
     *
     * @return Nombre del vigilante.
     */
    public String getVigilante() {
        return vigilante;
    }

}
