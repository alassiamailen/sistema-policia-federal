
import policia.federal.Tools;

public class Vigilante {

    private String nombre_apellido;
    private int codigo;
    private int edad;

    Tools tools = new Tools();

    public Vigilante(String nombre_apellido, int codigo, int edad) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.edad = edad;
    }

    public void ingresarDatos() {
        String nombre_apellido, aux_codigo, aux_edad;
        int codigo, edad;
        nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        codigo = tools.leerEntero("Ingrese codigo: ");
        edad = tools.leerEntero("Ingrese edad: ");

    }
}