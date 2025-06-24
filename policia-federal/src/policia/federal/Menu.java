//package policia.federal;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// *
// * @author Nico
// */
//public class Menu {
//
//    private Usuario usuario;
//    private Map<Permiso, Accion> acciones = new HashMap<>();
//    private Contexto contexto;
//    private ArrayList<ContratoSucVig> contratos = new ArrayList<>();
//    private Sistema sistema;
//
//    public Menu(Usuario usuario, Contexto contexto, Sistema sistema) {
//        this.sistema = sistema;
//        this.contexto = contexto;
//        this.usuario = usuario;
//        inicializarAcciones();
//    }
//    Tools tools = new Tools();
//
//    private void inicializarAcciones() {
//        acciones.put(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES, this::deConsultarDatos);
//        acciones.put(Permiso.CONTRATAR_VIGILANTE, this::deContratarVigilante);
//        acciones.put(Permiso.CONSULTAR_MIS_DATOS, this::deConsultarMisDatos);
//        acciones.put(Permiso.EDITAR_DATOS, this::deCrearDatos);
//        acciones.put(Permiso.CREAR_USUARIOS, this::deEditarDatos);
//        acciones.put(Permiso.ELIMINAR_DATOS, this::deEliminarUsuarios);
//        acciones.put(Permiso.CERRAR_SESION, this::deCerrarSesion);
//        acciones.put(Permiso.SALIR, this::deSalir);
//    }
//
//    public void deInicio() {
//        System.out.println("Usuario " + usuario.getNombreUsuario() + ":");
//        ArrayList<Permiso> permisos = new ArrayList<>(usuario.getRol().getPermisos());
//        Scanner sc = new Scanner(System.in);
//
//        do {
//            int i = 1;
//            Map<Integer, Permiso> opciones = new HashMap<>();
//            for (Permiso permiso : permisos) {
//                System.out.println(i + " - " + permiso.toString());
//                opciones.put(i, permiso);
//                i++;
//            }
//            System.out.print("\nSeleccione una opcion >>> ");
//            int eleccion = sc.nextInt();
//            Permiso seleccionado = opciones.get(eleccion);
//
//            if (seleccionado != null && acciones.containsKey(seleccionado)) {
//                acciones.get(seleccionado).ejecutar();
//            } else {
//                System.out.println("Opcion no valida.");
//            }
//        } while (true);
//
//    }
//
//    private void deConsultarMisDatos() {
//        boolean vigilante_encontrado = false;
//        int codigo_vigilante = tools.leerEntero("Ingrese su codigo de Vigilante.");
//        for (Vigilante v : contexto.getVigilante()) {
//            if (codigo_vigilante == v.getCodigo()) {
//                System.out.println(v.toString());
//                for (ContratoSucVig c : contratos) {
//                    if (v.getNombre() == c.getVigilante()) {
//                        System.out.println("Contrato: " + c);
//                    }
//
//                }
//                vigilante_encontrado = true;
//            }
//        }
//        if (vigilante_encontrado == false) {
//            System.out.println("Codigo ingresado no coincide con un vigilante.");
//        };
//        deInicio();
//    }
//
//    private void deConsultarDatos() {
//        System.out.println("Mostrando todos los registros del sistema...");
//    }
//
//    private void deCrearDatos() {
//        System.out.println("Entrando al panel de creacion...");
//    }
//
//    private void deEditarDatos() {
//        System.out.println("Entrando al panel de edicion...");
//        // Contratar Vgilante
//        //elegir entindad basncaria
//        //elegir sucrusal
//        //crearContrato
//        //Consultar vigiliantes disponibles
//        //this.vigilante. 
//
//    }
//
//    private void deEliminarUsuarios() {
//        System.out.println("Entrando al panel de eliminacion...");
//    }
//
//    private void deContratarVigilante() {
//        String entidad_bancaria, sucursal, vigilante;
//        boolean salir = false;
//        int index_entidad_bancaria, index_sucursal, index_vigilante;
//
//        do {
//            do {
//                contexto.mostrarEntidadesBancarias();
//                index_entidad_bancaria = tools.leerEntero("Ingrese nombre de ENTIDAD BANCARIA o <0> para SALIR: ");
//                if (index_entidad_bancaria == 0) {
//                    salir = true;
//                    break;
//                }
//
//            } while (contexto.validarEntidadBancaria(index_entidad_bancaria) == null);
//
//            if (!salir) {
//                do {
//                    contexto.mostrarSucursales();
//                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
//                } while (contexto.validarSucursal(index_sucursal) == null);
//
//                do {
//                    contexto.mostrarVigilantes();
//                    index_vigilante = tools.leerEntero("Ingrese nombre de VIGILANTE: ");
//                } while (contexto.validarVigilante(index_vigilante) == null);
//
//                entidad_bancaria = contexto.obtenerNombreEntidadBancaria(index_entidad_bancaria);
//                sucursal = contexto.obtenerNombreSucursal(index_sucursal);
//                vigilante = contexto.obtenerNombreVigilante(index_vigilante);
//
//                ContratoSucVig nuevo_contrato = new ContratoSucVig(entidad_bancaria, sucursal, vigilante);
//                nuevo_contrato.setCodigo(contratos.size());
//                contratos.add(nuevo_contrato);
//                contexto.mostrarContratos(contratos);
//            }
//        } while (!salir);
//
//        deInicio();
//
//    }
//
//    private void deCerrarSesion() {
//        sistema.iniciarApp(contexto, sistema);
//    }
//
//    private void deSalir() {
//        String mensaje = "===== Saliendo del Sistema de Gestion Policial =====";
//        System.out.println(mensaje);
//    }
//
//}


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
        acciones.put(Permiso.CONSULTAR_MIS_DATOS_VIGILANTE, this::deConsultarMisDatos);
        acciones.put(Permiso.EDITAR_DATOS, this::deCrearDatos);
        acciones.put(Permiso.CREAR_USUARIOS, this::deEditarDatos);
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
            System.out.println("\n\n");
            if (seleccionado != null && acciones.containsKey(seleccionado)) {
                acciones.get(seleccionado).ejecutar();
                if (seleccionado == Permiso.SALIR) {
                seguir = false;
            }
            } else {
                System.out.println("Opcion no valida.");
            }
        } while (seguir);

    }

    
    
    
    
    
    
    private void deConsultarMisDatos() {
        boolean vigilante_encontrado = false;
        int codigo_vigilante = tools.leerEntero("Ingrese su codigo de Vigilante.");
        for (Vigilante v : contexto.getVigilante()) {
            if (codigo_vigilante == v.getCodigo()) {
                System.out.println(v.toString());
                for (ContratoSucVig c : contratos) {
                    if (v.getNombre() == c.getVigilante()) {
                        System.out.println("Contrato: " + c);
                    }

                }
                vigilante_encontrado = true;
            }
        }
        if (vigilante_encontrado == false) {
            System.out.println("Codigo ingresado no coincide con un vigilante.");
        };
    }

    private void deConsultarDatos() {
        // menuItemListener.abrirPantallaConsultaDeDatos()
        System.out.println("Mostrando todos los registros del sistema...");
    }

    private void deCrearDatos() {
        System.out.println("Entrando al panel de creacion...");
    }

    private void deEditarDatos() {
        System.out.println("Entrando al panel de edicion...");
        // Contratar Vgilante
        //elegir entindad basncaria
        //elegir sucrusal
        //crearContrato
        //Consultar vigiliantes disponibles
        //this.vigilante. 

    }

    private void deEliminarUsuarios() {
        System.out.println("Entrando al panel de eliminacion...");
    }

    private void deContratarVigilante() {
        String entidad_bancaria, sucursal, vigilante;
        boolean salir = false;
        int index_entidad_bancaria, index_sucursal, index_vigilante;

        do {
            do {
                contexto.mostrarEntidadesBancarias();
                index_entidad_bancaria = tools.leerEntero("Ingrese nombre de ENTIDAD BANCARIA o <0> para SALIR: ");
                if (index_entidad_bancaria == 0) {
                    salir = true;
                    break;
                }

            } while (contexto.validarEntidadBancaria(index_entidad_bancaria) == null);

            if (!salir) {
                do {
                    contexto.mostrarSucursales();
                    index_sucursal = tools.leerEntero("Ingrese nombre de SUCURSAL: ");
                } while (contexto.validarSucursal(index_sucursal) == null);

                do {
                    contexto.mostrarVigilantes();
                    index_vigilante = tools.leerEntero("Ingrese nombre de VIGILANTE: ");
                } while (contexto.validarVigilante(index_vigilante) == null);

                entidad_bancaria = contexto.obtenerNombreEntidadBancaria(index_entidad_bancaria);
                sucursal = contexto.obtenerNombreSucursal(index_sucursal);
                vigilante = contexto.obtenerNombreVigilante(index_vigilante);

                ContratoSucVig nuevo_contrato = new ContratoSucVig(entidad_bancaria, sucursal, vigilante);
                nuevo_contrato.setCodigo(contratos.size());
                contratos.add(nuevo_contrato);
                contexto.mostrarContratos(contratos);
            }
        } while (!salir);

        mostrar();

    }

    private void deCerrarSesion() {
        menuItemListener.cerrarSesion();
    }

    private void deSalir() {
        String mensaje = "===== Saliendo del Sistema de Gestion Policial =====";
        System.out.println(mensaje);
    }

}