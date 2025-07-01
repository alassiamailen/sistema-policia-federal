package policia.federal;

/**
 * Interfaz funcional que representa una accion que puede ser ejecutada.
 * Contiene un unico metodo abstracto para realizar la ejecucion.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
@FunctionalInterface  //Esto nos indica que hay un solo metodo abstracto
public interface Accion {

    /**
     * Ejecuta la accion definida.
     */
    void ejecutar();
}
