/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.time.LocalDate;

/**
 *
 * @author Alassia
 */
public class Asalto {
    private int codigo_asalto;
    private LocalDate fecha;
    private Asaltante detenido;
    private Sucursal sucursal;
    private BandaCriminal banda_criminal;  
    

    public Asalto(LocalDate fecha, Asaltante detenido, Sucursal sucursal, BandaCriminal banda_criminal) {       
        this.fecha = fecha;
        this.detenido = detenido;
        this.sucursal = sucursal;
        this.banda_criminal = banda_criminal;
    }
    
    public void setCodigo(int codigo) {
        this.codigo_asalto = codigo;
    }

    @Override
    public String toString() {
        return "Asalto{" + "codigo_asalto=" + codigo_asalto + ", fecha=" + fecha + ", detenido=" + detenido.getNombre() + ", sucursal=" + sucursal.getNombre() + ", banda_criminal=" + banda_criminal.getCodigoIdentificacion() + '}';
    }
    
    
    
}
