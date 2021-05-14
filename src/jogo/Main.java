/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main {

    JFrame janelaPrincipal = new JFrame("Trash in the Jungle !");
    //Valores de dimensão para o JFrame e o JPanel
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public void principalGame() {
        //Definições do Panel e Frame
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = janelaPrincipal.getContentPane();

        Comandos painel = new Comandos();
        painel.addKeyListener(painel);
        painel.setFocusable(true);

        container.setLayout(new BorderLayout());

        container.add(painel, BorderLayout.CENTER);

        janelaPrincipal.setSize(WIDTH, HEIGHT);
        janelaPrincipal.setResizable(false);
        janelaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {

        AudioAcerto y = new AudioAcerto(); // Chamando a classe aonde está o audio.
        y.AudioAcerto(); // Chamando o método do audio

        javax.swing.SwingUtilities.invokeLater(new Runnable() { //Pronta para ser executada
            public void run() { // Chama o método run e executa as Threads
                new Main().principalGame();
            }
        });
    }

}
