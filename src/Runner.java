//<<<<<<< HEAD
////import engine.Engine;
////import engine.GameLoader;
////import game.Element;
////import game.Game;
////import game.Tile;
////import model.*;
////import javafx.application.Application;
////import javafx.event.ActionEvent;
////import javafx.event.EventHandler;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.scene.layout.BorderPane;
////import javafx.scene.layout.VBox;
////import javafx.stage.Stage;
////import resources.Sound;
////
////import java.util.ArrayList;
////import java.util.HashMap;
////
////public class Runner extends Application {
////
////    String style = getClass().getResource("UI.css").toExternalForm();
////
////    public ArrayList<Sound> sounds = new ArrayList<Sound>();
////
////    public static void main(String[] args) {
////        launch(args);
////    }
////
////    @Override
////    public void start(Stage primaryStage) throws Exception {
////        Button startGameButton = new Button("Start Game");
////
////        Button highScoreButton = new Button("Highscores");
////
////        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
////            @Override
////            public void handle(ActionEvent event) {
////                startGame(primaryStage);
////            }
////        });
////
////
////        VBox vBox = new VBox();
////        vBox.getChildren().addAll(startGameButton,highScoreButton);
////
////        BorderPane borderPane = new BorderPane();
////        borderPane.setCenter(vBox);
////        Scene scene = new Scene(borderPane, 1600, 900);
////        scene.getStylesheets().add(style);
////        primaryStage.setScene(scene);
////        primaryStage.show();
////
////
////        primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(1));
////        primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(1));
////        primaryStage.setResizable(true);
////        primaryStage.show();
////    }
////
////    private void startGame(Stage primaryStage){
////        GameLoader gameLoader = new GameLoader();
//////        SoundControler.loadSounds();
//////        SoundCoåntroler.getSound("themesong").startLoop();
////        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
////        tileHashMap.put(0, GrassTile.class);
////        tileHashMap.put(1, gridTile.class);
////        tileHashMap.put(2, breakingTileNormal.class);
////
////        gameLoader.addTileConfiguration(tileHashMap);
////
////        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();
////        elementHashMap.put(0, Player1.class);
////        elementHashMap.put(4, Player2.class);
////        elementHashMap.put(3, Timer.class);
////        elementHashMap.put(5, Camera.class);
//////              elementHashMap.put(0, MouseCursor.class);
////        gameLoader.addElementsConfiguration(elementHashMap);
////
////        gameLoader.addLevel(1,"/resources/level1Tiles.txt","/resources/level1Elements.txt");
////
////        Game game = gameLoader.load();
////        game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(2));
////        game.setActiveLevel(game.getLevels().get(0));
////
////        Engine engine = new Engine(game);
////        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());
////
////        engine.start(primaryStage);
////    }
////}
//=======
//
//import engine.Engine;
//import engine.GameLoader;
//import game.Element;
//import game.Game;
//import game.Tile;
//import impl.*;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import resources.Sound;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Runner extends Application {
//
//	String style = getClass().getResource("UI.css").toExternalForm();
//
//	public ArrayList<Sound> sounds = new ArrayList<Sound>();
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Button startGameButton = new Button("Start Game");
//
//        Button highScoreButton = new Button("Highscores");
//
//        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                startGame(primaryStage);
//            }
//        });
//
//
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(startGameButton,highScoreButton);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setCenter(vBox);
//        Scene scene = new Scene(borderPane, 1600, 900);
//        scene.getStylesheets().add(style);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//        primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(1));
//        primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(1));
//        primaryStage.setResizable(true);
//        primaryStage.show();
//    }
//
//    private void startGame(Stage primaryStage){
//        GameLoader gameLoader = new GameLoader();
//        soundControler.loadSounds();
//        soundControler.getSound("themesong").startLoop();
//        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
//        tileHashMap.put(0,GrassTile.class);
//        tileHashMap.put(1, gridTile.class);
//        tileHashMap.put(2, breakingTileNormal.class);
//
//        gameLoader.addTileConfiguration(tileHashMap);
//
//        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();
//        elementHashMap.put(0, Player1.class);
//        elementHashMap.put(4, Player2.class);
//        elementHashMap.put(3, Timer.class);
//        elementHashMap.put(5, Camera.class);
////              elementHashMap.put(0, MouseCursor.class);
//        gameLoader.addElementsConfiguration(elementHashMap);
//
//        gameLoader.addLevel(1,"/resources/level1Tiles.txt","/resources/level1Elements.txt");
//
//        Game game = gameLoader.load();
//        game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(1));
//        game.setActiveLevel(game.getLevels().get(0));
//
//        Engine engine = new Engine(game);
//        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());
//
//        engine.start(primaryStage);
//    }
//}
//>>>>>>> origin/finall
