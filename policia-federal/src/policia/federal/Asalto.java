package policia.federal;

import java.time.LocalDate;

/**
 * Representa un asalto registrado en el sistema policial.
 * <p>
 * Contiene información sobre el incidente, incluyendo fecha, asaltante
 * involucrado, sucursal afectada y banda criminal relacionada.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
public class Asalto {

    private int codigo_asalto;
    private LocalDate fecha;
    private Asaltante detenido;
    private Sucursal sucursal;
    private BandaCriminal banda_criminal;
    private boolean condenado;

    /**
     * Constructor principal para crear un registro de asalto.
     *
     * @param fecha Fecha del asalto
     * @param detenido Asaltante detenido (puede ser null)
     * @param sucursal Sucursal afectada
     * @param banda_criminal Banda criminal responsable
     */
    public Asalto(LocalDate fecha, Asaltante detenido, Sucursal sucursal, BandaCriminal banda_criminal) {
        this.fecha = fecha;
        this.detenido = detenido;
        this.sucursal = sucursal;
        this.banda_criminal = banda_criminal;
    }

    /**
     * Establece el código identificador del asalto.
     *
     * @param codigo Código numérico único
     */
    public void setCodigo(int codigo) {
        this.codigo_asalto = codigo;
    }

    /**
     * Devuelve una representación en cadena del asalto.
     *
     * @return String con los datos principales del asalto
     */
    public int obtenerCodigo() {
        return this.codigo_asalto;
    }

    /**
     * Obtiene el asaltante detenido.
     *
     * @return Objeto {@code Asaltante} o {@code null} si no hay detenido.
     */
    public Asaltante obtenerDetenido() {
        return detenido;
    }

    /**
     * Obtiene la sucursal afectada por el asalto.
     *
     * @return Objeto {@code Sucursal}.
     */
    public Sucursal obtenerSucursal() {
        return sucursal;
    }

    /**
     * Marca al asaltante como condenado.
     */
    public void condenarAsaltante() {
        condenado = true;
    }

    /**
     * Devuelve una representación en cadena del asalto.
     *
     * @return Cadena con los datos principales del asalto.
     */    
    @Override
    public String toString() {
        return "Asalto" + "codigo_asalto=" + codigo_asalto + ", fecha=" + fecha + ", detenido=" + detenido.getNombre() + ", sucursal=" + sucursal.getNombre() + ", banda_criminal=" + banda_criminal.getCodigoIdentificacion() + '}';
    }
     /**
     * Muestra por consola los detalles del asalto, indicando si el asaltante fue condenado.
     */
    public void mostarAsalto() {
        if (condenado) {
            System.out.println("ID asalto: " + codigo_asalto + "fecha: " + fecha + ", detenido: " + detenido.getNombre() + " sucursal: " + sucursal.getNombre() + " ID banda criminal: " + banda_criminal.getCodigoIdentificacion() + "Condenado: SI");
        } else {
            System.out.println("ID asalto: " + codigo_asalto + " fecha: " + fecha + " detenido: " + detenido.getNombre() + " sucursal: " + sucursal.getNombre() + " ID banda criminal: " + banda_criminal.getCodigoIdentificacion() + " Condenado: NO");
        }
    }

    /**
     * Obtiene el código del asalto.
     *
     * @return Código identificador
     */
    public int getCodigoAsalto() {
        return codigo_asalto;
    }

    /**
     * Obtiene la fecha del asalto.
     *
     * @return Fecha del incidente
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el asaltante detenido.
     *
     * @return Objeto Asaltante o null
     */
    public Asaltante getDetenido() {
        return detenido;
    }

}
