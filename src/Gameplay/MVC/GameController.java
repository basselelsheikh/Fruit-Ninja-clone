/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay.MVC;

import gui.GameFrame;

/**
 *
 * @author TheANARXIST
 *
 * Controls time, lives, and score
 */
public class GameController {

    //private final XMLHandler xmlHandler;
    private final GameData model;
    private final GameView view;

    private static GameController instance = null;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController(new GameData(), new GameView());
        }
        return instance;
    }

    private GameController(GameData model, GameView view) {
        this.model = model;
        this.view = view;
        //this.xmlHandler = XMLHandler.getInstance();
    }

    public void newGame(String player_name) {
        model.newGame(player_name);
        this.startTimer();
        this.UpdateView();
        view.startGameTimer();
    }

    public void loadGame(String player_name, int score,int chighscore,int ahighscore, int life) {
        model.loadGame(player_name, score,chighscore,ahighscore, life);
        this.startTimer();
        this.UpdateView();
        view.startGameTimer();
    }

    public String getName() {
        return model.getPlayer_name();
    }

    public int getClassicHighScore() {
        return model.getClassicHighScore();
    }

    public int getArcadeHighScore() {
        return model.getArcadeHighScore();
    }

    public int getLives() {
        return model.getLives();
    }

    public GameFrame getGameFrame() {
        return view.getGameFrame();
    }

    public GameFrame newGameFrame() {
        return view.newGameFrame();
    }

    public void IncScore(int score) {
        model.setScore(model.getScore() + score);
        if (model.getScore() > model.getClassicHighScore() && model.getMode() == 0) {
            model.setClassicHighScore(model.getScore());
        }
        if (model.getScore() > model.getArcadeHighScore() && model.getMode() == 1) {
            model.setArcadeHighScore(model.getScore());
        }
    }

    public void DecScore(int score) {
        int h_score = model.getScore();
        model.setScore(model.getScore() - score);
        if (model.getScore() < 0) {
            model.setScore(0);
        }
        if (h_score == model.getClassicHighScore()) {
            model.setClassicHighScore(model.getScore());
        }
    }

    public void DecrementLives() {
        model.setLives(model.getLives() - 1);
        if (model.getLives() == 0) {
            this.endGame();
        }
    }

    public void IncrementLives() {
        model.setLives(model.getLives() + 1);
    }

    public void EndLives() {
        model.setLives(0);
        this.endGame();
    }

    public void setGameArcade() {
        model.setTimerArcade();
        view.setGUIArcade();
        view.setMode(1);
        model.setMode(1);
    }

    public void setGameClassic() {
        model.setTimerClassic();
        view.setGUIClassic();
        view.setMode(0);
        model.setMode(0);
    }

    public void startTimer() {
        model.startTimer();
    }

    public void stopTimer() {
        model.stopTimer();
    }

    public void setHighScore(int highScore) {
        model.setClassicHighScore(highScore);
    }

    public void stopTimers() {
        this.UpdateView();
        this.stopTimer();
        this.view.stopGameTimer();
    }

    public void resumeTimers() {
        this.UpdateView();
        this.startTimer();
        this.view.resumeGameTimer();
    }
    
    public void endGame() {
        this.stopTimers();
        this.getGameFrame().endGame();
    }

    //need to fix this as the gamePanel is data
    //or maybe not, I'll have to think about it later
    public void setDiffState(int state) {
        view.setDiffState(state);
    }

    public int getScore() {
        return model.getScore();
    }
    
    public void UpdateView() {
        int highScore = 0;
        switch (model.getMode()) {
            case 0:
                highScore = model.getClassicHighScore();
                break;
            case 1:
                highScore = model.getArcadeHighScore();
                break;
        }
        view.updateGUI(model.getScore(), highScore, model.getTime(), model.getLives());
    }
}
