package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class Engine {
    /**
     * Конструктор класса.
     */
    Engine() {
    }

    /**
     * Метод, который содержит логику выбора игры.
     */
    @SuppressWarnings("java:S106")
    public void pickGame() {
        System.out.print("""
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            Your choice:\s""");
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine();

            if (choice.equals("6")) {
                Prime game = new Prime(scanner);
                game.playGame();
            } else if (choice.equals("5")) {
                Progression game = new Progression(scanner);
                game.playGame();
            } else if (choice.equals("4")) {
                GCD game = new GCD(scanner);
                game.playGame();
            } else if (choice.equals("3")) {
                Calc game = new Calc(scanner);
                game.playGame();
            } else if (choice.equals("2")) {
                Even game = new Even(scanner);
                game.playGame();
            } else if (choice.equals("1")) {
                Cli game = new Cli(scanner);
                game.greet();
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Unknown choice: " + choice);
            }
        }
    }
}
