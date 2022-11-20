/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author beso_
 */
public class Music {

    private String filename;
    private Player player;

    public Music(String filename) {
        this.filename = filename;
    }

    public void playBackgroundMusic() {
        try {
            while (true) {
                BufferedInputStream buffer = new BufferedInputStream(
                        new FileInputStream(filename));
                player = new Player(buffer);
                player.play();

            }

        } catch (FileNotFoundException | JavaLayerException e) {

            JOptionPane.showMessageDialog(null, "can't find audio file");
        }

    }

    public void play() {
        try {

            BufferedInputStream buffer = new BufferedInputStream(
                    new FileInputStream(filename));
            player = new Player(buffer);
            player.play();

        } catch (FileNotFoundException | JavaLayerException e) {

            JOptionPane.showMessageDialog(null, "can't find audio file");
        }

    }

}
