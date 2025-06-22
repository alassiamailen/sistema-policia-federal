/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nico
 */
public enum Permiso {
    CONSULTAR_DATOS_PROPIOS("Puede ver solo sus propios datos"),
    CONSULTAR_TODO("Puede ver todos los datos"),
    ADMINISTRAR_TODO("Acceso total al sistema");

    private final String descripcion;

    Permiso(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

