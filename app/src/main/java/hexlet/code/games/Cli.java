package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для приветствия пользователя через командную строку.
 * @author l1mpex
 */
public class Cli extends Games {
    public Cli(Scanner sc) {
        super(sc);
    }

    public Cli(Scanner sc, String userNameString) {
        super(sc, userNameString);
    }

    /**
     * Метод, который содержит логику игры
     */
    @SuppressWarnings("java:S106")
    public void greet() {
        System.out.println("Hello, " + userNameString + "!");
    }
}
