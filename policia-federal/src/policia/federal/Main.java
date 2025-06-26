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
        Sucursal paternal = new Sucursal(15, "Paternal");
        Sucursal vicente_lopez = new Sucursal(15, "Vicente Lopez");
        Sucursal triunvirato = new Sucursal(15, "Triunvirato");
        /// BANDA CRIMINAL
        BandaCriminal banda_1 = new BandaCriminal(889, 2);
        BandaCriminal banda_2 = new BandaCriminal(579, 1);
        /// ASALTANTES
        Asaltante detenido_1 = new Asaltante(23, "Mario Ledesma", banda_1);
        Asaltante detenido_2 = new Asaltante(12, "Carlos Gomez", banda_2);
        Asaltante detenido_3 = new Asaltante(120, "Susana Palacios", banda_1);

        /// ASALTO
        LocalDate fecha = LocalDate.of(2024, 04, 02);
        Asalto asalto_1 = new Asalto(fecha, detenido_1, paternal, banda_1);

        // Inicializar entidad
        contexto.agregarEntidadBancaria(BBVA);
        contexto.agregarEntidadBancaria(GALICIA);
        contexto.agregarEntidadBancaria(SANTANDER_RIO);
        // Inicializar sucursal
        contexto.agregarSucursal(paternal);
        contexto.agregarSucursal(vicente_lopez);
        contexto.agregarSucursal(triunvirato);

        contexto.agregarJuez(new Juez("Esteban Paz", 123, 2));
        contexto.agregarJuez(new Juez("Joaquin Lopez", 234, 5));
        contexto.agregarJuez(new Juez("Juana Palapa", 456, 8));
        // Inicializar asaltante
        contexto.agregarAsaltantes(detenido_1);
        contexto.agregarAsaltantes(detenido_2);
        contexto.agregarAsaltantes(detenido_3);
        // Inicializar banda criminal
        contexto.agregarBandaCriminal(banda_1);
        contexto.agregarBandaCriminal(banda_2);

        // Inicializar asalto
        contexto.agregarAsalto(asalto_1);

        // Lanzar el sistema principal
        Sistema sistema = new Sistema();
        sistema.iniciar(contexto);

    }

}
