package Gameplay;

import java.util.Random;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author OWNER 2
 */
public class Lemon extends Fruit implements IGameObject {

    public Lemon(int x, int y, int state, int mode) {
        super(x, y, state, mode);
        this.fruitImageInit = new ImageIcon("images/fn_lemon.png");
        this.fruitImageSliced = new ImageIcon("images/fn_lemon_2_halves.png");
        this.currentImage = this.fruitImageInit;
    }

    @Override
    public GameObjects getObjectType() {
        return GameObjects.LEMON;
    }

    @Override
    public ImageIcon getBufferedImage() {
        return this.currentImage;
    }

    public int getrandomangle() {
        double degree;
        Random d = new Random();
        degree = d.nextInt(101) - 50;
        degree = Math.toRadians(degree);
        return (int) degree;
    }
    int degree = getrandomangle();

    public void move() {
        if ((degree > 50.0) && (x == 0)) {
            x = (int) (x + 10 * Math.cos(degree));
            y = (int) (y + 10 * Math.sin(degree));
            if (y == 1080) {
                degree = -degree;
            }
        } else if ((degree > 50.0) && (x == 1080)) {
            x = (int) (x - 10 * Math.cos(degree));
            y = (int) (y + 10 * Math.sin(degree));
            if (y == 1080) {
                degree = -degree;
            }
        }
        if ((degree < 50.0) && (x == 0)) {
            x = (int) (x + 10 * Math.cos(degree));
            y = (int) (y - 10 * Math.sin(degree));
        }
        if ((degree < 50.0) && (x == 1080)) {
            x = (int) (x - 10 * Math.cos(degree));
            y = (int) (y - 10 * Math.sin(degree));
        }

    }

    /*@Override
    public void move() {
        if (this.y < 20) {
            this.y += this.getFallingVelocity();
            if (this.y > 800) {
                movedoffScreen = true;
            }
        } else {
            this.y -= this.getInitialVelocity();
        }
    }*/
    @Override
    public void setYLocation(int newy) {
        y = newy;
    }

    @Override
    public int getYLocation() {
        return y;
    }

    @Override
    public void setXLocation(int newX) {
        x = newX;
    }

    @Override
    public int getXLocation() {
        return x;
    }

    @Override
    public void setMovedOff(boolean b) {
        movedoffScreen = b;
    }
}
