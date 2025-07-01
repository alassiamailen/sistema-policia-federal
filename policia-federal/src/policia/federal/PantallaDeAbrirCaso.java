/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 * Clase encargada de manejar la interfaz de usuario para la creación de nuevos
 * casos.
 * <p>
 * Permite seleccionar un asalto registrado, ingresar los años de condena,
 * asignar un juez, y finalmente crear un {@link Caso} con su respectiva
 * {@link Condena}. Este nuevo caso se asocia tanto al juez como al detenido
 * implicado en el asalto.
 * </p>
 *
 * El flujo permite al usuario:
 * <ul>
 * <li>Seleccionar un asalto por código</li>
 * <li>Validar años de condena</li>
 * <li>Seleccionar un juez disponible</li>
 * <li>Crear la condena y asociarla al detenido</li>
 * <li>Crear el caso y asociarlo al juez</li>
 * </ul>
 *
 * @author Alassia
 */
public class PantallaDeAbrirCaso {

    private Tools tools = new Tools();

    /**
     * Inicia el proceso interactivo para crear un nuevo caso en el sistema.
     *
     * @param contexto El contexto del sistema que contiene todas las entidades
     * registradas.
     */
    public void abrirCaso(Contexto contexto) {
        boolean salir = false;
        int index_cod_asalto, anios_de_condena, index_juez;
        Asaltante detenido;
        Asalto delito;
        Juez juez;

        do {
            do {
                System.out.println("*** CREAR UN CASO ***");
                index_cod_asalto = tools.leerEntero("Ingrese codigo de ASALTO o <0> para SALIR: ");
                if (index_cod_asalto == 0) {
                    salir = true;
                    break;
                }
            } while (!contexto.validarCodigoAsalto(index_cod_asalto));
            if (!salir) {
//                contexto.obtenerAsaltoPorCodigo(index_cod_asalto);
//                contexto.obtenerPorCodigo(contexto.getAsaltos(), index_cod_asalto);
                do {
                    anios_de_condena = tools.leerEntero("Ingrese anios de Condena");
                } while (!contexto.validarAniosCondena(anios_de_condena));

                detenido = contexto.obtenerPorCodigo(contexto.getAsaltos(), index_cod_asalto).obtenerDetenido();
//                detenido = contexto.obtenerDetenidoPorAsalto(index_cod_asalto);
                delito = contexto.obtenerPorCodigo(contexto.getAsaltos(), index_cod_asalto);

                do {
                    System.out.println("*** ASALTO SELECCIONADO ***");
                    System.out.println(delito.toString());
//                    contexto.mostrarJueces();
                    contexto.mostrarNombreEntidad(contexto.getJuez());
                    index_juez = tools.leerEntero("Ingrese numero de Juez");
                    juez = contexto.validarEntidadGenerica(contexto.getJuez(), index_juez);
                } while (juez == null);

                Condena nuevo_condena = new Condena(detenido, delito, anios_de_condena);
                // Asignar Condena a Detenido
                detenido.agregarCondena(nuevo_condena);

                Caso nuevo_caso = new Caso(juez, nuevo_condena);
                // Asignar Caso a Juez
                juez.agregarCasos(nuevo_caso);

                contexto.agregarEntidadAlArrayList(contexto.getCasos(), nuevo_caso);

            }

        } while (!salir);
    }

}
