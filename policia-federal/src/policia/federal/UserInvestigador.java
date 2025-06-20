package policia.federal;

/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class UserInvestigador extends Usuario {
    
    public UserInvestigador(String usuario, String password) {
        super(usuario, password);
    }       

    public void mostrarMenu() {
        System.out.println("Menú de Investigador");
    }

}
