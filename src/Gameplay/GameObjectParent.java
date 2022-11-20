package Gameplay;

import Gameplay.MVC.GameController;
import javax.swing.ImageIcon;

public abstract class GameObjectParent {

    GameController gameController;
    
    ImageIcon fruitImageInit;
    ImageIcon currentImage;
    boolean movedoffScreen = false;
    boolean movingUp = true;
    boolean sliced = false;
    int x, y;
    
    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public GameObjectParent(int x, int y) {
        this.gameController = GameController.getInstance();
        this.x = x;
        this.y = y;
    }

    public int getXlocation() {
        return x;
    }

    public int getYlocation() {
        return y;
    }

    public Boolean isSliced() {
        return sliced;
    }

    public int getMaxHeight() {
        return 20;
    }
}
