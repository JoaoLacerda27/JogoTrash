
package jogo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


class AudioAcerto {

    void AudioAcerto() { //Método AudioAcerto para chamar na classe executavel.
        try {
            //Carrega o arquivo do audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/img/Audio.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //Faz o loop do som.
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
}
