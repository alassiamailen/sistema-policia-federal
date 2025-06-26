package policia.federal;

/**
 *
 * @author Alassia
 */
public class PantallaDeCrearCondena {
    private Tools tools = new Tools();

    public void crearCondena(Contexto contexto) {
        boolean salir = false;
        int index_cod_asalto,anios_de_condena;
        Asaltante detenido;
        Asalto delito;
        
        do{
            do{
                System.out.println("*** CREAR CONDENA ***");
                index_cod_asalto = tools.leerEntero("Ingrese codigo de ASALTO o <0> para SALIR: ");
                 if (index_cod_asalto == 0) {
                    salir = true;
                    break;
                }
            }while(!contexto.validarCodigoAsalto(index_cod_asalto));
            if(!salir){
                ///mostrar detalles del asato
                do{
                    anios_de_condena= tools.leerEntero("Ingrese anios de Condena");
                }while(!contexto.validarAniosCondena(anios_de_condena));
                
                
                detenido= contexto.obtenerDetenidoPorAsalto(index_cod_asalto);
                delito= contexto.obtenerAsaltoPorCodigo(index_cod_asalto);              
                
                
                Condena nuevo_condena = new Condena(detenido, delito, anios_de_condena);
                
            
            }
            
            
        }while(!salir);
    }
}
