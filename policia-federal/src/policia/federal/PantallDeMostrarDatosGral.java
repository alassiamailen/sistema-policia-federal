/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Nico
 */
class PantallDeMostrarDatosGral {

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
                tools.limpiarConsola();

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
                tools.limpiarConsola();
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
        System.out.println("\n\n=== Seleccione que desea consultar ===\n");

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

    private void consultarJuez() {
        new ConsultorEntidad<>(contexto, tools, contexto.getJuez(), "*** Listado de jueces ***").consultar();
    }

    private void consultarCondena() {
        new ConsultorEntidad<>(contexto, tools, contexto.getCondenas(), "*** Listado de condenas ***").consultar();
    }

    private void consultarAsaltante() {
        new ConsultorEntidad<>(contexto, tools, contexto.getAsaltante(), "*** Listado de detenidos ***").consultar();
    }

    private void consultarDelito() {
        new ConsultorEntidad<>(contexto, tools, contexto.getAsaltos(), "*** Listado de delitos ***").consultar();
    }

    private void consultarCasos() {
        new ConsultorEntidad<>(contexto, tools, contexto.getCasos(), "*** Listado de casos ***").consultar();
    }

    private void consultarVigilante() {
        new ConsultorEntidad<>(contexto, tools, contexto.getVigilante(), "*** Listado de vigilantes ***").consultar();
    }

    private void consultarContratos() {
        new ConsultorEntidad<>(contexto, tools, contexto.getVigilante(), "*** Listado de contratos ***").consultar();
    }

    private void consultarEntidadBancaria() {
//        new ConsultorEntidad<>(contexto, tools, contexto.getEntidadBancaria(), "*** Listado de entidades bancarias ***").consultar();
    }

    private void consultarSucursal() {
        new ConsultorEntidad<>(contexto, tools, contexto.getSucursal(), "*** Listado de sucursales ***").consultar();
    }

    private void consultarUsuarios() {
        List<Usuario> usuarios = Authenticacion.getInstance().getUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }

        System.out.println("*** Usuarios del sistema ***\n");

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            System.out.println("-" + u.getNombreUsuario() + " - Rol: " + u.getRol().getNombre());
        }

        tools.leerEntero("\nPresione 0 para volver al menu anterior.");
    }

    private void consultarRoles() {
        List<Usuario> usuarios = Authenticacion.getInstance().getUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados, por lo tanto no hay roles asignados.");
            return;
        }

        Set<Rol> rolesUnicos = new LinkedHashSet<>();

        for (Usuario u : usuarios) {
            rolesUnicos.add(u.getRol()); // evita duplicados
        }

        System.out.println("*** Roles en el sistema ***\n");

        int i = 1;
        for (Rol rol : rolesUnicos) {
            System.out.println(i + ". " + rol.getNombre());
            System.out.println("Permisos:");
            for (Permiso p : rol.getPermisos()) {
                System.out.println("  - " + p);
            }
            System.out.println();
            i++;
        }

        tools.leerEntero("Presione 0 para volver al menu anterior.");
    }

    private void consultarPermisos() {
        List<Permiso> permisosDisponibles = new ArrayList<>(List.of(Permiso.values()));
        permisosDisponibles.remove(Permiso.CERRAR_SESION);
        permisosDisponibles.remove(Permiso.SALIR);
        for (int i = 0; i < permisosDisponibles.size(); i++) {
            System.out.println("-" + permisosDisponibles.get(i));
        }

        tools.leerEntero("Presione 0 para volver al menu anterior.");
    }

}
