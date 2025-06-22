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
        
        // Roles
        Rol admin = new Rol("Administrador");
        admin.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        admin.agregarPermiso(Permiso.CONSULTAR_MIS_DATOS);
        admin.agregarPermiso(Permiso.CREAR_USUARIOS);
        admin.agregarPermiso(Permiso.EDITAR_DATOS);
        admin.agregarPermiso(Permiso.ELIMINAR_DATOS);

        Rol vigilante = new Rol("Vigilante");
        vigilante.agregarPermiso(Permiso.CONSULTAR_MIS_DATOS);

        Rol investigador = new Rol("Investigador");
        investigador.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);

        // Sistema y usuarios
        Sistema sistema = new Sistema();
        sistema.registrarUsuario(new Usuario("juan", "1234", admin));
        sistema.registrarUsuario(new Usuario("pepe", "abcd", vigilante));
        sistema.registrarUsuario(new Usuario("lula", "123", investigador));

        sistema.iniciarApp();

    }

}
