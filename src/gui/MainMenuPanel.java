/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author beso_
 */
public class MainMenuPanel extends JPanel {

    private final ImageIcon background = new ImageIcon("images/fn_background.png");
    private final ImageIcon title = new ImageIcon("images/title.png");

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, this);
        g.drawImage(title.getImage(), 200, 70, this);

    }
}
