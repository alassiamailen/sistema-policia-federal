package policia.federal;

/**
 * Enum que representa los distintos permisos que pueden ser asignados a un rol.
 * Cada permiso tiene una descripción legible que se utiliza en la interfaz del
 * sistema.
 *
 * Estos permisos definen qué acciones puede realizar un usuario según su rol.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public enum Permiso {
    /**
     * Permite consultar los datos personales del vigilante.
     */
    CONSULTAR_MIS_DATOS_VIGILANTE("Consultar mis datos."),
    /**
     * Permite consultar los datos de todas las entidades del sistema.
     */
    CONSULTAR_DATOS_DE_OTRAS_ENTIDADES("Consultar datos DE TODO."),
    /**
     * Permite editar datos dentro del sistema.
     */
    EDITAR_DATOS("Editar datos."),
    /**
     * Permite crear nuevos usuarios.
     */
    CREAR_USUARIOS("Crear usuario."),
    /**
     * Permite crear un contrato entre una sucursal y un vigilante.
     */
    CONTRATAR_VIGILANTE("Crear un contrato entre sucursal y vigilante."),
    /**
     * Permite registrar un nuevo detenido en el sistema.
     */
    CARGAR_DETENIDO("Cargar un detenido."),
    /**
     * Permite eliminar usuarios del sistema.
     */
    ELIMINAR_DATOS("Eliminar usuarios."),
    /**
     * Permite abrir un caso judicial.
     */
    ABRIR_CASO("Abrir un caso"),
    /**
     * Permite cerrar la sesión actual.
     */
    CERRAR_SESION("Cerrar sesion."),
    /**
     * Permite salir completamente del sistema.
     */
    SALIR("Salir del programa.");

    private final String descripcion;

    /**
     * Constructor del enum Permiso.
     *
     * @param descripcion descripción legible del permiso
     */
    Permiso(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la descripción del permiso.
     *
     * @return descripción legible del permiso
     */
    @Override
    public String toString() {
        return descripcion;
    }

}
