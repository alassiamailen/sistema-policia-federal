/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

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
    public List<BandaCriminal> bandaCriminal = new ArrayList<>();

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

    public void agregarBandaCriminal(BandaCriminal b) {
        bandaCriminal.add(b);
    }

    /// MOSTRAR
    public void mostrarEntidadesBancarias() {
        for (int i = 0; i < entidadBancaria.size(); i++) {
            System.out.println((i + 1) + "- " + entidadBancaria.get(i));
        }
    }

    public void mostrarBandasCriminales() {
        for (int i = 0; i < bandaCriminal.size(); i++) {
            System.out.println((i + 1) + "- " + "Numero Identificacion: " + bandaCriminal.get(i).getCodigoIdentificacion());
        }
    }    

    public void mostrarSucursales() {
        for (int i = 0; i < sucursal.size(); i++) {
            System.out.println((i + 1) + "- " + sucursal.get(i).getNombre());

        }
    }

    public void mostrarJueces() {
        for (Juez cadaUno : juez) {
            System.out.println(cadaUno);
        }
    }

    public void mostrarAsaltantes() {
        for (int i = 0; i < asaltante.size(); i++) {
            System.out.println((i + 1) + "- " + asaltante.get(i).toString());
        }
    }

    public void mostrarVigilantes() {
        for (int i = 0; i < vigilante.size(); i++) {
            System.out.println((i + 1) + "- " + vigilante.get(i).getNombre());
        }
    }

    public void mostrarContratos(ArrayList<ContratoSucVig> contratos) {
        System.out.println("-- CONTRATOS --");
        for (ContratoSucVig contrato : contratos) {
            System.out.println(contrato);
        }
    }
    public void mostrarAsaltos(ArrayList<Asalto> asaltos){
        System.out.println("-- ASALTOS --");
        for (Asalto asalto : asaltos) {
            System.out.println(asalto);
        }
    }

    /// VALIDAR
    public String validarEntidadBancaria(int index) {

        if (index > 0 && index <= entidadBancaria.size()) {
            return entidadBancaria.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }

    }
    public String validarAsaltante(int index){
        if (index > 0 && index <= asaltante.size()) {
            return asaltante.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        } 
    }

    public String validarSucursal(int index) {

        if (index > 0 && index <= sucursal.size()) {
            return sucursal.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }

    public String validarVigilante(int index) {

        if (index > 0 && index <= vigilante.size()) {
            return vigilante.get(index - 1).getNombre();
        } else {
            System.out.println("Error - Ingrese una opcion valida");
            return null;
        }
    }   

    ///OBTENER DATOS APARTIR DEL INDEX
    public String obtenerNombreEntidadBancaria(int index) {
        return entidadBancaria.get(index - 1).getNombre();
    }

    public String obtenerNombreSucursal(int index) {
        return sucursal.get(index - 1).getNombre();
    }

    public String obtenerNombreVigilante(int index) {
        return vigilante.get(index - 1).getNombre();
    }
    public Asaltante obtenerDetenido(int index){       
       return asaltante.get(index-1);
    }
    public BandaCriminal obtenerBandaCriminal(int index){
        return asaltante.get(index-1).obtenerBandaCriminal();
    }
    public Sucursal obtenerSucursal(int index){
        return sucursal.get(index - 1);
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

    /// VINCULAR ENTIDADES
    // Asignar a [Vigilante] un [Contrato] con una [Sucursal] determinada
    public void asignarContratoAVigilante(String nombre_vigilante, ContratoSucVig contrato) {
        for (int i = 0; i < vigilante.size(); i++) {
            if (nombre_vigilante.equals(vigilante.get(i).getNombre())) {
                vigilante.get(i).agregarContrato(contrato);
                break;
            }
        }

    }
    // Asignar un [Asalto] a un [Asaltante] determinado
    public void asignarAsaltoADetenido(int index, Asalto nuevo_asalto){
        asaltante.get(index-1).agregarAsalto(nuevo_asalto);
    }
    
}
