package policia.federal;

/**
 * Clase principal que coordina la ejecución del sistema de gestión policial.
 * Implementa los listeners para manejar eventos de login y navegación del menú.
 *
 * Se encarga de iniciar sesión, mostrar el menú principal al usuario
 * autenticado y redirigir la ejecución de acciones como cerrar sesión o abrir
 * pantallas específicas.
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class Sistema implements Menu.OnMenuItemSelectedListener, Authenticacion.Listener {

    private Contexto contexto;
    private Menu menu;

    /**
     * Inicia el sistema con el contexto dado, y lanza el inicio de sesión.
     *
     * @param contexto contexto del sistema, con los datos cargados previamente.
     */
    public void iniciar(Contexto contexto) {
        this.contexto = contexto;
        //this siempre es una referencia al objeto en el cual se llama. En este caso sistema. 
        this.menu = new Menu(contexto, this);

        Authenticacion.getInstance().iniciarSesion(this);
    }

    /**
     * Callback que se ejecuta cuando un usuario inicia sesión correctamente. Se
     * encarga de mostrar el menú correspondiente a ese usuario.
     */
    @Override
    public void onUserLogin() {
        menu.mostrar();
    }

    /**
     * Cierra la sesión del usuario actual e inicia una nueva sesión.
     */
    @Override
    public void cerrarSesion() {
        Authenticacion.getInstance().cerrarSesion();
        Authenticacion.getInstance().iniciarSesion(this);
    }

    //POSIBLEMENTE HAY QUE ELIMINAR ESTO!!!!!!!!!
    /**
     * Abre la pantalla de consulta de datos. Este método sirve como ejemplo del
     * uso de callbacks para modularizar la lógica del sistema.
     *
     * Se recomienda crear una clase separada para cada pantalla, por ejemplo:
     * {@code PantallaRegistroDatos p = new PantallaRegistroDatos(); p.mostrar();}
     */
    @Override
    public void abrirPantallaConsultaDeDatos() {
        // esto es un ejemplo de como usar la interfaz de menu como callback
        // para no meter toda la logica ahi. Tambien podrian crear una clase
        // para cada pantalla, y que maneja su logica dentro. Podrian llamarla desde
        // aca. Algo como:
        // PantallaRegistroDatos p = new PantallaRegistroDatos()
        // p.mostrar();
    }

}
