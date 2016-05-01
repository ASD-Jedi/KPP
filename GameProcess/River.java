package GameProcess;

import Control.CollisionControl;
import Textures.TextureLoadder;
import com.sun.javafx.geom.Vec2d;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class River extends Pane {
    private TextureLoadder localLoadder = new TextureLoadder();
    private CollisionControl collisions = new CollisionControl();
    private Vec2d persChange = new Vec2d(8, 5);
    private ImageView currentPerson;
    private int textureCounter = 8;
    private int textStartBoreder = 8;
    private int textEndBoreder = 15;
    private boolean textGrow = true;
    private boolean infly = false;
    private double jumpState = 0;
    private double jumpHeight = 0;
    private boolean upFly = true;
    private double flightSpeed = 1;
    private double initialCordsY = 0;
    private int[][] collisionMap;
    private int blockSize = 32;

    River() {
        currentPerson = localLoadder.loadSentImageView(persChange);
        this.getChildren().addAll(currentPerson);
    }

    public void setCollisionMap(int[][] set) {
        collisionMap = set;
    }

    public void persGo(boolean direction, double shift) {
        if (direction) {
            this.setTranslateX(this.getTranslateX() + shift);
        } else {
            this.setTranslateX(this.getTranslateX() - shift);
        }
        viewUpdate(false);
    }

    public void viewUpdate(boolean flyUpdate) {
        if (flyUpdate) {
            if (infly) {
                if (upFly) {
                    this.setTranslateY(this.getTranslateY() - flightSpeed);
                    jumpState += flightSpeed;
                    if (jumpState > jumpHeight) {
                        upFly = false;
                        jumpState -= flightSpeed;
                    }
                } else {
                    this.setTranslateY(this.getTranslateY() + flightSpeed);
                    jumpState -= flightSpeed;
                    if (jumpState < 0) {
                        upFly = true;
                        infly = false;
                        this.setTranslateY(initialCordsY);
                    }
                }
            }
        } else {
            if (textGrow) {
                if (textureCounter == textEndBoreder) {
                    textGrow = false;
                    textureCounter--;
                } else {
                    textureCounter++;
                }
            } else {
                if (textureCounter == textStartBoreder) {
                    textGrow = true;
                    textureCounter++;
                } else {
                    textureCounter--;
                }
            }
            persChange.x = textureCounter;
            currentPerson = localLoadder.loadSentImageView(persChange);
            this.getChildren().removeAll();
            this.getChildren().add(currentPerson);
        }
    }

    public void persJump(double height, double current) {
        if (!infly) {
            jumpHeight = height;
            infly = true;
            flightSpeed = jumpHeight / 20;
            initialCordsY = current;
        }
    }
}
