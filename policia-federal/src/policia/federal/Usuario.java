package policia.federal;

/**
 * Representa un usuario del sistema, el cual tiene un nombre de usuario, una
 * contraseña, un rol con permisos específicos, y opcionalmente un vigilante
 * asociado.
 *
 * Los usuarios pueden autenticarse y verificar si tienen permisos para realizar
 * ciertas acciones.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Usuario {

    private String nombreUsuario;
    private String password;
    private Rol rol;
    private Vigilante vigilante; // null si no aplica

    /**
     * Constructor para crear un nuevo usuario.
     *
     * @param nombreUsuario el nombre de usuario
     * @param password la contraseña del usuario
     * @param rol el rol asignado al usuario, que define sus permisos
     */
    public Usuario(String nombreUsuario, String password, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    /**
     * Verifica si las credenciales ingresadas coinciden con este usuario.
     *
     * @param nombreUsuario el nombre de usuario ingresado
     * @param password la contraseña ingresada
     * @return true si ambos coinciden, false en caso contrario
     */
    public boolean autenticar(String nombreUsuario, String password) {
        return this.nombreUsuario.equals(nombreUsuario) && this.password.equals(password);
    }

    /**
     * Verifica si el usuario tiene el permiso especificado.
     *
     * @param permiso el permiso a verificar
     * @return true si el usuario lo tiene, false si no
     */
    public boolean puedeRealizar(Permiso permiso) {
        return rol.tienePermiso(permiso);
    }

    /**
     * Devuelve el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Muestra por consola los permisos asociados al rol del usuario.
     */
    public void mostrarPermisos() {
        rol.permisosAdquiridos();
    }

    /**
     * Devuelve el rol asignado al usuario.
     *
     * @return el rol del usuario
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Asocia un vigilante al usuario (en caso de que aplique).
     *
     * @param vigilante el vigilante a asociar
     */
    public void setVigilante(Vigilante vigilante) {
        this.vigilante = vigilante;
    }

    /**
     * Devuelve el vigilante asociado al usuario, o null si no tiene.
     *
     * @return el vigilante asociado, o null
     */
    public Vigilante getVigilante() {
        return vigilante;
    }

}
