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
    
    
    public void iniciarApp(){
        System.out.println("===== Sistema de Gestion Policial =====");
        String Usuario = leerString("Usuario: ");
        String clave = leerString("Clave: ");
        // Login
        Usuario logueado = login(Usuario, clave);
        autenticacion(logueado);
        
    }
        
    public int leerEntero(String mensaje){
        System.out.println(mensaje);
        int valor = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea pendiente
        return valor;
    }

    
    public String leerString(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }   
    
    private void autenticacion(Usuario logueado){
    if (logueado != null) {
            System.out.println("Bienvenido, " + logueado.getNombreUsuario());
            System.out.println("Rol: " + logueado.getRol().getNombre());
            logueado.mostrarPermisos();
            System.out.println("\n---------------------------------------\n");
            logueado.getRol().getPermisos();
        } else {
            System.out.println("Usuario o password incorrectos");
        }
    }
}
