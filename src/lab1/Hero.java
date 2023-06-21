package lab1;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private static final Map<String, Movable> movementMethods = new HashMap<>();

    private Movable methodOfMovement = new Walker();
    private int position;

    static {
        movementMethods.put("walk", new Walker());
        movementMethods.put("ride", new HorseRider());
        movementMethods.put("drive", new Driver());
    }

    public void move() {
        position = methodOfMovement.move(position);
    }

    public int getPosition() {
        return position;
    }

    public void setMethodOfMovement(final String methodOfMovement) {
        this.methodOfMovement = movementMethods.getOrDefault(methodOfMovement, this.methodOfMovement);
    }

}
