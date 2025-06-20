/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class Sistema {

    private boolean enEjecucion = true;

    Tools tools = new Tools();

    public void iniciar() {
        while (enEjecucion) {
            mostrarLogin();
        }
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
                loginAdministrador();
                break;
            case 2:
                loginInvestigador();
                break;
            case 3:
                loginVigilante();
                break;
            case 0:
                enEjecucion = false;
                System.out.println("Sistema cerrado.");
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private void loginAdministrador() {
        System.out.println("Iniciando sesion como Administrador...");
        // Aqui iria la logica de autenticacion y menu de administrador
    }

    private void loginInvestigador() {
        System.out.println("Iniciando sesion como Investigador...");
        // Aqui iria la logica de autenticacion y menu de investigador
    }

    private void loginVigilante() {
        System.out.println("Iniciando sesion como Vigilante...");
        // Aqui iria la logica de autenticacion y menu de vigilante
    }

}
