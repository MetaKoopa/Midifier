package main;

/*
 All project files created by Josh Veltmeyer with
 IntelliJ IDEA and JavaFX 2.0 Scenebuilder
 Java 8.0 documentation used for reference.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Midifier");
        primaryStage.setScene(new Scene(root, 1270, 548));
        primaryStage.getIcons().add(new Image("main/note.png"));
        primaryStage.show();
        root.requestFocus();
        if (primaryStage.isFocused()) {
            System.out.println("Input Focus Initialized");
        } else {
            try {
                throw new CustomLaunchException("Focus Not Initialized");
            } catch (CustomLaunchException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
