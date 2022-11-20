/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import javax.swing.ImageIcon;

/**
 *
 * @author TheANARXIST
 */
public class Fruit extends GameObjectParent {

    int score;
    ImageIcon fruitImageSliced;
    DifficultyState diffState;
    int mode;

    public Fruit(int x, int y, int state, int mode) {
        super(x, y);
        score = 50;
        this.mode = mode;
        switch (state) {
            case 0:
                diffState = new Easy();
                break;
            case 1:
                diffState = new Medium();
                break;
            case 2:
                diffState = new Hard();
                break;

        }
    }

    public int getInitialVelocity() {
        return this.diffState.getInitVelocity();
    }

    public int getFallingVelocity() {
        return this.diffState.getFallingVelocity();
    }

    public void slice() {
        this.sliced = true;
        this.gameController.IncScore(this.score);
        //this.gameController.UpdateView();
        this.currentImage = fruitImageSliced;
    }
    
    public Boolean hasMovedOffScreen() {
        if (movedoffScreen && !sliced && mode == 0) {
            this.gameController.DecrementLives();
        }
        return movedoffScreen;
    }

}
