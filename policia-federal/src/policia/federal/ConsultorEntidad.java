package policia.federal;

import java.util.List;
/**
 * Clase genérica encargada de consultar entidades que implementen la interfaz {@link Nombre}.
 * Muestra al usuario un listado de entidades disponibles, permite seleccionar una opción
 * y muestra su información detallada.
 *
 * @param <T> Tipo de entidad que debe implementar la interfaz {@link Nombre}.
 */
public class ConsultorEntidad<T extends Nombre> {

    private Contexto contexto;
    private Tools tools;
    private List<T> lista;
    private String mensajeTitulo;
/**
     * Constructor que inicializa el consultor con sus dependencias.
     *
     * @param contexto       Contexto que contiene la lógica de visualización y validación.
     * @param tools          Utilidades para lectura y limpieza de consola.
     * @param lista          Lista de entidades a consultar.
     * @param mensajeTitulo  Título que se mostrará al consultar entidades.
     */
    public ConsultorEntidad(Contexto contexto, Tools tools, List<T> lista, String mensajeTitulo) {
        this.contexto = contexto;
        this.tools = tools;
        this.lista = lista;
        this.mensajeTitulo = mensajeTitulo;
    }
/**
     * Método principal que permite al usuario consultar las entidades.
     * Si la lista está vacía, muestra un mensaje y retorna.
     * Si hay elementos, permite seleccionarlos por número de opción y muestra su información.
     */
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
            contexto.mostrarNombreEntidad(lista);  // Tambien podes usar mostrarEntidad()

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
