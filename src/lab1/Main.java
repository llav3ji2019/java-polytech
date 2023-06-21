package lab1;

import java.util.Scanner;

public class Main {
    private static final String COMMAND_ERROR = "Incorrect command, try again";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hero myPerson = new Hero();
        String command = "";
        while (!command.equals("quit")) {
            command = in.next();
            switch (command) {
                case "method" -> {
                    String methodOfMovement = in.next();
                    myPerson.setMethodOfMovement(methodOfMovement);
                }
                case "position" -> System.out.println(myPerson.getPosition());
                case "move" -> myPerson.move();
                default -> System.err.println(COMMAND_ERROR);
            }
        }
        in.close();
    }
}
