package GameProcess;

import Control.CollisionControl;
import MapClass.MapCreator;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Game {
    private Stage localStageControl;
    private MapCreator mainMapCreator = new MapCreator();
    private int[][] mapCollision;
    private Pane map;
    private Pane root = new Pane();
    private Scene currentScene;
    private River river = new River();
    private PerspectiveCamera gameCamera = new PerspectiveCamera(false);
    private boolean rightWalkDirection = true;
    private double walkSpeed = 5;
    private short direction = 0;
    private final short directionLeft = 1;
    private final short directonRight = 2;
    private final short directionUP = 3;
    private final short directionDefault = 0;
    private AnimationTimer timer;
    private double jumpHeight = 80;
    private int counter = 0;
    private int backCounter = 0;
    CollisionControl collisions = new CollisionControl();
    private int initialRiverX = 480;
    private int initialRiverY = 348;
    private int blockSize = 32;
    private boolean collisionUp = false;
    private boolean collisionRight = false;
    private boolean collisionLeft = false;

    public void gameClassInit(Stage globalStage) {
        localStageControl = globalStage;
        mapCollision = mainMapCreator.getMapCollision();
        map = mainMapCreator.getMap();
        river.setTranslateX(initialRiverX);
        river.setTranslateY(initialRiverY);
        root.getChildren().addAll(map, river);
        currentScene = new Scene(root);
        currentScene.setCamera(gameCamera);
        sceneActionInit();
        localStageControl.setScene(currentScene);
        localStageControl.show();

    }

    public void startGame() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    private void update() {
        collisionSet();
        switch (direction) {
            case directionUP:
                if (!collisionUp) {
                    river.persJump(jumpHeight, river.getTranslateY());
                }
                break;
            case directonRight:
                if (!collisionRight) {
                    rightWalkDirection = true;
                    river.persGo(rightWalkDirection, walkSpeed);
                    if (river.getTranslateX() >= (gameCamera.getTranslateX() + initialRiverX)) {
                        cameraGo();
                        collisions.updateBoreder(walkSpeed);
                    }
                }
                break;
            case directionLeft:
                if (!collisionLeft) {
                    rightWalkDirection = false;
                    if (collisions.isRiverBorder(river.getTranslateX(), walkSpeed)) {
                        river.persGo(rightWalkDirection, walkSpeed);
                    }
                    if (collisions.isCameraGo(gameCamera.getTranslateX())) {
                        cameraGo();
                    }
                }
                break;
        }

        river.viewUpdate(false);
        river.viewUpdate(true);

    }

    private void sceneActionInit() {
        currentScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    direction = directionUP;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    direction = directonRight;
                } else if (event.getCode() == KeyCode.LEFT) {
                    direction = directionLeft;
                }else if(event.getCode() == KeyCode.ESCAPE){
                    root.setEffect(new GaussianBlur(10));
                    timer.stop();
                }

            }
        });
        currentScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.UP)
                        || (event.getCode() == KeyCode.RIGHT)
                        || (event.getCode() == KeyCode.LEFT)
                        || (event.getCode() == KeyCode.DOWN)) {
                    direction = directionDefault;
                }
            }
        });
    }

    private void cameraGo() {
        if (rightWalkDirection) {
            gameCamera.setTranslateX(gameCamera.getTranslateX() + walkSpeed);
        } else {
            gameCamera.setTranslateX(gameCamera.getTranslateX() - walkSpeed);
        }
    }

    private void collisionSet() {
        int collisionTempX = ((int) river.getTranslateX() + blockSize) / blockSize;
        int collisionTempY = ((int) river.getTranslateY() + blockSize) / blockSize;
        if (collisions.isRiverCollision(mapCollision[collisionTempY][collisionTempX])) {
            collisionRight = false;
        } else {
            collisionRight = true;
        }
        collisionTempX = ((int) river.getTranslateX() - blockSize) / blockSize;
        if (collisions.isRiverCollision(mapCollision[collisionTempY][collisionTempX])) {
            collisionLeft = false;
        } else {
            collisionLeft = true;
        }
        collisionTempX = (int) river.getTranslateX() / blockSize;
        collisionTempY = ((int) river.getTranslateY() + blockSize) / blockSize;
        if (collisions.isRiverCollision(mapCollision[collisionTempY][collisionTempX])) {
            collisionUp = false;
        } else {
            collisionUp = true;
        }

    }


}
