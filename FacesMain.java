package com.NicksFaces.cb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FacesMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FacesRes.fxml"));
        primaryStage.setTitle("Nick Faces");
        primaryStage.setScene(new Scene(root, 600, 670));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
