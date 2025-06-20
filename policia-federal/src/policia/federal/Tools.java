/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policia.federal;

import java.util.Scanner;


/**
 *
 * @author Nicolas
 * @author Mailen 
 * @author Leo
 */
public class Tools {

    public Tools() {
    }
    
        
    private final Scanner sc = new Scanner(System.in);
    
    public int leerEntero(String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
    
    public String leerString(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }    
     
}