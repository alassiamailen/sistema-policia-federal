package policia.federal;

/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class UserAdministrador extends Usuario implements PAdministrador{

    public UserAdministrador(String usuario, String password) {
        super(usuario, password);
    }

    
    
    public void loginAdministrador() {
        System.out.println("Iniciando sesion como Administrador...");
        mostrarMenu();
    }
    
    
    
    @Override
    public void mostrarMenu() {
        System.out.println("\n\n===== Sistema de Gestion Policial =====");
        System.out.println("1. Crear Usuarios del sistema");
        System.out.println("2. Menu Vigilantes");
        System.out.println("3. Menu Jueces");
        System.out.println("4. Menu Bancos");
        System.out.println("0. Salir");
        
        int opcion = tools.leerEntero("Seleccione una opcion: ");

    }

    @Override
    public void administrarTodo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void consultarTodo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void consultarDatosPropios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}