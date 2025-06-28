package policia.federal;

import java.time.LocalDate;

/**
 * Clase principal que inicializa el sistema de gestión policial. Se encarga de
 * crear y registrar roles, usuarios, vigilantes, entidades bancarias,
 * sucursales, bandas criminales, asaltantes y jueces, y de iniciar el sistema.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Main {

    /**
     * Método principal que se ejecuta al iniciar la aplicación. Configura el
     * contexto inicial del sistema, crea roles, usuarios, vigilantes,
     * entidades, bandas, y lanza el sistema principal.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Contexto contexto = new Contexto();
        Authenticacion authenticacion = Authenticacion.getInstance();

        // Roles
        Rol admin = new Rol("Administrador");
        admin.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        admin.agregarPermiso(Permiso.CONTRATAR_VIGILANTE);
        admin.agregarPermiso(Permiso.CARGAR_DETENIDO);
        admin.agregarPermiso(Permiso.ABRIR_CASO);
        admin.agregarPermiso(Permiso.CREAR_USUARIOS);
        admin.agregarPermiso(Permiso.CREAR_ENTIDAD);
        admin.agregarPermiso(Permiso.EDITAR_DATOS);
        admin.agregarPermiso(Permiso.ELIMINAR_DATOS);
        admin.agregarPermiso(Permiso.CERRAR_SESION);
        admin.agregarPermiso(Permiso.SALIR);

        Rol vigilante = new Rol("Vigilante");
        vigilante.agregarPermiso(Permiso.CONSULTAR_MIS_DATOS_VIGILANTE);
        vigilante.agregarPermiso(Permiso.CERRAR_SESION);
        vigilante.agregarPermiso(Permiso.SALIR);

        Rol investigador = new Rol("Investigador");
        investigador.agregarPermiso(Permiso.CONSULTAR_DATOS_DE_OTRAS_ENTIDADES);
        investigador.agregarPermiso(Permiso.CERRAR_SESION);
        investigador.agregarPermiso(Permiso.SALIR);

        authenticacion.registrarUsuario(new Usuario("juan", "1234", admin));
        authenticacion.registrarUsuario(new Usuario("lula", "123", investigador));
        RegistroVigilantes registro = new RegistroVigilantes(authenticacion, contexto, vigilante);

        //Cargo vigilantes, linkeo con usuarios y cargo al contexto
        registro.crearVigilanteConUsuario("Carlos Sanchez", 10, 40, "carlos", "1234");
        registro.crearVigilanteConUsuario("Ana Gomez", 11, 38, "ana", "abcd");
        registro.crearVigilanteConUsuario("Luis Varela", 12, 45, "luis", "pass");

        //ENTIDADES
        EntidadBancaria BBVA = new EntidadBancaria("BBVA", 1234, "Triunvirato");
        EntidadBancaria GALICIA = new EntidadBancaria("Galicia", 134, "Vicente Lopez");
        EntidadBancaria SANTANDER_RIO = new EntidadBancaria("Santander Rio", 14, "Paternal");
        //SUCURSALES
        Sucursal paternal = new Sucursal(15, "Paternal","Donato Alvarez");
        Sucursal vicente_lopez = new Sucursal(15, "Vicente Lopez","Av.Maipu");
        Sucursal triunvirato = new Sucursal(15, "Triunvirato","Av.Juan Alvarez");
        /// BANDA CRIMINAL
        BandaCriminal banda_1 = new BandaCriminal(889, 2);
        BandaCriminal banda_2 = new BandaCriminal(579, 1);
        /// ASALTANTES
        Asaltante detenido_1 = new Asaltante("Mario Ledesma", banda_1);
        Asaltante detenido_2 = new Asaltante("Carlos Gomez", banda_2);
        Asaltante detenido_3 = new Asaltante("Susana Palacios", banda_1);

        //Jueces
        Juez juez_1 = new Juez("Esteban Paz", 123, 2);
        Juez juez_2 = new Juez("Joaquin Lopez", 234, 5);
        Juez juez_3 = new Juez("Juana Palapa", 456, 8);

        /// ASALTO
        LocalDate fecha = LocalDate.of(2024, 04, 02);
        Asalto asalto_1 = new Asalto(fecha, detenido_1, paternal, banda_1);

        // Inicializar entidad
        contexto.agregarEntidadAlArrayList(contexto.getEntidadBancaria(), BBVA);
        contexto.agregarEntidadAlArrayList(contexto.getEntidadBancaria(), GALICIA);
        contexto.agregarEntidadAlArrayList(contexto.getEntidadBancaria(), SANTANDER_RIO);

        // Inicializar sucursal
        contexto.agregarEntidadAlArrayList(contexto.getSucursal(), paternal);
        contexto.agregarEntidadAlArrayList(contexto.getSucursal(), vicente_lopez);
        contexto.agregarEntidadAlArrayList(contexto.getSucursal(), triunvirato);

        // Inicializar jueces
        contexto.agregarEntidadAlArrayList(contexto.getJuez(), juez_1);
        contexto.agregarEntidadAlArrayList(contexto.getJuez(), juez_2);
        contexto.agregarEntidadAlArrayList(contexto.getJuez(), juez_3);

        // Inicializar asaltante
        contexto.agregarEntidadAlArrayList(contexto.getAsaltante(), detenido_1);
        contexto.agregarEntidadAlArrayList(contexto.getAsaltante(), detenido_2);
        contexto.agregarEntidadAlArrayList(contexto.getAsaltante(), detenido_3);

        // Inicializar banda criminal
        contexto.agregarEntidadAlArrayList(contexto.getBandaCriminal(), banda_1);
        contexto.agregarEntidadAlArrayList(contexto.getBandaCriminal(), banda_2);

        // Inicializar asalto
        contexto.agregarEntidadAlArrayList(contexto.getAsaltos(), asalto_1);

        // Lanzar el sistema principal
        Sistema sistema = new Sistema();
        sistema.iniciar(contexto);

    }

}
