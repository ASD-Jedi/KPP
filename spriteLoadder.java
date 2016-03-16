package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class spriteLoadder {
    private final Image MainMAPTexture = new Image(getClass().getResourceAsStream("mario_main.png"));
    private int textSize = 32;

    public ImageView GetLoadMapText(int whichX, int whichY) {
        ImageView localCut = new ImageView(MainMAPTexture);
        int x = whichX * textSize;
        int y = whichY * textSize;
        Rectangle2D temp = new Rectangle2D(x, y, textSize, textSize);
        localCut.setViewport(temp);
        return localCut;
    }
}
