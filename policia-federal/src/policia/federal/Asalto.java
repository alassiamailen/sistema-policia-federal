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
public class Asalto implements Codigo{

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

    public Asaltante obtenerDetenido() {
        return detenido;
    }

    public Sucursal obtenerSucursal() {
        return sucursal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========= ASALTO =========\n");
        sb.append("Código de Asalto        : ").append(codigo_asalto).append("\n");
        sb.append("Fecha del Asalto        : ").append(fecha).append("\n");

        if (detenido != null) {
            sb.append("Nombre del Detenido     : ").append(detenido.getNombre()).append("\n");
        } else {
            sb.append("Nombre del Detenido     : No registrado\n");
        }

        if (sucursal != null) {
            sb.append("Sucursal Asaltada       : ").append(sucursal.getNombre()).append("\n");
        } else {
            sb.append("Sucursal Asaltada       : No registrada\n");
        }

        if (banda_criminal != null) {
            sb.append("Código Banda Criminal   : ").append(banda_criminal.getCodigoIdentificacion()).append("\n");
        } else {
            sb.append("Código Banda Criminal   : No asociada\n");
        }

        sb.append("==========================\n");
        return sb.toString();
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
