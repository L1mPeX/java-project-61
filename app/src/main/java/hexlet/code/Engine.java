package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.*;

public class Engine {

    /**
     * Конструктор класса
     */
    Engine () {
    }

    @SuppressWarnings("java:S106")
    public void pickGame() {
        System.out.print("""
        Please enter the game number and press Enter.
        1 - Greet
        2 - Even
        3 - Calc
        0 - Exit
        Your choice: """ + " ");
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine();

            if (choice.equals("3")) {
                Calc game = new Calc(scanner);
                game.playGame();
            }
            else if (choice.equals("2")) {
                Even game = new Even(scanner);
                game.playGame();
            }
            else if (choice.equals("1")) {
                Cli game = new Cli(scanner);
                game.greet();
            }
            else if (choice.equals("0")) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Unknown choice: " + choice);
            }
        }
    }
}
