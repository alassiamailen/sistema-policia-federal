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
   private boolean vigilante_armando;
   //vigilante
   
   Tools tools = new Tools();

    public ContratoSucVig(String entidad_bancaria, String sucursal) {
        this.entidad_bancaria = entidad_bancaria;
        this.sucursal = sucursal;
        crearContrato();
    }

   
   
    public ContratoSucVig(LocalDate fecha_de_inicio, LocalDate fecha_de_fin, boolean vigilante_armando) {
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_de_fin = fecha_de_fin;
        this.vigilante_armando = vigilante_armando;
    }
   
   public void crearContrato(){
       String entidad_bancaria, sucursal,armado;
      
       this.fecha_de_inicio= tools.leerFecha("Ingrese fecha de inicio de contrato en formato (dd-MM-yyyy)");
       this.fecha_de_fin= tools.leerFecha("Ingrese fecha de fin de contrato en formato (dd-MM-yyyy)");
       //ingresar vigilante
       entidad_bancaria= tools.leerString("Ingrese la entidad bancaria: ");
       sucursal= tools.leerString("Ingrese la sucursal: ");
       armado= tools.leerString("Ingrese <1> si el vigilante porta arma o <0> en caso contrario");
       if(armado=="1"){
           this.vigilante_armando=true;
       }else{
           this.vigilante_armando=false;
       }
       if(armado!="1" || armado!="0"){
           System.err.println("Ingrese una opcion valida");
       }   
       
       
   }
}
