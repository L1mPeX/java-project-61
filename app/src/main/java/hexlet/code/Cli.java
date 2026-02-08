package hexlet.code;

import java.util.Scanner;

/**
 * Утилитарный класс для приветствия пользователя.
 * Используется только при выборе "1" в меню.
 */
public final class Cli {
    /** Приветственное сообщение. */
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    /** Запрос имени пользователя. */
    private static final String NAME_REQUEST = "May I have your name? ";
    /** Формат приветствия. */
    private static final String GREETING_FORMAT = "Hello, %s!";

    /**
     * Приватный конструктор, чтобы предотвратить создание экземпляров класса.
     */
    private Cli() {
    }

    /**
     * Приветствует пользователя и запрашивает его имя.
     */
    public static void greet() {
        final Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(WELCOME_MESSAGE);
            System.out.print(NAME_REQUEST);
            final String userName = scanner.next();
            System.out.println(String.format(GREETING_FORMAT, userName));
        } finally {
            scanner.close();
        }
    }
}
