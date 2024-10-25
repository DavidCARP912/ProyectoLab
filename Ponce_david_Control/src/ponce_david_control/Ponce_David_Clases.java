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
public class Ponce_David_Clases {
    


 
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la fecha actual en formato \"dia, DD/MM\":");
        String fecha = sc.nextLine().toLowerCase();

        if (fecha.length() < 9 || !fecha.contains(",") || !fecha.contains("/")) {
            System.out.println("Se produjo un error.");
            return;
        }

        String dia = fecha.substring(0, fecha.indexOf(","));
        String diaMes = fecha.substring(fecha.indexOf(",") + 2, fecha.indexOf("/"));
        String mes = fecha.substring(fecha.indexOf("/") + 1);

        int diaNum = Integer.parseInt(diaMes);
        int mesNum = Integer.parseInt(mes);

        if (diaNum > 31 || mesNum > 12) {
            System.out.println("Se produjo un error.");
            return;
        }

        boolean examenes = false;
        int aprobados = 0;
        int reprobados = 0;

        switch (dia) {
            case "lunes":
                examenes = true;
                break;
            case "martes":
                examenes = true;
                break;
            case "miércoles":
                examenes = true;
                break;
            case "jueves":
                System.out.println("Ingrese el porcentaje de asistencia a clase: ");
                int asistencia = sc.nextInt();
                if (asistencia > 50) {
                    System.out.println("Asistio ");
                } else {
                    System.out.println("No asistio lo suficiente ");
                }
                return;
            case "viernes":
                if (diaNum == 1 && (mesNum == 1 || mesNum == 7)) {
                    System.out.println("Comienzo de nuevo ciclo");
                    System.out.println("Cual es la cantidad de alumnos del nuevo ciclo:");
                    int alumnos = sc.nextInt();
                    System.out.println("Ingrese el precio en dolares por cada alumno: ");
                    double precio = sc.nextDouble();
                    double ingreso = alumnos * precio;
                    System.out.printf("Ingreso total en $: %.2f\n", ingreso);
                }
                return;
            default:
                System.out.println("Error.");
                return;
        }

        if (examenes) {
            System.out.println("Cuantos alumnos aprobaron?");
            aprobados = sc.nextInt();
            System.out.println("Cuantos alumnos reprobaron?");
            reprobados = sc.nextInt();
            int total = aprobados + reprobados;
            double porcentaje = (double) aprobados / total * 100;
            System.out.printf("Porcentaje de alumnos que aprobaron: %.2f%%\n", porcentaje);
        }
    }
}