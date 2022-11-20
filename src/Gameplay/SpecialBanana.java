/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class SpecialBanana extends SpecialFruit implements IGameObject {
    
    public SpecialBanana(int x, int y) {
        super(x, y);
         this.fruitImageInit = new ImageIcon("images/fn_banana.png");
        this.fruitImageSliced = new ImageIcon("images/fn_banana_sliced.png");
        this.currentImage = this.fruitImageInit;
    }

    @Override
    public GameObjects getObjectType() {
        return GameObjects.SPECIALBANANA;
    }

    @Override
    public int getInitialVelocity() {
       return 8;
    }

    @Override
    public int getFallingVelocity() {
        return 16;
    }

    @Override
    public void move() {
    }

    @Override
    public ImageIcon getBufferedImage() {
        return this.currentImage;
    }

    @Override
    public void setYLocation(int newy) {
       y=newy;
    }

    @Override
    public void setXLocation(int newx) {
        x=newx;
    }

    @Override
    public int getYLocation() {
       return y;
    }

    @Override
    public int getXLocation() {
    return x;
    }

    @Override
     public void setMovedOff(boolean b) {
        movedoffScreen = b;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return movedoffScreen;
    }
   
    
}
