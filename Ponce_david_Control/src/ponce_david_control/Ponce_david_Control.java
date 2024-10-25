/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ponce_david_control;
import java.util.Scanner;
import ponce_david_control.Ponce_David_Notas;

 
public class Ponce_david_Control {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
        Scanner eleccion = new Scanner(System.in);
        boolean menu = true;
        int opcion;
        System.out.println("Menu");
        System.out.println("1. Cadena");
        System.out.println("2. Notas");
        System.out.println("3. Clases");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
        opcion = eleccion.nextInt();
        
        
        switch (opcion){
            
            case 1:
                Ponce_David_Cadena.ejecutar();
                break;
            
            case 2:
                Ponce_David_Notas.ejecutar();
                break;
                
            case 3:
                Ponce_David_Clases.ejecutar();
                break;
                
            case 4:
                System.out.println("Se ha cerrado el programa.");
                break;
    }
    }}