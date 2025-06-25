package policia.federal;

import java.util.ArrayList;

public class Vigilante {

    private String nombre_apellido;
    private int codigo;
    private int edad;
    private int contadorContratos = 0;
    private ArrayList<ContratoSucVig> contratos = new ArrayList<>();

    Tools tools = new Tools();

    /////////////BORRAR ESTO/////////////     
     Contexto contexto = new Contexto();

    public Vigilante(String nombre_apellido, int codigo, int edad) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.edad = edad;
    }

    public void ingresarDatos() {
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo: ");
        this.edad = tools.leerEntero("Ingrese edad: ");

    }
    /// Agregar un [ContratoSucVig] al ArrayList [contratos]
    public void agregarContrato(ContratoSucVig contrato) {
        // Le asigno un codigo unico al contrato antes de guardarlo en el array
        contrato.setCodigo(contadorContratos);
        contratos.add(contrato);
        contadorContratos++;

       /////////////BORRAR ESTO/////////////
        contexto.mostrarContratos(contratos);

    }

    @Override
    public String toString() {
        String presentacion = "";
        presentacion += "Nombre: " + nombre_apellido + "\n";
        presentacion += "Edad: " + edad + "\n";
        presentacion += "Codigo: " + codigo + "\n";
        presentacion += "\n-----------------------\n";

        return presentacion;
    }

    public int getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
