package lab1;

public class Driver implements Movable {
    private static final int DISTANCE_TRAVELED_PER_UNIT_OF_TIME = 20;

    @Override
    public int move(int start) {
        return start + DISTANCE_TRAVELED_PER_UNIT_OF_TIME;
    }
}