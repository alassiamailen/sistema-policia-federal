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
        EntidadBancaria BBVA = new EntidadBancaria("BBVA",1234, "Triunvirato");
        EntidadBancaria GALICIA = new EntidadBancaria("Galicia",134, "Vicente Lopez");
        EntidadBancaria SANTANDER_RIO = new EntidadBancaria("Santander Rio",14, "Paternal");
        //SUCURSALES
        Sucursal paternal = new Sucursal(15,"Paternal");
        Sucursal vicente_lopez = new Sucursal(15,"Vicente Lopez");
        Sucursal triunvirato = new Sucursal(15,"Triunvirato");
        // VIGILANTES
        Vigilante vigilante_1 = new Vigilante("JUAN PEREZ", 12, 45);
        Vigilante vigilante_2 = new Vigilante("MONICA DIAZ", 33, 56);
        Vigilante vigilante_3 = new Vigilante("PEDRO PEDRO", 120, 54);
        
     
        
        Contexto contexto = new Contexto();
        // Inicializar entidad
        contexto.agregarEntidadBancaria(BBVA);
        contexto.agregarEntidadBancaria(GALICIA);
        contexto.agregarEntidadBancaria(SANTANDER_RIO);
        // Inicializar sucursal
        contexto.agregarSucursal(paternal);
        contexto.agregarSucursal(vicente_lopez);
        contexto.agregarSucursal(triunvirato);
        // Inicializar vigilante
        contexto.agregarVigilante(vigilante_1);
        contexto.agregarVigilante(vigilante_2);
        contexto.agregarVigilante(vigilante_3);

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
