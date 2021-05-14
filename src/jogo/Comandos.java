
package jogo;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

//Importa os conteúdos necessários das outras classes
import componentes.Char;
import componentes.Obstaculos;
import componentes.Terreno;
import componentes.Premios;

class Comandos extends JPanel implements KeyListener, Runnable {//Herdan o JPanel e Implementa as Threads e Açoes do Teclado

    public static int WIDTH;
    public static int HEIGHT;
    private Thread animator; //Cria uma Thread

    private boolean correndo1 = false;
    private boolean gameOver = false;

    Terreno terreno;
    Char psgm;
    Obstaculos obstaculos;
    Premios premio;

    private int pontuacao, pontuacao1;
    private String bonus = "+50"; //Váriavel que apresenta o valor quando se coleta um lixo

    public Comandos() {
        WIDTH = Main.WIDTH;
        HEIGHT = Main.HEIGHT;

        terreno = new Terreno(HEIGHT);
        psgm = new Char();
        obstaculos = new Obstaculos((int) (WIDTH * 1.5));
        premio = new Premios((int) (WIDTH * 1.25));

        pontuacao = 0;

        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public void paint(Graphics g) {

        super.paint(g);//Chama para a superclass
        
        
        //Desenha os elementos gráficos na tela
        terreno.create(g);
        psgm.create(g);
        obstaculos.create(g);
        premio.create(g);
        //Atualiza o prêmio
        premio.atualiza();

        if (premio.colisao()) {
            //Faz o posicionamento e o recebimento do bonus após a coleta
            pontuacao += 50;
            g.setFont(new Font("Agency FB", Font.BOLD, 32));
            g.setColor(Color.white);
            g.drawString(bonus, getWidth() / 2 - 15, 190);
        }
        
        
        //Posiciona e printa a pontuação na tela
        g.setFont(new Font("Agency FB", Font.BOLD, 40));
        g.setColor(Color.white);
        g.drawString(Integer.toString(pontuacao), getWidth() / 2 - 4, 150);
        
        
        //Posiciona e printa o recorde na tela
        g.setFont(new Font("Agency FB", Font.BOLD, 23));
        g.setColor(Color.white);
        g.drawString(Integer.toString(pontuacao1), getWidth() / 1 - 48, 28);

    }

    public void run() {
        correndo1 = true;

        while (correndo1) {
            if (pontuacao <= 200) {
                //De acordo com a pontuação a ser alcançada define a velocidade de execução das Threads.
                att();
                repaint();
                try {  
                    Thread.sleep(65);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (pontuacao >= 200 && pontuacao <= 800) {
                att();
                repaint();
                try {
                    Thread.sleep(55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (pontuacao >= 800 && pontuacao <= 1500) {
                att();
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (pontuacao >= 1500 && pontuacao <= 4000) {
                att();
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                att();
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public void att() {
        //Atualiza o terreno e os obstáculos fazendo eles se repetirem
        pontuacao += 1;

        terreno.atualiza();
        obstaculos.atualiza();

        if (premio.colisao()) { //Relatório caso voce colete um lixo
            System.out.println("Recebe 50 !");
        }

        if (obstaculos.colisao()) {
            //Define o recorde
            if (pontuacao >= pontuacao1) {
                pontuacao1 = pontuacao;
            }

            psgm.morre();//Caso colida atribui o método morre ao personagem
            repaint();
            correndo1 = false;
            gameOver = true;
            System.out.println("Colidiu :(");
        }
    }

    public void reinicia() {
        //Reinicia o jogo após a colisão
        pontuacao = 0;//zera a pontuação
        System.out.println("Reiniciar !");
        obstaculos.resume();
        premio.resume();
        gameOver = false;
    }

    public void keyTyped(KeyEvent e) { // Define as ações da Tecla Espaço
        // System.out.println(e);
        if (e.getKeyChar() == ' ') {
            if (gameOver) {
                reinicia();
            }
            if (animator == null || !correndo1) {
                System.out.println("Começa o Game !");
                animator = new Thread(this);
                animator.start();
                psgm.iniciaCorre();
            } else {
                psgm.pula();
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        // System.out.println("keyPressed: "+e);
    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("keyReleased: "+e);
    }
}
