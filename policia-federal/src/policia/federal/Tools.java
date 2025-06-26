package policia.federal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase utilitaria para la lectura de datos desde la consola.
 * <p>
 * Proporciona métodos estándar para leer enteros, cadenas y fechas, con
 * validación básica y formato predefinido.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Tools {

    /**
     * Constructor por defecto.
     */
    public Tools() {
    }

    private final Scanner sc = new Scanner(System.in);

    /**
     * Lee un número entero desde la consola mostrando un mensaje personalizado.
     *
     * @param mensaje Mensaje que se muestra al usuario para solicitar el dato.
     * @return El entero ingresado por el usuario.
     */
    public int leerEntero(String mensaje) {
        System.out.println(mensaje);
        int valor = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea pendiente
        return valor;
    }

    /**
     * Lee una cadena de texto desde la consola mostrando un mensaje
     * personalizado.
     *
     * @param mensaje Mensaje que se muestra al usuario para solicitar el dato.
     * @return La cadena ingresada por el usuario.
     */
    public String leerString(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    /**
     * Lee una fecha desde la consola en formato "dd-MM-yyyy".
     * <p>
     * Ejemplo de entrada válida: "31-12-2023".
     *
     * @param mensaje Mensaje que se muestra al usuario para solicitar el dato.
     * @return La fecha parseada como {@link LocalDate}.
     * @throws DateTimeParseException Si el formato de la fecha es incorrecto.
     */
    public LocalDate leerFecha(String mensaje) {
        System.out.println(mensaje);
        String fechaTexto = sc.nextLine();  // leer la fecha como texto
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(fechaTexto, formato);  // parsear a LocalDate
    }

}
