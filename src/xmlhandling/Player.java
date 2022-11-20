/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlhandling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author beso_
 */
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    private String name;
    private int difficulty;
    private int lives;
    private int classicHighScore;
    private int mode;
    private int arcadeHighScore;
    private int score;

    public Player() {
    }

    public Player(String name, int difficulty, int mode) {
        this.name = name;
        this.difficulty = difficulty;
        this.mode = mode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getClassicHighScore() {
        return classicHighScore;
    }

    public int getArcadeHighScore() {
        return arcadeHighScore;
    }

    public void setClassicHighscore(int classicHighScore) {
        this.classicHighScore = classicHighScore;
    }

    public void setArcadeHighscore(int arcadeHighScore) {
        this.arcadeHighScore = arcadeHighScore;
    }
}
