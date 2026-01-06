package hexlet.code;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем через командную строку.
 *
 * @author l1mpex
 */
public final class Cli {
    private Cli() {
    }

    /**
     * Приветствует пользователя.
     */
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
