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
    /**
     * Agrega una nueva entidad bancaria al sistema.
     *
     * @param entidad La entidad bancaria a registrar
     */
    public void agregarEntidadBancaria(EntidadBancaria entidad) {
        entidadBancaria.add(entidad);
    }

    /**
     * Agrega una nueva sucursal bancaria al sistema.
     *
     * @param s La sucursal a registrar
     */
    public void agregarSucursal(Sucursal s) {
        sucursal.add(s);
    }

    /**
     * Agrega un nuevo vigilante al sistema.
     *
     * @param v El vigilante a registrar
     */
    public void agregarVigilante(Vigilante v) {
        vigilante.add(v);
    }

    /**
     * Agrega un nuevo asaltante al sistema.
     *
     * @param a El asaltante a registrar
     */
    public void agregarAsaltantes(Asaltante a) {
        asaltante.add(a);
    }

    /**
     * Agrega un nuevo juez al sistema.
     *
     * @param j El juez a registrar
     */
    public void agregarJuez(Juez j) {
        juez.add(j);
    }

    /**
     * Agrega una nueva banda criminal al sistema.
     *
     * @param b La banda criminal a registrar
     */
    public void agregarBandaCriminal(BandaCriminal b) {
        bandaCriminal.add(b);
    }

    public void agregarAsalto(Asalto a) {
        asaltos.add(a);
    }

    // ------------------------ MÉTODOS DE VISUALIZACIÓN ------------------------
    /**
     * Muestra por consola todas las entidades bancarias registradas.
     */
    public void mostrarEntidadesBancarias() {
        for (int i = 0; i < entidadBancaria.size(); i++) {
            System.out.println((i + 1) + "- " + entidadBancaria.get(i));
        }
    }

    /**
     * Muestra por consola todas las bandas criminales registradas.
     */
    public void mostrarBandasCriminales() {
        for (int i = 0; i < bandaCriminal.size(); i++) {
            System.out.println((i + 1) + "- " + "Numero Identificacion: " + bandaCriminal.get(i).getCodigoIdentificacion());
        }
    }

    /**
     * Muestra por consola todas las sucursales registradas.
     */
    public void mostrarSucursales() {
        for (int i = 0; i < sucursal.size(); i++) {
            System.out.println((i + 1) + "- " + sucursal.get(i).getNombre());
        }
    }

    /**
     * Muestra por consola todos los jueces registrados.
     */
    public void mostrarJueces() {
        for (int i = 0; i < juez.size(); i++) {
            System.out.println((i + 1) + "- " + juez.get(i).getNombre_apellido());

        }
    }

    /**
     * Muestra por consola todos los asaltantes registrados.
     */
    public void mostrarAsaltantes() {
        for (int i = 0; i < asaltante.size(); i++) {
            System.out.println((i + 1) + "- " + asaltante.get(i).toString());
        }
    }

    /**
     * Muestra por consola todos los vigilantes registrados.
     */
    public void mostrarVigilantes() {
        for (int i = 0; i < vigilante.size(); i++) {
            System.out.println((i + 1) + "- " + vigilante.get(i).getNombre());
        }
    }

    /**
     * Muestra por consola todos los contratos de vigilancia.
     *
     * @param contratos Lista de contratos a mostrar
     */
    public void mostrarContratos(ArrayList<ContratoSucVig> contratos) {
        System.out.println("-- CONTRATOS --");
        for (ContratoSucVig contrato : contratos) {
            System.out.println(contrato);
        }
    }

    /**
     * Muestra por consola todos los asaltos registrados.
     *
     * @param asaltos Lista de asaltos a mostrar
     */
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

    public void mostrarCondenas(ArrayList<Condena> condenas) {
        System.out.println("-- CONDENAS --");
        for (Condena condena : condenas) {
            System.out.println(condena.toString());
        }
    }

    // ------------------------ MÉTODOS DE VALIDACIÓN ------------------------
    /**
     * Valida y obtiene el nombre de una entidad bancaria por su índice.
     *
     * @param index Índice de la entidad bancaria
     * @return Nombre de la entidad o null si el índice es inválido
     */
    public String validarEntidadBancaria(int index) {
        if (index > 0 && index <= entidadBancaria.size()) {
            return entidadBancaria.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }

    /**
     * Valida y obtiene el nombre de un asaltante por su índice.
     *
     * @param index Índice del asaltante
     * @return Nombre del asaltante o null si el índice es inválido
     */
    public String validarAsaltante(int index) {
        if (index > 0 && index <= asaltante.size()) {
            return asaltante.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }

    /**
     * Valida si el índice ingresado corresponde a una condena existente en la
     * lista. Si es válido, retorna la condena correspondiente. Si no, muestra
     * un mensaje de error.
     *
     * @param index índice ingresado por el usuario (1-based).
     * @return la instancia de Condena si es válida, o null si es inválida.
     */
    public Condena validarCondena(int index) {
        if (index > 0 && index <= condenas.size()) {
            return condenas.get(index - 1);
        } else {
            System.out.println("Error - Ingrese una opción válida");
            return null;
        }
    }

    /**
     * Valida y obtiene el nombre de una sucursal por su índice.
     *
     * @param index Índice de la sucursal
     * @return Nombre de la sucursal o null si el índice es inválido
     */
    public String validarSucursal(int index) {
        if (index > 0 && index <= sucursal.size()) {
            return sucursal.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }

    public Juez validarJuez(int index) {
        if (index > 0 && index <= juez.size()) {
            return juez.get(index - 1);
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }

    /**
     * Valida y obtiene el nombre de un vigilante por su índice.
     *
     * @param index Índice del vigilante
     * @return Nombre del vigilante o null si el índice es inválido
     */
    public String validarVigilante(int index) {
        if (index > 0 && index <= vigilante.size()) {
            return vigilante.get(index - 1).getNombre();
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

    // ------------------------ MÉTODOS DE OBTENCIÓN ------------------------
    /**
     * Obtiene el nombre de una entidad bancaria por su índice.
     *
     * @param index Índice de la entidad bancaria
     * @return Nombre de la entidad bancaria
     */
    public String obtenerNombreEntidadBancaria(int index) {
        return entidadBancaria.get(index - 1).getNombre();
    }

    /**
     * Obtiene el nombre de una sucursal por su índice.
     *
     * @param index Índice de la sucursal
     * @return Nombre de la sucursal
     */
    public String obtenerNombreSucursal(int index) {
        return sucursal.get(index - 1).getNombre();
    }

    /**
     * Obtiene el nombre de un vigilante por su índice.
     *
     * @param index Índice del vigilante
     * @return Nombre del vigilante
     */
    public String obtenerNombreVigilante(int index) {
        return vigilante.get(index - 1).getNombre();
    }

    /**
     * Obtiene un asaltante por su índice.
     *
     * @param index Índice del asaltante
     * @return Objeto Asaltante correspondiente
     */
    public Asaltante obtenerDetenido(int index) {
        return asaltante.get(index - 1);
    }

    /**
     * Obtiene la banda criminal asociada a un asaltante por su índice.
     *
     * @param index Índice del asaltante
     * @return Banda criminal asociada
     */
    public BandaCriminal obtenerBandaCriminal(int index) {
        return asaltante.get(index - 1).obtenerBandaCriminal();
    }

    /**
     * Obtiene una sucursal por su índice.
     *
     * @param index Índice de la sucursal
     * @return Objeto Sucursal correspondiente
     */
    public Sucursal obtenerSucursal(int index) {
        return sucursal.get(index - 1);
    }

    public Asaltante obtenerDetenidoPorAsalto(int codigo) {
        for (int i = 0; i < asaltos.size(); i++) {
            if (codigo == asaltos.get(i).obtenerCodigo()) {
                return asaltos.get(i).obtenerDetenido();
            }
        }
        return null;
    }

    public Asalto obtenerAsaltoPorCodigo(int codigo) {
        for (int i = 0; i < asaltos.size(); i++) {
            if (codigo == asaltos.get(i).obtenerCodigo()) {
                return asaltos.get(i);
            }
        }
        return null;
    }

    // ------------------------ GETTERS ------------------------
    /**
     * Obtiene la lista completa de entidades bancarias.
     *
     * @return Lista de EntidadBancaria
     */
    public List<EntidadBancaria> getEntidadBancaria() {
        return entidadBancaria;
    }

    /**
     * Obtiene la lista completa de jueces.
     *
     * @return Lista de Juez
     */
    public List<Juez> getJuez() {
        return juez;
    }

    /**
     * Obtiene la lista completa de vigilantes.
     *
     * @return Lista de Vigilante
     */
    public List<Vigilante> getVigilante() {
        return vigilante;
    }

    /**
     * Obtiene la lista completa de sucursales.
     *
     * @return Lista de Sucursal
     */
    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    /**
     * Obtiene la lista completa de asaltantes.
     *
     * @return Lista de Asaltante
     */
    public List<Asaltante> getAsaltante() {
        return asaltante;
    }

    // ------------------------ MÉTODOS DE VINCULACIÓN ------------------------
    /**
     * Asigna un contrato a un vigilante específico por nombre.
     *
     * @param nombre_vigilante el nombre del vigilante
     * @param contrato el contrato a asignar
     */
    public void asignarContratoAVigilante(String nombre_vigilante, ContratoSucVig contrato) {
        for (int i = 0; i < vigilante.size(); i++) {
            if (nombre_vigilante.equals(vigilante.get(i).getNombre())) {
                vigilante.get(i).agregarContrato(contrato);
                break;
            }
        }
    }

    /**
     * Asigna un asalto a un asaltante dado su índice en la lista.
     *
     * @param index índice del asaltante
     * @param nuevo_asalto asalto a asignar
     */
    // Asignar un [Asalto] a un [Asaltante] determinado
    public void asignarAsaltoADetenido(int index, Asalto nuevo_asalto) {
        asaltante.get(index - 1).agregarAsalto(nuevo_asalto);
        agregarAsaltoAlArrayAsaltos(nuevo_asalto);
    }

    // AGREGAR UN ASALTO A "BASE DE DATOS DE ASALTOS"
    public void agregarAsaltoAlArrayAsaltos(Asalto nuevo_asalto) {
        asaltos.add(nuevo_asalto);
    }

}
