package sample;
//
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;

public class Settings {
    private int Hight;
    private int Wight;
    private int screenH;
    private int screenW;
    private Controller MainLogic;
    private Pane local;
    private Rectangle baccker;
    private Button setter;
    private Label ResLabel;
    private Label ScaleLabel;
    private ComboBox<String> Resolution;
    private ComboBox<String> Scale;

    private void interfaceInit() {
        baccker.setHeight(400);
        baccker.setWidth(200);
        baccker.setX(0);
        baccker.setY(0);
        baccker.setFill(Paint.valueOf("#BFBFBF"));

        ResLabel.setLayoutX(55);
        ResLabel.setLayoutY(10);
        ResLabel.setPrefSize(200, 20);
        ResLabel.setText("Set Resolution");
        ResLabel.setTextFill(Paint.valueOf("Black"));
        ResLabel.setTextAlignment(TextAlignment.CENTER);

        setter.setText("Accept Settings");
        setter.setPrefSize(130, 20);
        setter.setTranslateX(30);
        setter.setTranslateY(350);

        Resolution.getItems().addAll(
                "640x480",
                "800x600",
                "1024x768",
                "1280x720",
                "1366x768"
        );
        Resolution.setPrefSize(150, 30);
        Resolution.setTranslateX(30);
        Resolution.setTranslateY(40);

    }

    public Settings() {
        local = new Pane();
        baccker = new Rectangle();
        setter = new Button();
        ResLabel = new Label();
        ScaleLabel = new Label();
        Resolution = new ComboBox<>();
        Scale = new ComboBox<>();
        MainLogic = new Controller();
        GraphicsDevice getRes = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenH = getRes.getDisplayMode().getHeight();
        screenW = getRes.getDisplayMode().getWidth();
    }

    public Scene SettingsScene(Stage edit) {
        interfaceInit();
        setter.setOnAction(event -> {
            if (Resolution.getValue() != null) {
                switch (Resolution.getValue()) {
                    case "640x480":
                        Wight = 640;
                        Hight = 480;
                        break;
                    case "800x600":
                        Wight = 800;
                        Hight = 600;
                        break;
                    case "1024x768":
                        Wight = 1024;
                        Hight = 768;
                        break;
                    case "1280x720":
                        Wight = 1280;
                        Hight = 720;
                        break;
                    case "1366x768":
                        Wight = 1366;
                        Hight = 768;
                        break;
                    default:
                        System.out.println("Doesn't work");
                        break;
                }
            } else {
                Wight = 800;
                Hight = 600;
            }
            MainLogic.sizeSet(Hight, Wight);

            edit.setScene(MainLogic.sceneController());
            edit.setX(screenH / 2 - 800 / 2);
            edit.setY(screenW / 2 - 600 / 2);
            edit.setWidth(Wight);
            edit.setHeight(Hight);
            edit.show();
        });

        local.getChildren().addAll(baccker, ResLabel, setter, Resolution);
        Scene chose = new Scene(local);
        return chose;
    }

}
