/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author TheANARXIST
 */
public class FatalBomb extends GameObjectParent implements IGameObject {

    private FatalBombState fatalBombState;

    public FatalBomb(int x, int y, int state) {
        super(x, y);
        this.fruitImageInit = new ImageIcon("images/fn_bomb_2.png");
        this.currentImage = this.fruitImageInit;
        if (state == 0) {
            fatalBombState = new FatalBombClassic();
        } else if (state == 1) {
            fatalBombState = new FatalBombArcade();
        }
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return movedoffScreen;
    }

    @Override
    public void slice() {
        this.sliced = true;
        fatalBombState.slice();
    }

    @Override
    public GameObjects getObjectType() {
        return GameObjects.FATALBOMB;
    }

    @Override
    public int getInitialVelocity() {
        return 1;
    }

    @Override
    public int getFallingVelocity() {
        return 2;
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

    @Override
    public void setYLocation(int newy) {
        y = newy;
    }

    @Override
    public int getYLocation() {
        return y;
    }

    @Override
    public void setXLocation(int newx) {
        x = newx;
    }

    @Override
    public int getXLocation() {
        return x;
    }

    @Override
    public void setMovedOff(boolean b) {
        movedoffScreen = b;
    }

    /*@Override
    public void move() {
        if (this.y < 20) {
            System.out.println("Going down" + y);
            y += this.getFallingVelocity();
            if (this.y > 800) {
                movedoffScreen = true;
            }
        } else {
            this.y -= this.getInitialVelocity();
        }
    }*/
}
