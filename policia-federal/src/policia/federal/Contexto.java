/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nico
 */
public class Contexto {
    public List<EntidadBancaria> entidadBancaria = new ArrayList<>();
    public  List<Juez> Juez = new ArrayList<>();
    public  List<Vigilante> Vigilante = new ArrayList<>();
    public  List<Sucursal> Sucursal = new ArrayList<>();

    public Contexto() {
    }

    public void agregarEntidadBancaria(EntidadBancaria entidad){
        entidadBancaria.add(entidad);
    }
    
    public void mostrarEntidadesBancarias(){
        for(EntidadBancaria cadaUna : entidadBancaria){
            System.out.println(cadaUna);
        }
    }
    
    
}


