/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.List;
import java.util.Scanner;

/**
 * Clase que permite la edición de datos de diferentes entidades del sistema,
 * como Juez, Vigilante y Entidad Bancaria.
 *
 * Muestra menús para seleccionar qué entidad editar y qué atributos modificar.
 * Utiliza la clase Contexto para acceder a las listas de entidades.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class PantallaDeEditarDatos {

    private Contexto contexto;

    /**
     * Constructor que recibe el contexto general con las listas de entidades.
     *
     * @param contexto contexto general del sistema con las entidades cargadas
     */
    public PantallaDeEditarDatos(Contexto contexto) {
        this.contexto = contexto;
    }

    /**
     * Muestra el menú principal de edición y procesa las opciones del usuario.
     * Permite elegir la entidad a editar (Juez, Vigilante, Entidad Bancaria).
     */
    public void mostrarMenuEditables() {
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
                        editarJuez();
                    case 2 ->
                        editarVigilante();
                    case 3 ->
                        editarEntidadBancaria();

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
     * Muestra las opciones del menú principal de edición.
     */
    private void mostrarMenuEditar() {
        System.out.println("=== Menu de Editar ===");
        System.out.println("1. Juez");
        System.out.println("2. Vigilante");
        System.out.println("3. Entidad Bancaria");
        System.out.println("4. Sucursal");
        System.out.println("0. Volver al menu principal");
    }

    /**
     * Permite editar los atributos del Juez seleccionado. Puede editar nombre
     * completo y tiempo de servicio.
     */
    private void editarJuez() {
        Scanner sc = new Scanner(System.in);

        boolean seguir = true;
        while (seguir) {
            System.out.println("\n=== Editar Juez ===");
            System.out.println("1. Editar Nombre Completo");
            System.out.println("2. Editar Tiempo de Servicio");
            System.out.println("0. Volver");

            System.out.print("\nSeleccione atributo a editar >>> ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    Juez a = seleccionarJuez();
                    if (a != null) {
                        System.out.print("Ingrese el Nuevo Nombre Completo: ");
                        String nuevo_nombre = sc.nextLine();
                        a.setNombre_apellido(nuevo_nombre);
                        System.out.println("Nuevo nombre actualizado.");
                    }
                }
                case 2 -> {
                    Juez a = seleccionarJuez();
                    if (a != null) {
                        System.out.print("Ingrese el Nuevo tiempo de Servicio: ");
                        int nuevo_codigo = sc.nextInt();
                        a.setAnios_de_servicio(nuevo_codigo);
                        System.out.println("Tiempo de servicio actualizado.");
                    }
                }
                case 0 ->
                    seguir = false;
                default ->
                    System.out.println("Opcion invalida.");
            }
        }
    }

    /**
     * Muestra la lista de jueces para seleccionar uno.
     *
     * @return el objeto Juez seleccionado o null si se cancela
     */
    private Juez seleccionarJuez() {
        List<Juez> jueces = contexto.getJuez();
        Scanner sc = new Scanner(System.in);

        if (jueces.isEmpty()) {
            System.out.println("No hay jueces disponibles.");
            return null;
        }

        while (true) {
            System.out.println("\n=== Seleccione un Juez ===");
            for (int i = 0; i < jueces.size(); i++) {
                Juez juez = jueces.get(i);
                System.out.println((i + 1) + ". " + juez.getNombre_apellido());
                System.out.println("\tServicio:" + juez.getAnios_de_servicio());
                System.out.println("\tCode: " + juez.getCodigo());
            }
            System.out.println("0. Volver");
            System.out.print("Ingrese numero del juez >>> ");

            if (sc.hasNextInt()) {
                int eleccion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (eleccion == 0) {
                    return null;
                }

                if (eleccion >= 1 && eleccion <= jueces.size()) {
                    return jueces.get(eleccion - 1);
                } else {
                    System.out.println("Seleccion fuera de rango. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                sc.nextLine(); // limpiar entrada no numerica
            }
        }
    }

    /**
     * Permite editar los atributos del Vigilante seleccionado. Puede editar
     * nombre completo y edad.
     */
    private void editarVigilante() {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\n=== Editar Vigilante ===");
            System.out.println("1. Editar Nombre Completo");
            System.out.println("2. Editar Edad");
            System.out.println("0. Volver");

            System.out.print("\nSeleccione atributo a editar >>> ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    Vigilante v = seleccionarVigilante();
                    if (v != null) {
                        System.out.print("Ingrese el Nuevo Nombre Completo: ");
                        String nuevoNombre = sc.nextLine();
                        v.setNombre_apellido(nuevoNombre);
                        System.out.println("Nombre actualizado.");
                    }
                }
                case 2 -> {
                    Vigilante v = seleccionarVigilante();
                    if (v != null) {
                        System.out.print("Ingrese la Nueva Edad: ");
                        int nuevaEdad = sc.nextInt();
                        sc.nextLine();
                        v.setEdad(nuevaEdad);
                        System.out.println("Edad actualizada.");
                    }
                }

                case 0 ->
                    seguir = false;
                default ->
                    System.out.println("Opcion invalida.");
            }
        }
    }

    /**
     * Muestra la lista de vigilantes para seleccionar uno.
     *
     * @return el objeto Vigilante seleccionado o null si se cancela
     */
    private Vigilante seleccionarVigilante() {
        List<Vigilante> vigilantes = contexto.getVigilante();
        Scanner sc = new Scanner(System.in);

        if (vigilantes.isEmpty()) {
            System.out.println("No hay vigilantes disponibles.");
            return null;
        }

        while (true) {
            System.out.println("\n=== Seleccione un Vigilante ===");
            for (int i = 0; i < vigilantes.size(); i++) {
                Vigilante v = vigilantes.get(i);
                System.out.println((i + 1) + ". " + v.getNombre());
                System.out.println("\tCode: " + v.getCodigo());
                System.out.println("\tEdad: " + v.getEdad());

                // Si queres mostrar edad tambien, agrega un getter
            }
            System.out.println("0. Volver");
            System.out.print("Ingrese numero del vigilante >>> ");

            if (sc.hasNextInt()) {
                int eleccion = sc.nextInt();
                sc.nextLine();

                if (eleccion == 0) {
                    return null;
                }

                if (eleccion >= 1 && eleccion <= vigilantes.size()) {
                    return vigilantes.get(eleccion - 1);
                } else {
                    System.out.println("Seleccion fuera de rango. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }
    }

    /**
     * Permite editar atributos de la Entidad Bancaria seleccionada. Puede
     * editar nombre y domicilio.
     */
    private void editarEntidadBancaria() {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\n=== Editar Entidad Bancaria ===");
            System.out.println("1. Editar Nombre");
            System.out.println("2. Editar Domicilio");
            System.out.println("0. Volver");

            System.out.print("\nSeleccione atributo a editar >>> ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    EntidadBancaria entidad = seleccionarEntidad();
                    if (entidad != null) {
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        entidad.setNombre(nuevoNombre); // Acceso directo, o hace un setNombre si lo creas
                        System.out.println("Nombre actualizado.");
                    }
                }

                case 2 -> {
                    EntidadBancaria entidad = seleccionarEntidad();
                    if (entidad != null) {
                        System.out.print("Ingrese el nuevo domicilio: ");
                        String nuevoDomicilio = sc.nextLine();
                        entidad.setDomicilio(nuevoDomicilio);
                        System.out.println("Domicilio actualizado.");
                    }
                }
                case 0 ->
                    seguir = false;
                default ->
                    System.out.println("Opcion invalida.");
            }
        }
    }

    /**
     * Permite seleccionar una Entidad Bancaria para editar.
     *
     * @return la EntidadBancaria seleccionada o null si se cancela
     */
    private EntidadBancaria seleccionarEntidad() {
        List<EntidadBancaria> entidades = contexto.getEntidadBancaria(); // asegurate que exista este metodo
        Scanner sc = new Scanner(System.in);

        if (entidades.isEmpty()) {
            System.out.println("No hay entidades bancarias disponibles.");
            return null;
        }

        while (true) {
            System.out.println("\n=== Seleccione una Entidad Bancaria ===");
            for (int i = 0; i < entidades.size(); i++) {
                EntidadBancaria e = entidades.get(i);
                System.out.println((i + 1) + ". " + e.getNombre());
                System.out.println("\tCodigo: " + e.getCodigo());
                System.out.println("\tDomicilio: " + e.getDomicilio());
            }
            System.out.println("0. Volver");
            System.out.print("Ingrese nuevo Nombre de la entidad >>> ");

            if (sc.hasNextInt()) {
                int eleccion = sc.nextInt();
                sc.nextLine();

                if (eleccion == 0) {
                    return null;
                }

                if (eleccion >= 1 && eleccion <= entidades.size()) {
                    return entidades.get(eleccion - 1);
                } else {
                    System.out.println("Seleccion fuera de rango. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }
    }

}
