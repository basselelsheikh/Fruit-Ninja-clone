/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

/**
 *
 * @author TheANARXIST
 */
public abstract class DifficultyState {

    int initVelocity;
    int fallingVelocity;

    public int getInitVelocity() {
        return initVelocity;
    }

    public int getFallingVelocity() {
        return fallingVelocity;
    }

}
