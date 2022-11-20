/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import Gameplay.IGameObject;

/**
 *
 * @author OWNER 2
 */
public class MouseListener implements MouseMotionListener {

    GamePanel g;

    public MouseListener(GamePanel g) {
        this.g = g;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        /*
        Point p =MouseInfo.getPointerInfo().getLocation();
        p=new Point(p.x,p.y);
        System.out.println(p.x +"\n"+ p.y);
         */
        int x = e.getX();
        int y = e.getY();
        //System.out.println(x + "     " + y);

        for (IGameObject obj : g.getGameObjects()) {
            if (x >= obj.getXLocation() && x <= obj.getXLocation()
                    + obj.getBufferedImage().getIconWidth()) {
                if (y >= obj.getYLocation() && y <= obj.getYLocation()
                        + obj.getBufferedImage().getIconHeight()) {
                    if (!obj.isSliced()) {
                        obj.setMovingUp(false);
                        obj.slice();
                    }
                }
            }

        }
    }

}
