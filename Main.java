package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(400);
        primaryStage.setWidth(200);

        primaryStage.setResizable(false);
        Settings set = new Settings();


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

//