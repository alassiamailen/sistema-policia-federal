package policia.federal;

import java.time.LocalDate;

/**
 * Representa un asalto registrado en el sistema policial.
 * <p>
 * Contiene informacion sobre el incidente, incluyendo fecha, asaltante
 * involucrado, sucursal afectada y banda criminal relacionada.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
public class Asalto implements Codigo, Nombre{

    private int codigo_asalto = 0;
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
     * Establece el codigo identificador del asalto.
     *
     * @param codigo Codigo numerico unico
     */
    public void setCodigo(int codigo) {
        this.codigo_asalto = codigo;
    }



    public Asaltante obtenerDetenido() {
        return detenido;
    }

    public Sucursal obtenerSucursal() {
        return sucursal;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public Asaltante getDetenido() {
        return detenido;
    }

    @Override
    public int obtenerCodigo() {
        return codigo_asalto;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========= ASALTO =========\n");
        sb.append("Codigo de Asalto        : ").append(codigo_asalto).append("\n");
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
            sb.append("Codigo Banda Criminal   : ").append(banda_criminal.getCodigoIdentificacion()).append("\n");
        } else {
            sb.append("Codigo Banda Criminal   : No asociada\n");
        }

        sb.append("==========================\n");
        return sb.toString();
    }


    @Override
    public String getNombre() {
       return "Asalto nro: " + codigo_asalto + " - Fecha: " + getFecha()+ "\n";
    }
}
