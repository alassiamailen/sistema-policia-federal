package policia.federal;

/**
 * Representa un rol dentro del sistema, que tiene un nombre y un conjunto de
 * permisos asociados. Cada usuario posee un rol que determina las acciones que
 * puede realizar.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
import java.util.LinkedHashSet;
import java.util.Set;

public class Rol {

    private String nombre;
    private Set<Permiso> permisos = new LinkedHashSet<>();

    /**
     * Crea un nuevo rol con el nombre especificado.
     *
     * @param nombre el nombre del rol
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Agrega un permiso al conjunto de permisos del rol.
     *
     * @param permiso el permiso a agregar
     */
    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    /**
     * Verifica si el rol tiene un permiso determinado.
     *
     * @param permiso el permiso a verificar
     * @return true si el rol tiene el permiso, false si no
     */
    public boolean tienePermiso(Permiso permiso) {
        return permisos.contains(permiso);
    }

    /**
     * Devuelve el nombre del rol.
     *
     * @return el nombre del rol
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el conjunto de permisos asignados al rol.
     *
     * @return conjunto de permisos
     */
    public Set<Permiso> getPermisos() {
        return permisos;
    }

    /**
     * Muestra por consola los permisos adquiridos por este rol.
     */
    public void permisosAdquiridos() {
        System.out.println("\nPermisos del rol " + nombre + ":");
        for (Permiso p : permisos) {
            System.out.println("- " + p.toString());
        }
    }

}
