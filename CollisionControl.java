package Control;

public class CollisionControl {
    private int[] marioCollision = {1, 3, 4, 5};
    private int collisNum = 4;
    private int resX = 940;
    private double leftBorder = 0;

    public boolean isRiverCollision(int checkState) {
        for (int i = 0; i < collisNum; i++) {
            if (marioCollision[i] == checkState) {
                return false;
            }
        }
        return true;
    }

    public boolean isCameraGo(double currentPos) {
        if (currentPos == leftBorder || currentPos<leftBorder) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRiverBorder(double currentPos, double speed) {
        if (currentPos == leftBorder || (currentPos - speed) < leftBorder) {
            return false;
        } else {
            return true;
        }
    }


    public double getLeftBorder() {
        return leftBorder;
    }

    public void updateBoreder(double borderShift) {
        leftBorder += borderShift;
    }
}
