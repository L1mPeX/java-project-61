package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Even;

/**
 * Основной класс приложения Brain Games.
 *
 * @author l1mpex
 */
public final class App {
    private App() {
    }

    /**
     * Запускает интерактивное консольное приложение.
     *
     * @param args аргументы командной строки
     */
    @SuppressWarnings("java:S106")
    public static void main(final String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                2 - Even
                1 - Greet
                0 - Exit
                Your choice: """);
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "2" -> {
                    Even game = new Even();
                    game.greet();
                    game.playGame();
                }
                case "1" -> Cli.greet();
                case "0" -> System.out.println("Goodbye!");
                default -> System.out.println("Unknown choice: " + choice);
            }
        }
    }
}
