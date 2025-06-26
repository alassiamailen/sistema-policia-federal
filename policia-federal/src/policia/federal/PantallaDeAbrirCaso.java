package policia.federal;
/**
 * Pantalla encargada de abrir un nuevo caso judicial en el sistema.
 * <p>
 * Esta clase representa la lógica de interacción con el usuario para registrar un nuevo caso
 * basado en un asalto previamente ingresado, asignando una condena al detenido y
 * un juez al caso.
 * </p>
 *
 * Flujo general:
 * - Selección del asalto mediante su código.
 * - Ingreso de años de condena.
 * - Selección de juez.
 * - Generación y asignación de la condena y el caso correspondiente.
 *
 * @author Alassia
 */

public class PantallaDeAbrirCaso {

    private Tools tools = new Tools();
    
    /**
     * Inicia el proceso de apertura de un nuevo caso judicial.
     * <p>
     * El usuario deberá:
     * - Seleccionar un asalto mediante su código.
     * - Ingresar los años de condena.
     * - Seleccionar un juez válido.
     * Luego, se genera una {@code Condena} que se asigna al {@code Asaltante},
     * se marca el asaltante como condenado, y se crea un {@code Caso} asociado a un {@code Juez}.
     * </p>
     *
     * @param contexto Objeto {@code Contexto} que contiene y gestiona los datos del sistema.
     */
    public void abrirCaso(Contexto contexto) {
        boolean salir = false;
        int index_cod_asalto, anios_de_condena, index_juez;
        Asaltante detenido;
        Asalto delito;
        Juez juez;

        do {
            // Selección del asalto
            do {
                System.out.println("*** CREAR UN CASO ***");
                index_cod_asalto = tools.leerEntero("Ingrese codigo de ASALTO o <0> para SALIR: ");
                if (index_cod_asalto == 0) {
                    salir = true;
                    break;
                }
            } while (!contexto.validarCodigoAsalto(index_cod_asalto));
            if (!salir) {
                contexto.obtenerAsaltoPorCodigo(index_cod_asalto);
                // Ingreso y validación de años de condena
                do {
                    anios_de_condena = tools.leerEntero("Ingrese anios de Condena");
                } while (!contexto.validarAniosCondena(anios_de_condena));

                detenido = contexto.obtenerDetenidoPorAsalto(index_cod_asalto);
                delito = contexto.obtenerAsaltoPorCodigo(index_cod_asalto);
                
                // Selección del juez
                do {
                    System.out.println("*** ASALTO SELECCIONADO ***");
                    System.out.println(delito.toString());
                    contexto.mostrarJueces();
                    index_juez = tools.leerEntero("Ingrese numero de Juez");
                    juez = contexto.validarJuez(index_juez);
                } while (juez == null);
                // Registrar condena y caso
                delito.condenarAsaltante();
                Condena nuevo_condena = new Condena(detenido, delito, anios_de_condena);                
                
                detenido.agregarCondena(nuevo_condena);
                /////////BORRAR ESTO/////////
                delito.mostarAsalto();
                
                Caso nuevo_caso = new Caso(juez, nuevo_condena);
              
                juez.agregarCasos(nuevo_caso);

            }

        } while (!salir);
    }

}
