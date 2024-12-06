/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectolab;

/**
 *
 * @author sandr
 */
import javax.swing.*;
import java.awt.*;

public class JuegoTableroVisual {
    private static String usuarioActual = null;
    private static UsuarioManager usuarioManager = new UsuarioManager();
    private static Tablero tablero;

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        JFrame frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(4, 1));

        JButton botonRegistro = crearBotonMenu("Registrar", Color.WHITE, Color.RED);
        JButton botonLogin = crearBotonMenu("Iniciar Sesión", Color.WHITE, Color.RED);
        JButton botonIniciarJuego = crearBotonMenu("Iniciar Juego", Color.WHITE, Color.RED);
        JButton botonRecord = crearBotonMenu("Ver Record", Color.WHITE, Color.RED);

        botonRegistro.addActionListener(e -> usuarioManager.registrarUsuario());
        botonLogin.addActionListener(e -> {
            usuarioActual = usuarioManager.iniciarSesion();
        });
        botonIniciarJuego.addActionListener(e -> {
            if (usuarioActual != null) {
                frame.dispose();
                seleccionarModoJuego();
            } else {
                JOptionPane.showMessageDialog(frame, "Debe iniciar sesión para jugar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        botonRecord.addActionListener(e -> usuarioManager.mostrarRecords());

        frame.add(botonRegistro);
        frame.add(botonLogin);
        frame.add(botonIniciarJuego);
        frame.add(botonRecord);

        frame.setVisible(true);
    }

    private static JButton crearBotonMenu(String texto, Color colorTexto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setForeground(colorTexto);
        boton.setBackground(colorFondo);
        boton.setFocusPainted(false);
        return boton;
    }

    private static void seleccionarModoJuego() {
        String[] modos = {"Normal", "Difícil", "Genius"};
        int modoSeleccionado = JOptionPane.showOptionDialog(
                null, "Selecciona un modo de juego", "Modos de Juego",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, modos, modos[0]
        );

        if (modoSeleccionado < 0) {
            JOptionPane.showMessageDialog(null, "No seleccionaste un modo. Saliendo del juego.");
            return;
        }

        String modo = modos[modoSeleccionado].toLowerCase();
        tablero = new Tablero(6, usuarioActual, usuarioManager);
        tablero.inicializarJuego(modo);
        tablero.crearTableroVisual();
    }
}
