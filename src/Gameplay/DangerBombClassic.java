/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import Gameplay.MVC.GameController;

/**
 *
 * @author DELL
 */
public class DangerBombClassic implements DangerBombState{
    GameController gameController = GameController.getInstance();


    @Override
    public void slice() {
     gameController.DecrementLives();
    }
    
}
