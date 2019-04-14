package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class LoginController {
    private Button button1;
    private Button button2;
    private boolean player1ready = false;
    boolean player2ready = false;

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private PasswordField passwordPlayer1;

    @FXML
    private PasswordField passwordPlayer2;

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

    @FXML
    private void KlaarSpeler1(ActionEvent event) {
        String usernamePlayer1 = player1.getText().trim();
        String player1Password = passwordPlayer1.getText().trim();
        button1 = ((Button)event.getSource());

        if (usernamePlayer1.equals(player2.getText())) {
            button1.setText("DEZELFDE NAAM!");
            button1.setStyle("-fx-background-color: #FF0000; ");
        } else if (model.User.userExist(usernamePlayer1)) {
            User player1 = new User(usernamePlayer1);

            if (player1.getPassword().equals(player1Password)) {

                button1.setText("READY");
                button1.setStyle("-fx-background-color: #00FF00; ");
                player1ready = true;
                checkStart();
            } else {
                button1.setText("Wrong Input");
                button1.setStyle("-fx-background-color: #FF0000; ");
            }
        }
    }

    @FXML
    private void KlaarSpeler2(ActionEvent event) {
        String usernamePlayer2 = player2.getText().trim();
        String player2Password = passwordPlayer2.getText().trim();
        button2 = ((Button)event.getSource());

        if (usernamePlayer2.equals(player1.getText())) {
            button2.setText("DEZELFDE NAAM!");
            button2.setStyle("-fx-background-color: #FF0000; ");
        } else if (model.User.userExist(usernamePlayer2)) {
            User player2 = new User(usernamePlayer2);
            if (player2.getPassword().equals(player2Password)) {

                button2.setText("READY");
                button2.setStyle("-fx-background-color: #00FF00; ");
                player2ready = true;
                checkStart();
            } else {
                button2.setText("Wrong Input");
                button2.setStyle("-fx-background-color: #FF0000; ");
            }
        }
    }

    private void checkStart() {
        if(player1ready == true && player2ready == true) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/levelSelector.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
            // Create new scene
            Scene scene = new Scene(fxmlLoader.getRoot());
            scene.getStylesheets().add(getClass().getResource("/view/levelSelector.css").toExternalForm());
            // Set new st
            MainController.getStage().setScene(scene);

        }
        else {
            System.out.println("Niet beide spelers zijn klaar.");
        }
    }

}
