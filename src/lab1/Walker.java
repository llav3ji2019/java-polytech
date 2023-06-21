package lab1;

class Walker implements Movable {
    private static final int DISTANCE_TRAVELED_PER_UNIT_OF_TIME = 5;

    @Override
    public int move(int start) {
        return start + DISTANCE_TRAVELED_PER_UNIT_OF_TIME;
    }
}