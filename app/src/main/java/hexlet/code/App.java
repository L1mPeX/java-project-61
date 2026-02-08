package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

/**
 * Основной класс приложения Brain Games.
 * Реализует меню выбора игр.
 */
public final class App {
    /** Сообщение о неверном выборе. */
    private static final String UNKNOWN_CHOICE_FORMAT = "Unknown choice: %s";
    /** Сообщение о выходе. */
    private static final String EXIT_MESSAGE = "Goodbye!";

    /**
     * Приватный конструктор, чтобы предотвратить создание экземпляров класса.
     */
    private App() {
    }

    /**
     * Выводит меню выбора игр.
     */
    private static void printMenu() {
        final String[] menuItems = {
            "Please enter the game number and press Enter.",
            "1 - Greet",
            "2 - Even",
            "3 - Calc",
            "4 - GCD",
            "5 - Progression",
            "6 - Prime",
            "0 - Exit",
            "Your choice: "
        };

        for (final String item : menuItems) {
            System.out.println(item);
        }
    }

    /**
     * Обрабатывает выбор пользователя.
     *
     * @param choice выбор пользователя
     */
    private static void processChoice(final String choice) {
        switch (choice) {
            case "1":
                Cli.greet();
                break;
            case "2":
                runGame(new Even());
                break;
            case "3":
                runGame(new Calc());
                break;
            case "4":
                runGame(new GCD());
                break;
            case "5":
                runGame(new Progression());
                break;
            case "6":
                runGame(new Prime());
                break;
            case "0":
                System.out.println(EXIT_MESSAGE);
                break;
            default:
                throw new RuntimeException(
                    String.format(UNKNOWN_CHOICE_FORMAT, choice)
                );
        }
    }

    /**
     * Запускает игру с помощью движка.
     *
     * @param game объект игры
     */
    private static void runGame(final Game game) {
        final Engine engine = new Engine();
        engine.play(game);
    }

    /**
     * Запускает интерактивное консольное приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        printMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            final String choice = scanner.nextLine();
            processChoice(choice);
        }
    }
}
