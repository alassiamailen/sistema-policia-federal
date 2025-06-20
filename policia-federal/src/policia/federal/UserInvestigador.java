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

    
    public void loginInvestigador() {
        System.out.println("Iniciando sesion como Investigador...");
        // Aqui iria la logica de autenticacion y menu de investigador
    }

}
