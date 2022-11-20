/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC.Timer;

import javax.swing.Timer;

/**
 *
 * @author TheANARXIST
 */
public abstract class State {
    
    Timer timer;
    TimeClass time;
    
    public void startTimer() {
        timer.start();
    }
    
    public void stopTimer() {
        timer.stop();
    }
    
    public TimeClass getTime() {
        return time;
    }
}
