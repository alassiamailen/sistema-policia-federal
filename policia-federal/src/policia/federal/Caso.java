package policia.federal;

/**
 * Representa un caso judicial asignado a un juez, vinculado a una condena específica.
 * Contiene información sobre el juez responsable y la condena asociada al caso.
 * 
 * @author Alassia
 */
public class Caso {
    private int codigo_caso;
    private Juez juez;
    private Condena condena;
    
     /**
     * Constructor para crear un nuevo caso judicial.
     * 
     * @param juez   El juez asignado al caso.
     * @param condena La condena asociada al caso.
     */
    public Caso(Juez juez, Condena condena) {
        this.juez = juez;
        this.condena = condena;
    }
    
     /**
     * Establece el código identificador del caso.
     * 
     * @param codigo Código numérico único para el caso.
     */
    public void setCodigo(int codigo) {
        this.codigo_caso = codigo;
    }
    
     /**
     * Devuelve una representación en cadena con los detalles del caso.
     * 
     * @return Cadena con el código del caso, nombre del juez y código de la condena.
     */
    @Override
    public String toString() {
        return "Caso{" + "Codigo de Caso: =" + codigo_caso + "Juez asignado: =" + juez.getNombre_apellido() + ", Codigo de condena: " + condena.mostrarCodigoCondena() + '}';
    }
    
   
}
