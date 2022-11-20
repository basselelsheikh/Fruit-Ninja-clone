/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author beso_
 */
public class MainMenu {

    ImageIcon title = new ImageIcon("images/title.png");
    ImageIcon newgame = new ImageIcon("images/newgame.png");
    ImageIcon loadgame = new ImageIcon("images/loadgame.png");
    ImageIcon exit = new ImageIcon("images/exit.png");


    public void render(Graphics g, ImageObserver io) {

g.drawImage(title.getImage(), 200,60, io);
g.drawImage(newgame.getImage(), 350,175, io);
g.drawImage(loadgame.getImage(), 350,285, io);
g.drawImage(exit.getImage(), 350,395, io);

    }

    public ImageIcon getTitle() {
        return title;
    }

    public void setTitle(ImageIcon title) {
        this.title = title;
    }

    public ImageIcon getNewgame() {
        return newgame;
    }

    public void setNewgame(ImageIcon newgame) {
        this.newgame = newgame;
    }

    public ImageIcon getLoadgame() {
        return loadgame;
    }

    public void setLoadgame(ImageIcon loadgame) {
        this.loadgame = loadgame;
    }

    public ImageIcon getExit() {
        return exit;
    }

    public void setExit(ImageIcon exit) {
        this.exit = exit;
    }
    
}
