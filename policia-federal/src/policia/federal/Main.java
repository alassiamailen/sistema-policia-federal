/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package policia.federal;

/**
 *
 * @author Nico
 */
public class Main {

    public static void main(String[] args) {
        // 

        // Roles
        Rol admin = new Rol("Administrador");
        admin.agregarPermiso(Permiso.ADMINISTRAR_TODO);

        Rol vigilante = new Rol("Vigilante");
        vigilante.agregarPermiso(Permiso.CONSULTAR_DATOS_PROPIOS);

        Rol investigador = new Rol("Investigador");
        investigador.agregarPermiso(Permiso.CONSULTAR_DATOS_PROPIOS);

        // Sistema y usuarios
        Sistema sistema = new Sistema();
        sistema.registrarUsuario(new Usuario("juan", "1234", admin));
        sistema.registrarUsuario(new Usuario("pepe", "abcd", vigilante));
        sistema.registrarUsuario(new Usuario("lula", "123", investigador));

        sistema.iniciarApp();

    }

}
