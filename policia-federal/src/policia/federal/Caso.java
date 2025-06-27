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
        return "\n========= CASO =========\n"
                + "Código del Caso        : " + codigo_caso + "\n"
                + "Juez Asignado          : " + (juez != null ? juez.getNombre_apellido() : "No asignado") + "\n"
                + "Código de Condena      : " + (condena != null ? condena.mostrarCodigoCondena() : "Sin condena") + "\n"
                + "========================\n";
    }

}
