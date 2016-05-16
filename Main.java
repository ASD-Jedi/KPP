package Main;

/**
 * Main/start class call game menu.
 */
import Interface.StartMenu;
import MapClass.MapCreator;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Pane root = new Pane();
    private MapCreator mainMap = new MapCreator();
    private Scene localScene = new Scene(root);
    private int windowsSizeX = 960;
    private int windowsSizeY = 540;
    private StartMenu startMenu = new StartMenu();

    @Override public void start(Stage primaryStage) throws Exception {
        root.getChildren().add(mainMap.getMap());

        primaryStage.setWidth(windowsSizeX);
        primaryStage.setHeight(windowsSizeY);
        primaryStage.setResizable(false);
        primaryStage.setTitle("River");
        primaryStage.setScene(localScene);
        primaryStage.show();
        startMenu.menuShow(primaryStage, localScene, root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
