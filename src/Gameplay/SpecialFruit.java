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
public abstract class SpecialFruit extends GameObjectParent {
    
   int score;
    ImageIcon fruitImageSliced;

    public SpecialFruit(int x, int y) {
        super(x, y);
        score = 200;

    }

    public void slice() {
        this.sliced = true;
        this.gameController.IncScore(this.score);
        gameController.IncrementLives();
        //this.gameController.UpdateView();
        this.currentImage = fruitImageSliced;
    }

}
