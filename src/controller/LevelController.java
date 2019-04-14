package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class LevelController  {
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @FXML
    private void Button1() {
        GameController.startGame("/resources/level1Tiles.txt", "/resources/level1Elements.txt");
    }

    @FXML
    private void Button2(ActionEvent event) {
        GameController.startGame("/resources/level2Tiles.txt","/resources/level2Elements.txt");
        button2 = ((Button)event.getSource());
        button2.setText("LEVEL 2 START! :D");
        button2.setStyle("-fx-background-color: #00FF00; ");
        System.out.println("Start level 2");
    }

    @FXML
    private void Button3(ActionEvent event) {
        GameController.startGame("/resources/level3Tiles.txt","/resources/level3Elements.txt");
        button3 = ((Button)event.getSource());
        button3.setText("LEVEL 3 START! :D");
        button3.setStyle("-fx-background-color: #00FF00; ");
        System.out.println("Start level 3");
    }

    @FXML
    private void Button4(ActionEvent event) {
        GameController.startGame("/resources/level4Tiles.txt","/resources/level4Elements.txt");
        button4 = ((Button)event.getSource());
        button4.setText("LEVEL 4 START! :D");
        button4.setStyle("-fx-background-color: #00FF00; ");
        System.out.println("Start level 4");
    }

    @FXML
    private void Button5(ActionEvent event) {
        button5 = ((Button)event.getSource());
        button5.setText("LEVEL 5 START! :D");
        button5.setStyle("-fx-background-color: #00FF00; ");
        System.out.println("Start level 5");
    }

    @FXML
    private void previous(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        // Create new scene
        Scene scene = new Scene(fxmlLoader.getRoot());
        scene.getStylesheets().add(getClass().getResource("/view/login.css").toExternalForm());
        // Set new st
        MainController.getStage().setScene(scene);
    }


}
