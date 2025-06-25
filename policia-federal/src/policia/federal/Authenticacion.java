/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nico
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authenticacion {

    //A traves de esta interfaz le aviso a quien llame a mi metodo (En este caso iniciar sesion) que hubo un inicio de sesion existoso.
    public interface Listener {
        void onUserLogin();
    }
    
    //PATRON Singelton, esto hace que no pueda existir mas de una instancia del objeto a la vez en el sistema.
    //Para esto armo estas dos statics, la variable y el metodo.
    //Al ser static no pertencee al objeto, sino a la clase./
    //La clase Auth se instancia a si misma y se adjudica a getInstance.
    private static Authenticacion instance;

    public static Authenticacion getInstance() {
        if (instance == null) {
            instance = new Authenticacion();
        }
        return instance;
    }

    private Usuario usuarioActual = null;
    private List<Usuario> usuarios = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    private Authenticacion() {
        
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }

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

    private Usuario login(String nombreUsuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.autenticar(nombreUsuario, contraseña)) {
                return u;
            }
        }
        return null; // login fallido
    }

    private String leerString(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }
}
