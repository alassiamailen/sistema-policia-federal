package policia.federal;

import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class PantallDeMostrarDatosGral {

    private Tools tools = new Tools();
    private Contexto contexto;

    public PantallDeMostrarDatosGral(Contexto contexto) {
        this.contexto = contexto;
    }

    /**
     * Muestra un menu de consultas agrupadas por categoria (judicial,
     * seguridad, entidades bancarias y administracion del sistema), y procesa
     * la opcion seleccionada por el usuario. Cada opcion futura llamara a un
     * metodo que implementa la consulta correspondiente. El menu se repite
     * hasta que el usuario decida volver al menu principal.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        boolean seguir = true;

        while (seguir) {
            mostrarMenuOpcionAver(); // Muestra las opciones cada vez
            System.out.print("\nSeleccione una opcion >>> ");

            if (sc.hasNextInt()) {
                seleccion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (seleccion) {
                    case 1 ->
                        consultarJuez();
                    case 2 ->
                        consultarCondena();
                    case 3 ->
                        consultarAsaltante();
                    case 4 ->
                        consultarDelito();
                    case 5 ->
                        consultarCasos();

                    case 6 ->
                        consultarVigilante();
                    case 7 ->
                        consultarContratos();

                    case 8 ->
                        consultarEntidadBancaria();
                    case 9 ->
                        consultarSucursal();

                    case 10 ->
                        consultarUsuarios();
                    case 11 ->
                        consultarRoles();
                    case 12 ->
                        consultarPermisos();

                    case 0 ->
                        seguir = false;

                    default ->
                        System.out.println("Opcion invalida.");
                }
            } else {
                System.out.println("Debe ingresar un numero.");
                sc.nextLine(); // limpiar entrada invalida
            }
        }
    }

    /**
     * Muestra en consola un menu de opciones agrupadas por categorias tematicas
     * para consultar informacion del sistema. Las categorias incluyen:
     *
     * <ul>
     * <li><b>Informacion Judicial</b>: juez, condena, asaltante, delito,
     * casos.</li>
     * <li><b>Seguridad Bancaria</b>: vigilantes y contratos.</li>
     * <li><b>Entidades Financieras</b>: entidad bancaria y sucursal.</li>
     * <li><b>Administracion del Sistema</b>: usuarios, roles y permisos.</li>
     * </ul>
     *
     * El usuario puede elegir una opcion para consultar o ingresar 0 para
     * volver al menu principal.
     */
    private void mostrarMenuOpcionAver() {
        System.out.println("=== Seleccione que desea consultar ===\n");

        System.out.println(">> Informacion Judicial:");
        System.out.println("1. Juez");
        System.out.println("2. Condena");
        System.out.println("3. Asaltante");
        System.out.println("4. Delito");
        System.out.println("5. Casos");

        System.out.println("\n>> Seguridad Bancaria:");
        System.out.println("6. Vigilante");
        System.out.println("7. Contratos");

        System.out.println("\n>> Entidades Financieras:");
        System.out.println("8. Entidad Bancaria");
        System.out.println("9. Sucursal");

        System.out.println("\n>> Administracion del Sistema:");
        System.out.println("10. Usuarios del sistema");
        System.out.println("11. Roles del sistema");
        System.out.println("12. Permisos");

        System.out.println("\n0. Volver al menu principal");
    }

    /**
     * Consulta la informacion de los jueces registrados en el sistema.
     */
    private void consultarJuez() {
        Juez juez;
        
        do {
            int opcion;
            System.out.println("*** Listado de jueces ***");
            contexto.mostrarJueces();
            opcion = tools.leerEntero("Ingrese numero de Juez");
            juez = contexto.validarJuez(opcion);
            System.out.println(juez.toString());
            opcion = tools.leerEntero("Ingrese \"0\" para salir");
        } while (juez == null);
    }

    /**
     * Consulta las condenas asignadas a los asaltantes.
     */
    private void consultarCondena() {
        Condena condena;
        
        do {
            int opcion;
            System.out.println("*** Listado de condenas ***");
            contexto.mostrarCondenas();
            opcion = tools.leerEntero("Ingrese numero de condena");
            condena = contexto.validarCondena(opcion);
            System.out.println(condena.toString());
            opcion = tools.leerEntero("Ingrese \"0\" para salir");
        } while (condena == null);
    }

    /**
     * Consulta los asaltantes registrados, con sus vinculos a casos o bandas.
     */
    private void consultarAsaltante() {
        // TODO: Implementar logica para mostrar asaltantes
    }

    /**
     * Consulta la informacion relacionada a los delitos (asaltos).
     */
    private void consultarDelito() {
        // TODO: Implementar logica para mostrar delitos o asaltos
    }

    /**
     * Consulta los casos judiciales en el sistema.
     */
    private void consultarCasos() {
        // TODO: Implementar logica para mostrar casos
    }

    /**
     * Consulta los vigilantes registrados, con sus contratos y datos
     * personales.
     */
    private void consultarVigilante() {
        // TODO: Implementar logica para mostrar vigilantes
    }

    /**
     * Consulta los contratos de vigilancia activos o finalizados.
     */
    private void consultarContratos() {
        // TODO: Implementar logica para mostrar contratos
    }

    /**
     * Consulta las entidades bancarias registradas.
     */
    private void consultarEntidadBancaria() {
        // TODO: Implementar logica para mostrar entidades bancarias
    }

    /**
     * Consulta las sucursales pertenecientes a las entidades bancarias.
     */
    private void consultarSucursal() {
        // TODO: Implementar logica para mostrar sucursales
    }

    /**
     * Consulta los usuarios del sistema, sean administrativos, investigadores o
     * vigilantes.
     */
    private void consultarUsuarios() {
        // TODO: Implementar logica para mostrar usuarios del sistema
    }

    /**
     * Consulta los roles disponibles en el sistema (ej: Administrador,
     * Investigador, Vigilante).
     */
    private void consultarRoles() {
        // TODO: Implementar logica para mostrar roles
    }

    /**
     * Consulta los permisos definidos en el sistema y su descripcion.
     */
    private void consultarPermisos() {
        // TODO: Implementar logica para mostrar permisos
    }

}
