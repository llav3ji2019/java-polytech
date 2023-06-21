package lab6;

import java.util.Random;

public class Utils {
    public static void pause(int startTime, int endTime) {
        try {
            Thread.sleep(new Random().nextInt(endTime - startTime) + startTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static State generateRandomState() {
        return State.values()[new Random().nextInt(State.values().length - 1) + 1];
    }
}
