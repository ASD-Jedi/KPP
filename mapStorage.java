package sample;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Vector;


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

    public mapStorage() {
        TextureLoad = new spriteLoadder();
    }

    public void createConstant(int gameResX, int gameResY){
        screenResX = gameResX;
        screenResY = gameResY;
        layerLN = (screenResX/32)*4;
        

    }

    public ArrayList<ImageView> map() {
        ArrayList<ImageView> MapReturn = new ArrayList<>();
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
