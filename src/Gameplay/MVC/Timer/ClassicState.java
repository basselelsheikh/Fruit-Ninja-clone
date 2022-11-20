/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC.Timer;

import Gameplay.MVC.GameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author TheANARXIST
 */
public class ClassicState extends State {

    GameController gameController = GameController.getInstance();

    public ClassicState() {
        time = new TimeClass(0,0,0);
        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time.increaseTime();
                gameController.UpdateView();
            }
        });
    }
}
