package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreController extends MainController {

    impl.Highscores scoreboard;
    int SIZE = 800;
    Button terug;
    public String score1;
    public String score2;
    public String score3;
    public String score4;
    public String score5;
    public List<String> scorelijst = new ArrayList<String>();

    public void bepaallabels() {
        scoreboard = new impl.Highscores();
        scorelijst = scoreboard.getHighscore();
        for (int i = 0; i < scorelijst.size(); i++) {
            if (i == 0) {
                score1 = scorelijst.get(i);
            }
            else if (i == 1) {
                score2 = scorelijst.get(i);
            }
            else if (i == 2) {
                score3 = scorelijst.get(i);
            }
            else if (i == 3) {
                score4 = scorelijst.get(i);
            }
            else if (i == 4) {
                score5 = scorelijst.get(i);
            }
        }
    }

    @FXML
    private Label highscore1;

    @FXML
    private Label highscore2;

    @FXML
    private Label highscore3;

    @FXML
    private Label highscore4;

    @FXML
    private Label highscore5;

    @FXML
    private void initialize() {
        bepaallabels();
        highscore1.setText(score1);
        highscore2.setText(score2);
        highscore3.setText(score3);
        highscore4.setText(score4);
        highscore5.setText(score5);
    }

    @FXML
    private void previous(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/menu.fxml"));
        System.out.println("test");
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        // Create new scene
        Scene scene = new Scene(fxmlLoader.getRoot());
        scene.getStylesheets().add(getClass().getResource("/view/menu.css").toExternalForm());
        // Set new st
        MainController.getStage().setScene(scene);
    }
}
