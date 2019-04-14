package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController  {
    @FXML
    private void buttonStart(ActionEvent event) {
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

    @FXML
    private void buttonScore(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/highscore.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        // Create new scene
        Scene scene = new Scene(fxmlLoader.getRoot());
        scene.getStylesheets().add(getClass().getResource("/view/highscore.css").toExternalForm());
        // Set new st
        MainController.getStage().setScene(scene);
    }

    @FXML
    private void buttonEindig(ActionEvent event) {
        System.exit(0);
    }
}

