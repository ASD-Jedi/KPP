package Interface;


import GameProcess.Game;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//
public class StartMenu {
    private Label gameName = new Label();
    private Label sinlglePlayerLabel = new Label();
    private Label multiPlayerLabel = new Label();
    private Label exitLabel = new Label();
    private double gameNameX = 294;
    private double gameNameY = 168;
    private double gameStartLabelX = 290;
    private double gameStartLabelY = 246;
    private double multiPlayerX = 296;
    private double multiPlayerY = 315;
    private double exitX = 415;
    private double exitY = 445;
    private Font allFont = new Font("Gill Sans Ultra Bold", 34);
    private Game mainGame = new Game();
    public void menuShow(Stage primaryStage, Scene back, Pane getPane){
        interfaceInit();
        getPane.getChildren().addAll(gameName, sinlglePlayerLabel, multiPlayerLabel, exitLabel);
        sinlglePlayerLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainGame.gameClassInit(primaryStage);
                mainGame.startGame();
            }
        });
    }

    private void interfaceInit(){
        labelInit();
    }

    private void labelInit(){
        gameName.setText("River Game");
        gameName.setTranslateX(gameNameX);
        gameName.setTranslateY(gameNameY);
        gameName.setFont(allFont);
        sinlglePlayerLabel.setText("Single Player");
        sinlglePlayerLabel.setTranslateX(gameStartLabelX);
        sinlglePlayerLabel.setTranslateY(gameStartLabelY);
        sinlglePlayerLabel.setFont(allFont);
        multiPlayerLabel.setText("Multiplayer");
        multiPlayerLabel.setTranslateX(multiPlayerX);
        multiPlayerLabel.setTranslateY(multiPlayerY);
        multiPlayerLabel.setFont(allFont);
        exitLabel.setText("Exit");
        exitLabel.setTranslateX(exitX);
        exitLabel.setTranslateY(exitY);
        exitLabel.setFont(allFont);

    }
}
