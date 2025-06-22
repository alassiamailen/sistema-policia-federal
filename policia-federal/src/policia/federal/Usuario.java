/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nico
 */
public class Usuario {
    private String nombreUsuario;
    private String password;
    private Rol rol;

    public Usuario(String nombreUsuario, String password, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    public boolean autenticar(String nombreUsuario, String password) {
        return this.nombreUsuario.equals(nombreUsuario) && this.password.equals(password);
    }

    public boolean puedeRealizar(Permiso permiso) {
        return rol.tienePermiso(permiso);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void mostrarPermisos(){
        rol.permisosAdquiridos();}
    
    public Rol getRol() {
        return rol;
    }
    
}

