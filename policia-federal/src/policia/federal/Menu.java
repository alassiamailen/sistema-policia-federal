package policia.federal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class Menu {

    public interface OnMenuItemSelectedListener {

        void cerrarSesion();

        void abrirPantallaConsultaDeDatos();
    }

    private Map<Permiso, Accion> acciones = new HashMap<>();
    private Contexto contexto;
    private ArrayList<ContratoSucVig> contratos = new ArrayList<>();

    private Tools tools = new Tools();

    private OnMenuItemSelectedListener menuItemListener;

    public Menu(Contexto contexto, OnMenuItemSelectedListener menuItemListener) {
        this.contexto = contexto;
        this.menuItemListener = menuItemListener;
        inicializarAcciones();
    }

    // Le adjudico un metodo a cada permiso
    private void inicializarAcciones() {
        acciones.put(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES, this::deConsultarDatos);
        acciones.put(Permiso.CONTRATAR_VIGILANTE, this::deContratarVigilante);
        acciones.put(Permiso.CARGAR_DETENIDO, this::cargarDetenido);     
        acciones.put(Permiso.ABRIR_CASO, this::abrirCaso);
        acciones.put(Permiso.CONSULTAR_MIS_DATOS_VIGILANTE, this::deConsultarMisDatos);
        acciones.put(Permiso.EDITAR_DATOS, this::deEditarDatos);
        acciones.put(Permiso.CREAR_USUARIOS, this::deCrearUsuarios);
        acciones.put(Permiso.ELIMINAR_DATOS, this::deEliminarUsuarios);
        acciones.put(Permiso.CERRAR_SESION, this::deCerrarSesion);
        acciones.put(Permiso.SALIR, this::deSalir);
    }

    // MENU PRINCIPAL
    public void mostrar() {
        Usuario usuario = Authenticacion.getInstance().getUsuarioActual();
        System.out.println("Usuario " + usuario.getNombreUsuario() + ":");
        ArrayList<Permiso> permisos = new ArrayList<>(usuario.getRol().getPermisos());

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

        //Listo
    }

    private void deConsultarMisDatos() {
        Vigilante v = Authenticacion.getInstance().getUsuarioActual().getVigilante();
        if (v != null) {
            System.out.println("\n------Datos del vigilante asociado al usuario:------\n");
            System.out.println(v);
        } else {
            System.out.println("***Este usuario no tiene vigilante asociado.***");
        }

    }

    //Falta
    private void deConsultarDatos() {
        // menuItemListener.abrirPantallaConsultaDeDatos()
        System.out.println("Mostrando todos los registros del sistema...");
    }

    //Listo
    private void deCrearUsuarios() {
        PantallaDeCrearUsuario p = new PantallaDeCrearUsuario(contexto);
        p.menu();
    }

    //Listo
    private void deEditarDatos() {
        PantallaDeEditarDatos p = new PantallaDeEditarDatos(contexto);
        p.mostrarMenuEditables();

    }

    //Falta
    private void deEliminarUsuarios() {
        System.out.println("Entrando al panel de eliminacion...");
    }

    //Mai laburando en esto
    private void deContratarVigilante() {
        PantallaDeContratarVigilante accion_de_contrato = new PantallaDeContratarVigilante();
        accion_de_contrato.contratarVigilante(contexto);
    }

    private void cargarDetenido() {
        PantallaDeCargarDetenido accion_de_cargar_detenido = new PantallaDeCargarDetenido();
        accion_de_cargar_detenido.cargarDetenido(contexto);
    }    
    private void abrirCaso(){
        PantallaDeAbrirCaso accion_de_abrir_un_caso= new PantallaDeAbrirCaso();
        accion_de_abrir_un_caso.abrirCaso(contexto);
    }

    //Listo
    private void deCerrarSesion() {
        menuItemListener.cerrarSesion();
    }

    //Listo
    private void deSalir() {
        String mensaje = "===== Saliendo del Sistema de Gestion Policial =====";
        System.out.println(mensaje);
    }

}
