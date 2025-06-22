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
    CONSULTAR_MIS_DATOS("Consultar mis datos."),
    CONSULTAR_DATOS_DE_OTRAS_ENTIDADES("Consultar datos."),
    EDITAR_DATOS("Editar datos."),
    CREAR_USUARIOS("Crear usuario."),
    ELIMINAR_DATOS("Eliminar usuarios.");


    private final String descripcion;

    Permiso(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
