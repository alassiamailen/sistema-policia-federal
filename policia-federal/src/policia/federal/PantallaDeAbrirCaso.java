/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Alassia
 */
public class PantallaDeAbrirCaso {

    private Tools tools = new Tools();

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
                    contexto.mostrarJueces();
                    index_juez = tools.leerEntero("Ingrese numero de Juez");
                    juez = contexto.validarEntidadGenerica(contexto.getJuez(),index_juez);
                } while (juez == null);

                Condena nuevo_condena = new Condena(detenido, delito, anios_de_condena);
                // Asignar Condena a Detenido
                detenido.agregarCondena(nuevo_condena);

                Caso nuevo_caso = new Caso(juez, nuevo_condena);
                // Asignar Caso a Juez
                juez.agregarCasos(nuevo_caso);

            }

        } while (!salir);
    }

}
