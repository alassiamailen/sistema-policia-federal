package policia.federal;

/**
 *
 * @author Alassia
 */
public class PantallaDeContratarVigilante {
      private Tools tools = new Tools();

    public void contratarVigilante(Contexto contexto) {
        String entidad_bancaria, sucursal, vigilante;
        boolean salir = false;
        int index_entidad_bancaria, index_sucursal, index_vigilante;

        do {
            do {               
                System.out.println("*** CREAR CONTRATO ***");
                contexto.mostrarEntidadesBancarias();
                index_entidad_bancaria = tools.leerEntero("Ingrese nombre de ENTIDAD BANCARIA o <0> para SALIR: ");
                if (index_entidad_bancaria == 0) {
                    salir = true;
                    break;
                }

            } while (contexto.validarEntidadBancaria(index_entidad_bancaria) == null);

            if (!salir) {
                do {
                    contexto.mostrarSucursales();
                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
                } while (contexto.validarSucursal(index_sucursal) == null);

                do {
                    contexto.mostrarVigilantes();
                    index_vigilante = tools.leerEntero("Ingrese nombre de VIGILANTE: ");
                } while (contexto.validarVigilante(index_vigilante) == null);

                entidad_bancaria = contexto.obtenerNombreEntidadBancaria(index_entidad_bancaria);
                sucursal = contexto.obtenerNombreSucursal(index_sucursal);
                vigilante = contexto.obtenerNombreVigilante(index_vigilante);

                ContratoSucVig nuevo_contrato = new ContratoSucVig(entidad_bancaria, sucursal, vigilante);
                contexto.asignarContratoAVigilante(vigilante, nuevo_contrato);
            }
        } while (!salir);       

    }
}
