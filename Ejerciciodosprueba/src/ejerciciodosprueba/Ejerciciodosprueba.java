/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciodosprueba;

import java.util.Scanner;

/**
 *
 * @author sandr
 */
public class Ejerciciodosprueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     


        Scanner scanner = new Scanner(System.in);
        
        double total = 0;

       
        for (int mes = 1; mes <= 12; mes++) {
            System.out.print("Ingrese el consumo de agua que tuvo mensualmente " + mes + ": ");
            double consumo = scanner.nextDouble();
            total += consumo;
        }

      
        double promensual = total / 12;

        
        System.out.printf("El consumo anual es %.2f litros\n", total);
        System.out.printf("El promedio por mes es %.2f litros\n", promensual);

        scanner.close();
    }
}

    
    

