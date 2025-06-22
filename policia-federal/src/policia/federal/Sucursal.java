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
    private ArrayList<ContratoSucVig> contrato= new ArrayList<>();
    
    
    

    Tools tools = new Tools();

    public Sucursal(int cantidad_de_empleados) {
        this.cantidad_de_empleados = cantidad_de_empleados;
    }

    public void ingresarDatos() {
        this.cantidad_de_empleados = tools.leerEntero("Ingrese cantidad de empleados: ");
    }
    public void abrirSucursal(){
        
    }
    public void contratarVigilante() {
        String nombre_apellido;
        int codigo, edad;        
        nombre_apellido = tools.leerString("Ingrese nombre y apellido del vigilante: ");
        codigo = tools.leerEntero("Ingrese codigo: ");
        edad = tools.leerEntero("Ingrese edad: ");
        Vigilante nuevo_vigilante = new Vigilante(nombre_apellido, codigo, edad);
        vigilantes_contratados.add(nuevo_vigilante);
    }
}
