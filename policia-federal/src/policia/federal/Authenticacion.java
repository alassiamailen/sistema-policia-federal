package policia.federal;

/**
 * Sistema de autenticacion para el Sistema de Gestion Policial.
 * <p>
 * Implementa el patron Singleton para garantizar una unica instancia en el
 * sistema. Proporciona funcionalidades para registro de usuarios, inicio de
 * sesion y gestion de sesiones activas.
 *
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authenticacion {

    /**
     * Interfaz para notificar eventos de inicio de sesion exitoso.
     */
    //A traves de esta interfaz le aviso a quien llame a mi metodo (En este caso iniciar sesion) que hubo un inicio de sesion existoso.
    public interface Listener {

        void onUserLogin();
    }
    // Singleton instance
    //PATRON Singelton, esto hace que no pueda existir mas de una instancia del objeto a la vez en el sistema.
    //Para esto armo estas dos statics, la variable y el metodo.
    //Al ser static no pertencee al objeto, sino a la clase./
    //La clase Auth se instancia a si misma y se adjudica a getInstance.
    private static Authenticacion instance;

    /**
     * Obtiene la instancia unica de la clase Authenticacion.
     *
     * @return La instancia singleton de Authenticacion
     */
    public static Authenticacion getInstance() {
        if (instance == null) {
            instance = new Authenticacion();
        }
        return instance;
    }

    private Usuario usuarioActual = null;
    private List<Usuario> usuarios = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructor privado para implementacion del patron Singleton.
     */
    private Authenticacion() {

    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario El objeto Usuario a registrar
     */
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Cierra la sesion del usuario actual.
     */
    public void cerrarSesion() {
        usuarioActual = null;
    }

    /**
     * Inicia sesion con un nombre de usuario y clave.
     * <p>
     * Permite 3 intentos fallidos antes de bloquear el acceso temporalmente.
     *
     * @param listener Objeto que sera notificado cuando el login sea exitoso
     */
    public void iniciarSesion(Listener listener) {
        int intento = 3;
        System.out.println("===== Sistema de Gestion Policial =====");
        do {
            System.out.println("\n.::Iniciar Sesion::.");
            String usuario = leerString("Usuario: ");
            String clave = leerString("Clave: ");
            usuarioActual = login(usuario, clave);
            if (usuarioActual == null) {
                System.out.println("......................");
                System.out.println("Usuario o Clave Incorrecta");
                intento--;
                if (intento == 0) {
                    System.out.println("Limite de intentos denegados. Contactarse con el administrador.");
                    return;
                }
                if (intento < 2) {
                    System.out.println("Intente nuevamente. Queda " + intento + " intento.");
                } else {
                    System.out.println("Intente nuevamente. Quedan " + intento + " intentos.");
                }
                System.out.println("......................");
            }
        } while (usuarioActual == null && intento != 0);

        System.out.println("Bienvenido, " + usuarioActual.getRol().getNombre() + " " + usuarioActual.getNombreUsuario());

        listener.onUserLogin();
    }

    /**
     * Verifica las credenciales de un usuario.
     *
     * @param nombreUsuario Nombre de usuario a verificar
     * @param clave Contraseña a verificar
     * @return El objeto Usuario si las credenciales son validas, null en caso
     * contrario
     */
    private Usuario login(String nombreUsuario, String clave) {
        for (Usuario u : usuarios) {
            if (u.autenticar(nombreUsuario, clave)) {
                return u;
            }
        }
        return null; // login fallido
    }

    /**
     * Lee una cadena de texto desde la consola.
     *
     * @param mensaje Mensaje a mostrar al usuario
     * @return La cadena ingresada por el usuario
     */
    private String leerString(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
}
