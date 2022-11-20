/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Gameplay.Fruit;
import Gameplay.GameObjectFactory;
import Gameplay.MainMenu;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import Gameplay.IGameObject;

/**
 *
 * @author OWNER 2
 */
public final class GamePanel extends JPanel implements ActionListener {

    private final ImageIcon backgroundImage;
    private final ArrayList<IGameObject> gameObjects;
    private final GameObjectFactory objectfactory;
    private final MainMenu menu;
    final Timer gameTimer;
    private int diffState;
    private int mode;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getDiffState() {
        return diffState;
    }

    public void setDiffState(int diffState) {
        this.diffState = diffState;
    }

    public GamePanel() {
        this.objectfactory = GameObjectFactory.getInstance();
        this.gameObjects = new ArrayList<>();
        this.backgroundImage = new ImageIcon("images/fn_background.png");
        this.gameTimer = new Timer(5, this);
        this.menu = new MainMenu();

        //for test purposes only - however, do not remove
        //To-Do: use controller
        MouseListener ml = new MouseListener(this);
        addMouseMotionListener(ml);
    }

    public void generateObjects() {
        int noOfShapes;
        Random r = new Random();
        noOfShapes = r.nextInt(4) + 1;
        for (int counter = 0; counter < noOfShapes; counter++) {
            IGameObject g = generateRandomObject();
            getGameObjects().add(g);
        }
    }

    public void generateSpecialFruit() {
        int noOfShapes;
        Random r = new Random();
        noOfShapes = r.nextInt(9) - 7;
        for (int counter = 0; counter < noOfShapes; counter++) {
            IGameObject g = generateRandomSpecialFruit();
            getGameObjects().add(g);
        }
    }

    public void generateBombs() {
        int noOfShapes;
        Random r = new Random();
        noOfShapes = r.nextInt(5) - 3;
        for (int counter = 0; counter < noOfShapes; counter++) {
            IGameObject g = generateRandomBomb();
            getGameObjects().add(g);
        }
    }

    public IGameObject generateRandomObject() {
        Random r = new Random();
        int x = r.nextInt(4);
        int y = r.nextInt(2);
        int x_position = r.nextInt(1050) + 10;
        switch (x) {
            case 0:
                return objectfactory.getGameObject("lemon", x_position, 648, diffState, mode);
            case 1: {
                return objectfactory.getGameObject("pineapple", x_position, 648, diffState, mode);
            }
            case 2: {
                return objectfactory.getGameObject("strawberry", x_position, 648, diffState, mode);
            }
            case 3: {
                return objectfactory.getGameObject("watermelon", x_position, 648, diffState, mode);
            }
            default:
                break;
        }
        return null;
    }

    public IGameObject generateRandomBomb() {
        Random r = new Random();
        int x = r.nextInt(2);
        int x_position = r.nextInt(1050) + 10;
        switch (x) {
            //will probably remove the state from here later too
            case 0: {
                return objectfactory.getGameObject("fatalbomb", x_position, 648, diffState, mode);
            }
            case 1: {
                return objectfactory.getGameObject("dangerbomb", x_position, 648, diffState, mode);
            }

            default:
                break;
        }
        return null;
    }

    public IGameObject generateRandomSpecialFruit() {
        Random r = new Random();
        int x = r.nextInt(2);
        int x_position = r.nextInt(1050) + 10;
        switch (x) {
            //will probably remove the state from here later too
            case 0:
                return objectfactory.getGameObject("banana", x_position, 648, diffState, mode);
            case 1: {
                return objectfactory.getGameObject("pome", x_position, 648, diffState, mode);
            }

            default:
                break;
        }
        return null;
    }
    int j = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, this);

        int x, y;
        for (int counter = 0; counter < getGameObjects().size(); counter++) {
            IGameObject go = getGameObjects().get(counter);
            x = go.getXLocation();
            y = go.getYLocation();
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            at.rotate(Math.toRadians(j++), go.getBufferedImage().getImage().getWidth(this) / 2, go.getBufferedImage().getImage().getHeight(this) / 2);
            at.scale(1, 1);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(go.getBufferedImage().getImage(), at, null);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Fruit thisFruit = null;
        int newx, newy, oldx, oldy;
        for (int counter = 0; counter < getGameObjects().size(); counter++) {
            IGameObject go = getGameObjects().get(counter);

            if (go.isMovingUp()) {
                oldy = go.getYLocation();
                newy = oldy - go.getInitialVelocity();
                go.setYLocation(newy);
                if (newy < 10) {
                    go.setMovingUp(false);
                }

            } else {
                oldy = go.getYLocation();
                newy = oldy + go.getFallingVelocity();
                go.setYLocation(newy);
                if (newy > 648) {
                    go.setMovedOff(true);
                }

            }
        }

        boolean allOffScreen = true;

        for (int counter = 0; counter < getGameObjects().size(); counter++) {

            IGameObject go = getGameObjects().get(counter);

            if (!go.hasMovedOffScreen()) {
                allOffScreen = false;
                break;
            }
        }

        if (allOffScreen) {
            getGameObjects().clear();
            generateObjects();
            generateSpecialFruit();
            generateBombs();
        }

        repaint();

        //new MouseMotionListenerExample();
    }

    public void paintMenu() {
    }

    public void moveObject(IGameObject object) {
        // to organize the code later   
    }

    /**
     * @return the gameObjects
     */
    public ArrayList<IGameObject> getGameObjects() {
        return gameObjects;
    }

    public void stopGameTimer() {
        this.gameTimer.stop();
    }

    void startGameTimer() {
        this.gameTimer.start();
        generateSpecialFruit();
        generateObjects();
        generateBombs();
    }
    
    void resumeGameTimer() {
        this.gameTimer.start();
    }
}
