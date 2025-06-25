package policia.federal;

/**
 * Interfaz funcional que representa una acción que puede ser ejecutada.
 * Contiene un único método abstracto para realizar la ejecución.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
@FunctionalInterface  //Esto nos indica que hay un solo metodo abstracto
public interface Accion {

    /**
     * Ejecuta la acción definida.
     */
    void ejecutar();
}
