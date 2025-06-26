package policia.federal;

import java.time.LocalDate;

/**
 * Clase que representa la pantalla para cargar información de detenidos
 * (asaltantes). Permite seleccionar un asaltante, una sucursal y registrar un
 * nuevo asalto con fecha.
 *
 * El usuario puede ingresar múltiples asaltos hasta decidir salir.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class PantallaDeCargarDetenido {

    private Tools tools = new Tools();
    int index_asaltante, index_sucursal;
    LocalDate fecha;
    Asaltante detenido;
    BandaCriminal banda_criminal;
    Sucursal sucursal;

    /**
     * Método que despliega la interfaz de texto para cargar un detenido.
     * Permite seleccionar un asaltante existente, una sucursal y la fecha del
     * asalto para crear un nuevo registro de asalto vinculado.
     *
     * @param contexto contexto general del sistema que contiene las listas y
     * datos
     */
    public void cargarDetenido(Contexto contexto) {
        boolean salir = false;
        do {
            do {
                System.out.println("*** CARGAR DETENIDO ***");
                contexto.mostrarAsaltantes();
                index_asaltante = tools.leerEntero("Ingrese numero de ASALTANTE o <0> para SALIR: ");
                if (index_asaltante == 0) {
                    salir = true;
                    break;
                }

            } while (contexto.validarAsaltante(index_asaltante) == null);
            if (!salir) {
                detenido = contexto.obtenerDetenido(index_asaltante);
                System.out.println(detenido);

                do {
                    contexto.mostrarSucursales();
                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
                } while (contexto.validarSucursal(index_sucursal) == null);

                fecha = tools.leerFecha("Ingrese fecha de cuando ocurrio el asalto en formato(dd-MM-yyyy)");

                banda_criminal= contexto.obtenerBandaCriminal(index_asaltante);
                sucursal= contexto.obtenerSucursal(index_sucursal);
                Asalto nuevo_asalto = new Asalto(fecha, detenido, sucursal,banda_criminal);                
                contexto.asignarAsaltoADetenido(index_asaltante, nuevo_asalto);
            }

        } while (!salir);
    }
}
