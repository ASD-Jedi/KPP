package sample;


public class coordConverter {
    private double sizeScreenX;
    private double sizeScreenY;

    coordConverter(double x, double y) {
        sizeScreenX = x;
        sizeScreenY = y;
    }


    public double helperX(double x) {
        return (sizeScreenX - x) * (-1);
    }

    public double helperY(double y) {
        return (sizeScreenY - y) * (-1);
    }
}