package policia.federal;

/**
 * Clase encargada de registrar vigilantes en el sistema, creando tanto el
 * objeto Vigilante como su Usuario asociado.
 *
 * Usa el contexto para agregar el vigilante y la autenticación para registrar
 * el usuario.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */

public class RegistroVigilantes {

    private final Authenticacion authenticacion;
    private final Contexto contexto;
    private final Rol rolVigilante;

    /**
     * Constructor que recibe las dependencias necesarias para crear vigilantes.
     *
     * @param auth instancia de autenticación para registrar usuarios
     * @param contexto contexto general con las listas de entidades
     * @param rolVigilante rol que será asignado al usuario vigilante creado
     */
    public RegistroVigilantes(Authenticacion auth, Contexto contexto, Rol rolVigilante) {
        this.authenticacion = auth;
        this.contexto = contexto;
        this.rolVigilante = rolVigilante;
    }

    /**
     * Crea un nuevo vigilante y su usuario asociado, los vincula y los registra
     * en el contexto y el sistema de autenticación.
     *
     * @param nombreApellido nombre y apellido completo del vigilante
     * @param codigo código identificador único del vigilante
     * @param edad edad del vigilante
     * @param nombreUsuario nombre de usuario para login
     * @param clave contraseña del usuario
     */
    public void crearVigilanteConUsuario(String nombreApellido, int edad, String nombreUsuario, String clave) {
        Vigilante vigilante = new Vigilante(nombreApellido, edad);
        Usuario usuario = new Usuario(nombreUsuario, clave, rolVigilante);
        usuario.setVigilante(vigilante);

        contexto.agregarEntidadAlArrayList(contexto.getVigilante(),vigilante);
        authenticacion.registrarUsuario(usuario);
    }
}
