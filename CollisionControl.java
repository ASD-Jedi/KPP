package Control;

/**
 * Class include function for test permission to move camera of River.
 */

public class CollisionControl {
    private int[] marioCollision = {1, 3, 4, 5};
    private int collisNum = 4;
    private int resX = 940;
    private double leftBorder = 0;

    /**
     * Function compare parametrs from block around person.
     * @param checkState id statement from call place.
     * @return return collision statement.
     */
    public boolean isRiverCollision(int checkState) {
        for (int i = 0; i < collisNum; i++) {
            if (marioCollision[i] == checkState) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check camera permission for left move.
     * @param currentPos current position of camera.
     * @return permission
     */
    public boolean isCameraGo(double currentPos) {
        if (currentPos == leftBorder || currentPos < leftBorder) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Function block person move over the borders.
     * @param currentPos
     * @param speed
     * @return
     */
    public boolean isRiverBorder(double currentPos, double speed) {
        if (currentPos == leftBorder || (currentPos - speed) < leftBorder) {
            return false;
        } else {
            return true;
        }
    }

    public void updateBoreder(double borderShift) {
        leftBorder += borderShift;
    }
}
