package policia.federal;

public class Sistema implements Menu.OnMenuItemSelectedListener, Authenticacion.Listener {

    private Contexto contexto;
    private Menu menu;

    public void iniciar(Contexto contexto) {
        this.contexto = contexto;
        this.menu = new Menu(contexto, this);

        Authenticacion.getInstance().iniciarSesion(this);
    }

    @Override
    public void onUserLogin() {
        menu.mostrar();
    }

    @Override
    public void cerrarSesion() {
        Authenticacion.getInstance().cerrarSesion();
        Authenticacion.getInstance().iniciarSesion(this);
    }

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
