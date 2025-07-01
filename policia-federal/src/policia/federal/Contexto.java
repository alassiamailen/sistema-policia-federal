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

    public List<EntidadBancaria> entidadBancaria = new ArrayList<>();
    public List<Juez> juez = new ArrayList<>();
    public List<Vigilante> vigilante = new ArrayList<>();
    public List<Sucursal> sucursal = new ArrayList<>();
    public List<Asaltante> asaltante = new ArrayList<>();
    public List<BandaCriminal> bandaCriminal = new ArrayList<>();
    public List<Asalto> asaltos = new ArrayList<>();
    public List<Condena> condenas = new ArrayList<>();
    public List<Caso> casos = new ArrayList<>();

    public Contexto() {
    }

    // ------------------------ MÉTODOS DE AGREGADO ------------------------
    public <T> void agregarEntidadAlArrayList(List<T> lista, T elemento) {
        lista.add(elemento);
    }

    // ------------------------ MÉTODOS DE VISUALIZACIÓN ------------------------
    public <T> void mostrarEntidad(List<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "- " + lista.get(i));
        }
    }

    public <T extends Nombre> void mostrarNombreEntidad(List<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "- " + lista.get(i).getNombre());
        }
    }

    public void mostrarPermisos() {
        Permiso[] permisos = Permiso.values();
        for (int i = 0; i < permisos.length; i++) {
            System.out.println((i + 1) + "- " + permisos[i].name());
        }
    }

    // ------------------------ MÉTODOS DE VALIDACIÓN ------------------------
    public <T> T validarEntidadGenerica(List<T> lista, int index) {
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
