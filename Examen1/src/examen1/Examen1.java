/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1;

import java.util.Scanner;

/**
 *
 * @author sandr
 */
public class Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int opcion;
        

          do {
            System.out.println("1- Piramide");
            System.out.println("2- El mayor");
            System.out.println("3 Calcular pago de television");
            System.out.println("4- Opcion 4");
            System.out.println("5- Salir");
            System.out.print("Escoga una ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    piramide(6); 
                    break;
                case 2:
                    encontrarMayor();
                    break;
                case 3:
                    television();
                    break;
                case 4:
                    System.out.println("Opcion 4");
                    break;
                case 5:
                    System.out.println("Saliendo de programa");
                    break;
                default:
                    System.out.println("Escoga una opcion del 1 al 5");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void piramide(int filas) {
        int resultado = 1;

        for (int i = 1; i <= filas; i++) {
            int sumadelasfilas

            for (int j = 1; j <= i; j++) {
                System.out.print(resultado + " ");
                sumadelasfilas += resultado;
                resultado += 2;
            }

            System.out.println("= " + sumadelasfilas);
        }
    }

    public static void encontrarMayor() {
        Scanner scanner = new Scanner(System.in);
        int mayor = Integer.MIN_VALUE;
        int suma = 0;
        int contador = 0;

        while (true) {
            System.out.print("Introduce un número entero (o escribe 'no' para terminar): ");
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                suma += numero;
                contador++;
                if (numero > mayor) {
                    mayor = numero;
                }
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Solo entregar numeros enteros.");
                }
            }
        }

        if (contador > 0) {
            double promedio = (double) suma / contador;
            System.out.println("El numero mayor " + mayor);
            System.out.printf("El promedio es: %.2f\n", promedio);
        } else {
            System.out.println("No se ingresaron numeros.");
        }
    }

    public static void television() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        int canalesHD = 0;
        int canales = 0;
        int costoCanales = 0;

        while (true) {
            System.out.print("Introduce el tipo de canal HD o NORMAL: ");
            String tipoCanal = scanner.nextLine().toUpperCase();

            if (tipoCanal.equals("HD")) {
                canalesHD++;
                costoCanales += 30; 
            } else if (tipoCanal.equals("NORMAL")) {
                canales++;
                costoCanales += 20;
            } else {
                System.out.println("Este canal no es valido pone en HD o Canal normal.");
                continue;
            }

            System.out.print("Va ingresar otro canal ponga SI o NO: ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (!respuesta.equals("SI")) {
                break;
            }
        }

        System.out.print("Introduce el tipo de Caja Digital LIGHTBOX, HDBOX, DVRBOX ");
        String tipoCaja = scanner.nextLine().toUpperCase();
        int caja = 0;

        switch (tipoCaja) {
            case "LIGHTBOX":
                caja = 50;
                break;
            case "HDBOX":
                caja = 100;
                break;
            case "DVRBOX":
                caja = 150;
                break;
            default:
                System.out.println("La caja digital no es valida.");
                return;
        }

         int subtotal = costoCanales + costoCaja;
         double impuesto = subtotal * 0.15;
         double totalAPagar = subtotal + impuesto;

        
           System.out.println("Cliente: " + nombreCliente);
        System.out.println("Canales Normales: " + canales);
        System.out.println("Canales HD: " + canalesHD);
        System.out.println("Subtotal " + subtotal + " lps");
        System.out.println("Impuesto 15%: " + impuesto + " lps");
        System.out.println("Total : " + totalAPagar + " lps");
    }
}

       