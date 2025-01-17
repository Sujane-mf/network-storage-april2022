package ru.gb.storage.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/window.fxml"));
        stage.setTitle("Cloud storage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}

