
package componentes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import componentes.Terreno;
import rsc.Process;

public class Char {

    private static int pBaseY, pTopY, pIniciaX, pFimX;
    private static int pTop, pBotao, pontoCima;

    private static boolean pontoMark;
    private static int fazPulo = 20;

    public static final int PARADO = 1, CORRENDO = 2, PULANDO = 3, MORRE = 4;
    private final int ESQUERDA = 1, DIREITA = 2, SEMPE = 3;

    private static int estado;

    private int pe;

    static BufferedImage image;
    BufferedImage peEsquerdo;
    BufferedImage peDireito;
    BufferedImage morto;

    public Char() {
        //Carrega as imagens a partir do BufferedImage
        image = new Process().getResourceImage("../img/empe1.png");
        peEsquerdo = new Process().getResourceImage("../img/esquerdo1.png");
        peDireito = new Process().getResourceImage("../img/direito1.png");
        morto = new Process().getResourceImage("../img/morre1.png");

        pBaseY = Terreno.TERRENO_Y + 5;// Define o limite da Base Y
        pTopY = Terreno.TERRENO_Y - image.getHeight() + 5;// Define a posição do personagem em relação ao terreno
        pIniciaX = 100;// Define a posição no eixo X que o personagem inicia o jogo
        pFimX = pIniciaX + image.getWidth();
        pontoCima = pTopY - 120; // Define a altura do pulo do personagem

        estado = 1;
        pe = SEMPE;
    }

    public void create(Graphics g) {
        pBotao = pTop + image.getHeight();

        switch (estado) {
            //Segundo cada estado do personagem, as medidas definem o loop, e a posição que a imagem vai tomar.

            case PARADO:
                System.out.println("PARADO !");
                g.drawImage(image, pIniciaX, pTopY, null);
                break;

            case CORRENDO:
                if (pe == SEMPE) {
                    pe = ESQUERDA;
                    g.drawImage(peEsquerdo, pIniciaX, pTopY, null);
                } else if (pe == ESQUERDA) {
                    pe = DIREITA;
                    g.drawImage(peDireito, pIniciaX, pTopY, null);
                } else {
                    pe = ESQUERDA;
                    g.drawImage(peEsquerdo, pIniciaX, pTopY, null);
                }
                break;

            case PULANDO:
                if (pTop > pontoCima && !pontoMark) {
                    g.drawImage(image, pIniciaX, pTop -= fazPulo, null);
                    break;
                }
                if (pTop >= pontoCima && !pontoMark) {
                    pontoMark = true;
                    g.drawImage(image, pIniciaX, pTop += fazPulo, null);
                    break;
                }
                if (pTop > pontoCima && pontoMark) {
                    if (pTopY == pTop && pontoMark) {
                        estado = CORRENDO;
                        pontoMark = false;
                        break;
                    }
                    g.drawImage(image, pIniciaX, pTop += fazPulo, null);
                    break;
                }
            case MORRE:
                g.drawImage(morto, pIniciaX, pTop, null);
                break;
        }
    }

    public void morre() {
        estado = MORRE; // Atribui o estado morto
    }

    public static Rectangle srcChar() { // Define a caixa ou "Retangulo" da área do personagem.
        Rectangle psgm = new Rectangle();
        psgm.x = pIniciaX;

        if (estado == PULANDO && !pontoMark) {
            psgm.y = pTop - pontoCima;
        } else if (estado == PULANDO && pontoMark) {
            psgm.y = pTop + pontoCima;
        } else if (estado != PULANDO) {
            psgm.y = pTop;
        }

        psgm.width = image.getWidth();
        psgm.height = image.getHeight();

        return psgm;
    }

    public void iniciaCorre() {
        pTop = pTopY;
        estado = CORRENDO;
    }

    public void pula() {
        pTop = pTopY;
        pontoMark = false;
        estado = PULANDO;
    }

    private class pImages {

    }

}
