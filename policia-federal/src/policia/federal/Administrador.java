package policia.federal;

/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class Administrador extends Usuario implements PAdministrador{

    public Administrador(String usuario, String password) {
        super(usuario, password);
    }
    
    
    @Override
    public void mostrarMenu() {

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
