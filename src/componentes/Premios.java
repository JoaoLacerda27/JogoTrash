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

public class Premios {

    private class Premio {

        BufferedImage image;
        int x;
        int y;

        Rectangle getObstacle() {//Define o retangulo dos premios
            Rectangle premio = new Rectangle();
            premio.x = x;
            premio.y = y;
            premio.width = image.getWidth();
            premio.height = image.getHeight();

            return premio;
        }
    }

    private int primeiro;
    private int tempoPremio;
    private int veloMove;

    private ArrayList<BufferedImage> imagens1;
    private ArrayList<Premio> premios;

    private Premio bloqueio;

    public Premios(int priPosicao) {

        premios = new ArrayList<Premio>();
        imagens1 = new ArrayList<BufferedImage>();

        primeiro = priPosicao;
        tempoPremio = 370;//Distância entre os prêmios
        veloMove = 10;// Velocidade que os prêmios se movem na direção do personagem

        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));
        imagens1.add(new Process().getResourceImage("../img/Garrafa1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lata1.png"));
        imagens1.add(new Process().getResourceImage("../img/Lixo1.png"));

        int x = primeiro + 2; //Define primeira posição no eixo X
        
        
        //Carrega a primeira Array dos premios    
        for (BufferedImage bi : imagens1) {

            Premio ob = new Premio();

            ob.image = bi;
            ob.x = x;
            ob.y = Terreno.TERRENO_Y - bi.getHeight() + 5;
            x += tempoPremio;

            premios.add(ob);
        }
    }

    public void atualiza() {
        Iterator<Premio> repetidor = premios.iterator();//Acessa sequencialmente os elementos de um objeto agregado

        Premio primeiroPremio = repetidor.next();
        primeiroPremio.x -= veloMove;

        while (repetidor.hasNext()) {//Cria o repetidor
            Premio ob = repetidor.next();
            ob.x -= veloMove;
        }

        Premio ultimoPremio = premios.get(premios.size() - 1);

        if (primeiroPremio.x < -primeiroPremio.image.getWidth()) {
            premios.remove(primeiroPremio);
            primeiroPremio.x = premios.get(premios.size() - 1).x + tempoPremio;
            premios.add(primeiroPremio);
        }
    }

    public void create(Graphics g) {
        //Cria na tela as imagens dos premios apartir do método Graphics
        for (Premio ob : premios) {
            g.setColor(Color.black);
            g.drawImage(ob.image, ob.x, ob.y, null);
        }
    }

    public boolean colisao() {
        //Condição, caso o personagem colida com o premio atribui um valor lógico
        for (Premio ob : premios) {
            if (Char.srcChar().intersects(ob.getObstacle())) {
                ob.x = 100000;//Caso colida o premio some dando a sensação de coleta
                System.out.println("Personagem = " + Char.srcChar() + "\nPrêmio = " + ob.getObstacle() + "\n\n");
                return true;// importante para a memorização da pontuação
            }
        }
        return false;
    }

    public void resume() {
        int x = primeiro / 15;
        premios = new ArrayList<Premio>();
        // Faz o jogo voltar a funcionar a pós a colisão, posicionando novamente o Array com os premios
        for (BufferedImage bi : imagens1) {

            Premio ob = new Premio();
            
            ob.image = bi;
            ob.x = x;
            ob.y = Terreno.TERRENO_Y - bi.getHeight() + 5;
            x += tempoPremio;

            premios.add(ob);
        }
    }

}
