/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nico
 */
import java.util.LinkedHashSet;
import java.util.Set;

public class Rol {
    private String nombre;
    private Set<Permiso> permisos = new LinkedHashSet<>();


    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    public boolean tienePermiso(Permiso permiso) {
        return permisos.contains(permiso);
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }
    
    public void permisosAdquiridos(){
        System.out.println("\nPermisos del rol " + nombre + ":");
        for(Permiso p : permisos){
            System.out.println("- " + p.toString());
        }
    }
    
}