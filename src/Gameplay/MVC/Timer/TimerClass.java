/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC.Timer;

/**
 *
 * @author TheANARXIST
 * 
 * Uses state pattern to determine whether
 * it's a regular timer or an arcade mode
 * countdown timer
 * 
 */
public class TimerClass {
    
    //this is the timer state: it could either be arcade or classic
    private State state = null;

    public TimerClass(State state) {
        this.state = state;
    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public void startTimer () {
        this.state.startTimer();
    }
    
    public void stopTimer () {
        this.state.stopTimer();
    }
    
    public TimeClass getTime() {
        return state.getTime();
    }
}
