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
    public List<Juez> Juez = new ArrayList<>();
    public List<Vigilante> vigilantes = new ArrayList<>();
    public List<Sucursal> sucursal = new ArrayList<>();

    public Contexto() {
    }

    /// AGREGAR
    public void agregarEntidadBancaria(EntidadBancaria entidad) {
        entidadBancaria.add(entidad);
    }

    public void agregarSucursal(Sucursal sucursales) {
        sucursal.add(sucursales);
    }

    public void agregarVigilante(Vigilante vigilante) {
        vigilantes.add(vigilante);
    }

    /// MOSTRAR
    public void mostrarEntidadesBancarias() {
        for (int i = 0; i < entidadBancaria.size(); i++) {
            System.out.println((i + 1) + "- " + entidadBancaria.get(i));
        }
    }

    public void mostrarSucursal() {
        for (int i = 0; i < sucursal.size(); i++) {
            System.out.println((i + 1) + "- " + sucursal.get(i));
        }
    }

    public void mostrarVigilantes() {
        for (int i = 0; i < vigilantes.size(); i++) {
            System.out.println((i + 1) + "- " + vigilantes.get(i));
        }
    }

    public void mostrarContratos(ArrayList<ContratoSucVig> contratos) {
        System.out.println("-- CONTRATOS --");
        for (ContratoSucVig contrato : contratos) {
            System.out.println(contrato);
        }
    }

    /// VALIDAR
    public boolean validarEntidadBancaria(String nombre) {

        for (int i = 0; i < entidadBancaria.size(); i++) {
            if (entidadBancaria.get(i).getNombre().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
                return true;
            }
        }
        System.out.println("Error - Ingrese un nombre valido");
        return false;
    }

    public boolean validarSucursal(String nombre) {

        for (int i = 0; i < sucursal.size(); i++) {
            if (sucursal.get(i).getNombre().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
                return true;
            }
        }
        System.out.println("Error - Ingrese un nombre valido");
        return false;
    }

    public boolean validarVigilante(String nombre) {

        for (int i = 0; i < vigilantes.size(); i++) {
            if (vigilantes.get(i).getNombre().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
                return true;
            }
        }
        System.out.println("Error - Ingrese un nombre valido");
        return false;
    }

}
