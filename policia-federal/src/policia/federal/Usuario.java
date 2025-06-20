/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
abstract class Usuario {
    public String usuario;
    public String password;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    
    public abstract void mostrarMenu();
}
