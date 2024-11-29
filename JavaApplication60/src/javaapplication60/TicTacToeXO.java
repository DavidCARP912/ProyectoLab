/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template

*/

import javax.swing.*;
import java.awt.*;

public class TicTacToeXO {
    private static JFrame marco;
    private static JPanel panelJuego;
    private static JLabel etiquetaMensaje;
    private static JTextArea areaTablero;
    private static JTextField entradaCoordenada;
    private static String jugador1, jugador2;
    private static char jugadorActual;
    private static char[][] tablero;
    private static int victoriasJugador1 = 0;
    private static int victoriasJugador2 = 0;

    public static void main(String[] args) {
        marco = new JFrame("Tic Tac Toe");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 450);
        marco.setLayout(new CardLayout());

        registrarJugadores();

        panelJuego = new JPanel();
        panelJuego.setLayout(new BorderLayout());

        areaTablero = new JTextArea(10, 10);
        areaTablero.setFont(new Font("Monospaced", Font.PLAIN, 20));
        areaTablero.setEditable(false);

        entradaCoordenada = new JTextField();
        entradaCoordenada.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton botonEnviar = new JButton("Enviar");

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new BorderLayout());
        panelEntrada.add(entradaCoordenada, BorderLayout.CENTER);
        panelEntrada.add(botonEnviar, BorderLayout.EAST);

        etiquetaMensaje = new JLabel("", SwingConstants.CENTER);
        panelJuego.add(etiquetaMensaje, BorderLayout.NORTH);
        panelJuego.add(new JScrollPane(areaTablero), BorderLayout.CENTER);
        panelJuego.add(panelEntrada, BorderLayout.SOUTH);

        marco.add(panelJuego, "Juego");

        botonEnviar.addActionListener(e -> procesarMovimiento());

        marco.setVisible(true);
        iniciarJuego();
    }

    private static void registrarJugadores() {
        while (true) {
            jugador1 = JOptionPane.showInputDialog(marco, "Jugador 1 (X) - Nombre de usuario:");
            String contrasena1 = JOptionPane.showInputDialog(marco, "Jugador 1 - Contraseña:");

            if (jugador1 == null || contrasena1 == null || jugador1.isEmpty() || contrasena1.isEmpty()) {
                JOptionPane.showMessageDialog(marco, "Todos los campos son obligatorios.");
                continue;
            }

            if (contrasena1.length() < 6) {
                JOptionPane.showMessageDialog(marco, "La contraseña debe tener al menos 6 caracteres.");
                continue;
            }

            jugador2 = JOptionPane.showInputDialog(marco, "Jugador 2 (O) - Nombre de usuario:");
            String contrasena2 = JOptionPane.showInputDialog(marco, "Jugador 2 - Contraseña:");

            if (jugador2 == null || contrasena2 == null || jugador2.isEmpty() || contrasena2.isEmpty()) {
                JOptionPane.showMessageDialog(marco, "Todos los campos son obligatorios.");
                continue;
            }

            if (jugador1.equals(jugador2)) {
                JOptionPane.showMessageDialog(marco, "Los nombres de usuario no pueden ser iguales.");
                continue;
            }

            if (contrasena2.length() < 6) {
                JOptionPane.showMessageDialog(marco, "La contraseña debe tener al menos 6 caracteres.");
                continue;
            }

            break;
        }
    }

    private static void iniciarJuego() {
        jugadorActual = 'X';
        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
        actualizarTablero();
        etiquetaMensaje.setText("Turno de " + jugador1 + " (X)");
    }

    private static void procesarMovimiento() {
        String entrada = entradaCoordenada.getText().toUpperCase();
        if (entrada.matches("[A-C][1-3]")) {
            int col = entrada.charAt(0) - 'A';
            int fila = entrada.charAt(1) - '1';
            if (tablero[fila][col] == ' ') {
                tablero[fila][col] = jugadorActual;
                if (comprobarGanador()) {
                    actualizarTablero();
                    etiquetaMensaje.setText("¡" + getNombreJugadorActual() + " ha ganado!");
                    if (jugadorActual == 'X') {
                        victoriasJugador1++;
                    } else {
                        victoriasJugador2++;
                    }
                    mostrarRecord();
                    iniciarJuego();
                } else if (tableroCompleto()) {
                    actualizarTablero();
                    etiquetaMensaje.setText("¡Es un empate!");
                    mostrarRecord();
                    iniciarJuego();
                } else {
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                    actualizarTablero();
                    etiquetaMensaje.setText("Turno de " + getNombreJugadorActual() + " (" + jugadorActual + ")");
                }
                entradaCoordenada.setText("");
            } else {
                JOptionPane.showMessageDialog(marco, "Coordenadas inválidas o celda ocupada.");
            }
        } else {
            JOptionPane.showMessageDialog(marco, " ingrese coordenadas en el formato 'A1', 'B2', etc.");
        }
    }

    private static void actualizarTablero() {
        StringBuilder display = new StringBuilder("  A B C\n");
        for (int i = 0; i < 3; i++) {
            display.append(i + 1).append(" ");
            for (int j = 0; j < 3; j++) {
                display.append(tablero[i][j] == ' ' ? "." : tablero[i][j]);
                if (j < 2) display.append("|");
            }
            display.append("\n");
            if (i < 2) display.append("  -----\n");
        }
        areaTablero.setText(display.toString());
    }

    private static boolean comprobarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) return true;
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) return true;
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) return true;
        return false;
    }

    private static boolean tableroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private static String getNombreJugadorActual() {
        return jugadorActual == 'X' ? jugador1 : jugador2;
    }

    private static void mostrarRecord() {
        JOptionPane.showMessageDialog(marco, "record actual:\n" +
                jugador1 + " (X): " + victoriasJugador1 + " victorias\n" +
                jugador2 + " (O): " + victoriasJugador2 + " victorias");
    }
}
