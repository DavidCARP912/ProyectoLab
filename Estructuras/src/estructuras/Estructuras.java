/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuras;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sandr
 */
public class Estructuras {


      
    private static int palabraalrevez = 0;
    private static int numeroperfecto = 0;
    private static int contadorPrimos = 0;
    private static int contadorVotaciones = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // Mostramos el menu
            System.out.println("Menu ");
            System.out.println("1 Palabra alrevez");
            System.out.println("2 numero perfecto");
            System.out.println("3 numero primos");
            System.out.println("4 contadro de elecciones");
            System.out.println("5  salir");
            System.out.print("Escoge la funcion que quiera hacer ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    invertirPalabra(scanner);
                    palabraalrevez++;
                    break;
                case 2:
                    numeroPerfecto(scanner);
                    numeroperfecto++;
                    break;
                case 3:
                    primos();
                    contadorPrimos++;
                    break;
                case 4:
                    votaciones(scanner);
                    contadorVotaciones++;
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Intenta de nuevo ");
            }
        } while (opcion != 5);

        // Imprimir contadores
        System.out.println("Palabra alrevez seleccionada " + palabraalrevez + " veces");
        System.out.println("El numero perfecto es " + numeroperfecto + " veces");
        System.out.println("Los numeros primos son " + contadorPrimos + " veces");
        System.out.println("La votaciones son " + contadorVotaciones + " veces");

        scanner.close();
    }

    // Metodo para invertir una palabra
    private static void invertirPalabra(Scanner scanner) {
        System.out.print("Ingresa una palabra: ");
        String palabra = scanner.nextLine();
        // Imprimir palabra al reves
        String palabraInversa = new StringBuilder(palabra).reverse().toString();
        System.out.println("Palabra al reves: " + palabraInversa);
    }

    // Metodo para verificar si un numero es perfecto
    private static void numeroPerfecto(Scanner scanner) {
        System.out.print("Ingresa un numero: ");
        int numero = scanner.nextInt();
        int sumaDivisores = 0;

        // Calcular la suma de los divisores
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }

        // Esto es para ver si el numero es perfecto o no
        if (sumaDivisores == numero) {
            System.out.println(numero + " es un numero perfecto.");
        } else {
            System.out.println(numero + " no es un  perfecto.");
        }
    }

    // para generar numero primo y los numeros que dividen
    private static void primos() {
        Random random = new Random();
        int numero = random.nextInt(100) + 1; 
// Generar nUmero aleatorio de 1 al 100
        System.out.println("Numero generado: " + numero);

        // Determinar si el nUmero es primo y encontrar divisores
        int divisorCount = 0;
        StringBuilder divisores = new StringBuilder();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisorCount++;
                divisores.append(i).append(" ");
            }
        }

        if (divisorCount == 2) {
            System.out.println(numero + " es primo porque solo tiene dos divisores.");
        } else {
            System.out.println(numero + "no es primo.");
        }

        // Imprimir divisores
        System.out.println("Divisores de " + numero + " son: " + divisores.toString());
    }

    // Metodo para manejar el proceso de votaciones
    private static void votaciones(Scanner scanner) {
        System.out.print("Cuantos votantes hay? ");
        int numVotantes = scanner.nextInt();
        scanner.nextLine(); 

        // Inicializamos contadores para los votos
        int votosValidos = 0;
        int votosAzul = 0;
        int votosRojo = 0;
        int votosNegro = 0;
        int votosAmarillo = 0;

        // Ingreso de votos
        for (int i = 0; i < numVotantes; i++) {
            System.out.print("Ingresa tu voto (AZUL, ROJO, NEGRO, AMARILLO): ");
            String voto = scanner.nextLine().toUpperCase();
            // Contar votos validos
            switch (voto) {
                case "AZUL":
                    votosAzul++;
                    votosValidos++;
                    break;
                case "ROJO":
                    votosRojo++;
                    votosValidos++;
                    break;
                case "NEGRO":
                    votosNegro++;
                    votosValidos++;
                    break;
                case "AMARILLO":
                    votosAmarillo++;
                    votosValidos++;
                    break;
                default:
                    System.out.println("Voto nulo.");
            }
        }

        // Verificamos si la votación es vAlida
        if (votosValidos >= 0.6 * numVotantes) {
            String planillaGanadora = "";
            int maxVotos = Math.max(Math.max(votosAzul, votosRojo), Math.max(votosNegro, votosAmarillo));

            if (maxVotos == votosAzul) {
                planillaGanadora = "AZUL";
            } else if (maxVotos == votosRojo) {
                planillaGanadora = "ROJO";
            } else if (maxVotos == votosNegro) {
                planillaGanadora = "NEGRO";
            } else if (maxVotos == votosAmarillo) {
                planillaGanadora = "AMARILLO";
            }

            System.out.println("La planilla ganadora es: " + planillaGanadora);
        } else {
            System.out.println("VOTACIÓN FALLIDA");
        }
    }
}

    
