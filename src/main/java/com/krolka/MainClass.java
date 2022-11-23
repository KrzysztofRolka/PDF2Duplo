package com.krolka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class MainClass extends Application {

        @Override
        public void start(Stage stage) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("pdf2duplo.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 800, 600);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            stage.setTitle("PDF 2 DUPLO");
            stage.setScene(scene);
            stage.show();

//                    var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
}