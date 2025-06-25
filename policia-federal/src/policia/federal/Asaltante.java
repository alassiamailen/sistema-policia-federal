package policia.federal;

import java.util.ArrayList;

/**
 *
 * @author Alassia
 * @author Nico
 */
public class Asaltante {

    private int codigo;
    private String nombre_apellido;
    private BandaCriminal banda_criminal;
    private ArrayList<Asalto> asaltos = new ArrayList<>();
    private int contadorAsaltos = 0;

    Tools tools = new Tools();

    public Asaltante(int codigo, String nombre_apellido) {
        this.codigo = codigo;
        this.nombre_apellido = nombre_apellido;
    }

    public Asaltante(int codigo, String nombre_apellido, BandaCriminal banda_criminal) {
        this.codigo = codigo;
        this.nombre_apellido = nombre_apellido;
        this.banda_criminal = banda_criminal;
    }

    /////////////BORRAR ESTO/////////////     
    Contexto contexto = new Contexto();

    public Asaltante() {
        ingresarDatos();
    }

    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo del asaltado: ");

    }

    public String getNombre() {
        return nombre_apellido;
    }

    @Override
    public String toString() {
        return "ID: " + codigo + "\nNombre: " + nombre_apellido + "\nID Banda Criminal: " + banda_criminal.getCodigoIdentificacion();
    }

    public BandaCriminal obtenerBandaCriminal() {
        return banda_criminal;
    }

    /// Agregar un [Asalto] al ArrayList [asaltos]
    public void agregarAsalto(Asalto nuevo_asalto) {
        // Le asigno un codigo unico al contrato antes de guardarlo en el array
        nuevo_asalto.setCodigo(contadorAsaltos);
        asaltos.add(nuevo_asalto);
        contadorAsaltos++;

        /////////////BORRAR ESTO///////////// 
        contexto.mostrarAsaltos(asaltos);
    }
}
