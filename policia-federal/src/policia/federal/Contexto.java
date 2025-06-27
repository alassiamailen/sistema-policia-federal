package policia.federal;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el contexto global del sistema policial, actuando como almacén
 * centralizado de todas las entidades operativas: bancos, sucursales, jueces,
 * vigilantes, asaltantes y bandas criminales.
 * <p>
 * Permite agregar, mostrar, validar y obtener datos de forma estructurada.
 * También facilita la vinculación de entidades como contratos o asaltos.
 * Implementa el patrón de diseño Singleton para garantizar una única instancia.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.1
 */
public class Contexto {

    /**
     * Lista de entidades bancarias registradas en el sistema
     */
    public List<EntidadBancaria> entidadBancaria = new ArrayList<>();

    /**
     * Lista de jueces registrados en el sistema
     */
    public List<Juez> juez = new ArrayList<>();

    /**
     * Lista de vigilantes registrados en el sistema
     */
    public List<Vigilante> vigilante = new ArrayList<>();

    /**
     * Lista de sucursales bancarias registradas
     */
    public List<Sucursal> sucursal = new ArrayList<>();

    /**
     * Lista de asaltantes registrados
     */
    public List<Asaltante> asaltante = new ArrayList<>();

    /**
     * Lista de bandas criminales registradas
     */
    public List<BandaCriminal> bandaCriminal = new ArrayList<>();

    public List<Asalto> asaltos = new ArrayList<>();
    public List<Condena> condenas = new ArrayList<>();
    public List<Caso> casos = new ArrayList<>();

    /**
     * Constructor del contexto, inicializa todas las listas vacías.
     */
    public Contexto() {
    }

    // ------------------------ MÉTODOS DE AGREGADO ------------------------
    
    public <T> void agregarEntidadAlArrayList(List<T> lista, T elemento) {
        lista.add(elemento);
    }

    // ------------------------ MÉTODOS DE VISUALIZACIÓN ------------------------

    public void mostrarEntidadesBancarias() {
        for (int i = 0; i < entidadBancaria.size(); i++) {
            System.out.println((i + 1) + "- " + entidadBancaria.get(i));
        }
    }

 
    public void mostrarBandasCriminales() {
        for (int i = 0; i < bandaCriminal.size(); i++) {
            System.out.println((i + 1) + "- " + "Numero Identificacion: " + bandaCriminal.get(i).getCodigoIdentificacion());
        }
    }


    public void mostrarSucursales() {
        for (int i = 0; i < sucursal.size(); i++) {
            System.out.println((i + 1) + "- " + sucursal.get(i).getNombre());
        }
    }


    public void mostrarDelitos() {
        for (int i = 0; i < asaltos.size(); i++) {
            Asalto c = asaltos.get(i);
            System.out.println((i + 1) + "- " + c);
        }
    }


    public void mostrarCondenas() {
        for (int i = 0; i < condenas.size(); i++) {
            Condena c = condenas.get(i);
            System.out.println((i + 1) + "- " + c);
        }
    }


    public void mostrarJueces() {
        for (int i = 0; i < juez.size(); i++) {
            System.out.println((i + 1) + "- " + juez.get(i).getNombre_apellido());

        }
    }

    public void mostrarAsaltantes() {
        for (int i = 0; i < asaltante.size(); i++) {
            System.out.println((i + 1) + "- " + asaltante.get(i).toString());
        }
    }

    public void mostrarVigilantes() {
        for (int i = 0; i < vigilante.size(); i++) {
            System.out.println((i + 1) + "- " + vigilante.get(i).getNombre());
        }
    }


    public void mostrarContratos(ArrayList<ContratoSucVig> contratos) {
        System.out.println("-- CONTRATOS --");
        for (ContratoSucVig contrato : contratos) {
            System.out.println(contrato);
        }
    }

    public void mostrarAsaltos(ArrayList<Asalto> asaltos) {
        System.out.println("-- ASALTOS --");
        for (Asalto asalto : asaltos) {
            System.out.println(asalto);
        }
    }

    public void mostrarCasos(ArrayList<Caso> casos) {
        System.out.println("-- CASOS --");
        for (Caso caso : casos) {
            System.out.println(caso);
        }
    }

    public void mostrarCasos() {
        for (int i = 0; i < casos.size(); i++) {
            System.out.println((i + 1) + "- " + casos.get(i));
        }
    }

    public void mostrarCondenas(ArrayList<Condena> condenas) {
        System.out.println("-- CONDENAS --");
        for (Condena condena : condenas) {
            System.out.println(condena.toString());
        }
    }


    public void mostrarPermisos() {
        Permiso[] permisos = Permiso.values();
        for (int i = 0; i < permisos.length; i++) {
            System.out.println((i + 1) + "- " + permisos[i].name());
        }
    }

    // ------------------------ MÉTODOS DE VALIDACIÓN ------------------------
  
    public <T> T validarEntidadGenerica(List <T> lista, int index){
         if (index > 0 && index <= lista.size()) {
            return lista.get(index - 1);
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }
    
    public boolean validarCodigoAsalto(int codigo) {

        for (int i = 0; i < asaltos.size(); i++) {
            if (codigo == asaltos.get(i).obtenerCodigo()) {
                return true;
            }
        }
        System.out.println("Error - El codigo " + codigo + " no existe. Intente nuevamente");
        return false;
    }

    public boolean validarAniosCondena(int anios) {
        if (anios > 0 && anios <= 50) {
            return true;
        } else {
            System.out.println("Error - La pena permitida es de 0 a 50 anios. Intente nuevamente");
            return false;
        }
    }

    public Permiso validarPermiso(int index) {
        Permiso[] permisos = Permiso.values();
        if (index > 0 && index <= permisos.length) {
            return permisos[index - 1];
        } else {
            System.out.println("Error - Ingrese una opción válida");
            return null;
        }
    }

    // ------------------------ GETTERS ------------------------
    public List<EntidadBancaria> getEntidadBancaria() {
        return entidadBancaria;
    }

    public List<Asalto> getAsaltos() {
        return asaltos;
    }

    public List<Juez> getJuez() {
        return juez;
    }

    public List<Vigilante> getVigilante() {
        return vigilante;
    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    public List<Asaltante> getAsaltante() {
        return asaltante;
    }

    public List<Condena> getCondenas() {
        return condenas;
    }

    public List<BandaCriminal> getBandaCriminal() {
        return bandaCriminal;
    }

    public List<Caso> getCasos() {
        return casos;
    }

    
    // ------------------------ MÉTODOS DE VINCULACIÓN ------------------------
    public void asignarContratoAVigilante(String nombre_vigilante, ContratoSucVig contrato) {
        for (int i = 0; i < vigilante.size(); i++) {
            if (nombre_vigilante.equals(vigilante.get(i).getNombre())) {
                vigilante.get(i).agregarContrato(contrato);
                break;
            }
        }
    }

    public void asignarAsaltoADetenido(int index, Asalto nuevo_asalto) {
        asaltante.get(index - 1).agregarAsalto(nuevo_asalto);
        asaltos.add(nuevo_asalto);
    }

    // ------------------------ MÉTODOS DE OBTENCIÓN GENERICOS ------------------------
    public <T> T obtenerEntidadPorIndex(List<T> lista, int index) {
        return lista.get(index - 1);
    }

    public <T extends Codigo> T obtenerPorCodigo(List<T> lista, int codigo) {
        for (int i = 0; i < lista.size(); i++) {
            if (codigo == lista.get(i).obtenerCodigo()) {
                return lista.get(i);
            }
        }
        return null;
    }

}
