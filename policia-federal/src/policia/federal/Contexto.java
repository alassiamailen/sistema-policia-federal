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
    public List<Juez> juez = new ArrayList<>();
    public List<Vigilante> vigilante = new ArrayList<>();
    public List<Sucursal> sucursal = new ArrayList<>();
    public List<Asaltante> asaltante = new ArrayList<>();

    public Contexto() {
    }

    /// AGREGAR
    public void agregarEntidadBancaria(EntidadBancaria entidad) {
        entidadBancaria.add(entidad);
    }

    public void agregarSucursal(Sucursal s) {
        sucursal.add(s);
    }

    public void agregarVigilante(Vigilante v) {
        vigilante.add(v);
    }

    public void agregarAsaltantes(Asaltante a) {
        asaltante.add(a);
    }

    public void agregarJuez(Juez j) {
        juez.add(j);
    }

    /// MOSTRAR
    public void mostrarEntidadesBancarias() {
        for (int i = 0; i < entidadBancaria.size(); i++) {
            System.out.println((i + 1) + "- " + entidadBancaria.get(i));
        }
    }

    public void mostrarSucursales() {
        for (int i = 0; i < sucursal.size(); i++) {
            System.out.println((i + 1) + "- " + sucursal.get(i));
        }
    }

    public void mostrarJueces() {
        for (Juez cadaUno : juez) {
            System.out.println(cadaUno);
        }
    }

    public void mostrarAsaltantes() {
        for (Asaltante cadaUno : asaltante) {
            System.out.println(cadaUno);
        }
    }

    public void mostrarVigilantes() {
        for (int i = 0; i < vigilante.size(); i++) {
            System.out.println((i + 1) + "- " + vigilante.get(i));
        }
    }

    public void mostrarContratos(ArrayList<ContratoSucVig> contratos) {
        System.out.println("-- CONTRATOS --");
        for (ContratoSucVig contrato : contratos) {
            System.out.println(contrato);
        }
    }

    /// VALIDAR
    public String validarEntidadBancaria(int index) {

        if (index > 0 && index <= entidadBancaria.size()) {
            return entidadBancaria.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valido");
            return null;
        }

    }

    public String validarSucursal(int index) {

        if (index > 0 && index <= sucursal.size()) {
            return sucursal.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valido");
            return null;
        }
    }

    public String validarVigilante(int index) {

        if (index > 0 && index <= vigilante.size()) {
            return vigilante.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valido");
            return null;
        }
    }

    ///OBTENER NOMBRE APARTIR DEL INDEX
    public String obtenerNombreEntidadBancaria(int index) {
        return entidadBancaria.get(index - 1).getNombre();
    }

    public String obtenerNombreSucursal(int index) {
        return sucursal.get(index - 1).getNombre();
    }

    public String obtenerNombreVigilante(int index) {
        return vigilante.get(index - 1).getNombre();
    }

    // GETTERS 

    public List<EntidadBancaria> getEntidadBancaria() {
        return entidadBancaria;
    }

    public List<Juez> getJuez() {
        return juez;
    }

    public List<Vigilante> getVigilante() {
        return vigilante;
    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    public List<Asaltante> getAsaltante() {
        return asaltante;
    }
}
