package sample;

import javafx.scene.image.ImageView;

import java.util.ArrayList;


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
    private int globalWaterTime;

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
        FifthLayerY = screenResY - 32 * 7;
        waterTime = 0;
        waterNow = false;
        globalWaterTime = 0;
        globalWater = false;
    }


    public ArrayList<ImageView> map() {
        ArrayList<ImageView> MapReturn = new ArrayList<>();
        for (int i = 0; i < globalLn; i = i + 1) {
            if (i < FirstLayer) {
                MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                MapReturn.get(i).setX(i * 32);
                MapReturn.get(i).setY(FirstLayerY);
                MapReturn.get(i).setId("1");
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
                    if (((Math.random() + 17) < (Math.random() + 17)) && (waterTime > 4) && (
                        waterTime < 8) && waterNow == false) {
                        MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                        MapReturn.get(i).setX((i - FirstLayer) * 32);
                        MapReturn.get(i).setY(SecondLayerY);
                        MapReturn.get(i).setId("2");
                        waterNow = true;
                        if (waterTime >= 8)
                            waterTime = 0;
                        else
                            waterTime++;
                    } else {
                        MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                        MapReturn.get(i).setX((i - FirstLayer) * 32);
                        MapReturn.get(i).setY(SecondLayerY);
                        MapReturn.get(i).setId("1");
                        if (waterTime >= 8)
                            waterTime = 0;
                        else
                            waterTime++;
                    }
                }
            }
            if (i == SecondLayer) {
                waterNow = false;
                waterTime = 0;
            }
            if ((i >= SecondLayer) && i < (ThirdLayer)) {
                if (waterNow) {
                    MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                    MapReturn.get(i).setX((i - SecondLayer) * 32);
                    MapReturn.get(i).setY(ThirdLayerY);
                    MapReturn.get(i).setId("3");
                    if (waterTime >= 15) {
                        waterNow = false;
                        waterTime = 0;
                    } else {
                        waterNow = true;
                        waterTime++;
                    }
                } else {
                    if ((Math.random() + 37 > Math.random() + 37) && (waterTime > 11) && (waterNow
                        == false)) {
                        MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                        MapReturn.get(i).setX((i - SecondLayer) * 32);
                        MapReturn.get(i).setY(ThirdLayerY);
                        MapReturn.get(i).setId("3");
                        waterNow = true;
                        waterTime++;
                    } else {
                        MapReturn.add(TextureLoad.GetLoadMapText(2, 0));
                        MapReturn.get(i).setX((i - SecondLayer) * 32);
                        MapReturn.get(i).setY(ThirdLayerY);
                        MapReturn.get(i).setId("1");
                        waterNow = false;
                        waterTime++;
                    }
                }
            }
            if (i == ThirdLayer) {
                waterNow = false;
                waterTime = 0;
                globalWaterTime = 0;
            }
            if ((i >= ThirdLayer) && (i < FourthLayer)) {
                if (MapReturn.get(i - layerLN).getId().contentEquals("3")) {
                    MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                    MapReturn.get(i).setX((i - ThirdLayer) * 32);
                    MapReturn.get(i).setY(FourthLayerY);
                    MapReturn.get(i).setId("3");
                    waterTime++;
                    globalWaterTime++;
                } else {
                    if (waterNow) {
                        MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                        MapReturn.get(i).setX((i - ThirdLayer) * 32);
                        MapReturn.get(i).setY(FourthLayerY);
                        MapReturn.get(i).setId("2");
                        if (waterTime < 9) {
                            waterTime++;
                            waterNow = true;
                        } else {
                            waterNow = false;
                            waterTime = 0;
                        }
                    } else {
                        if (MapReturn.get(i - layerLN - 1).getId().contains("3")) {
                            waterNow = false;
                            waterTime = 0;
                        }
                        if ((Math.random() + 25 < Math.random() + 25) && (waterNow == false) && (
                            waterTime > 6)) {
                            MapReturn.add(TextureLoad.GetLoadMapText(15, 12));
                            MapReturn.get(i).setX((i - ThirdLayer) * 32);
                            MapReturn.get(i).setY(FourthLayerY);
                            MapReturn.get(i).setId("2");
                            waterNow = true;
                            waterTime++;
                        } else {
                            MapReturn.add(TextureLoad.GetLoadMapText(3, 0));
                            MapReturn.get(i).setX((i - ThirdLayer) * 32);
                            MapReturn.get(i).setY(FourthLayerY);
                            MapReturn.get(i).setId("1");
                            waterNow = false;
                            waterTime++;
                        }
                    }
                }
            }
            if ((i >= FourthLayer) && (i < FifthLayer)) {
                if (MapReturn.get(i - layerLN * 2).getId().contains("3")) {
                    MapReturn.add(TextureLoad.GetLoadMapText(7, 0));
                    MapReturn.get(i).setX((i - FourthLayer) * 32);
                    MapReturn.get(i).setY(FifthLayerY);
                    MapReturn.get(i).setId("5");
                } else {
                    MapReturn.add(TextureLoad.GetLoadMapText(8, 10));
                    MapReturn.get(i).setX((i - FourthLayer) * 32);
                    MapReturn.get(i).setY(FifthLayerY);
                    MapReturn.get(i).setId("5");
                }
            }
        }

        return MapReturn;
    }
}
