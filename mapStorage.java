package sample;
//////
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;


public class mapStorage {
    private spriteLoadder TextureLoad;
    private int layerLN;
    private int FirstLayer;
    private int SecondLayer;
    private int ThirdLayer;
    private int FourthLayer;
    private int FifthLayer;
    private int screenResX;
    private int screenResY;
    private int globalLn;
    private int FirstLayerY;
    private int SecondLayerY;
    private int ThirdLayerY;
    private int FourthLayerY;
    private int FifthLayerY;
    private int waterTime;
    private boolean waterNow;
    private boolean globalWater;

    public mapStorage() {
        TextureLoad = new spriteLoadder();
    }

    public void createConstant(int gameResX, int gameResY) {
        screenResX = gameResX;
        screenResY = gameResY - 29;
        layerLN = (screenResX / 32) * 4;
        FirstLayer = layerLN;
        SecondLayer = FirstLayer + layerLN;
        ThirdLayer = SecondLayer + layerLN;
        FourthLayer = ThirdLayer + layerLN;
        FifthLayer = FourthLayer + layerLN;
        globalLn = layerLN * 5;
        FirstLayerY = screenResY - 32;
        SecondLayerY = screenResY - 32 * 2;
        ThirdLayerY = screenResY - 32 * 3;
        FourthLayerY = screenResY - 32 * 4;
        FifthLayerY = screenResY - 32 * 5;
        waterTime = 0;
        waterNow = false;
        globalWater = false;
    }


    public ArrayList<ImageView> map() {
        ArrayList<ImageView> MapReturn = new ArrayList<>();
        for (int i = 0; i < globalLn; i = i + 1) {
            if (i < FirstLayer) {
                MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                MapReturn.get(i).setX(i * 32);
                MapReturn.get(i).setY(FirstLayerY);
            }
            if ((i >= FirstLayer) && (i < SecondLayer)) {
                if (waterNow) {
                    MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                    MapReturn.get(i).setX((i - FirstLayer) * 32);
                    MapReturn.get(i).setY(SecondLayerY);
                    if (waterTime >= 8) {
                        waterTime = 0;
                        waterNow = false;
                    } else
                        waterTime++;
                } else {
                    if (((Math.random() + 17) < (Math.random() + 17)) && (waterTime > 4) && (waterTime < 8) && waterNow == false) {
                        MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                        MapReturn.get(i).setX((i - FirstLayer) * 32);
                        MapReturn.get(i).setY(SecondLayerY);
                        waterNow = true;
                        if (waterTime >= 8)
                            waterTime = 0;
                        else
                            waterTime++;
                    } else {
                        MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                        MapReturn.get(i).setX((i - FirstLayer) * 32);
                        MapReturn.get(i).setY(SecondLayerY);
                        if (waterTime >= 8)
                            waterTime = 0;
                        else
                            waterTime++;
                    }
                }
            }
            if(i==SecondLayer) {
                waterNow = false;
                waterTime = 0;
            }
            if ((i >= SecondLayer) && i < (ThirdLayer)) {
                if (!globalWater) {
                    if (((Math.random() + 32) > (Math.random() + 32))&&(waterTime>17)) {
                        MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                        MapReturn.get(i).setX((i - SecondLayer) * 32);
                        MapReturn.get(i).setY(ThirdLayerY);
                        globalWater = true;
                    } else {
                        MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                        MapReturn.get(i).setX((i - SecondLayer) * 32);
                        MapReturn.get(i).setY(ThirdLayerY);
                        globalWater = false;
                        if (waterTime >= 17)
                            waterTime = 0;
                        else
                            waterTime++;
                    }
                } else {
                    MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                    MapReturn.get(i).setX((i - SecondLayer) * 32);
                    MapReturn.get(i).setY(ThirdLayerY);
                    if (waterTime >= 17) {
                        waterTime = 0;
                        globalWater = false;
                    }
                }
            }
            if ((i >= ThirdLayer) && (i < FourthLayer)) {

            }
            if ((i >= FourthLayer) && (i < FifthLayer)) {

            }

        }

        /*
        for (int i = 0; i < FifthLayer; i = i + 1) {
            if (i < FirstLayer) {
                MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                MapReturn.get(i).setX(i * 32);
                MapReturn.get(i).setY(568);
            }
            if ((i >= FirstLayer) && (i < SecondLayer)) {
                MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                MapReturn.get(i).setX((i - FirstLayer) * 32);
                MapReturn.get(i).setY(536);
            }
            if ((i >= SecondLayer) && i < (ThirdLayer)) {
                MapReturn.add(TextureLoad.GetLoadMapText(3, 0));
                MapReturn.get(i).setX((i - SecondLayer) * 32);
                MapReturn.get(i).setY(504);
            }
            if ((i >= ThirdLayer) && (i < FourthLayer)) {
                MapReturn.add(TextureLoad.GetLoadMapText(3, 0));
                MapReturn.get(i).setX((i - ThirdLayer) * 32);
                MapReturn.get(i).setY(472);
            }
            if ((i >= FourthLayer) && (i < FifthLayer)) {
                MapReturn.add(TextureLoad.GetLoadMapText(3, 0));
                MapReturn.get(i).setX((i - FourthLayer) * 32);
                MapReturn.get(i).setY(440);
            }
        }*/


        return MapReturn;
    }
}
