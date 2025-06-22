package policia.federal;

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
        this.nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
        this.codigo = tools.leerEntero("Ingrese codigo: ");
        this.edad = tools.leerEntero("Ingrese edad: ");

    }
    
    @Override
    public String toString() {
        return nombre_apellido;
    }
    
      public String getNombre() {
        return nombre_apellido;
    }
}