/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class UsersTools {

    private ArrayList<Usuario> usuarios;


    public <T extends Usuario> T autenticar(String usuario, String clave, Class<T> tipoUsuario) {
        for (Usuario u : usuarios) {
            if (tipoUsuario.isInstance(u) && u.getUsuario().equals(usuario) && u.getPassword().equals(clave)) {
                return tipoUsuario.cast(u);
            }
        }
        return null;
    }
}
