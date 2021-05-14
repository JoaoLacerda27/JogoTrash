package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import componentes.Char;
import componentes.Terreno;
import rsc.Process;

public class Obstaculos {

    private class Obstaculo {

        BufferedImage image;
        int x;
        int y;

        Rectangle getObstacle() { //Define o retangulo dos obstáculos, importante para a colisão
            Rectangle obstaculo = new Rectangle();
            obstaculo.x = x;
            obstaculo.y = y;
            obstaculo.width = image.getWidth();
            obstaculo.height = image.getHeight();

            return obstaculo;
        }
    }

    private int primeiro;
    private int tempoObstaculo;
    private int veloMove;

    private ArrayList<BufferedImage> imagens1;
    private ArrayList<Obstaculo> inimigos;

    private Obstaculo bloqueio;

    public Obstaculos(int priPosicao) {
        inimigos = new ArrayList<Obstaculo>();
        imagens1 = new ArrayList<BufferedImage>();

        primeiro = priPosicao;
        tempoObstaculo = 370;//Distância entre os obstáculos 
        veloMove = 10; // Velocidade que os obstáculos se movem na direção do personagem

        imagens1.add(new Process().getResourceImage("../img/rocha.png"));
        imagens1.add(new Process().getResourceImage("../img/Obs1.png"));
        imagens1.add(new Process().getResourceImage("../img/toco.png"));
        imagens1.add(new Process().getResourceImage("../img/arvore.png"));
        imagens1.add(new Process().getResourceImage("../img/graveto.png"));

        int x = primeiro;
        
        //Carrega a primeira Array dos Obstaculos
        for (BufferedImage bi : imagens1) {

            Obstaculo ob = new Obstaculo();

            ob.image = bi;
            ob.x = x;
            ob.y = Terreno.TERRENO_Y - bi.getHeight() + 6;
            x += tempoObstaculo;

            inimigos.add(ob);
        }
    }

    public void atualiza() {
        Iterator<Obstaculo> repetidor = inimigos.iterator();//Acessa sequencialmente os elementos de um objeto agregado

        Obstaculo primeiroObstaculo = repetidor.next();
        primeiroObstaculo.x -= veloMove;

        while (repetidor.hasNext()) {//Cria o repetidor
            Obstaculo ob = repetidor.next();
            ob.x -= veloMove;
        }

        Obstaculo ultimoObstaculo = inimigos.get(inimigos.size() - 1);

        if (primeiroObstaculo.x < -primeiroObstaculo.image.getWidth()) {
            inimigos.remove(primeiroObstaculo);
            primeiroObstaculo.x = inimigos.get(inimigos.size() - 1).x + tempoObstaculo;
            inimigos.add(primeiroObstaculo);
        }
    }

    public void create(Graphics g) {
        //Cria na tela as imagens dos obstaculos apartir do método Graphics
        for (Obstaculo ob : inimigos) {
            g.setColor(Color.black);
            g.drawImage(ob.image, ob.x, ob.y, null);
        }
    }

    public boolean colisao() {
        //Condição, caso o personagem colida com o obstaculo atribui um valor lógico 
        for (Obstaculo ob : inimigos) {
            if (Char.srcChar().intersects(ob.getObstacle())) {
                System.out.println("Personagem = " + Char.srcChar() + "\nObstaculo = " + ob.getObstacle() + "\n\n");
                bloqueio = ob;
                return true; //Verdadeiro para colisão
            }
        }
        return false;//Valor padrão de falso para colisão
    }

    public void resume() {
        // Faz o jogo voltar a funcionar apartir da colisão, posicionando novamente o Array com os obstaculos
        int x = primeiro / 2;
        inimigos = new ArrayList<Obstaculo>();

        for (BufferedImage bi : imagens1) {

            Obstaculo ob = new Obstaculo();

            ob.image = bi;
            ob.x = x;
            ob.y = Terreno.TERRENO_Y - bi.getHeight() + 5;
            x += tempoObstaculo;

            inimigos.add(ob);
        }
    }

}
