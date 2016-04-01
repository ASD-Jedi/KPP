package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private AnimationTimer timer;
    private PerspectiveCamera GameCamera;
    private int direct_walk;

    public Controller() {
        rootPane = new Pane();
        MainGame = new Scene(rootPane);
        mapCreator = new mapStorage();
        GameCamera = new PerspectiveCamera(false);
        GameCamera.setFieldOfView(350);
        MainGame.setCamera(GameCamera);
        direct_walk = 0;
    }

    public void sizeSet(int Hight, int Width) {
        SizeX = Width;
        SizeY = Hight;
    }

    private void MapGenerator() {
        mapCreator.createConstant(SizeX, SizeY);
        MainMap = mapCreator.map();
        for (ImageView i : MainMap) {
            rootPane.getChildren().add(i);
        }
    }

    public void sceneController(Stage GlobalStage) {
        MapGenerator();
        GlobalStage.setScene(MainGame);
        MainGame.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    direct_walk = 1;
                } else if (event.getCode() == KeyCode.DOWN) {
                    direct_walk = 2;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    direct_walk = 3;
                } else if (event.getCode() == KeyCode.LEFT) {
                    direct_walk = 4;
                }
            }
        });
        MainGame.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                //@formatter:off
                        if ((event.getCode() == KeyCode.UP)
                            || (event.getCode() == KeyCode.RIGHT)
                            || (event.getCode() == KeyCode.LEFT)
                            || (event.getCode() == KeyCode.DOWN)){
                            direct_walk = 0;
                        }
                        //@formatter:on
            }
        });
        timer = new AnimationTimer() {
            @Override public void handle(long now) {

                switch (direct_walk){
                    case 0:
                        System.out.println("STOP");
                        break;
                    case 1:
                        GameCamera.setTranslateY(GameCamera.getTranslateY()+10);
                        break;
                    case 2:
                        //GameCamera.setVisible(true);
                        GameCamera.setTranslateY(GameCamera.getTranslateY()-10);
                        System.out.println("DOWN");
                        break;
                    case 3:
                        GameCamera.setTranslateX(GameCamera.getTranslateX()+10);
                        System.out.println("RIGHT");
                        break;
                    case 4:
                        GameCamera.setTranslateX(GameCamera.getTranslateX()-10);
                        break;
                }
            }
        };
        timer.start();
        GlobalStage.show();
    }
}

