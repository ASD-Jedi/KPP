package MapClass;


import Textures.TextureLoadder;
import com.sun.javafx.geom.Vec2d;
import javafx.scene.layout.Pane;

public class MapCreator {
    MapEditor localMap = new MapEditor();
    TextureLoadder loadder = new TextureLoadder();
    private int[][] drawMap;
    private Vec2d mapSize;
    private int textSize = 32;
    private static final int spriteGroundX = 2;
    private static final int spriteGroundY = 0;
    private static final int spriteWaterX = 15;
    private static final int spriteWaterY = 12;
    private static final int spriteBrickX = 7;
    private static final int spriteBrickY = 0;
    private static final int spriteBlankX = 8;
    private static final int spriteBlankY = 10;
    private static final int spriteGrassX = 3;
    private static final int spriteGrassY = 0;

    public MapCreator() {
        drawMap = localMap.getLevel();
        mapSize = localMap.getMapSize();
    }

    public int[][] getMapCollision(){
        return localMap.getLevel();
    }

    public Pane getMap() {
        Pane localReturn = new Pane();
        Pane temp;
        for (int i = 0; i < (int)mapSize.x; i++) {
            for (int j = 0; j < (int)mapSize.y; j++) {
                switch (drawMap[j][i]) {
                    case 0:
                        temp = loadder.loadSentPane(spriteBlankX, spriteBlankY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                    case 1:
                        temp = loadder.loadSentPane(spriteBrickX, spriteBrickY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                    case 2:
                        temp = loadder.loadSentPane(spriteWaterX, spriteWaterY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                    case 3:
                        temp = loadder.loadSentPane(spriteGroundX, spriteGroundY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                    case 4:
                        temp = loadder.loadSentPane(spriteGrassX, spriteGrassY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                    case 5:
                        temp = loadder.loadSentPane(spriteBrickX, spriteBrickY);
                        temp.setTranslateX(i*textSize);
                        temp.setTranslateY(j*textSize);
                        localReturn.getChildren().add(temp);
                        break;
                }
            }
        }
        return localReturn;
    }
}
