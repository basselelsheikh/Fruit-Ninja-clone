/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

/**
 *
 * @author TheANARXIST
 *
 *
 */
//array with GameObjects (probably to be moved somewhere else in the code)
public class GameObjectFactory {

    // private static GameObjectFactory instance;
    private static GameObjectFactory Factory = null;

    private GameObjectFactory() {

    }

    public static GameObjectFactory getInstance() {
        if (Factory == null) {
            Factory = new GameObjectFactory();
        }
        return Factory;
    }

    //x and y are random co-ordinates passed from the CreateObject method
    public IGameObject getGameObject(String item, int x, int y, int state_dif,int state_mode) {
        switch (item.toLowerCase()) {
            case "lemon":
                return new Lemon(x, y, state_dif, state_mode);
            case "pineapple":
                return new Pineapple(x, y, state_dif, state_mode);
            case "strawberry":
                return new Strawberry(x, y, state_dif, state_mode);
            case "watermelon":
                return new Watermelon(x, y, state_dif, state_mode);
            case "dangerbomb":
                return new DangerBomb(x, y, state_mode);
            case "fatalbomb":
                return new FatalBomb(x, y, state_mode);
            case "pome":
                return new SpecialPome(x,y);
                case "banana":
                return new SpecialBanana(x,y); 
            default:
                return null;
        }
    }
}
