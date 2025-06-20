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
public class UserVigilante extends Usuario {

    public UserVigilante(String usuario, String password) {
        super(usuario, password);
    }
    
    
    @Override
    public void mostrarMenu() {
        System.out.println("Menú de UserVigilante");
    }
    
}
