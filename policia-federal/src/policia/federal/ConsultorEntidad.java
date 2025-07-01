package policia.federal;

import java.util.List;

public class ConsultorEntidad<T extends Nombre> {

    private Contexto contexto;
    private Tools tools;
    private List<T> lista;
    private String mensajeTitulo;

    public ConsultorEntidad(Contexto contexto, Tools tools, List<T> lista, String mensajeTitulo) {
        this.contexto = contexto;
        this.tools = tools;
        this.lista = lista;
        this.mensajeTitulo = mensajeTitulo;
    }

    public void consultar() {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay elementos registrados en el sistema.\n");
            tools.leerEntero("Presione 0 para volver al menu anterior");
            tools.limpiarConsola();
            return;
        }

        T entidad = null;

        do {
            System.out.println(mensajeTitulo);
            contexto.mostrarNombreEntidad(lista);  // También podés usar mostrarEntidad()

            int opcion = tools.leerEntero("Indique el numero de su opcion a elegir (0 para salir):");
            if (opcion == 0) {
                return;
            }

            entidad = contexto.validarEntidadGenerica(lista, opcion);

            if (entidad != null) {
                System.out.println(entidad.toString());
                tools.leerEntero("Presione 0 para volver al menu anterior");
                tools.limpiarConsola();
                
            }

        } while (entidad == null);
    }
}
