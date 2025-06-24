/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nico
 */

public class RegistroVigilantes {

    private final Authenticacion authenticacion;
    private final Contexto contexto;
    private final Rol rolVigilante;

    public RegistroVigilantes(Authenticacion auth, Contexto contexto, Rol rolVigilante) {
        this.authenticacion = auth;
        this.contexto = contexto;
        this.rolVigilante = rolVigilante;
    }

    public void crearVigilanteConUsuario(String nombreApellido, int codigo, int edad, String nombreUsuario, String clave) {
        Vigilante vigilante = new Vigilante(nombreApellido, codigo, edad);
        Usuario usuario = new Usuario(nombreUsuario, clave, rolVigilante);
        usuario.setVigilante(vigilante);

        contexto.agregarVigilante(vigilante);
        authenticacion.registrarUsuario(usuario);
    }
}


