/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ponce_david_control;
import java.util.Scanner;

/** 
 * 
 * @author sandr
 */
public class Ponce_David_Notas {
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de notas:");
        int cantidadNotas = scanner.nextInt();

       
        while (cantidadNotas <= 0) {
            System.out.println("Ingrese una cantidad positiva de notas:");
            cantidadNotas = scanner.nextInt();
        }

        double suma = 0;
        double masalta = -1;
        double menor = 101;

        for (int i = 1; i <= cantidadNotas; i++) {
            double nota;
            do {
                System.out.println("Nota #" + i + ":");
                nota = scanner.nextDouble();
                if (nota < 0 || nota > 100) {
                    System.out.println("Solo se aceptan notas dentro del rango 0 a 100.");
                }
            } while (nota < 0 || nota > 100);

            suma += nota;
            if (nota > masalta) {
                masalta = nota;
            }
            if (nota < menor) {
                menor = nota;
            }
        }

        double promedio = suma / cantidadNotas;
        System.out.printf("Promedio: %.2f %%\n", promedio);
        System.out.printf("Nota mayor: %.2f\n", masalta);
        System.out.printf("Nota menor: %.2f\n", menor);
    }
}

