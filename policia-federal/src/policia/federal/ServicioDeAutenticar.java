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
public class ServicioDeAutenticar {
    
    private ArrayList <Usuario> usuario;

    public ServicioDeAutenticar(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }
        
    public Usuario login(String username, String password) {
        for (Usuario user : usuario) {
            if (user.getUsuario().equals(username) && user.getPassword().equals(password)) {
                return user; // Autenticado
            }
        }
        return null; // Fallo
    }
    
}
