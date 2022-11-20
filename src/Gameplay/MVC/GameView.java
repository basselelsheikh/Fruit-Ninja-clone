/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC;

import Gameplay.MVC.Timer.TimeClass;
import gui.GameFrame;

/**
 *
 * @author TheANARXIST
 *
 * For use to display score, time and lives via GUI
 *
 */
public class GameView {

    private GameFrame gameFrame;

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public GameFrame newGameFrame() {
        this.gameFrame = new GameFrame();
        return gameFrame;
    }

    public void updateGUI(int score, int highScore, TimeClass time, int lives) {
        gameFrame.setCurrentScore(score);
        gameFrame.setHighScore(highScore);
        gameFrame.setTime(time);
        gameFrame.setLives(lives);
    }

    void setGUIArcade() {
        gameFrame.hideLives();
    }

    void setGUIClassic() {
        gameFrame.showLives();
    }

    void startGameTimer() {
        this.gameFrame.startGameTimer();
    }
    
    void resumeGameTimer() {
        this.gameFrame.resumeGameTimer();
    }

    void setDiffState(int state) {
        this.gameFrame.setDiffState(state);
    }

    void setMode(int mode) {
        this.gameFrame.setMode(mode);
    }

    void stopGameTimer() {
        this.gameFrame.stopGameTimer();
    }
}
