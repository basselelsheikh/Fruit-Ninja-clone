/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC;

import Gameplay.MVC.Timer.ArcadeState;
import Gameplay.MVC.Timer.ClassicState;
import Gameplay.MVC.Timer.State;
import Gameplay.MVC.Timer.TimeClass;
import Gameplay.MVC.Timer.TimerClass;
import xmlhandling.Player;

/**
 *
 * @author TheANARXIST
 */
public class GameData {

    private TimerClass timer;
    private int score;
    private int lives;
    private int mode;
    private int classicHighScore;
    private int arcadeHighScore;
    private String player_name;

    public TimerClass getTimer() {
        return timer;
    }

    public GameData() {
    }

    public void setTimer(TimerClass timer) {
        this.timer = timer;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void newGame(String name) {
        score = 0;
        lives = 3;
        this.player_name = name;
    }

    public void loadGame(String name, int score,int chighscore,int ahighscore, int life) {
        if (life == 0) {
            lives = 3;
            this.score=0;
        } else {
            lives = life;
            this.score=score;
        }
        
        if (mode == 0) {
            classicHighScore = chighscore;
        } else {
            arcadeHighScore = ahighscore;
        }
        this.player_name = name;

    }

    public int getClassicHighScore() {
        return classicHighScore;
    }

    public int getArcadeHighScore() {
        return arcadeHighScore;
    }

    public void setClassicHighScore(int classicHighScore) {
        this.classicHighScore = classicHighScore;

    }

    public void setArcadeHighScore(int arcadeHighScore) {
        this.arcadeHighScore = arcadeHighScore;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;

        if (lives > 3) {
            setLives(3);

        }
    }

    public void setTimerArcade() {
        timer = new TimerClass(new ArcadeState());
    }

    public void setTimerClassic() {
        timer = new TimerClass(new ClassicState());
    }

    public State getTimerState() {
        return timer.getState();
    }

    public void startTimer() {
        timer.startTimer();
    }

    public void stopTimer() {
        timer.stopTimer();
    }

    public TimeClass getTime() {
        return timer.getTime();
    }
}
