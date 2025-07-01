/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package policia.federal;

/**
 * Interfaz que define un contrato para obtener el nombre de una entidad.
 * 
 * Las clases que implementen esta interfaz deben proporcionar una implementación
 * del método {@code getNombre}, que devuelve una representación en texto
 * del nombre de la entidad.
 * 
 * Esta interfaz se utiliza comúnmente para mostrar nombres en listados,
 * menús o procesos de selección.
 * 
 * @author Alassia
 */
public interface Nombre {
     /**
     * Devuelve el nombre de la entidad.
     *
     * @return Una cadena que representa el nombre.
     */
    String getNombre();
}
