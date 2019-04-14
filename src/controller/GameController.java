package controller;

import engine.Engine;
import engine.GameLoader;
import game.Element;
import game.Game;
import game.Tile;
import model.*;

import java.util.HashMap;

public class GameController {
    private static GameLoader gameLoader;
    private static Engine engine;

    public static void startGame(String levelTi, String lvelEl){
         gameLoader = new GameLoader();
        SoundControler.loadSounds();
        SoundControler.getSound("themesong").startLoop();
        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
        tileHashMap.put(0, GrassTile.class);
        tileHashMap.put(1, gridTile.class);
        tileHashMap.put(2, breakingTileNormal.class);

        gameLoader.addTileConfiguration(tileHashMap);

        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();
        elementHashMap.put(0, Player1.class);
        elementHashMap.put(4, Player2.class);
        elementHashMap.put(3, Timer.class);
        elementHashMap.put(5, Camera.class);
//              elementHashMap.put(0, MouseCursor.class);
        gameLoader.addElementsConfiguration(elementHashMap);

        gameLoader.addLevel(1,levelTi,lvelEl);
        //gameLoader.addLevel(1,levelTi,lvelEl);

        Game game = gameLoader.load();
        game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(1));
        game.setActiveLevel(game.getLevels().get(0));

        engine = new Engine(game);
        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());

        engine.start(MainController.getStage());


    }


    public static GameLoader getGameLoader() {
        return gameLoader;
    }

    public static Engine getEngine() {
        return engine;
    }
}
