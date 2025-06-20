package policia.federal;

import java.util.ArrayList;

/**
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Sistema {

    //private boolean enEjecucion = true;
    private ArrayList<UserAdministrador> administradores = new ArrayList<>();
    private ArrayList<UserInvestigador> investigadores = new ArrayList<>();
    private ArrayList<UserVigilante> vigilantes = new ArrayList<>();
    private String user;
    private String clave;
    private boolean autenticado = false;

    Tools tools = new Tools();

    public Sistema() {
        // Inicializar algunos usuarios
        administradores.add(new UserAdministrador("admin", "1234"));
        administradores.add(new UserAdministrador("admin", "123"));
        administradores.add(new UserAdministrador("admin", "567"));
        administradores.add(new UserAdministrador("admin", "911"));

        investigadores.add(new UserInvestigador("invest", "12345"));
        vigilantes.add(new UserVigilante("vigi", "123456"));
    }

    public void iniciar() {
        mostrarLogin();
    }

    private void mostrarLogin() {
        System.out.println("===== Sistema de Gestion Policial =====");
        System.out.println("1. Iniciar sesion como Administrador");
        System.out.println("2. Iniciar sesion como Investigador");
        System.out.println("3. Iniciar sesion como Vigilante");
        System.out.println("0. Salir");

        int opcion = tools.leerEntero("Seleccione una opcion: ");

        switch (opcion) {
            case 1:
                ingresoUserPass();
                for (UserAdministrador admin : administradores) {
                    if (admin.getUsuario().equals(user) && admin.getPassword().equals(clave)) {
                        System.out.println("Autenticación exitosa.");
                        admin.loginAdministrador();
                        autenticado = true;
                        break;
                    }
                }
                if (!autenticado) {
                    System.out.println("Usuario o clave incorrectos.");
                }
                break;
            case 2:
                ingresoUserPass();
               for (UserInvestigador invest : investigadores) {
                    if (invest.getUsuario().equals(user) && invest.getPassword().equals(clave)) {
                        System.out.println("Autenticación exitosa.");
                        invest.loginInvestigador();
                        autenticado = true;
                        break;
                    }
                }
                if (!autenticado) {
                    System.out.println("Usuario o clave incorrectos.");
                }
                break;
            case 3:
                ingresoUserPass();
               for (UserVigilante vigi : vigilantes) {
                    if (vigi.getUsuario().equals(user) && vigi.getPassword().equals(clave)) {
                        System.out.println("Autenticación exitosa.");
                        vigi.loginVigilante();
                        autenticado = true;
                        break;
                    }
                }
                if (!autenticado) {
                    System.out.println("Usuario o clave incorrectos.");
                }
                break;
            case 0:
                //enEjecucion = false;
                System.out.println("Sistema cerrado.");
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private void ingresoUserPass() {
        this.user = tools.leerString("Usuario:");
        this.clave = tools.leerString("Clave:");
    }

}
