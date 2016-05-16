package GameProcess;

import Control.CollisionControl;
import Textures.TextureLoadder;
import com.sun.javafx.geom.Vec2d;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * River - class of game person, extends from Pane.
 * Include methods of texture update, position and boreder calculations.
 */

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
    private boolean upFly = false;
    private double flightSpeed = 1;
    private int[][] collisionMap;
    private int blockSize = 32;
    private boolean flightDown = false;

    River() {
        currentPerson = localLoadder.loadSentImageView(persChange);
        this.getChildren().addAll(currentPerson);
    }

    public void setCollisionMap(int[][] set) {
        collisionMap = set;
    }

    /**
     * Function for shifting person.
     * Changing position and call view update function.
     * @param direction
     * @param shift
     */
    public void persGo(boolean direction, double shift) {
        if (direction) {
            this.setTranslateX(this.getTranslateX() + shift);
        } else {
            this.setTranslateX(this.getTranslateX() - shift);
        }
        viewUpdate();
    }

    /**
     * Function change texture in a predetermined order.
     */
    public void viewUpdate() {
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
            persChange.x = textureCounter;
            currentPerson = localLoadder.loadSentImageView(persChange);
            this.getChildren().removeAll();
            this.getChildren().add(currentPerson);
        }
    }

    /**
     * This function update Y position depends from borders and game gravity.
     */
    public void updateY() {
        if (upFly) {
            testUpBorder();
            this.setTranslateY(this.getTranslateY() - flightSpeed);
            jumpState += flightSpeed;
            if (jumpState > jumpHeight) {
                upFly = false;
            }
        } else {
            testDownBorder();
            if (flightDown) {
                this.setTranslateY(this.getTranslateY() + flightSpeed);
            }
        }
    }

    /**
     * Function whitch says that person jump, set height for fly and set flags.
     * @param height
     */
    public void setJump(double height) {
        if (!infly) {
            if (!upFly) {
                jumpState = 0;
                jumpHeight = height;
                flightSpeed = jumpHeight / blockSize;
                upFly = true;
                infly = true;
            }
        }
    }

    /**
     * testDownBorder check if River have something bottom from them.
     */
    private void testDownBorder() {
        int collisionX_L = (int) this.getTranslateX() / blockSize;
        int collisionX_R = (int) Math.floor((this.getTranslateX() + blockSize) / blockSize);
        int collisionY = (int) Math.floor((this.getTranslateY() + blockSize) / blockSize);
        if (!collisions.isRiverCollision(collisionMap[collisionY][collisionX_L]) || !collisions
            .isRiverCollision(collisionMap[collisionY][collisionX_R])) {
            flightDown = false;
            infly = false;
        } else {
            flightDown = true;
        }
    }

    /**
     * testUpBorder check if River have something top of them.
     */
    private void testUpBorder() {
        int collisionX_L = (int) this.getTranslateX() / blockSize;
        int collisionX_R = (int) Math.floor((this.getTranslateX() + blockSize) / blockSize);
        int collisionY = (int) Math.floor((this.getTranslateY()) / blockSize);
        if (!collisions.isRiverCollision(collisionMap[collisionY][collisionX_L]) || !collisions
            .isRiverCollision(collisionMap[collisionY][collisionX_R])) {
            upFly = false;
        }
    }
}
