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
public interface IGameObject {

    /**
     * @return the type of game object
     */
    public GameObjects getObjectType();

    /*
* @return X location of game object
     */
    public int getXlocation();

    /*
* @return Y location of game object
     */
    public int getYlocation();

    /*
* @return max Y location that the object can reach on the screen
     */
    public int getMaxHeight();

    /*
* @return velocity at which game object is thrown
     */
    public int getInitialVelocity();

    /*
* @return failing velocity of game object
     */
    public int getFallingVelocity();

    /*
* @return whether the object is sliced or not
     */
    public Boolean isSliced();

    /*
* @return whether the object is dropped off the screen or not
     */
    public Boolean hasMovedOffScreen();

    /*
*it is used to slice the object
     */
    public void slice();

    /*
*it is used to move the object on the screen
@param deltaTime: time elapsed since the object is thrown
it is used calculate the new position of
fruit object.
     */
    public void move();

    /*
* @return at least two images of the object, one when it is
sliced and one when it is not.
     */
    public ImageIcon getBufferedImage();

    public boolean isMovingUp();

    public void setMovingUp(boolean movingUp);

    public void setYLocation(int newy);

    public void setXLocation(int newx);

    public int getYLocation();

    public int getXLocation();

    public void setMovedOff(boolean b);
}
