package policia.federal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase encargada de mostrar y gestionar el menú principal del sistema de
 * gestión policial. Las opciones disponibles dependen de los permisos del
 * usuario autenticado.
 *
 * Cada permiso está vinculado a una acción concreta que puede ejecutar el
 * usuario.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Menu {

    /**
     * Interfaz para definir acciones externas que puede realizar el menú como
     * abrir pantallas o cerrar sesión.
     */
    public interface OnMenuItemSelectedListener {

        /**
         * Ejecuta el cierre de sesión del usuario actual.
         */
        void cerrarSesion();

        /**
         * Abre la pantalla para consultar datos de otras entidades.
         */
        void abrirPantallaConsultaDeDatos();
    }

    private Map<Permiso, Accion> acciones = new HashMap<>();
    private Contexto contexto;
    private ArrayList<ContratoSucVig> contratos = new ArrayList<>();
    private OnMenuItemSelectedListener menuItemListener;

    /**
     * Constructor del menú.
     *
     * @param contexto El contexto actual del sistema, donde se almacenan los
     * datos centrales.
     * @param menuItemListener Listener que permite ejecutar acciones externas
     * como abrir pantallas o cerrar sesión.
     */
    public Menu(Contexto contexto, OnMenuItemSelectedListener menuItemListener) {
        this.contexto = contexto;
        this.menuItemListener = menuItemListener;
        inicializarAcciones();
    }

    /**
     * Asocia a cada permiso una acción correspondiente dentro del sistema.
     */
    private void inicializarAcciones() {
        acciones.put(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES, this::deConsultarDatos);
        acciones.put(Permiso.CONTRATAR_VIGILANTE, this::deContratarVigilante);
        acciones.put(Permiso.CARGAR_DETENIDO, this::cargarDetenido);
        acciones.put(Permiso.ABRIR_CASO, this::abrirCaso);
        acciones.put(Permiso.CONSULTAR_MIS_DATOS_VIGILANTE, this::deConsultarMisDatos);
        acciones.put(Permiso.EDITAR_DATOS, this::deEditarDatos);
        acciones.put(Permiso.CREAR_USUARIOS, this::deCrearUsuarios);
        acciones.put(Permiso.CREAR_ENTIDAD, this::crearEntidad);
        acciones.put(Permiso.ELIMINAR_DATOS, this::deEliminarUsuarios);
        acciones.put(Permiso.CERRAR_SESION, this::deCerrarSesion);
        acciones.put(Permiso.SALIR, this::deSalir);
    }

    /**
     * Muestra el menú principal del sistema basado en los permisos del usuario
     * actual. Permite ejecutar acciones hasta que el usuario decida salir o
     * cerrar sesión.
     */
    public void mostrar() {
        Usuario usuario = Authenticacion.getInstance().getUsuarioActual();
        System.out.println("Usuario " + usuario.getNombreUsuario() + ":");
        ArrayList<Permiso> permisos = new ArrayList<>(usuario.getRol().getPermisos());
        Tools tools = new Tools();
        Scanner sc = new Scanner(System.in);

        boolean seguir = true;

        do {
            int i = 1;
            Map<Integer, Permiso> opciones = new HashMap<>();
            System.out.println("\n .::Menu principal::.");
            for (Permiso permiso : permisos) {
                System.out.println(i + " - " + permiso.toString());
                opciones.put(i, permiso);
                i++;
            }
            System.out.print("\nSeleccione una opcion >>> ");
            int eleccion = sc.nextInt();
            Permiso seleccionado = opciones.get(eleccion);
            tools.limpiarConsola();
            System.out.println("\n");
            if (seleccionado != null && acciones.containsKey(seleccionado)) {
                acciones.get(seleccionado).ejecutar();
                if (seleccionado == Permiso.SALIR || seleccionado == Permiso.CERRAR_SESION) {
                    seguir = false;
                }
            } else {
                System.out.println("Opcion no valida.");
            }
        } while (seguir);

    }

    /**
     * Muestra los datos del vigilante asociado al usuario actual.
     */
    private void deConsultarMisDatos() {
        Vigilante v = Authenticacion.getInstance().getUsuarioActual().getVigilante();
        if (v != null) {
            System.out.println("\n------Datos del vigilante asociado al usuario:------\n");
            System.out.println(v);
        } else {
            System.out.println("***Este usuario no tiene vigilante asociado.***");
        }

    }

    /**
     * Acción pendiente de implementación para consultar datos del sistema.
     */
    private void deConsultarDatos() {
        PantallDeMostrarDatosGral p = new PantallDeMostrarDatosGral(contexto);
        p.menu();
    }

    /**
     * Muestra el menú de creación de usuarios.
     */
    private void deCrearUsuarios() {
        PantallaDeCrearUsuario p = new PantallaDeCrearUsuario(contexto);
        p.menu();
    }

    /**
     * Muestra el menú para editar datos del sistema.
     */
    private void deEditarDatos() {
        PantallaDeEditarDatos p = new PantallaDeEditarDatos(contexto);
        p.mostrarMenuEditables();

    }

    /**
     * Acción pendiente de implementación para eliminar usuarios del sistema.
     */
    private void deEliminarUsuarios() {
        System.out.println("Entrando al panel de eliminacion...");
    }

    /**
     * Ejecuta la acción de contratación de un nuevo vigilante.
     */
    private void deContratarVigilante() {
        PantallaDeContratarVigilante accion_de_contrato = new PantallaDeContratarVigilante();
        accion_de_contrato.contratarVigilante(contexto);
    }

    /**
     * Carga un detenido en el sistema.
     */
    private void cargarDetenido() {
        PantallaDeCargarDetenido accion_de_cargar_detenido = new PantallaDeCargarDetenido();
        accion_de_cargar_detenido.cargarDetenido(contexto);
    }

    /**
     * Ejecuta la acción de abrir un nuevo caso en el sistema.
     */
    private void abrirCaso() {
        PantallaDeAbrirCaso accion_de_abrir_un_caso = new PantallaDeAbrirCaso();
        accion_de_abrir_un_caso.abrirCaso(contexto);
    }

    /**
     * Muestra el menú para crear nuevas entidades en el sistema.
     */
    private void crearEntidad() {
        PantallaDeCrearEntidad accion_de_crear_entidad = new PantallaDeCrearEntidad(contexto);
        accion_de_crear_entidad.menuCrearEntidad();
    }

    /**
     * Ejecuta el cierre de sesión utilizando el listener del menú.
     */
    private void deCerrarSesion() {
        menuItemListener.cerrarSesion();
    }

    /**
     * Muestra un mensaje de salida del sistema.
     */
    private void deSalir() {
        String mensaje = "===== Saliendo del Sistema de Gestion Policial =====";
        System.out.println(mensaje);
    }

}
