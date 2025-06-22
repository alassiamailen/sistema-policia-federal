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

public class Sistema {

    private List<Usuario> usuarios = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario login(String nombreUsuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.autenticar(nombreUsuario, contraseña)) {
                return u;
            }
        }
        return null; // login fallido
    }

    public void iniciarApp(Contexto contexto) {
        int intento = 3;
        Usuario logueado = null;
        System.out.println("===== Sistema de Gestion Policial =====");
        do {
            System.out.println("\n=========Iniciar Sesion=========");
            String Usuario = leerString("Usuario: ");
            String clave = leerString("Clave: ");
            logueado = login(Usuario, clave);
            if (logueado == null) {
                System.out.println("......................");
                System.out.println("Usuario o Clave Incorrecta");
                intento--;
                if (intento == 0) {
                    System.out.println("Limite de intentos denegados. Contactarse con el administrador.");
                    return;
                }
                if (intento < 2) {
                    System.out.println("Intente nuevamente. Queda " + intento + " intento.");
                    System.out.println("......................");

                } else {
                    System.out.println("Intente nuevamente. Quedan " + intento + " intentos.");
                    System.out.println("......................");

                }

            }
        } while (logueado == null && intento != 0);
            if (logueado != null){
                System.out.println("Bienvenido, " + logueado.getNombreUsuario());
                System.out.println("Rol: " + logueado.getRol().getNombre());
                MostrarElMenu mostrarMenu = new MostrarElMenu(logueado, contexto);
                mostrarMenu.deInicio();
            }
        
    }

    public int leerEntero(String mensaje) {
        System.out.println(mensaje);
        int valor = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea pendiente
        return valor;
    }

    public String leerString(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }


}
