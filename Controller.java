package sample;
//
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {

    private ArrayList<ImageView> MainMap;
    private Scene MainGame;
    private Pane rootPane;
    private mapStorage mapCreator;
    private int SizeX;
    private int SizeY;

    public Controller() {
        rootPane = new Pane();
        MainGame = new Scene(rootPane);
        mapCreator = new mapStorage();
    }

    public void sizeSet(int Hight, int Width){
        SizeX = Width;
        SizeY = Hight;
    }

    private void MapGenerator(){
        mapCreator.createConstant(SizeX,SizeY);
        MainMap = mapCreator.map();
        for (ImageView i : MainMap
                ) {
            rootPane.getChildren().add(i);
        }
    }

    public Scene sceneController() {
        MapGenerator();

        return MainGame;
    }
}
