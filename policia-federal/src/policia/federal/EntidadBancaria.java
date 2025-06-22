
package policia.federal;
/**
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class EntidadBancaria {
    private int codigo;
    private String domicilio;
    private String nombre;   
    
    
    
    Tools tools = new Tools();

    public EntidadBancaria(String nombre, int codigo, String domicilio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.domicilio = domicilio;
    }
    
    public void EntidadBancaria(){
        ingresarDatos();
    }
    
    public void ingresarDatos(){        
        this.codigo= tools.leerEntero("Ingrese codigo de Entidad Bancaria: ");
        this.domicilio= tools.leerString("Ingrese el domicilio: ");
        this.nombre= tools.leerString("Ingrese el nombre: ");        
       
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    
}


