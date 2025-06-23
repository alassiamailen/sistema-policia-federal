/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.ArrayList;

/**
 *
 * @author Alassia
 */
public class Sucursal {

    private int cantidad_de_empleados;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Vigilante> vigilantes_contratados = new ArrayList<>();
    private ArrayList<Asaltante> asaltantes = new ArrayList<>();
    private ArrayList<ContratoSucVig> contrato = new ArrayList<>();
    private String nombre;   
    

    Tools tools = new Tools();

    public Sucursal(int cantidad_de_empleados, String nombre) {
        this.cantidad_de_empleados = cantidad_de_empleados;
        this.nombre=nombre;
    }

    public void ingresarDatos() {
        this.cantidad_de_empleados = tools.leerEntero("Ingrese cantidad de empleados: ");
    }
    public void abrirSucursal(){
        
    }
    public void contratarVigilante() {
        String nombre;
        int codigo, edad;        
        nombre = tools.leerString("Ingrese nombre de Sucursal: ");
        
    }
     @Override
    public String toString() {
        return nombre;
    }
     public String getNombre() {
        return nombre;
    }

    public ArrayList<ContratoSucVig> getContrato() {
        return contrato;
    }
     
     
}
