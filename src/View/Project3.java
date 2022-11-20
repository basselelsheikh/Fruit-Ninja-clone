/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Gameplay.Music;
import gui.MainMenuWindow;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author TheANARXIST
 *
 */
public class Project3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, UnsupportedAudioFileException {

// Point p =MouseInfo.getPointerInfo().getLocation();
//       p=new Point(p.x,p.y);
//               System.out.println(p.x +"\n"+ p.y);
        Music background_music = new Music("game_music.mp3");
        new MainMenuWindow().setVisible(true);
        background_music.playBackgroundMusic();

    }

}
