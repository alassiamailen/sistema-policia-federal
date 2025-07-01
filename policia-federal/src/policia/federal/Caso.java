package policia.federal;

/**
 * Representa un caso judicial en la jurisdicción de la Policía Federal.
 * Cada caso tiene un código identificador, un juez asignado y una condena asociada.
 * Implementa las interfaces {@link Codigo} y {@link Nombre}.
 * 
 * @author Alassia
 */
public class Caso implements Codigo, Nombre {

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
                + "Codigo del Caso        : " + codigo_caso + "\n"
                + "Juez Asignado          : " + (juez != null ? juez.getNombre_apellido() : "No asignado") + "\n"
                + "Codigo de Condena      : " + (condena != null ? condena.mostrarCodigoCondena() : "Sin condena") + "\n"
                + "========================\n";
    }

    @Override
    public int obtenerCodigo() {
        return codigo_caso;
    }

    @Override
    public String getNombre() {
       return "Caso nro: " + codigo_caso + " por Juez: " +  juez.getNombre_apellido();
    }

}
