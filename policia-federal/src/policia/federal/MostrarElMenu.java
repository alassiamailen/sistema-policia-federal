package policia.federal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class MostrarElMenu {

    private final Usuario usuario;
    private final Map<Permiso, Accion> acciones = new HashMap<>();
    private Contexto contexto;
    
    public MostrarElMenu(Usuario usuario, Contexto contexto) {
        this.contexto = contexto;
        this.usuario = usuario;
        inicializarAcciones();
    }
    
    private void inicializarAcciones() {
        acciones.put(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES, this::deConsultarDatos);
        acciones.put(Permiso.CONTRATAR_VIGILANTE, this::deContratarVigilante);
        acciones.put(Permiso.CONSULTAR_MIS_DATOS, this::deConsultarMisDatos);
        acciones.put(Permiso.EDITAR_DATOS, this::deCrearDatos);
        acciones.put(Permiso.CREAR_USUARIOS, this::deEditarDatos);
        acciones.put(Permiso.ELIMINAR_DATOS, this::deEliminarUsuarios);
    }

    public void deInicio() {
        System.out.println("Usuario " + usuario.getRol().getNombre() + " " + usuario.getNombreUsuario() + ":");
        ArrayList<Permiso> permisos = new ArrayList<>(usuario.getRol().getPermisos());
        Scanner sc = new Scanner(System.in);

        int i = 1;
        Map<Integer, Permiso> opciones = new HashMap<>();
        for (Permiso permiso : permisos) {
            System.out.println(i + " - " + permiso.toString());
            opciones.put(i, permiso);
            i++;
        }

        System.out.print("Seleccione una opción: ");
        int eleccion = sc.nextInt();
        Permiso seleccionado = opciones.get(eleccion);

        if (seleccionado != null && acciones.containsKey(seleccionado)) {
            acciones.get(seleccionado).ejecutar();
        } else {
            System.out.println("Opcion no valida.");
        }
    }

    private void deConsultarMisDatos() {
        System.out.println("Crear entidad bancaria...");
        contexto.mostrarEntidadesBancarias();
        EntidadBancaria nueva = new EntidadBancaria("Banco Provincia", 9999, "aca cerca");
        System.out.println("--------------------------------");
        contexto.agregarEntidadBancaria(nueva);
        contexto.mostrarEntidadesBancarias();

    }

    private void deConsultarDatos() {
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

    private void deContratarVigilante(){
        System.out.println("ACA INSTANCIO UN CONTRATO");
        //Mostar entidades
        //new contrato(entidad,   ,   ,   ,   ,);
        //Mostrar sucursales
        //new contrato(entidad,   ,   ,   ,   ,);

    }
}
