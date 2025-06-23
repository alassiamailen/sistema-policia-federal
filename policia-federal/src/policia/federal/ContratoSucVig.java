package policia.federal;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 * @author Mailen
 * @author Leo
 */
public class ContratoSucVig {

    private LocalDate fecha_de_inicio;
    private LocalDate fecha_de_fin;
    private String entidad_bancaria;
    private String sucursal;
    private String vigilante;
    private boolean portar_arma;
    private String armado;    
    private int codigo_contrato;

    Tools tools = new Tools();

    public ContratoSucVig(String entidad_bancaria, String sucursal, String vigilante) {
        this.entidad_bancaria = entidad_bancaria;
        this.sucursal = sucursal;
        this.vigilante = vigilante;
        crearContrato();
    }

    public void crearContrato() {
        String entidad_bancaria, sucursal, armado;
        boolean flag = false;

        this.fecha_de_inicio = tools.leerFecha("Ingrese fecha de inicio de contrato en formato (dd-MM-yyyy)");
        this.fecha_de_fin = tools.leerFecha("Ingrese fecha de fin de contrato en formato (dd-MM-yyyy)");

        do {
            armado = tools.leerString("Ingrese <1> si el vigilante porta arma o <0> en caso contrario");
            if (armado.equals("1")) {
                this.portar_arma = true;
                this.armado= "SI";
                flag = true;
            } else if (armado.equals("0")) {
                this.portar_arma = false;
                this.armado= "NO";
                flag = true;
            } else {
                System.err.println("Ingrese una opcion valida");
                flag = false;
            }
        } while (!flag);

    }

    public void setCodigo(int codigo) {
        this.codigo_contrato = codigo;
    }

    public String toString() {
        return "Codigo: #" + codigo_contrato + "\n"
                + "Entidad: " + entidad_bancaria + "\n"
                + "Sucursal: " + sucursal + "\n"
                + "Vigilante: " + vigilante + "\n"
                + "Porta Arma: " + armado + "\n"
                + "Fecha de inicio: " + fecha_de_inicio + "\n"
                + "Fecha de fin: " + fecha_de_fin;
    }

    public String getVigilante() {
        return vigilante;
    }
    
    

}
