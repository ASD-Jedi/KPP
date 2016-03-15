package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(400);
        primaryStage.setWidth(200);

        primaryStage.setResizable(false);
        Pane root = new Pane();
        Settings set = new Settings();
        mapStorage MAP = new mapStorage();

        ArrayList<ImageView> LoadMap;

        LoadMap = MAP.map();
        for (ImageView i:LoadMap
             ) {
            root.getChildren().add(i);
        }

        Scene scene = new Scene(root);
        System.out.println(primaryStage.getHeight());
        System.out.println(primaryStage.getWidth());
        primaryStage.setTitle("River - Settings");

        primaryStage.setScene(set.SettingsScene(primaryStage));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

