package policia.federal;

import java.util.Scanner;

/**
 * Clase que representa la pantalla para crear diferentes tipos de entidades del
 * sistema: Juez, Asaltante, Vigilante, Entidad Bancaria y Sucursal.
 *
 * Muestra un menú al usuario para seleccionar qué tipo de entidad desea crear,
 * y delega la creación a métodos específicos.
 *
 * Utiliza la clase {@link Contexto} para acceder y modificar las listas de
 * entidades existentes.
 *
 * @author Alassia
 */
class PantallaDeCrearEntidad {

    /**
     * Contexto general del sistema que contiene las listas de entidades.
     */
    private Contexto contexto;

    /**
     * Constructor que recibe el contexto principal del sistema.
     *
     * @param contexto el contexto compartido que contiene las entidades del
     * sistema
     */
    public PantallaDeCrearEntidad(Contexto contexto) {
        this.contexto = contexto;
    }
    /**
     * Herramientas auxiliares para entrada/salida y utilidades.
     */
    private Tools tools = new Tools();

    /**
     * Muestra el menú de creación de entidades y gestiona la interacción con el
     * usuario.
     *
     * Permite seleccionar el tipo de entidad a crear o volver al menú
     * principal.
     */
    public void menuCrearEntidad() {
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
                        crearJuez();
                    case 2 ->
                        crearAsaltante();
                    case 3 ->
                        crearVigilante();
                    case 4 ->
                        crearEntidadBancaria();
                    case 5 ->
                        crearSucursal();

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
     * Muestra por consola las opciones del menú para crear entidades.
     */
    private void mostrarMenuOpcionAver() {
        System.out.println("\n\n=== Seleccione que entidad desea crear ===\n");

        System.out.println("1. Juez");
        System.out.println("2. Asaltante");
        System.out.println("3. Vigilante");
        System.out.println("4. Entidad Bancaria");
        System.out.println("5. Sucursal");

        System.out.println("\n0. Volver al menu principal");
    }

    /**
     * Crea un nuevo objeto {@link Juez}, lo agrega a la lista correspondiente
     * en el contexto y muestra un mensaje de éxito o error.
     */
    public void crearJuez() {
        tools.limpiarConsola();
        System.out.println("Crear Juez");
        Juez nuevo_juez = new Juez();
        if (nuevo_juez != null) {
            System.out.println("Juez creado con exito");
            contexto.agregarEntidadAlArrayList(contexto.getJuez(), nuevo_juez);

        } else {
            System.out.println("Error al crear Juez");
        }

    }

    /**
     * Crea un nuevo {@link Asaltante}, con o sin asignación de
     * {@link BandaCriminal}, y lo agrega al contexto.
     */
    public void crearAsaltante() {
        int id_banda_criminal, ingresar_banda;
        BandaCriminal banda_criminal;
        Asaltante nuevo_asaltante;
        String nombre_apellido;
        tools.limpiarConsola();
        System.out.println("Crear Asaltante");
        ingresar_banda = tools.leerEntero("Ingrese 1 para agregar banda criminal o 0 de lo contrario");
        if (ingresar_banda == 1) {
            do {
                contexto.mostrarEntidad(contexto.getBandaCriminal());
                id_banda_criminal = tools.leerEntero("Ingrese opcion");
                banda_criminal = contexto.validarEntidadGenerica(contexto.getBandaCriminal(), id_banda_criminal);
            } while (banda_criminal == null);

            nombre_apellido = tools.leerString("Ingrese nombre y apellido: ");
            nuevo_asaltante = new Asaltante(nombre_apellido, banda_criminal);          

        } else {
            nuevo_asaltante = new Asaltante();

        }

        if (nuevo_asaltante != null) {
            System.out.println("Asaltante creado con exito");
            contexto.agregarEntidadAlArrayList(contexto.getAsaltante(), nuevo_asaltante);
        } else {
            System.out.println("Error al crear Asaltante");
        }
    }

    /**
     * Crea un nuevo {@link Vigilante} y lo agrega al contexto.
     */
    public void crearVigilante() {
        tools.limpiarConsola();
        System.out.println("Crear Vigilante");
        Vigilante nuevo_vigilante = new Vigilante();
        if (nuevo_vigilante != null) {
            System.out.println("Vigilante creado con exito");
            contexto.agregarEntidadAlArrayList(contexto.getVigilante(), nuevo_vigilante);
        } else {
            System.out.println("Error al crear Vigilante");
        }
    }

    /**
     * Crea una nueva {@link EntidadBancaria} y la agrega al contexto.
     */

    public void crearEntidadBancaria() {
        tools.limpiarConsola();
        System.out.println("Crear Entidad Bancaria");
        EntidadBancaria nueva_entidad = new EntidadBancaria();
        if (nueva_entidad != null) {
            System.out.println("Entidad Bancaria creada con exito");
            contexto.agregarEntidadAlArrayList(contexto.getEntidadBancaria(), nueva_entidad);
        } else {
            System.out.println("Error al crear Entidad Bancaria");
        }
    }

    /**
     * Crea una nueva {@link Sucursal} y la agrega al contexto.
     */
    public void crearSucursal() {
        tools.limpiarConsola();
        System.out.println("Crear Sucursal");
        Sucursal nueva_sucursal = new Sucursal();
        if (nueva_sucursal != null) {
            System.out.println("Sucursal creada con exito");
            contexto.agregarEntidadAlArrayList(contexto.getSucursal(), nueva_sucursal);
        } else {
            System.out.println("Error al crear Sucursal");
        }
    }
}
