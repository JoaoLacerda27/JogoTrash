package componentes;

import rsc.Process;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;

public class Terreno {

    private class TerrenoImagem {

        BufferedImage image, fundo;
        int x;
    }

    public static int TERRENO_Y;

    private BufferedImage image, bg;

    private ArrayList<TerrenoImagem> terrenoImageSet;

    public Terreno(int panelHeight) {
        TerrenoImagem img = new TerrenoImagem();
        img.fundo = bg;//Atribui ao Buffer fundo a variável BG
        TERRENO_Y = (int) (panelHeight - 0.12 * panelHeight);//Define a posição do terreno em relação ao fundo

        try {
            image = new Process().getResourceImage("../img/terreno3.png"); //Carrega a imagem do terreno no Buffered
        } catch (Exception e) {
            e.printStackTrace();
        }

        terrenoImageSet = new ArrayList<TerrenoImagem>();

        bg = new Process().getResourceImage("../img/BG1.png");//Carrega a imagem na variável BG
        

        //Primeira Imagem do chão
        for (int i = 0; i < 3; i++) {
            TerrenoImagem obj = new TerrenoImagem();
            obj.image = image;
            obj.x = 0;
            terrenoImageSet.add(obj);

        }
    }

    public void atualiza() {
        Iterator<TerrenoImagem> repetidor = terrenoImageSet.iterator();//Acessa sequencialmente os elementos do objeto agregado
        TerrenoImagem primeiro = repetidor.next();

        primeiro.x -= 10; //Define a velocidade em que o chão se movimenta pelo eixo X

        int pontoX = primeiro.x;
        while (repetidor.hasNext()) {
            //faz o loop do chão na tela 
            TerrenoImagem proximo = repetidor.next();
            proximo.x = pontoX + image.getWidth();
            pontoX = proximo.x;
        }
            //Não deixa a imagem do terreno acabar, vai adicionando uma atrás da outra
        if (primeiro.x < -image.getWidth()) {
            terrenoImageSet.remove(primeiro);
            primeiro.x = pontoX + image.getWidth();
            terrenoImageSet.add(primeiro);
        }

    }

    public void create(Graphics g) {
        g.drawImage(bg, 0, 0, null);//Posiciona o fundo (background arvores)
        //Desenha o terreno(chão) pelo método Graphics 
        for (TerrenoImagem img : terrenoImageSet) {
            g.drawImage(img.image, (int) img.x, TERRENO_Y, null);

        }

    }
}
