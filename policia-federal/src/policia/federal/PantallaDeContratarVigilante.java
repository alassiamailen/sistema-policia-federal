package policia.federal;

/**
 * Clase que representa la pantalla para crear contratos entre vigilantes y
 * sucursales. Permite seleccionar una entidad bancaria, una sucursal y un
 * vigilante para crear un nuevo contrato.
 *
 * El proceso se repite hasta que el usuario decida salir.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class PantallaDeContratarVigilante {

    private Tools tools = new Tools();

    /**
     * Método que muestra la interfaz para crear un contrato entre una sucursal
     * y un vigilante. Solicita al usuario que seleccione la entidad bancaria,
     * sucursal y vigilante correspondientes, y registra el contrato en el
     * contexto.
     *
     * @param contexto contexto general del sistema que contiene las entidades y
     * datos
     */
    public void contratarVigilante(Contexto contexto) {
        String entidad_bancaria, sucursal, vigilante;
        boolean salir = false;
        int index_entidad_bancaria, index_sucursal, index_vigilante;

        do {
            do {
                System.out.println("*** CREAR CONTRATO ***");
//                contexto.mostrarEntidadesBancarias();
                contexto.mostrarEntidad(contexto.getEntidadBancaria());
                index_entidad_bancaria = tools.leerEntero("Ingrese nombre de ENTIDAD BANCARIA o <0> para SALIR: ");
                if (index_entidad_bancaria == 0) {
                    salir = true;
                    break;
                }

            } while (contexto.validarEntidadGenerica(contexto.getEntidadBancaria(),index_entidad_bancaria) == null);

            if (!salir) {
                do {
//                    contexto.mostrarSucursales();
                    contexto.mostrarNombreEntidad(contexto.getSucursal());
                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
                } while (contexto.validarEntidadGenerica(contexto.getSucursal(),index_sucursal) == null);

                do {
//                    contexto.mostrarVigilantes();
                    contexto.mostrarNombreEntidad(contexto.getVigilante());
                    index_vigilante = tools.leerEntero("Ingrese nombre de VIGILANTE: ");
                } while (contexto.validarEntidadGenerica(contexto.getVigilante(),index_vigilante) == null);
                    
                    
                    

                entidad_bancaria = contexto.obtenerEntidadPorIndex(contexto.getEntidadBancaria(),index_entidad_bancaria).getNombre();
                sucursal = contexto.obtenerEntidadPorIndex(contexto.getSucursal(),index_sucursal).getNombre();
                vigilante = contexto.obtenerEntidadPorIndex(contexto.getVigilante(),index_vigilante).getNombre();


                ContratoSucVig nuevo_contrato = new ContratoSucVig(entidad_bancaria, sucursal, vigilante);
                contexto.asignarContratoAVigilante(vigilante, nuevo_contrato);
            }
        } while (!salir);

    }
}
