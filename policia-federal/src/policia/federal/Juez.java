package policia.federal;
/**
 *
 * @author Alassia
 */
public class Juez {
    private String nombre_apellido;
    private int codigo;
    private int anios_de_servicio;

    Tools tools = new Tools();
     
    public Juez(String nombre_apellido, int codigo, int anios_de_servicio) {
        this.nombre_apellido = nombre_apellido;
        this.codigo = codigo;
        this.anios_de_servicio = anios_de_servicio;
    }    
    
    public Juez(){
        ingresarDatos();
    }
     public void ingresarDatos(){       
        this.nombre_apellido= tools.leerString("Ingrese nombre y apellido: "); 
        this.codigo= tools.leerEntero("Ingrese codigo de Juez: ");    
        this.anios_de_servicio=tools.leerEntero("Ingrese anios de servicio: ");
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnios_de_servicio() {
        return anios_de_servicio;
    }

    public void setAnios_de_servicio(int anios_de_servicio) {
        this.anios_de_servicio = anios_de_servicio;
    }

    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }
    
     
     
}
