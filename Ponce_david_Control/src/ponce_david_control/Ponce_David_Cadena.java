/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ponce_david_control;

import java.util.Scanner;


public class Ponce_David_Cadena {
    
    

   public static void ejecutar() {
         Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa cadena:");
        String cadena = scan.nextLine();

        char caracteres = ' ';
        int cuenta = 0;

        int i = 0;
        while (i < cadena.length()) {
            char ch = cadena.charAt(i);
            int cuentaActual = 0;

            int j = 0;
            while (j < cadena.length()) {
                if (cadena.charAt(j) == ch) {
                    cuentaActual++;
                }
                j++;
            }

            if (cuentaActual > cuenta) {
                caracteres = ch;
                cuenta = cuentaActual;
            }
            i++;
        }

        System.out.println("El caracter que mas se repite es '" + caracteres + "' y aparecio " + cuenta + " veces");
    }
}




   
  

