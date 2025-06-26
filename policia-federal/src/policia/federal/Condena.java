package policia.federal;

/**
 *
 * @author Alassia
 */
public class Condena {
    private int codigo_condena;  
    private Asaltante asaltante;
    private Asalto asalto;
    private int tiempo_condena;
    

    public Condena(Asaltante asaltante, Asalto asalto, int tiempo_condena) {
        this.asaltante = asaltante;
        this.asalto = asalto;
        this.tiempo_condena= tiempo_condena;
    }
    
    public String mostrarNombreAsaltante(){
        return asaltante.getNombre();
    }
    public int mostrarCodigoCondena(){
        return this.codigo_condena;
    }
   public void setCodigo(int codigo) {
        this.codigo_condena = codigo;
    }
   
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
