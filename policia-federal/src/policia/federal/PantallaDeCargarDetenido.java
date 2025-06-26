package policia.federal;
import java.time.LocalDate;
/**
 *
 * @author Alassia
 */
public class PantallaDeCargarDetenido {
    private Tools tools = new Tools();
    int index_asaltante, index_sucursal;
    LocalDate fecha;
    Asaltante detenido;
    BandaCriminal banda_criminal;
    Sucursal sucursal;
    public void cargarDetenido(Contexto contexto) {
        boolean salir = false;
        do {
            do{
                System.out.println("*** CARGAR DETENIDO ***");
                contexto.mostrarAsaltantes();
                index_asaltante = tools.leerEntero("Ingrese numero de ASALTANTE o <0> para SALIR: ");
                if (index_asaltante == 0) {
                    salir = true;
                    break;
                }
                
            }while(contexto.validarAsaltante(index_asaltante)==null);
            if(!salir){
                detenido= contexto.obtenerDetenido(index_asaltante);
                System.out.println(detenido);
                
                do {
                    contexto.mostrarSucursales();
                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
                } while (contexto.validarSucursal(index_sucursal) == null);
                 
                fecha = tools.leerFecha("Ingrese fecha de cuando ocurrio el asalto en formato(dd-MM-yyyy)");
                banda_criminal= contexto.obtenerBandaCriminal(index_asaltante);
                sucursal= contexto.obtenerSucursal(index_sucursal);
                Asalto nuevo_asalto = new Asalto(fecha, detenido, sucursal,banda_criminal);
                //ACA ME FALTA GUARDAR EL ASALTO EN EL ARRAY GENERAL DE ASALTOS SINO SOLO EXISTE EN EL ASALTANTE Y DSP NO ENCUENTRA EL CODIGO_ASALTO CND QUIERE ABRIR UN CASO
                contexto.asignarAsaltoADetenido(index_asaltante, nuevo_asalto);
            }
            
        }while(!salir);
    }
}
