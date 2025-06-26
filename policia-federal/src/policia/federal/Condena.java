package policia.federal;

/**
 * Representa una condena asignada a un asaltante por un asalto específico.
 * Contiene información sobre el asaltante, el asalto correspondiente y
 * la duración de la condena en años.
 * 
 * @author Alassia
 */
public class Condena {
    private int codigo_condena;  
    private Asaltante asaltante;
    private Asalto asalto;
    private int tiempo_condena;
    
     /**
     * Constructor para crear una nueva condena.
     * 
     * @param asaltante     El asaltante condenado.
     * @param asalto       El asalto por el cual se condena.
     * @param tiempo_condena Duración de la condena en años.
     */
    public Condena(Asaltante asaltante, Asalto asalto, int tiempo_condena) {
        this.asaltante = asaltante;
        this.asalto = asalto;
        this.tiempo_condena= tiempo_condena;
    }
    
     /**
     * Obtiene el nombre del asaltante condenado.
     * 
     * @return Nombre del asaltante.
     */
    public String mostrarNombreAsaltante(){
        return asaltante.getNombre();
    }
    
     /**
     * Obtiene el código identificador de la condena.
     * 
     * @return Código de la condena.
     */
    public int mostrarCodigoCondena(){
        return this.codigo_condena;
    }
    
     /**
     * Establece el código identificador de la condena.
     * 
     * @param codigo Código numérico único para la condena.
     */
   public void setCodigo(int codigo) {
        this.codigo_condena = codigo;
    }
   
    /**
     * Devuelve una representación en cadena de la condena con sus detalles.
     * 
     * @return Cadena con la información de la condena.
     */
 @Override
public String toString() {
    return "Condena \n" +
           "\tcodigo_condena = " + codigo_condena + ",\n" +
           "\tasaltante = " + asaltante.getNombre() + ",\n" +
           "\tasalto = " + asalto + ",\n" +
           "\ttiempo_condena = " + tiempo_condena + "\n" +
           "";
}   
}
