package policia.federal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa la pantalla para crear usuarios en el sistema. Permite
 * crear usuarios con roles predefinidos (Investigador, Vigilante,
 * Administrador) o crear un nuevo rol personalizado con permisos seleccionados.
 *
 * Contiene un menú interactivo para que el usuario elija qué tipo de usuario
 * crear.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class PantallaDeCrearUsuario {

    private Contexto contexto;
    Tools t = new Tools();

    /**
     * Constructor que recibe el contexto general del sistema.
     *
     * @param contexto Contexto que contiene listas y datos generales del
     * sistema
     */
    public PantallaDeCrearUsuario(Contexto contexto) {
        this.contexto = contexto;
    }

    /**
     * Método principal que muestra el menú de creación de usuarios y procesa la
     * selección del usuario.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int seleccion;

        boolean seguir = true;
        while (seguir) {
            mostrarMenuEditar(); // Muestra las opciones cada vez
            System.out.print("\nSeleccione una opcion >>> ");

            if (sc.hasNextInt()) {
                seleccion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (seleccion) {
                    case 1 ->
                        crearInvestigador();
                    case 2 ->
                        crearVigilante();
                    case 3 ->
                        crearAdministrador();
                    case 4 ->
                        crearRol();

                    case 0 ->
                        seguir = false; // salir del menu editable
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
     * Muestra las opciones disponibles en el menú de creación de usuarios.
     */
    private void mostrarMenuEditar() {
        System.out.println("=== Menu de Crear Usuarios ===");
        System.out.println("Elije el rol");
        System.out.println("1. Investigador");
        System.out.println("2. Vigilante");
        System.out.println("3. Administrador");
        System.out.println("4. Crear Rol");
        System.out.println("0. Volver al menu principal");
    }

    /**
     * Crea un usuario con rol Investigador y permisos predefinidos. Solicita
     * usuario y contraseña.
     */
    private void crearInvestigador() {
        Rol investigador = new Rol("Investigador");
        investigador.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        investigador.agregarPermiso(Permiso.CERRAR_SESION);
        investigador.agregarPermiso(Permiso.SALIR);
        String user = t.leerString("Ingresar Usuario");
        String clave = t.leerString("Ingresar Clave");
        Authenticacion.getInstance().registrarUsuario(new Usuario(user, clave, investigador));
        System.out.println("Usuario creado exitosamente");
    }

    /**
     * Crea un usuario con rol Vigilante y permisos predefinidos. Solicita datos
     * de usuario, contraseña, nombre completo, código y edad. Crea el vigilante
     * y lo vincula con el usuario.
     */
    private void crearVigilante() {
        Rol vigilante = new Rol("Vigilante");
        vigilante.agregarPermiso(Permiso.CONSULTAR_MIS_DATOS_VIGILANTE);
        vigilante.agregarPermiso(Permiso.CERRAR_SESION);
        vigilante.agregarPermiso(Permiso.SALIR);
        String user = t.leerString("Ingresar Usuario");
        String clave = t.leerString("Ingresar Clave");
        String NomApe = t.leerString("Ingresar Nombre Completo");        
        int edad = t.leerEntero("Ingresar edad");

        //Cargo vigilantes y linkeo con usuarios y cargo al contexto
        Authenticacion auth = Authenticacion.getInstance();
        RegistroVigilantes nuevoVigi = new RegistroVigilantes(auth, contexto, vigilante);
        nuevoVigi.crearVigilanteConUsuario(NomApe, edad, user, clave);
        System.out.println("Usuario creado exitosamente");
    }

    /**
     * Crea un usuario con rol Administrador y permisos predefinidos. Solicita
     * usuario y contraseña.
     */
    private void crearAdministrador() {
        Rol admin = new Rol("Administrador");
        admin.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        admin.agregarPermiso(Permiso.CONTRATAR_VIGILANTE);
        admin.agregarPermiso(Permiso.CREAR_USUARIOS);
        admin.agregarPermiso(Permiso.EDITAR_DATOS);
        admin.agregarPermiso(Permiso.ELIMINAR_DATOS);
        admin.agregarPermiso(Permiso.CERRAR_SESION);
        admin.agregarPermiso(Permiso.SALIR);
        String user = t.leerString("Ingresar Usuario");
        String clave = t.leerString("Ingresar Clave");
        Authenticacion.getInstance().registrarUsuario(new Usuario(user, clave, admin));
        System.out.println("Usuario creado exitosamente");
    }

    /**
     * Permite crear un nuevo rol personalizado, seleccionando permisos
     * disponibles. Luego crea un usuario con ese rol nuevo solicitando usuario
     * y contraseña.
     */
    private void crearRol() {
        System.out.println("=== Crear Nuevo Rol ===");
        String nombreDeRol = t.leerString("Ingrese el nombre del rol a crear");
        Rol nuevoRol = new Rol(nombreDeRol);

        List<Permiso> permisosDisponibles = new ArrayList<>(List.of(Permiso.values()));
        permisosDisponibles.remove(Permiso.CERRAR_SESION);
        permisosDisponibles.remove(Permiso.SALIR);
        while (true) {
            System.out.println("\nSeleccione un permiso para agregar al rol '" + nombreDeRol + "':");
            for (int i = 0; i < permisosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + permisosDisponibles.get(i));
            }
            System.out.println((permisosDisponibles.size() + 1) + ". Finalizar");

            int opcion = t.leerEntero("Opcion");

            if (opcion == permisosDisponibles.size() + 1) {
                break;
            } else if (opcion >= 1 && opcion <= permisosDisponibles.size()) {
                Permiso permisoSeleccionado = permisosDisponibles.get(opcion - 1);
                nuevoRol.agregarPermiso(permisoSeleccionado);
                nuevoRol.agregarPermiso(Permiso.CERRAR_SESION);
                nuevoRol.agregarPermiso(Permiso.SALIR);
                permisosDisponibles.remove(permisoSeleccionado);
                System.out.println("Permiso agregado: " + permisoSeleccionado);
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        System.out.println("\nRol '" + nombreDeRol + "' creado con los siguientes permisos:");
        for (Permiso p : nuevoRol.getPermisos()) {
            System.out.println("- " + p);
        }

        System.out.println("=== Crear Usuario ===");
        String user = t.leerString("Ingresar Usuario");
        String clave = t.leerString("Ingresar Clave");
        Authenticacion.getInstance().registrarUsuario(new Usuario(user, clave, nuevoRol));
        System.out.println("Usuario con rol nuevo creado exitosamente");
    }

}
