/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package policia.federal;

import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class Main {

    public static void main(String[] args) {
        //ENTIDADES
        EntidadBancaria nueva1 = new EntidadBancaria("BBVA",1234, "Triunvirato");
        EntidadBancaria nueva2 = new EntidadBancaria("Galicia",134, "aca");
        EntidadBancaria nueva3 = new EntidadBancaria("Santander Rio",14, "alla");
     
        
        Contexto contexto = new Contexto();
        
        contexto.agregarEntidadBancaria(nueva1);
        contexto.agregarEntidadBancaria(nueva2);
        contexto.agregarEntidadBancaria(nueva3);

        // Roles
        Rol admin = new Rol("Administrador");
        admin.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        admin.agregarPermiso(Permiso.CONTRATAR_VIGILANTE);
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

        sistema.iniciarApp(contexto);

    }

}
