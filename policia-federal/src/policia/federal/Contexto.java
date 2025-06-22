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
    public  List<Juez> juez = new ArrayList<>();
    public  List<Vigilante> vigilante = new ArrayList<>();
    public  List<Sucursal> sucursal = new ArrayList<>();
    public  List<Asaltante> asaltante = new ArrayList<>();


    public Contexto() {
    }

    //ENTIDADES BANCARIAS
    public void agregarEntidadBancaria(EntidadBancaria entidad){
        entidadBancaria.add(entidad);
    }
    
    public void mostrarEntidadesBancarias(){
        for(EntidadBancaria cadaUna : entidadBancaria){
            System.out.println(cadaUna);
        }
    }
    
    // JUECES
    public void agregarJuez(Juez j) {
        juez.add(j);
    }

    public void mostrarJueces() {
        for (Juez cadaUno : juez) {
            System.out.println(cadaUno);
        }
    }

    // VIGILANTES
    public void agregarVigilante(Vigilante v) {
        vigilante.add(v);
    }

    public void mostrarVigilantes() {
        for (Vigilante cadaUno : vigilante) {
            System.out.println(cadaUno);
        }
    }

    // SUCURSALES
    public void agregarSucursal(Sucursal s) {
        sucursal.add(s);
    }

    public void mostrarSucursales() {
        for (Sucursal cadaUna : sucursal) {
            System.out.println(cadaUna);
        }
    }
    
    //ASALTANTES
    public void agregarAsaltantes(Asaltante a){
        asaltante.add(a);
    }
    
    public void mostrarAsaltantes(){
        for(Asaltante cadaUno : asaltante){
            System.out.println(cadaUno);
        }
    }
}


