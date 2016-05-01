package Textures;

import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class TextureLoadder {
    private final Image mainTexture = new Image(getClass().getResourceAsStream("mario_main.png"));
    private int textureSize = 32;

    public Pane loadSentPane(int whichX, int whichY){
        Pane localPane = new Pane();
        ImageView localImage = new ImageView(mainTexture);
        localImage.setViewport(new Rectangle2D(whichX*textureSize, whichY*textureSize, textureSize,textureSize));
        localPane.getChildren().add(localImage);
        return localPane;
    }

    public ImageView loadSentImageView(Vec2d getVect){
        ImageView localImage = new ImageView(mainTexture);
        localImage.setViewport(new Rectangle2D(getVect.x*textureSize, getVect.y*textureSize, textureSize,textureSize));
        return localImage;
    }
}
