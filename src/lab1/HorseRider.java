package lab1;

public class HorseRider implements Movable {
    private static final int DISTANCE_TRAVELED_PER_UNIT_OF_TIME = 100;

    @Override
    public int move(int start) {
        return start + DISTANCE_TRAVELED_PER_UNIT_OF_TIME;
    }
}