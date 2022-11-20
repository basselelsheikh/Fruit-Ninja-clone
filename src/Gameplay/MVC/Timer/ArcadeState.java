/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC.Timer;

import Gameplay.MVC.GameController;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author TheANARXIST
 */
public class ArcadeState extends State {

    GameController gameController = GameController.getInstance();
    
    public ArcadeState() {
        time = new TimeClass(5,0,0); //timer is set to 5 minutes
        timer = new Timer(250, (ActionEvent evt) -> {
            time.decreaseTime();
            if(time.isTimeUp()){
                timer.stop();
                gameController.endGame();
            }
            gameController.UpdateView();
        });
    }
    
    
}
