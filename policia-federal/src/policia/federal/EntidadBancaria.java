package policia.federal;

/**
 *
 * @author Alassia
 */
public class EntidadBancaria {
    private int codigo;
    private String domicilio;
   
    
    Tools tools = new Tools();

    public EntidadBancaria(int codigo, String domicilio) {
        this.codigo = codigo;
        this.domicilio = domicilio;
    }
    
    public void EntidadBancaria(){
        ingresarDatos();
    }
    
    public void ingresarDatos(){
        int codigo;
        String domicilio;
        codigo= tools.leerEntero("Ingrese codigo de Entidad Bancaria: ");
        domicilio= tools.leerString("Ingrese el domicilio: ");        
    }
}
