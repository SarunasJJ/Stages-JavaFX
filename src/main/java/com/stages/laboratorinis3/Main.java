package com.stages.laboratorinis3;
/*
* @author Šarūnas Jemeljanovas 5 grupe
*  */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stage1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stage1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}