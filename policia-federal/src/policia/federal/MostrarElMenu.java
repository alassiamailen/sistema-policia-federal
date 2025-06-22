package policia.federal;

/**
 *
 * @author Nico
 */
public class MostrarElMenu {

    private Usuario usuario;

    public MostrarElMenu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void deInicio() {
        usuario.mostrarPermisos();
    }


}
