package policia.federal;

/**
 *
 * @author Alassia
 */
public class Caso {
    private int codigo_caso;
    private Juez juez;
    private Condena condena;

    public Caso(Juez juez, Condena condena) {
        this.juez = juez;
        this.condena = condena;
    }
    public void setCodigo(int codigo) {
        this.codigo_caso = codigo;
    }

    @Override
    public String toString() {
        return "Caso{" + "Codigo de Caso: =" + codigo_caso + "Juez asignado: =" + juez.getNombre_apellido() + ", Codigo de condena: " + condena.mostrarCodigoCondena() + '}';
    }
    
   
}
